package com.clrs.chapters.chap9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chapter9 {

	public void minMax(List<Integer> A){
		
		Integer min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
		System.out.println("Size:"+A.size());
		int size=A.size();
		if((size%2)==1){
			min=max=A.get(0);
			System.out.println("odd");
		}
		else{
			System.out.println("A[0]:"+A.get(0)+" A[1]:"+A.get(1));
			
			if(A.get(0)<A.get(1)){
				min=A.get(0);
				max=A.get(1);
				System.out.println("even");
				
			}
			else{
				min=A.get(1);
				max=A.get(0);
				System.out.println("even");
				
			}
		}
		System.out.println("Min:"+min+" Max:"+max);
		
		for(int i=0;i<A.size()-1;i+=2){
			
			System.out.println("A[i]:"+A.get(i)+" A[i+1]:"+A.get(i+1));
			
			if(A.get(i)<=A.get(i+1)){
				
				min=A.get(i)<min?A.get(i):min;
				max=A.get(i+1)>max?A.get(i+1):max;
			}
			else{
				min=A.get(i+1)<min?A.get(i+1):min;
				max=A.get(i)>max?A.get(i):max;
			}
			
		}
		
		System.out.println("Min:"+min+" Max:"+max);
	}
	private void swap(int A[],int i,int j)
	{
		int temp=A[i];
		A[i]=A[j];
		A[j]=temp;
	
	}
	private int partition(int[] A, int p,int q)
	{
		int randIndex=(int)(p+Math.random()*(q-p));
		swap(A,p,randIndex);
		int x=A[p];
		int i=p;
		
		for (int j=p+1;j<=q;j++)
		{
			if(A[j]<=x)
			{	
				i++;
				swap(A,i,j);
			}
		}
		swap(A,p,i);
		
		return i;
	}
	private int partition(int[] A, int p,int q,int index)
	{
		//int randIndex=(int)(p+Math.random()*(q-p));
		//swap(A,p,randIndex);
		int x=A[index];
		int i=p;
		
		for (int j=p+1;j<=q;j++)
		{
			if(A[j]<=x)
			{	
				i++;
				swap(A,i,j);
			}
		}
		swap(A,p,i);
		
		return i;
	}
	
	public int randomSelect(int [] A, int p, int q, int i)
	{
		if (p==q) return A[p];
		int r=partition(A,p,q);
		
		int k=r-p+1;
		if(i==k) return A[r];
		else if(i<k) return randomSelect(A, p, r-1, i);
		else return randomSelect(A, r+1, q, i-k);
			
		
	}
	
	public int randomSelectLoc(int [] A, int p, int q, int i)
	{
		if (p==q) return p;
		int r=partition(A,p,q);
		
		int k=r-p+1;
		if(i==k) return r;
		else if(i<k) return randomSelect(A, p, r-1, i);
		else return randomSelect(A, r+1, q, i-k);
			
		
	}
	
	
	public int rSelect(int[]A, int low, int high, int i){
		
		if(low==high){
			return A[low];
		}
	while(true){
		int r=partition(A,low,high);
		int k=r-low+1;
	
		if(i==k){return A[r];}
		
		else if(i<k){high=r-1;}
		else {low=r+1;i-=k;}
	}	
		
		
	}
	
	
	public int mSelect(int [] A,int p,int r,int i){
		if(p==r) return A[p];
		
		int x=randomSelect(A, p, r, (p-r)/2+1);
		int q=partition(A, p, r, x);
		
		int k=q-p+1;
		
		if(i==k) return A[q];
		else if (i<k) 
			return mSelect(A, p, q-1, i);
		
		else return mSelect(A, q+1, r, i-k);

	}
	
	public void kClosestToMedian(int[]A,int k){
		
		int medianLoc=randomSelectLoc(A, 0, A.length-1, A.length/2+1);
		
		for(int i=1;i<=k/2;i++){
			System.out.println(A[medianLoc+i]+" "+A[medianLoc-i]);
		}
		
	}
	
	public static void main(String...a){
		int []A={5,2,3,4,5,6,7,8,9,1,23,45,67,89};
		List<Integer> l1=new ArrayList<Integer>();
		//Arrays.sort(A);
		//for(int i:A){
			//l1.add(i);
			//System.out.print(" "+i);
		//}
		//System.out.println();
		Chapter9 ch=new Chapter9();
		//System.out.println(ch.randomSelect(A, 0, A.length-1, A.length/2+1));
		//ch.kClosestToMedian(A, 4);
		
		System.out.println(ch.randomSelect(A, 0, A.length-1, 7));
		
		for(int i:A){
			System.out.print(" "+i);
		}
	}
}
