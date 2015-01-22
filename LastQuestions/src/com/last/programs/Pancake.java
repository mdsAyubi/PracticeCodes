package com.last.programs;

public class Pancake {
	
	int flips=0;

	private void flip(int[] A, int i){
		flips++;
		for(int start=0,end=i;start<i;start++,end--){
			int temp=A[start];
			A[start]=A[end];
			A[end]=temp;
		}
		
	}
	
	private int max(int[]A, int end){
		
		int max=A[0];
		int maxPos=0;
		for(int i=1;i<end;i++){
			if(max>A[i]){
				max=A[i];
				maxPos=i;
			}
		}
		return maxPos;
	}
	
	public void pancakeSort(int []A){
		
		for(int currentSize=A.length;currentSize>1;currentSize--){
			
			int maxi=max(A, currentSize);
			if(maxi!=currentSize){
				
				flip(A, maxi);
				flip(A, currentSize-1);
				
			}
		}
		for(int i:A){
			System.out.print(" "+i);
		}
		System.out.println("Total flips:"+flips);
	}
	
	public static void main(String...a){
		
		int[] A={4,2,1,3,5,10,6,7,8,9,4,5,6,77,1,2,3,4,5,6,76,4,3,2,4,5,6,7,7,4,2,1,3,4,5,6,7,5,8,9,9,7,6,5,4,43,32};
		
		Pancake p=new Pancake();
		p.pancakeSort(A);
	}
	
	
}
