package com.clrs.chapters.chap2;

public class Chapter2 {

	
	public int[] insertionSort(int[] A){
		int i;
		for (int j=1;j<A.length;j++){
			int key=A[j];
			i=j-1;
			while(i>=0 && A[i]>key){
				A[i+1]=A[i];
				i--;
			}
			A[i+1]=key;
		}
		
		return A;
	}
	
	
	
	public int linearSearch(int[] A,int key){
		for(int i=0;i<A.length;i++){
			if(key==A[i]){
				return A[i];
			}
		}
		return -1;
	}
	
	
	
	public int[] bitAddition(int[] A,int[] B){
		int c=0;
		int bit,i,j;
		int[] C=new int[A.length+1];
		
		for(int k=0;k<C.length;k++)
			C[k]=0;
		
		for(int k=0;k<A.length;k++){
		
			i=A[k];j=B[k];
			
			
			if(i==0&&j==0)
				{bit=0;c=0;}
			if(i==1&&j==0)
				{bit=1;c=0;}
			if(i==0&&j==1)
				{bit=1;c=0;}
			if(i==1&&j==1)
				{bit=1;c=1;}
			
		
		}
		
		
		return C;
	}
	

	private void merge2(int[] A,int p,int q,int r)
	{
		int n1=q-p+1;
		int n2=r-q;
		int[] L=new int[n1];
		int[] R=new int[n2];
		int i,j,k=p;
				

		
		for(i=0;i<n1;i++)
			L[i]=A[p+i];
		
		for(j=0;j<n2;j++)
			R[j]=A[q+j+1];
		
		i=j=0;
		

		while(i<n1&&j<n2)
		A[k++]=(L[i]<=R[j])?L[i++]:R[j++];
		
		
		
		if(i==n1)
		while(j<n2)A[k++]=R[j++];
				

		else
		while(i<n1)A[k++]=L[i++];
				
		
	}


	private int merge(int[] A,int p,int q,int r){
		int inversion=0;
		int n1=q-p+1;
		int n2=r-q;
		int i=0,j=0,k=0;
		int	L[]=new int[n1+1];
		int R[]=new int[n2+1];
		
		
		
		for(i=0;i<n1;i++){
			L[i]=A[p+i];
		}
		L[n1]=Integer.MAX_VALUE;
		for(j=0;j<n2;j++){
			R[j]=A[q+j+1];
		}
		R[n2]=Integer.MAX_VALUE;
		
		System.out.println("Left Array");
		print(L);

		System.out.println("Right Array");
		print(R);
		
		i=0;j=0;
		for(k=p;k<=r;k++){
			if(L[i]<=R[j]){
				A[k]=L[i++];
				inversion++;
			}
			else
				A[k]=R[j++];
		}
	return inversion;	
	}
	
	
	public void recursiveInsertionSort(int[] A,int low,int high){
		
		if(low>high)
			return;
		else{
			int key=A[low];
			int i=low-1;
			while(i>=0 && A[i]>key){
				A[i+1]=A[i];
				i--;
			}
			A[i+1]=key;
		}
		recursiveInsertionSort(A, low+1, high);
		
		
	}
	
	public int binarySearch(int[] A,int low, int high,int key){
		
		while(low<=high){
		int mid=(low+high)/2;
		
		if(key==A[mid])
			return mid;
		else if(key<A[mid]){
			high=mid-1;
		}
		else
			low=mid+1;
		
		}
	
	return -1;
	}
	

	private void print(int[] A){
		for(int i:A)
		System.out.print(i+" ");
		System.out.println();
		
	}
	public void mergeSort(int[] A,int p,int r){
		if(p<r){
			int q=(p+r)/2;
			
			mergeSort(A,p,q);
			mergeSort(A,q+1,r);
			merge(A,p,q,r);
		}
			
	}
	
	
	public int[] selectionSort(int[] A){
		
		
		for(int k=0;k<A.length-1;k++){
			
			swap(A,k,findMin(A,k+1,A.length-1));
			
		}
		
		return A;
	}
	
	private int findMin(int[] A,int low,int high){
		int min=A[low];
		int pos=low;
		for(int i=low;i<=high;i++){
			if(A[i]<min){
				min=A[i];
				pos=i;
			}
		}
		System.out.println("min:"+min);
		return pos;
	}
	
	private void swap(int[] A,int i,int j){
		int temp;
		temp=A[i];
		A[i]=A[j];
		A[j]=temp;
	}
	
	public int recBinarySearch(int[] A,int low,int high,int key){
		
		int mid=(low+high)/2;
		if(low>high) return -1;
		
		else if(A[mid]==key) return mid;
		else if (key<A[mid]) return recBinarySearch(A, low, mid-1, key);
		else return recBinarySearch(A, mid+1, high, key);
		
	}
	
	public boolean findSum(int[] A,int low,int high,int x){
		
		if(low>high) return false;
		else if(recBinarySearch(A, low, high, x-A[low])!=-1)
			return true;
		else return findSum(A, low+1, high, x);
		
	}
	
	public void bubbleSort(int []A){
		for(int i=0;i<A.length;i++){
			for(int j=A.length-1;j>0;j--){
				if(A[j]<=A[j-1]){
					swap(A,j,j-1);
				}
			}
			print(A);
		}
	//print(A);
	}
	
	public int hornersRule(int k,int a[],int x[]){
		if(k==a.length)
			return 0;
		else return a[k]+x[k]*(hornersRule(k+1, a, x));
		
		
	}
	public int countInversions(int[] A, int p, int r ){
		int inversions = 0;
		if (p < r){
		int q=	(p + r)/2;

		inversions = inversions +countInversions(A, p, q);
		inversions = inversions +countInversions(A, q + 1, r );
		inversions = inversions +merge(A, p, q, r );
		}
		return inversions;
	}
	
	public static void main(String...args){
		Chapter2 ch=new Chapter2();
		//int[] A={1,2,3,4,5,7,8,9,10};
		//int[] A={1,7,2,5,3,4,6,8};
		
		//ch.bubbleSort(A);
		//ch.recursiveInsertionSort(A, 0, A.length-1);
		//int[] Arr1=ch.selectionSort(A);
		//ch.mergeSort(A, 0, A.length-1);
		//System.out.println("Sorted Array");
		//for(int i:A){
			//System.out.print(i+" ");	
		//}
		//System.out.println("Found:"+ch.recBinarySearch(A, 0, A.length-1, 4));
		//System.out.println("Not Found:"+ch.recBinarySearch(A, 0, A.length-1, 6));
		
		//System.out.println("Not Found:"+ch.findSum(A, 0, A.length-1, 119));
		
		int A[]={5,4,3,2,1};
		//int X[]={1,2,3,4};
		System.out.println("inversion:"+ch.countInversions(A, 0, A.length-1));
	
	}
	
	
}
