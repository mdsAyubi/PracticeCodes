package com.clrs.chapters.chap8;

import java.util.ArrayList;
import java.util.List;

public class CountingSort {

public int[] countingSort(int[] A,int k){
	
	int[] C = new int[k];
	int[] B = new int[A.length];
	
	for(int i=0;i<C.length;i++){
		C[i]=0;
	}
	
	
	for(int i=0;i<A.length;i++){
		C[A[i]]++;
	}
	
	for(int i=1;i<C.length;i++){
		C[i]=C[i]+C[i-1];
	}
	
	for(int i=B.length-1;i>=0;i--){
		
		//System.out.println("A[i]:"+A[i]+" C[A[i]]:"+C[A[i]]+" B[C[A[i]]]:"+B[C[A[i]]-1]);
		
		B[C[A[i]]-1]=A[i];
		C[A[i]]--;
	}
	return B;
}

public int numberInRange(int[]A,int a ,int b,int k){
	
	int[] C = new int[k];
	for(int i=0;i<C.length;i++){
		C[i]=0;
	}
	
	
	for(int i=0;i<A.length;i++){
		C[A[i]]++;
	}
	
	for(int i=1;i<C.length;i++){
		C[i]=C[i]+C[i-1];
	}
	
	return C[b]-C[a];
	
}

public int[] insertionSortByDigit(int[] A,int digit){
	int i;
	for (int j=1;j<A.length;j++){
		int x=A[j];
		int key=getIthDigit(A[j], digit);
		i=j-1;
		while(i>=0 && getIthDigit(A[i],digit)>key){
			A[i+1]=A[i];
			i--;
		}
		A[i+1]=x;
	}
	
	return A;
}


public int[] insertionSortByDigit(int[] A,int digit,int radix){
	int i;
	for (int j=1;j<A.length;j++){
		int x=A[j];
		int key=getIthDigit(A[j], digit,radix);
		i=j-1;
		while(i>=0 && getIthDigit(A[i],digit,radix)>=key){
			A[i+1]=A[i];
			i--;
		}
		A[i+1]=x;
	}
	
	return A;
}



public void radixSort(int[] A,int d){
	
	for(int i=1;i<=d;i++){
		insertionSortByDigit(A, i);
	}
	
	
}

public void radixSort(int[] A,int d,int radix){
	
	for(int i=1;i<=d;i++){
		insertionSortByDigit(A, i,radix);
	}
	
	
}


private int getIthDigit(int n,int i){
	
	int d=(int)((n/Math.pow(10,i))%10);
	/*
	while(i>0){
		d=n%10;
		n/=10;
		i--;
	}*/
	return d;
	
}


private int getIthDigit(int n,int i,int radix){
	
	int d=(int)((n/Math.pow(radix,i))%radix);
	System.out.println("For Number: "+n +"Digit:"+d);
	
	/*
	while(i>0){
		d=n%10;
		n/=10;
		i--;
	}*/
	return d;
	
}
public void waterJug(List<Integer> R, List<Integer>B){
	
	Integer r,b;
	List<Integer> smallerR,greaterR,smallerB,greaterB;
	smallerR=new ArrayList<Integer>();
	smallerB=new ArrayList<Integer>();
	greaterR=new ArrayList<Integer>();
	greaterB=new ArrayList<Integer>();
	if(R.size()==0){
		return;
	}
	else if(R.size()==1){
		r=R.get(0);
		b=B.get(0);
		System.out.println(r+" "+b);
		return;
	}
	else{
		
		r=R.get((int)(Math.random()*R.size()));
		
		for(Integer i:B){
			if(i<r){
				smallerB.add(i);
			}
			else if(i>r){
				greaterB.add(i);
			}
			else {
				b=i;
				System.out.println(r+" "+b);
			}
		}
		
		R.remove(r);
		for(Integer i:R){
			if(i<r){
				smallerR.add(i);
			}
			else{
				greaterR.add(i);
			}
		
		}
		
		waterJug(smallerR, smallerB);
		waterJug(greaterR, greaterB);
	}
	
	
	
}




public static void main(String...args){
	//int A[]={15,11,12,41,13,22,27,14,35,46,57,53,74,95,16,67,98,4};
	int A[]={36,40,55,6,63,1,5,17,23,35};
	int B[]={36,40,55,6,63,1,5,17,23,35};
	CountingSort c=new CountingSort();
	//c.radixSort(A,2,8);
	
	List<Integer> l1=new ArrayList<Integer>();
	List<Integer> l2=new ArrayList<Integer>();
	for(int i:A){
		l1.add(i);
	}
	
	for(int i:B){
		l2.add(i);
	}
	//System.out.print("Num in range:"+c.numberInRange(A, 2, 7, 100));
	
	c.waterJug(l1, l2);
}


}
