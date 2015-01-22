package com.clrs.chapters.chap6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Chapter6 {

	private int heapSize=0;
	private int parent(int i){
		return (i+1)/2-1;
	}
	
	private int left(int i){
		return 2*i+1;
	}
	
	private int right(int i){
		return 2*i+2;
	}
	private void swap(int[] A,int i,int j){
		int temp;
		temp=A[i];
		A[i]=A[j];
		A[j]=temp;
	}
	
	public void maxHeapify(int A[],int i,int heapSize){
		
		int l=left(i);
		int r=right(i);
		int largest;
		
		//System.out.println("left:"+l+"right:"+r);
		if(l<heapSize&&A[l]>A[i])
			largest=l;
		else largest=i;
		
		if(r<heapSize&&A[r]>A[largest])
			largest=r;
		//System.out.print(" largest:"+largest);
		if(i!=largest){
			swap(A,i,largest);
			maxHeapify(A, largest,heapSize);
		}
	}
	public void iterativeMaxHeapify(int A[],int i){
	
		int l=left(i);
		int r=right(i);
		int largest;
		boolean flag=false;
		do{
		//System.out.println("left:"+l+"right:"+r);
		if(l<A.length&&A[l]>A[i])
			largest=l;
		else largest=i;
		
		if(r<A.length&&A[r]>A[largest])
			largest=r;
		//System.out.print(" largest:"+largest);
		
		if(i!=largest)
		{
			swap(A,i,largest);
			flag=true;
		}
		else flag=false;
						
		}while(flag);
		
	}
	
	public void minHeapify(int A[],int i){
		
		int l=left(i);
		int r=right(i);
		int smallest;
		
		System.out.println("left:"+l+"right:"+r);
		if(l<A.length&&A[l]<A[i])
			smallest=l;
		else smallest=i;
		
		if(r<A.length&&A[r]<A[smallest])
			smallest=r;
		System.out.print(" largest:"+smallest);
		if(i!=smallest){
			swap(A,i,smallest);
			minHeapify(A, smallest);
		}
	}

	public void buildMaxHeap(int[] A){
		
		for(int i=A.length/2;i>=0;i--){
			maxHeapify(A, i,A.length);
		}
	}
	//Wrong: dont go from 1 to n/2
	public void buildMaxHeap1(int[] A){
		
		for(int i=0;i<=A.length/2;i++){
			maxHeapify(A, i,A.length);
		}
	}
	
	public void heapSort(int[] A){
		buildMaxHeap(A);
		int heapSize=A.length;
		for(int i=A.length-1;i>0;i--){
			System.out.println("Swapping:A[i]:"+A[i]+"A[0]"+A[0]);
			swap(A,0,i);
			
			maxHeapify(A, 0,--heapSize);//maxHeapify(A,0,i);
		}
		
	}
	
	public int heapMax(int A[]){
		buildMaxHeap(A);
		return A[0];
	}
	
	public int heapExtractMax(int []A,int heapSize){
		
		if (heapSize<0)
			System.out.print("Heap Undeflow!!!");
		
		int max=A[0];
		A[0]=A[heapSize];
		//System.out.println("Swapping:MAX:"+max+"A[heapsize]"+A[heapSize]);
		maxHeapify(A, 0, --heapSize);
		return max;
		
	}
	
	public void increaseKey(int[] A, int i,int key){
		if (key<A[i]){
			System.out.println("key is lower");
		}
		
		A[i]=key;
		while(i>0&&A[parent(i)]<A[i]){
			swap(A,i,parent(i));
			i=parent(i);
		}
	}
	
	public void maxHeapInsert(int []A,int key,int heapSize){
		heapSize++;
		A[heapSize]=Integer.MIN_VALUE;
		increaseKey(A, heapSize, key);
	}
	
	public void heapDelete(int[] A,int i,int heapSize){
		
		swap(A,i,heapSize);
		maxHeapify(A, i, heapSize);	
	}
	
	
	public void mergeKway(ArrayList<ArrayList<Integer>> lists){

		int[] A=new int [9];
		int heapSize=-1;
		ArrayList<Integer> m=new ArrayList<>();
		
		for(int i=0;i<lists.size();i++){
			
		maxHeapInsert(A, lists.get(i).get(0), heapSize);
		heapSize++;
			
		}

		System.out.println("HeapSize:"+heapSize);
		print(A);
		
		int k=0;
		
		while(k<9){
			System.out.println("HeapSize:"+heapSize);
			int max=heapExtractMax(A, heapSize);
			heapSize--;
			m.add(k++, max);
			print(A);
			
			
			for(int j=0;j<lists.size();j++){
				
				if(!lists.get(j).isEmpty()){
						if (max== lists.get(j).get(0)){
					
				
						lists.get(j).remove(0);
						if(!lists.get(j).isEmpty()){
						maxHeapInsert(A, lists.get(j).get(0), heapSize);
						heapSize++;
						print(A);
						
						break;
						}
					}
				}
			}
		}
		
		//for(ArrayList<Integer> l:lists){
			System.out.print("Merged List:"+m.toString());
		//	}
		
	}
	
	private void print(int[] A){
		for(int i:A){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	
	
	public static void main(String...args){
		Chapter6 ch=new Chapter6();
		Integer[] A={14,11,9};
		Integer[] B={24,10,6};
		Integer []C={9,3,2};
		//int [] A=new int[7];
		//ch.buildMaxHeap(A);	
		//ch.minHeapify(A, 0);	
		//ch.buildMaxHeap(A);
		//ch.heapSort(A);
		//ch.increaseKey(A, 5, 12);
		
		
		//for(int i=A.length-1;i>=0;i--){
			//System.out.print(" "+ch.heapExtractMax(A, i));
		//}
		
		ArrayList<ArrayList<Integer>> lists= new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> l1=new ArrayList<Integer>();
		ArrayList<Integer> l2=new ArrayList<Integer>();
		ArrayList<Integer> l3=new ArrayList<Integer>();
		
		List<Integer> list=Arrays.asList(A);
		System.out.print(list.toString());
		l1.addAll(list);
		System.out.print(l1.toString());
		
		list=Arrays.asList(B);
		l2.addAll(list);
		System.out.print(l2.toString());
		
		list=Arrays.asList(C);
		l3.addAll(list);
		System.out.print(l3.toString());
		
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		for(ArrayList<Integer> l:lists){
		System.out.print(l.toString());
		}
		ch.mergeKway(lists);
		/*
		char[] a =new char[23];
		ch.maxHeapInsert(A, 12, -1);
		ch.maxHeapInsert(A, 5, 0);
		ch.maxHeapInsert(A, 8, 1);
		ch.maxHeapInsert(A, 6, 2);
		ch.maxHeapInsert(A, 3, 3);
		ch.maxHeapInsert(A, 2, 4);
		ch.maxHeapInsert(A, 1, 5);
		for(int i:A){
		System.out.print(" "+i);
		
		}*/
	}
	
}
