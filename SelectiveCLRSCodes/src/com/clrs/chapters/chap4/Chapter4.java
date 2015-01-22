package com.clrs.chapters.chap4;

public class Chapter4 {


public int missingIntger1(int[] A,int n){
	
	int totalSum=n*(n+1)/2;
	int foundSum=0;
	for(int i:A){
		foundSum+=i;
	}
	
	return totalSum-foundSum;
}

public int missingInteger(int[] A,int n){
	
	int totalXOR=0;
	int foundXOR=0;
	
	for(int i=0;i<=n;i++){
		totalXOR=totalXOR^i;
		
	}
	for(int i:A){
		foundXOR=foundXOR^i;
	}
	
	return totalXOR^foundXOR;
}


/*
Another method
missing-integer(C, I, k)
if|C| = 1
then return the singleton element of C

if Sum eEC e mod 2 >Sum a[i][k] (bit 1 is missing)
then b = 0
else b = 1
C = C -{ e : e mod 2 = b}
I = I -{ i : a[i][k] = b}
missing-integer({e=2 : e E C}, I, k - 1)

*/
public static void main(String args[]){
	Chapter4 ch=new Chapter4();
	int[] A={0,1,2,4};
	System.out.println(ch.missingInteger(A, 4));
}
}
