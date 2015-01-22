package com.clrs.chapters.chap15;

public class LCS {

	public int [][] C;
	public int [][] B;
	
	
	
	
	public void lcsLength(int[] X, int[] Y){
		
	
	C=new int[X.length+1][Y.length+1];
	B=new int[X.length+1][Y.length+1];
	
		for(int i=0;i<X.length;i++)
			{C[i][0]=0;B[i][0]=0;}
		for(int i=0;i<Y.length;i++)
			{C[0][i]=0;B[0][i]=0;}
		
		for(int i=1;i<X.length+1;i++){
			for(int j=1;j<Y.length+1;j++){
				
				if(X[i-1]==Y[j-1]){
					C[i][j]=C[i-1][j-1]+1;
					B[i][j]=-1;
				}
				else if(C[i-1][j]>=C[i][j-1]){
					C[i][j]=C[i-1][j];
					B[i][j]=-2;
				}
				else{
					C[i][j]=C[i][j-1];
					B[i][j]=-3;
				
				}
				
				
			}
		}
		
		
	}
	
	public void print(int[][] M){
		for(int i=0;i<M.length;i++){
			for(int j=0;j<M[i].length;j++){
				System.out.print(" "+M[i][j]);
			}
			System.out.println(" ");
		}

	}
	
	public void printLCS(int[][]B,int[] X,int i, int j){
		if(i==0||j==0){
			return;
		}
		if(B[i][j]==-1){
			printLCS(B,X,i-1,j-1);
			System.out.println(X[i-1]);
		}
		else if(B[i][j]==-2){
			printLCS(B,X,i-1,j);
		}
		else{
			printLCS(B,X,i,j-1);
		}
		
	}
	
	public static void main(String...args){
		LCS lcs=new LCS();
		
		int[] X={1,2,3,2,4,1,2};
		int[] Y={2,4,3,1,2,1};
		
		lcs.lcsLength(X, Y);
		lcs.print(lcs.C);
		System.out.println(" ");
		System.out.println(" ");
		lcs.print(lcs.B);
		
		lcs.printLCS(lcs.B, X, X.length, Y.length);
		
		
	}
}
