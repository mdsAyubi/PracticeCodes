package com.clrs.chapters.chap7;


public class Quicksort {

		
	public Quicksort() {
		// TODO Auto-generated constructor stub
		
	}
	private void swap(int[] A,int i,int j){
		int temp;
		temp=A[i];
		A[i]=A[j];
		A[j]=temp;
	}
	private int partition(int[] A,int p,int r){
		
		int x=A[r];
		
		int i=p-1;
		
		for(int j=p;j<r;j++){
			if(A[j]>x){
			
				swap(A,++i,j);
			}
		}
		swap(A,i+1,r);
		return i+1;
		
	}
	private int randomAB(int a,int b){
		
		return (int)((a)+(Math.random()*(b-a)));
	}
	
	private int randomizedPartition(int[] A,int p,int r){
		int i=randomAB(p, r);
		swap(A,i,r);
		return partition(A, p, r);
		
	}
	
	
	public void rquickSort(int[] A,int p,int r){
		if(p<r){
			int q=randomizedPartition(A, p, r);
			rquickSort(A,p,q-1);
			rquickSort(A,q+1,r);
			
			
		}
	}
	
	
	
	
	public void quickSort(int[] A,int p,int r){
		if(p<r){
			int q=partition(A, p, r);
			quickSort(A,p,q-1);
			quickSort(A,q+1,r);
			
			
		}
	}
	
	
	public static void main(String...args){
		
		Quicksort q=new Quicksort();
		int[] A={14,11,9,4,67,12,3,56,23,45,23,34};
	
		q.rquickSort(A, 0, A.length-1);
		
		for(int l:A){
			System.out.print(l+" " );
			}
	}
	
	
	
	
}
