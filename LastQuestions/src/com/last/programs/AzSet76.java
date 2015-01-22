package com.last.programs;

import java.util.PriorityQueue;

public class AzSet76 {

	public void printRepeatedLex(String str){
		
		
		char[] letters=new char[26];
		
		for(char c: str.toCharArray()){
			
			letters[c-65]++;
		}
		for(int i=0;i<letters.length;i++){
			if(letters[i]>1)
				System.out.print((char)(65+i));
		}
		
	}
	
	public void mergeKWay(int[][] A){
		
		int [] loc=new int[A.length];
		int minArr=1;
		PriorityQueue<Integer> h=new PriorityQueue<Integer>();
		
		
		for(int i=0;i<loc.length;i++)loc[i]=0;
		for(int i=0;i<A.length;i++){
			h.add(A[i][0]);
		}
		
		while(!h.isEmpty()){
			//System.out.println("MinArr:"+minArr);
			System.out.print(" "+h.remove());
			
			
			int next=++loc[minArr];
			if(next<A.length)
			{	
				//System.out.println("Adding in heap, next="+next);
				h.add(A[minArr][loc[minArr]]);
			
			int tempMin=Integer.MAX_VALUE;
			for(int i=0;i<A.length;i++){
				if(A[i][loc[i]]<tempMin)
				{
					//System.out.println(A[i][loc[i]]+" "+tempMin);
					tempMin=A[i][loc[i]];
					minArr=i;
				}
			}
			
			}
			
		}
		
	}
	
	private void swap(int[] A,int i, int j){
		int temp=A[i];
		A[i]=A[j];
		A[j]=temp;
	}
	public void randomPlayList(int[] A){
		
		int i=0;
		
		while(i<A.length){
			swap(A,i,i+(int)(Math.random()*(A.length-i)));
			System.out.print(" "+A[i]);
			i++;
		}
		
	}
	public static void main(String...a){
		AzSet76 obj=new AzSet76();
		
		int A[]={5,3,2,1,4};
		int [][] B={{3,7,12},{1,5,10},{4,6,9}};
		//obj.printRepeatedLex("ABCCAD");
		//obj.mergeKWay(A);
		obj.randomPlayList(A);
	}
	
}
