package com.last.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Maths {

	public int countNumberOfSetBits(int n){
		int count=0;
		while(n>0){
			if( (n & 1) ==1){
				count++;
			}
			n=n>>1;
		}
		return count;
		
	}
	
	public boolean multipleOfThree(int n){
		
		if (n<0) n=-n;
		if(n==0) return true;
		if(n==1) return false;
		int oddCount=0;
		int evenCount=0;
		
		while(n>0){
			
			if((n&1)==1){
				oddCount++;
			}
			n=n>>1;
			if((n&1)==1){
				evenCount++;
			}
			n=n>>1;
			
		}
		if(Math.abs(evenCount-oddCount)%3==0)
			return true;
		else
			return false;
		
	}
	
	public boolean isLuckyNumber(int n){
		
		int currentStepNumber=2;
		
		while(true){
			
			if(n<currentStepNumber) return true;
			else if(n%currentStepNumber==0) return false;
			else n=n-(n/currentStepNumber);
			
			currentStepNumber++;
			
		}
		
	}
	
	public double babylonianSquareRoot(int n){
		
		double x=n;
		double y=1;
		double error=0.000001;
		
		while(x-y>error){
			x=(x+y)/2;
			y=n/x;
		}
		return x;
	}
	
	
	int arr[]=new int[100];
	int MaxPoints=3;
	public void printComposition(int n, int i){
		
		if(n==0) printArray(arr,i);
		else if (n>0){
			
			for(int k=1;k<=MaxPoints;k++){
				arr[i]=k;
				printComposition(n-k, i+1);
			}
		}
		
	}
	
	private void printArray(int[] arr, int i){
		
		for(int j=0;j<i;j++){
			System.out.print(" "+arr[j]);
		}
		System.out.println();
	}
	
	//No idea...
	public int countNumberWith3(int n){
		
		if(n<3) return n;
		
		if(n>=3 && n<10) return n-1;
		int po=1;
		
		while(n/po>9) po*=10;
		
		int msd=n/po;
		
		if(msd!=3){
			return countNumberWith3(msd)*countNumberWith3(po-1)+countNumberWith3(msd)+countNumberWith3(n%po);
		}
		else
			return countNumberWith3(msd*po-1);
					
	}
	
	public int numberNotContaining3(int x){
		
		int n=0; int count=0;
		while(n<x){
			if(!(n+"").contains("3"))
				count++;
			n++;
		
		}
		return count;
	}
	
	public int dayofweek(int d, int m, int y)
	{
	    int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
	    if(m<3)
	    	y -= 1;
	    return ( y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
	}
	
	private double getAverage(double prevAverage, int item, int n){
		
		return (prevAverage*n+item)/(n+1);
	}
	
	
	public void averageOfStream(int[] A){
		
		double avg=0;
		for(int i=0;i<A.length;i++){
			avg=getAverage(avg, A[i], i);
			System.out.println(avg);
		}
		//return avg;
		
	}
	
	private void markMultiples(int i, boolean[] arr){
		
		int x=2;
		while(i*x<arr.length) {arr[i*x]=true;x++;}
	}
	
	public void seiveOfEratosthenes(int n){
		
		boolean[] arr=new boolean[n];
		System.out.println("1");
		
		for(int i=2;i<n;i++){
			
			if(arr[i]==false) {System.out.println(i);markMultiples(i, arr);}
		}
	}
	
	public void largestNumberDivisibleBy3(Integer []A){
		
		int sum=0;
		for(int i=0;i<A.length;i++){
			sum+=A[i];
		}
		if(sum%3!=0){
			System.out.println("Not possible");
		}
		else{
			Arrays.sort(A,Collections.reverseOrder());
			
			for(Integer i: A){
				System.out.print(i);
			}
			
		}
	}
	
	private int fact(int n){
		int fact=1;
		for(int i=n;i>0;i--){
			fact=fact*i;
		}
		return fact;
	}
	
	public int lexiRank(String str){
		
		int n=str.length();
		int rank=1;
		
		for(int i=0;i<n-1;i++){
			int x=0;
			for(int j=i+1;j<n;j++){
				if(str.charAt(i)>str.charAt(j))x++;
			}
			rank=rank+x*fact(n-i-1);
		}
		return rank;
		
	}
	
	ArrayList<String> perm=new ArrayList<String>();
	public void permutation(char[] A, int i){
		
		if(i==A.length) perm.add(new String(A));
		else{
			for(int j=i;j<A.length;j++){
				swap(A,i,j);
				permutation(A, i+1);
				swap(A,i,j);
			}
		}
	}
	
	private void swap(char[] A, int i, int j){
		char temp=A[i];
		A[i]=A[j];
		A[j]=temp;
	}
	
	public void reservoirSampling(int stream[], int k){
		
		int[] reservoir=new int[k];
		
		for(int i=0;i<k;i++) reservoir[i]=stream[i];
		
		for(int i=k;i<stream.length;i++){
			
			int j=(int)(Math.random()*(i+1));
			if(j<k)
				reservoir[j]=stream[i];
		}
		printArray(reservoir,reservoir.length);
		
	}
	
	
	public int binomialCoff(int n, int k){
		int res=1;
		if(k>n-k) k=n-k;
		
		for(int i=0;i<k;i++){
			res*=n-i;
			res/=i+1;
		}
		return res;
	}
	
	public void makeOneLitre(int v1, int v2){
		
		int a=3,b=7;
		while(v1!=1){
			if(v1==0){
				System.out.println("v1: "+v1+" v2:"+v2);
				v1=a;
				System.out.println("v1: "+v1+" v2:"+v2);
			}
			if(v1<=a){
				if(v1+v2<=b) {
					System.out.println("v1: "+v1+" v2:"+v2);
					v2+=v1;
					v1=0;
					System.out.println("v1: "+v1+" v2:"+v2);
				}
				else{
					System.out.println("v1: "+v1+" v2:"+v2);
					int tempv2=v2; int tempv1=v1;
					v2=0;
					v1=(tempv1+tempv2)-b;
					System.out.println("v1: "+v1+" v2:"+v2);
				}
			}
		}
		
	}
	
	public void primeFactor(int n){
		
		ArrayList<Integer> factors=new ArrayList<Integer>();
		while(n%2==0){
			factors.add(2);
			n/=2;
		}
		
		for(int i=3;i<=Math.sqrt(n);i+=2){
			
			while(n%i==0){
				factors.add(i);
				n/=i;
			}
		}
		if(n>2) factors.add(n);
		System.out.println(factors.toString());
		
	}
	
	// replace index with all possible elements. The condition
    // "end-i+1 >= r-index" makes sure that including one element
    // at index will make a combination with remaining elements
    // at remaining positions
	
	public void printRCombInKSet(int [] arr, int data[], int start, int end, int index, int r){
		
		if(index==r)
			printArray(data, index);
	
		for(int i=start;i<=end/* end-i+1 >= r-index*/;i++){
			data[index]=arr[i];
			printRCombInKSet(arr, data, i+1, end, index+1, r);
		}
		
	}
	
	public  void towerOfHanoi(int n, char from, char to, char temp){
		
		if(n==1){
			System.out.println("Move disk 1 from:"+from+" to"+to);
			return;
		}
		towerOfHanoi(n-1, from, temp, to);
		System.out.println("Move disk "+ n +" from:"+from+" to "+to);
		towerOfHanoi(n-1, temp, to, from);
	}
	
	public int hornersRule(int k,int a[],int x[]){
		if(k==a.length)
			return 0;
		else return a[k]+x[k]*(hornersRule(k+1, a, x));
		
		
	}
	
	public int trailingZeroes(int n){
		int count=0;
		
		if(n<0) return -1;
		
		for(int i=5;n/i>0;i*=5){
			count+=n/i;
		}
		return count;
	}


	
	public static void main(String...a){
		Maths m=new Maths();
		int [] A={1,2,3,4,5};
		int[] data=new int[100];
		
		m.towerOfHanoi(3, 'A', 'C','B');
		//m.printRCombInKSet(A, data, 0, A.length-1,0, 3);
		//m.primeFactor(25);	
		//System.out.println(m.binomialCoff(10, 10));
		//m.makeOneLitre(0, 0);
		
		//String s="ABCD";
		//char[] t=s.toCharArray();
		//Arrays.sort(t);
		
		//m.permutation(t, 0);
		//System.out.println(m.perm.toString());
		//Collections.sort(m.perm);
		//System.out.println(m.perm.toString());
		
		//System.out.println(m.perm.lastIndexOf("STRING"));
		
		//System.out.println(m.lexiRank("string"));
		//m.largestNumberDivisibleBy3(A);
		//m.seiveOfEratosthenes(10);
		//System.out.println(m.numberNotContaining3(578));
		//m.averageOfStream(A);
		//System.out.println(m.isLuckyNumber(7));
		//System.out.println(m.dayofweek(19, 1, 1989));
		//System.out.println(m.countNumberWith3(578));
		//m.printComposition(5, 0);
		//System.out.println(m.babylonianSquareRoot(36));
		//System.out.println(m.multipleOfThree(24));
		//System.out.println(m.countNumberOfSetBits(3));
	}
	
}
