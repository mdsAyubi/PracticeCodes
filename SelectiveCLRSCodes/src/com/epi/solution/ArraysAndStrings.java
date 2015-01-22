package com.epi.solution;

public class ArraysAndStrings {

public void shift(int [] A){
		
		int pivot=3;
		int equal=0,smaller=0,larger=A.length-1;
		
		while(equal<=larger){
			
			if(A[equal]<pivot){
				swap(A,smaller++,equal++);
			}
			else if (A[equal]==pivot) equal++;
			
			else{
				swap(A,equal,larger--);
			}
			
		}
		
		for(int i:A){
			System.out.print(" "+i);
		}
		
	}

private void swap(int []A, int i, int j){
	int temp=A[i];
	A[i]=A[j];
	A[j]=temp;
}


	public static void main(String...a){
		
		ArraysAndStrings as=new ArraysAndStrings();
		as.shift(new int[]{1,2,3,4,5,});

	}




}
	

