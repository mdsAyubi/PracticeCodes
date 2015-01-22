package com.last.programs;

public class GFGALgo<E> {

	public void findUnsortedArray(int [] A){
		
		int start=0,end=0;
		int i;
		for(i=0;i<=A.length-2;i++){
			if(A[i]>A[i+1]){
				start=i; break;
			}
		}
		if(i==A.length-1){
			System.out.println("Completelty Sorted..");
			return;
		}
		for(i=A.length-1;i>0;i--){
			if(A[i]<A[i-1]){
				end=i; break;
			}
		}
		
		System.out.println("Start: "+start+" End: "+end);
		int min=A[start];
		for(i=start;i<=end;i++){
			if(A[i]<min)
				min=A[i];
		}
		int max=A[start];
		for(i=start;i<=end;i++){
			if(A[i]>max)
				max=A[i];
		}
		
		for(i=0;i<=start;i++){
			if(A[i]>min)
				{start=i;break;}
		}
		for(i=A.length-1;i<=end;i--){
			if(A[i]<max)
				{end=i;break;}
		}
		
		
		System.out.println("Start: "+start+" End: "+end);
		
		
	}
	
	public void mergeSort(LinkedList<E> list){
		
		if(list.head==null||list.head.next==null){
			return;
		}
		LinkedList<E> first=new LinkedList<E>();
		LinkedList<E> second=new LinkedList<E>();
		
		splitInHalf(list, first,second);
		
		mergeSort(first);
		mergeSort(second);
		
		list.head=merge(first.head,second.head);
		
		
	}
	
	
	private void splitInHalf(LinkedList<E> list, LinkedList<E> first, LinkedList<E> second){
		
		
		
		if(list.head==null||list.head.next==null){
			first=list;
			second=null;
			return;
		}
		Node<E> fast=list.head.next;
		Node<E> slow=list.head;
		
		while(fast!=null){
			fast=fast.next;
			
			if(fast!=null){
				fast=fast.next;
				slow=slow.next;
			}
		}
		
		first.head=list.head;
		second.head=slow.next;
		slow.next=null;
		
	}
	private Node<E> merge(Node<E> first, Node<E> second){
		
		Node<E> result=null;
 		
		if(first==null){
			return second;
		}
		if(second==null){
			return first;
		}
		
		if((Integer)first.getData()<(Integer)second.getData()){
			result=first;
			result.next=merge(first.next,second);
		}
		else{
			result=second;
			result.next=merge(first,second.next);
		}
		return result;
		
	}
	
	public void countingSort(int []A, int n, int exp){
		int [] output=new int[n];
		int[] count=new int [n];
		
		for(int i=0;i<A.length;i++){
			count[(A[i]/exp)%n]++;
		}
		
		for(int i=1;i<count.length;i++){
			count[i]=count[i]+count[i-1];
		}
		
		for(int i=n-1;i>=0;i--){
			output[count[(A[i]/exp)%n]-1]=A[i];
			count[A[i]/exp%n]--;
		}
		
		for(int i=0;i<A.length;i++){
			A[i]=output[i];
		}
		
	}
	
	public void activitySelection(int [] S, int []F){
		
		//int start=0;
		int previousFinish=0;
		
		for(int j=0;j<F.length;j++){
			if(S[j]>=previousFinish){
				System.out.println(j+"->");
				previousFinish=F[j];
			}
		}
		
	}
	
	
	public void plotGraph(){
		char [][] g=new char [100][100];
		
		
		for(int x=0;x<g[0].length;x++){
			double y=x;
			//System.out.print("y:"+y);
			g[g.length-(int)Math.abs(y)-1][x]='*';
		}
		
		for(int i=0;i<g.length;i++){
			for(int j=0;j<g[i].length;j++){
				if(g[i][j]!=0){
					System.out.print(g[i][j]);
				}
				else{
					System.out.print(' ');
				}
			}
			System.out.println();
		}
	}
	
	
	private void print(int[] A){
		
		for(int i:A){
			System.out.print(" "+i);
		}
		System.out.println();
		
	}
	
	public int[] sort0ton2(int []A, int n){
		
		countingSort(A, n, 1);// n^0=1
		countingSort(A,n,n);// n^1=1
		
		print(A);
		return A;
	}
	
	
	public static void main(String...a){
		int [] A={0,23,12,14,9};
		int S[]={1, 3, 0, 5, 8, 5};
		int F[]={2, 4, 6, 7, 9, 9};
		LinkedList<Integer> ll=new LinkedList<Integer>();
		/*
		ll.addFirst(12);
		ll.addFirst(13);
		ll.addFirst(2);
		ll.addFirst(3);
		ll.addFirst(15);
		ll.addFirst(16);
		ll.addFirst(11);
		ll.addFirst(9);
		*/
		GFGALgo<Integer> obj=new GFGALgo<Integer>();
		//obj.findUnsortedArray(A);
		//obj.sort0ton2(A, 5);
		//obj.activitySelection(S, F);
		//obj.mergeSort(ll);
		//System.out.println(ll.toString());
		obj.plotGraph();
	}
	
}
