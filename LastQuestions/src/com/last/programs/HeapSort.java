package com.last.programs;

public class HeapSort {
	
	
	private void heapify(Heap heap, int i){
		
		int largest=i;
		int left=(i<<1)+1;
		int right=(i<<1)+2;
		
		if(left<heap.size && heap.A[left]>heap.A[i]){
			largest=left;
		}
		if(right<heap.size && heap.A[right]>heap.A[i]){
			largest=right;
		}
		if(largest!=i){
			swap(heap.A, i, largest);
			heapify(heap, largest);
		}
		
	}
	private void swap(int[] A,int i, int j){
		int temp=A[i];
		A[i]=A[j];
		A[j]=temp;
	}
	
	private Heap buildHeap(int[] A, int size){
		Heap heap=new Heap(A, size);
		
		for(int i=(heap.size-2)/2;i>=0;i--){
			heapify(heap, i);
		}
		
		return heap;
	}
	
	public int[] heapSort(int[] A){
		
		print(A);
		Heap heap=buildHeap(A, A.length);
		
		print(A);
		while(heap.size>0){
			swap(heap.A,0,heap.size-1);
			heap.size--;
			heapify(heap,0);
			print(A);
		}
		
		return A;
	}
	public void print(int[] A){
		for(int i:A){
			System.out.print(" "+i);
		}
		System.out.println();
	}
	
	public static void main(String...a){
		
		HeapSort h=new HeapSort();
		int [] A={3,2,1,4,5,7,6};
		h.heapSort(A);
		System.out.println("Final");
		h.print(A);
	}

}

class Heap{
	int size;
	int[] A;
	public Heap(int []A, int size){
		this.A=A;
		this.size=size;
	}
}
