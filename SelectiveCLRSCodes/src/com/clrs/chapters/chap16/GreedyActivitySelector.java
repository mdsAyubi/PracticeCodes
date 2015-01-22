package com.clrs.chapters.chap16;

public class GreedyActivitySelector {

	int[] seq=new int[11];
	
	public int activitySelector(int[] S, int[] F,int i,int j){
		
		int m=i+1;
		while(m<j && S[m]<F[i]){
			m++;
		}
		int temp;
		if(m<j){
			temp=activitySelector(S, F, m, j);
			seq[m]=temp;
		}
		else{
			temp= 0;
		}
	
		return temp;
	}
	public void greedyActivitySelector(int[] S, int[] F){
		int n=S.length;
		int k=0;
		seq[k++]=1;
		
		int i=0;
		for (int m=1;m<n;m++){
			if(S[m]>=F[i]){
				seq[k++]=m+1;
				i=m;
			}
		}
	}
	
	public static void main(String...s){
		
		int[] Si={1,3,0,5,3,5,6,8,8,2,12};
		int[] Fi={4,5,6,7,8,9,10,11,12,13,14};
		
		GreedyActivitySelector gas=new GreedyActivitySelector();
		gas.greedyActivitySelector(Si, Fi);
		for(int i:gas.seq){
			System.out.print(" "+i);
		}
		
	}
	
	
}
