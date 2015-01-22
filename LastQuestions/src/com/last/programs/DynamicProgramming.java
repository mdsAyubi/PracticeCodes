package com.last.programs;

import java.util.Arrays;
import java.util.Hashtable;

public class DynamicProgramming {

	public int maxContiguousSum(int[ ] A){
		
		int[] M=new int[A.length];
		int maxSum=0;
		if(A[0] < 0) M[0]=0;
		else M[0]=A[0];
		
		
		for(int i=1; i<A.length;i++){
			if(M[i-1]+ A[i]>0) M[i]=M[i-1]+A[i];
			else M[i]=0;
		}
		
		for(int i=0;i<M.length;i++){
			if(M[i]>maxSum) maxSum=M[i];
		}
		
		return maxSum;
		
	}
	
	
	
	public int maxSumWithNoTwoContiguous(int[] A){
		int M[]=new int[A.length];
		
		M[0]=A[0];
		M[1]=A[0]>A[1]?A[0]:A[1];
		
		for(int i=2;i<A.length;i++){
			M[i]=M[i-1]>M[i-2]+A[i]?M[i-1]:M[i-2]+A[i];
		}
		return M[A.length];
	}
	
	public void matrixChainOrder(int []P){
		int n=P.length-1;
		int M[][]=new int[n][n];
		int S[][]=new int[n][n];
		
		for(int i=0;i<n;i++){
			M[i][i]=0;
		}
		for(int l=2;l<=n;l++){
			for(int i=1;i<=n-l+1;i++){
				int j=i+l-1;
				M[i][j]=Integer.MAX_VALUE;
				
				for(int k=i;k<=j;k++){
					int thisCost=M[i][k]+M[k+1][j]+P[i-1]*P[k]*P[j];
					if(thisCost<M[i][j]) {M[i][j]=thisCost;S[i][j]=k;}
					
					
				}
			}
		}
		
		System.out.println(M[1][n]);
	}
	
	
	//Not working...
	int[] table=new int[128];
	public int makingChange(int n,int[] denom){
		
		if(n<0) return 0;
		
		else if(n==0) return 0;
		//else if(n==1) return 1;
		else if(table[n]!=0) return table[n];
		else {
			int ans=-1;
			
			for(int i=0;i<denom.length;i++){
				
				int temp=makingChange(n-denom[i],denom);
				System.out.println("Ans:"+ans+" n:"+n+" i:"+i+" "+"temp:"+temp);
				
				if(temp<ans) ans=temp;
				table[n]=ans+1;
			}
			
			return table[n];
		}
		
	}
	
	
	/*
	 * Awesome:
	 * if value ie j is equal to the denomination, number of coins=1
	 * else
	 * subtract the denom from the value and add 1
	 */
	
	public void makingCoinChange(int sum, int[] denom){
		
		int [] table=new int[sum+1];
		
		table[0]=1;
		
		for(int i=0;i<denom.length;i++){
			for(int j=denom[i];j<=sum;j++){
				
				if(j==denom[i])
					table[j]=1;
				else if(table[j-denom[i]]>0)
				table[j]=table[j-denom[i]]+1;
				
			}
		}
		
		System.out.println(table[sum]);
	}
	
	public int LIS(int[]A){
		int[] LISTable=new int[1024];
		int max=0;
		for(int i=0;i<A.length;i++){
			LISTable[i]=1;
		}
		for(int i=0;i<A.length;i++){
			for(int j=0;j<i;j++){
				if(A[i]>A[j] && LISTable[i]<LISTable[j]+1)
					LISTable[i]=LISTable[j]+1;
			}
				
		}
		
		for(int i=0;i<A.length;i++){
			if(max<LISTable[i])
				max=LISTable[i];
		}
		return max;
		
	}
	
	public int LCSRecursive(char X[], char Y[], int m, int n){
		
		if(m==0||n==0) return 0;
		
		else if(X[m-1]==Y[n-1]){
			return 1+LCSRecursive(X, Y, m-1, n-1);
		}
		else{
			return Math.max(LCSRecursive(X, Y, m, n-1), LCSRecursive(X, Y, m-1, n));
		}
	}
	
	
	public int coinChangeRecursive(int sum, int[] d, int numOfCoins){
		if(sum==0) 
			return 1;
		if(sum<0) 
			return 0;
		System.out.println(sum+" "+numOfCoins);
		if(numOfCoins<=0 && sum>=1) 
			return 0;
		
		else{
			return coinChangeRecursive(sum,d,numOfCoins-1)+coinChangeRecursive(sum-d[numOfCoins-1],d,numOfCoins);
		}
		
		
	}
	
	//Not working..:-(
	public void subsetSum1(int []A, int T){
		
		int M[][]=new int[A.length+1][T+1];
		
		M[0][0]=0;
		
		for(int i=0;i<T+1;i++){
			M[0][i]=0;
		}
		
		for(int i=1;i<=M.length;i++){
			for(int j=0;j<M[i].length;j++){
				M[i][j]=Math.max(M[i-1][j],M[i-1][j-A[i]]);
			}
		}
		
		System.out.println(M[A.length][T]);
	}
	
	/*a is array, n is size of array,
	b and c are the 2 numbers
	between which we have to find min distance.*/
	public int minDist(int a[], int b, int c) {

	    int  ret = Integer.MAX_VALUE, cur = -1;
	    int n=a.length-1;
	    while(n-->=0) {
	        if(a[n] == b || a[n] == c) {
	            if(cur != -1 && a[cur] != a[n]) {
	                ret = Math.min(ret, cur - n);
	            }
	            cur = n;
	        }
	    }
	    return ret;
	}


	int[] catalanTable=new int[1024];
	
	public int catalanNumbers(int n){
		if(n==0) return 1;
		if(catalanTable[n]!=1) return catalanTable[n];// return value is already calculated...
		else{
		catalanTable[n]=0;
		for(int i=1;i<=n;i++){
			catalanTable[n]+=catalanNumbers(i-1)*catalanNumbers(n-i);
			}
		}
		return catalanTable[n];
		
		
	}
	
	/*We are given n infinite items of size si and value vi, We need to fill a knapsack of size C 
	 * Multiple items of same size can be taken. 
	 * Solution: Lets M(j) denote the size of knapsack j, for every j we have to decide if j-1 sized knapsack
	 * is ok or we add the current item
	 * M(j)=max{M(j-1), max(M(j-si)+vi, for i =1 to n)} if j>=1
	 * 		0									   if j=0
	 * 
	 */
	
	public void integerKnapsack(int[] s, int []v,int C){
		
		int M[] =new int[C+1];
		M[0]=0;
		
		for(int j=1;j<=C;j++){
			
			
			int max=Integer.MIN_VALUE;
			for(int i=0;i<s.length;i++){
				
				if(j-s[i]>=0&&M[j-s[i]]+v[i]>max){
					max=M[j-s[i]]+v[i];
				}
			}
			M[j]=M[j-1]>max?M[j-1]:max;
		}
		
		System.out.println(M[C]);
		
	}
	
	
	/*
	 * We are given a C sized knapsack, where we can choose or not choose a particular item to fill it in
	 * There are n items with si size and vi value
	 * How to fill optimally in the knapsack so that the max value is gained.
	 * You either choose an item or leave it. Only once is allowed
	 * n=4, C=10
	 * 
	 * Solution: The decision is to make about choosing or not choosing an item
	 * M[0][0]=0 , coz you don't have to choose any item to make a knapsack of size 0
	 * 
	 * M(i,j) be the item which represents a knapsack of size j made by choosing item 1 to i
	 * 
	 * Now, when you choose an item, you reduce the i by 1 and reduce the knapsack size by s[i] and increase 
	 * value by v[i]
	 * When you dont choose, you reduce the i by 1 and keep the size and value the same.
	 * 
	 * M(i,j)=Max(	M(i-1,j), M(i-1,j-si)+vi	)
	 * 
	 * 
	 */
	
	//if(j-s[j]>=0 && M01[i-1][j-s[j]]+v[j] > M01[i-1][j]){
	
	public void zeroOneknapsack(int[] s, int[] v, int C, int n){
	
		int M01[][]=new int [n+1][C+1];
		
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=C;j++){
				
				if(i==0||j==0) M01[i][j]=0;
				else if(s[i-1]<=j)				
					M01[i][j] =Math.max(v[i-1]+M01[i-1][j-s[i-1]], M01[i-1][j]);
				else 
					M01[i][j]=M01[i-1][j];
			}
		}
		
		for(int i=0;i<M01.length;i++){
			for(int j=1;j<M01[i].length;j++){
				System.out.print(" "+M01[i][j]);
			}
			System.out.println();
		}
		System.out.println(M01[n][C]);
		
	}
	
	
	public void makingChange1(int[] s, int []v,int C){
		
		int M[] =new int[11];
		M[0]=0;
		
		for(int j=1;j<=C;j++){	
			
			
			int max=-1;
			for(int i=0;i<s.length;i++){
				
				if(j-s[i]>=0&&M[j-s[i]]+v[i]>max){
					max=M[j-s[i]]+v[i];
				}
			}
			M[j]=M[j-1]>max?M[j-1]:max;
			//M[j]++;
		}
		
		System.out.println(M[C]);
		
	}
	
	/*
	 * Given an array , decide if there is a subset with a particular sum
	 * 
	 * Now, the solution  is to decide whether to take the new element or not
	 * If you take the new element, the i goes down by 1 and subset goes down by Ai
	 * Else, take the previous solution
	 * 
	 * A table M(i,j)= Max{ M(i-1,j), M(i-1,j-A[i])}
	 */
	
	public void subsetSum(int[] A, int sum){
		
		int[][] T=new int [sum+1][A.length+1];
		
		//columns are zero
		for(int i=0;i<T[0].length;i++){
			T[0][i]=1;
		}
		//rows are 0
		for(int i=0;i<T.length;i++){
			T[i][0]=0;
		}
		T[0][0]=0;
		for(int i=1;i<=sum;i++){
			for(int j=1;j<=A.length;j++){
				//T[i][j]=T[i][j-1];
				if(A[j-1]<=i){
					System.out.println("Changing ij"+i+" "+j);
					T[i][j]=Math.max(T[i][j-1],T[i-A[j-1]][j-1]);
				}
			}
		}
		System.out.println("POssibility: "+T[sum][A.length]);
	}
	
	private void print(int[] T){
		
			for(int j=0;j<T.length;j++){
				System.out.print(" "+T[j]);
			}
			System.out.println();
		
	}
	
	
	
	
	private void print(int[][] T){
		for(int i=0;i<T.length;i++){
			for(int j=0;j<T[i].length;j++){
				System.out.print(" "+T[i][j]);
			}
			System.out.println();
		}
	}
	//Nt working...
	public void collectApplesInMatrix(int [][]A){
		
		int T[][] =new int[A.length][A.length];
	
		
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[i].length;j++){
				T[i][j]=A[i][j];
				
				if(i>0&&T[i][j]+T[i-1][j]>T[i][j]) T[i][j]+=T[i-1][j]; 
				if(j>0&&T[i][j]+T[i][j-1]>T[i][j]) T[i][j]+=T[i][j-1];
				
				
				}
			}
		
		
		print(T);
		System.out.println("Most Apples:"+T[A.length-1][A.length-1]);
		
	}
	
	private int min(int a, int b, int c){
		int min=a;
		
		if(a<b&&a<c) min=a;
		if(b<a&&b<c) min=b;
		if(c<a&&c<b) min=c;
		
		return min;
	}
	
	public void maxSquareSizedSubMatrix(int B[][]){
		
		int L[][]=new int[B.length][B.length];
		
		for(int i=0;i<B.length;i++){
			L[i][0]=B[i][0];
		}

		for(int i=0;i<B[0].length;i++){
			L[0][i]=B[0][i];
		}
		
		for(int i=1;i<B.length;i++){
			for(int j=1;j<B[i].length;j++){
				if(B[i][j]==1)
					L[i][j]=min(L[i-1][j],L[i][j-1], L[i-1][j-1])+1;
				else
					L[i][j]=0;
			}
		}
		
		int max=L[0][0], maxi=0, maxj=0;
		
		for(int i=0;i<L.length;i++){
			for(int j=0;j<L.length;j++){
				
				if(L[i][j]>max){
					max=L[i][j];
					maxi=i;
					maxj=j;
				}
			}
		}
		
		for(int i=maxi;i>maxi-max;i--){
			for(int j=maxj;j>maxj-max;j--){
				System.out.print(" "+B[i][j]);
			}
			System.out.println();
		}

		System.out.println("L is..");
		print(L);
		System.out.println("B is..");
		print(B);
		
	}
	
	public void findMaxSubmatrixSum(int A[][]){
		int n=A.length;
		int [][]M=new int[n][n];
		
		
		//Add the matrix vertically
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(j==0)
					M[j][i]=A[j][i];
				else
					M[j][i]=A[j][i]+M[j-1][i];
			}
			
		}
		int maxSoFar=0;
		int min=0,subMatrix=0;
		
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				min=0;subMatrix=0;
				for(int k=0;k<n;k++){
					if(i==0) subMatrix+=M[j][k];
					else subMatrix+=M[j][k]-M[i-1][k];
					
					if(subMatrix<min){
						min=subMatrix;
					}
					if(subMatrix-min>maxSoFar) maxSoFar=subMatrix-min;
				}
			}
		}
		
		System.out.println("Submatrix Sum:"+maxSoFar);
		print(M);
	}
	
	
	
	public int minHopsToEnd(int A[]){
		int n=A.length;
		
		int max=Integer.MAX_VALUE-1;
		int[] result=new int[n];
		
		if(n==0||A[0]==0) return max;
		
		result[0]=0;
		
		for(int i=1;i<n;i++){
			result[i]=max;
			for(int j=0;j<i;j++){
				//check if jump is possible or not...
				
				if(A[j]>=i-j){
					if(result[j]+1<result[i])
						result[i]=result[j]+1;
				}
				
			}
		}
		
		int answer=result[n-1];
		return answer;
	}
	
	public int LCSWithDP(char []X, char[]Y, int m, int n){
		
		int[][] lcs=new int[m+1][n+1];
		
		
		
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				
				if(i==0||j==0){
					lcs[i][j]=0;
				}
				
				else if(X[i-1]==Y[j-1]){
					lcs[i][j]=1+lcs[i-1][j-1];
				}
				else{
					lcs[i][j]=Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
				
			}
		}
		return lcs[m][n];
	}
	
	
	public int minCostPathRecursive(int [][] A, int m, int n){
		
		if(m==A.length||n==A.length) return Integer.MAX_VALUE;
		
		else if(m==A.length-1 && n==A.length-1) return A[m][n];
		
		else{
			return A[m][n]+min(minCostPathRecursive(A, m+1, n+1),minCostPathRecursive(A, m+1, n), minCostPathRecursive(A, m, n+1));
		}
	}
	
	
	public int micCostPathDP(int A[][]){
		
		int[][] tc=new int [A.length+1][A.length+1];
		
		tc[0][0]=A[0][0];
		for(int i=1;i<A.length;i++){
			tc[i][0]=tc[i-1][0]+A[i][0];
		}
		for(int i=1;i<A.length;i++){
			tc[0][i]=tc[0][i-1]+A[0][i];
		}
		
		
		for(int i=1;i<A.length;i++){
			for(int j=1;j<A[i].length;j++){
				
				tc[i][j]=A[i][j]+min(tc[i-1][j-1],tc[i-1][j], tc[i][j-1]);
			}
		}
		
		print(tc);
		return tc[A.length-1][A.length-1];
		
		
		
	}
	
	public int coinChangeRec(int[] denom, int m, int n ){
		
		if(n==0) return 1;
		
		if(n<0) return 0;
		
		if(m<=0 && n>=1) return 0;
		
		return coinChangeRec(denom, m-1, n)+coinChangeRec(denom,m,n-denom[m-1]);
		
	}
	
	
	/*
	 * C(n,k)=C(n-1,k-1)+C(n-1,k)
	 * C(n,0)=C(n,n)=1
	 */
	
	public int binomialCoff(int n, int k){
		if(k==0 || k==n) return 1;
		return binomialCoff(n-1, k-1)+binomialCoff(n-1, k);
	}
	
	/*
	 * Based on pasacals triangle 
	 * Every element is the sum of the number digonnally above it and the one directly above it
	 * 
	 * 1
	 * 11
	 * 121
	 * 1331
	 * 
	 */
	
	public int binomialCoffDP(int n, int k){
		int C[][]=new int[n+1][k+1];
		
		for(int i=0;i<=n;i++){
			for(int j=0;j<=Math.min(i, k);j++){
				if(i==0||j==0)
					C[i][j]=1;
				else
					C[i][j]=C[i-1][j-1]+C[i-1][j];
			}
		}
		print(C);
		return C[n][k];
	}
	
	
	public int eggDropProblem(int n, int k){
		
		if(k==1 || k==0) return k;
		
		if(n==1) return k; // for one egg, we need k trials for k floors
		
		
		int min=Integer.MAX_VALUE; int res;
		for(int i=1;i<=k;i++){
			res=Math.max(eggDropProblem(n-1, i-1), eggDropProblem(n, k-i));
			
			if(res<min) min=res;
		}
		return min+1;
	}
	
	public int eggDropDP(int n, int k){
		
		int [][]egg=new int[n+1][k+1];
		
		for(int i=1;i<=n;i++){
			egg[i][0]=0;
			egg[i][1]=1;
		}
		
		for(int i=1;i<=k;i++){ //for 1 egg, total trials equals number of floors
			egg[1][i]=i;
		}
		int res=Integer.MAX_VALUE;
		for(int i=2;i<=n;i++){
			
			for(int j=2;j<=k;j++){
				egg[i][j]=Integer.MAX_VALUE;
				for (int x = 1; x <= j; x++)
	            {
					res=1+Math.max(egg[i-1][x-1], egg[i][j-x]);
					if(res<egg[i][j])
						egg[i][j]=res;
	            }
			}
		}
		print(egg);
		return egg[n][k];
	}
	
public int lps(char[] str, int begin, int end){
		
		if (begin==end) return 1;
		
		if(str[begin]==str[end] && begin+1==end) return 2;
		
		if(str[begin]==str[end]) return lps(str,begin+1,end-1)+2;
		
		return Math.max(lps(str,begin,end-1), lps(str,begin+1,end));
		
	}
	
	
	
	
	
	public int lpsDP(char [] str)
	{
	   int n = str.length;
	   int i, j, cl;
	   int[][] L=new int[n][n];  // Create a table to store results of subproblems
	 
	 
	   // Strings of length 1 are palindrome of lentgh 1
	   for (i = 0; i < n; i++)
	      L[i][i] = 1;
	 
	    // Build the table. Note that the lower diagonal values of table are
	    // useless and not filled in the process. The values are filled in a
	    // manner similar to Matrix Chain Multiplication DP solution (See
	    // http://www.geeksforgeeks.org/archives/15553). cl is length of
	    // substring
	    for (cl=2; cl<=n; cl++)
	    {
	        for (i=0; i<n-cl+1; i++)
	        {
	            j = i+cl-1;
	            if (str[i] == str[j] && cl == 2)
	               L[i][j] = 2;
	            else if (str[i] == str[j])
	               L[i][j] = L[i+1][j-1] + 2;
	            else
	               L[i][j] = Math.max(L[i][j-1], L[i+1][j]);
	        }
	    }
	 
	    return L[0][n-1];
	}
	
	//n is the lenght of rod
	//price is the price array for different sizes
	//cutRod(n)= max(price[i]+ cutRod(n-i-1)) where i is 0 to n-1
	
	public int cutRod(int[] price, int n){
		
		if(n<=0) return 0;
		
		int maxVal=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			maxVal=Math.max(maxVal, price[i]+cutRod(price, n-i-1));
		}
		return maxVal;
	}
	
	public int cutRodDP(int[] prices, int n){
		
		int tc[]=new int[n+1];
		tc[0]=0;
		
		for(int i=1;i<=n;i++){
			
			int max=Integer.MIN_VALUE;
			for(int j=0;j<i;j++){
				max=Math.max(max, prices[j]+tc[i-j-1]);
			}
			tc[i]=max;
		}
		return tc[n];
	}
	
	public int maxIncSubsequenceSum(int [] A){
		
		int []msis=new int [A.length];
		
		for(int i=0;i<A.length;i++){
			msis[i]=A[i];
		}
		
		for(int i=0;i<A.length;i++){
			
			for(int j=0;j<i;j++){
				if(A[i]>A[j] && msis[i]<msis[j]+A[i])
					msis[i]=A[i]+msis[j];
			}
		}
		//Get the maximum value
		int max=msis[0];
		for(int i=0; i<msis.length;i++){
			max=Math.max(max, msis[i]);
		}
		return max;
	}
	
	
	/*
	 * Given an array arr[0 ... n-1] containing n positive integers, 
	 * a subsequence of arr[] is called Bitonic if it is first increasing, then decreasing. 
	 * 
	 * Solution: calculate lis of arr and lds of arr
	 * 
	 * then find the max of lis[i]+lds[i]-1
	 */
	
	public int lbsWithDP(int[] arr){
		
		int N=arr.length;
		int[] lis=new int[N+1];
		int[] lds=new int[N+1];
		
		for(int i=0;i<lis.length;i++){
			lis[i]=1;
			lds[i]=1;
		}
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[i]>arr[j] && lis[i]<lis[j]+1)
					lis[i]=lis[j]+1;
			}
		}
		
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[i]<arr[j] && lds[i]<lds[j]+1)
					lds[i]=lds[j]+1;
			}
		}
		
		int max=lis[0]+lds[0]-1;
		
		for(int i=0;i<lis.length;i++){
			if(lis[i]+lds[i]-1 > max){
				max=lis[i]+lds[i]-1;
			}
		}
		return max;
	}
	
	/*
	 * Given a string, a partitioning of the string is a palindrome partitioning 
	 * if every substring of the partition is a palindrome. 
	 * For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”. 
	 * Determine the fewest cuts needed for palindrome partitioning of a given string. 
	 * For example, minimum 3 cuts are needed for “ababbbabbababa”. 
	 * The three cuts are “a|babbbab|b|ababa”. If a string is palindrome, then minimum 0 cuts are needed. 
	 * If a string of length n containing all different characters, then minimum n-1 cuts are needed.
	 * 
	 * 
	 * Solution: This is like matrix chain order for multiplication.
	 * 
	 * First you take a substring for all possible length.
	 * Maintain C[][] array for getting the min number of cuts required for str[i...j]
	 * Maintain P[][] array for storing whether the str[i...j] is palindrome or not
	 * 
	 */

	
	public int palindromePartition(char [] str){
		
		int N=str.length;
		int[][]C=new int[N][N];
		boolean [][] P=new boolean[N][N];
		
		for(int i=0;i<C.length;i++){
			C[i][i]=0;
			P[i][i]=true;
		}
		
		for(int L=2;L<=N;L++){ // consider substring of every length
			
			for(int i=0;i<N-L+1;i++){ // consider every starting position
				
				int j=i+L-1; //set ending index
				
				if(L==2) P[i][j]=(str[i]==str[j]);
				
				else P[i][j]=(str[i]==str[j] && P[i+1][j-1]);
				
				if(P[i][j]) C[i][j]=0;
				
				else{
					C[i][j]=Integer.MAX_VALUE;
					for(int k=i;k<j;k++){
						C[i][j]=Math.min(C[i][j], C[i][k]+1+C[k+1][j]);
					}
				}
			}
			
		}
		
		print(C);
		return C[0][N-1];
		
	}
	
	
	/*
	 * Given an array and a sum , check whether the given array can be partitioned into two subsets,
	 * such that the sum in both the subsets is same.
	 * 
	 * Soln: If sum of array elements is odd, return false
	 * If even, check whether there is a subset which sums up to sum/2
	 */
	
	
	public boolean isSubset(int A[], int n, int sum){
		
		if(sum==0) return true;
		if(n==0 && sum!=0) return false;
		
		if(A[n-1]>sum)
			return isSubset(A, n-1, sum);
		else
			return isSubset(A, n-1, sum)||isSubset(A, n-1, sum-A[n-1]);
	}
	
	/*
	 * Partition problem is to determine whether a given set can 
	 * be partitioned into two subsets such that the sum of elements in both subsets is same.
	 */
	
	public boolean partitionProb(int [] A){
		
		int sum=0;
		for(int i:A) sum+=i;
		
		if(sum%2!=0) return false;
		
		else
			return isSubset(A, A.length, sum/2);
	}
	
	/*
	 * You are given n pairs of numbers. In every pair, the first number is always smaller than 
	 * the second number. 
	 * A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. 
	 * Find the longest chain which can be formed from a given set of pairs.
	 * 
	 * 	1) Sort given pairs in increasing order of first (or smaller) element.
		2) Now run a modified 
		LIS process where we compare the second element of already finalized LIS 
		with the first element of new LIS being constructed.
	 */
	
	
	
	public int maxLengthChainOfPairs(Pair[] p){
	
		int mc[]=new int [p.length+1];
		
		for(int i=0;i<mc.length;i++){
			mc[i]=1;
		}
		
		for(int i=0;i<p.length;i++){
			for(int j=0;j<i;j++){
				if(p[i].a > p[j].b && mc[i] < mc[j]+1)
					mc[i]=mc[j]+1;
			}
		}
		int max=mc[0];
		for(int i=0;i<mc.length;i++){
			max=Math.max(max, mc[i]);
		}
		print(mc);
		return max;
	}
	
	//Wrong answer...looks fine though
	
	public int boxStacking(Box[] b){
		
		Box[] rotatedBox=new Box[b.length*3];
		
		for(int i=0;i<rotatedBox.length;i++) rotatedBox[i]=new Box();
		
		for(int i=0,index=0;i<b.length;i++){
			
			rotatedBox[index]=b[i];
			
			index++;
			
			rotatedBox[index].h=b[i].w;
			rotatedBox[index].d=Math.max(b[i].h, b[i].d);
			rotatedBox[index].w=Math.min(b[i].h, b[i].d);
			
			index++;
			
			rotatedBox[index].h=b[i].d;
			rotatedBox[index].d=Math.max(b[i].h, b[i].w);
			rotatedBox[index].w=Math.min(b[i].h, b[i].w);
			
			index++;
		}
		
		Arrays.sort(rotatedBox);
		
		for(Box m: rotatedBox){
			System.out.println(m.toString());
		}
		
		
		int[] maxHeight=new int [rotatedBox.length];
		
		for(int i=0;i<rotatedBox.length;i++)
			maxHeight[i]=rotatedBox[i].h;
		
		
		for(int i=0;i<rotatedBox.length;i++){
			for(int j=0;j<i;j++){
				
				if( rotatedBox[i].w < rotatedBox[j].w && 
					rotatedBox[i].d < rotatedBox[j].d && 
					maxHeight[i] < maxHeight[j]+rotatedBox[i].h){
					
							maxHeight[i]=maxHeight[j]+rotatedBox[i].h;
				}
			}
		}
		
		int max=maxHeight[0];
		for(int i=0;i<maxHeight.length;i++){
			max=Math.max(max, maxHeight[i]);
		}
		
		print(maxHeight);
		return max;
	}
	
	private int divideByN(int a, int b){
		
		while(a%b==0){
			a=a/b;
		}
		return a;
	}
	
	public boolean naiveUglyNumberChecker(int n){
		int num=n;
		num=divideByN(num,2);
		num=divideByN(num,3);
		num=divideByN(num,5);
		
		if(num==1) return true;
		else return false;
		
	}
	
	private int sumOf(int A[], int i, int j){
		int sum=0;
		
		for(int k=i;k<=j;k++){
			sum+=A[k];
		}
		return sum;
	}
	
	/*
	 * The idea of above formula is simple, we one by one try all nodes as root 
	 * (r varies from i to j in second term). 
	 * When we make rth node as root, we recursively calculate optimal cost from i to r-1 and r+1 to j.
	   We add sum of frequencies from i to j (see first term in the above formula), 
	   this is added because every search will go through root and one comparison will be done for every search.
	 */
	
	public int optimalBST(int freq[], int i, int j){
		if(j<i) return 0;// If there are no elements in this subarray
		
		if(j==i) return freq[i];// If there is one element in this subarray
		
		int fsum=sumOf(freq, i, j);// Get sum of freq[i], freq[i+1], ... freq[j]
		
		
		int min=Integer.MAX_VALUE;
		
		// One by one consider all elements as root and recursively find cost
		   // of the BST, compare the cost with min and update min if needed		
		for(int r=i;r<=j;r++){
			int cost=optimalBST(freq, i, r-1)+optimalBST(freq, r+1, j);
			if(cost<min) min=cost;
		}
		return min+fsum;
	}
	
	
	public int optimalBSTWithDP(int keys[], int freq[]){
		
		int n=keys.length;
		int [][] cost=new int [n][n];
		
		for(int i=0;i<freq.length;i++){
			cost[i][i]=freq[i];
		}
		
		for(int L=2;L<=n;L++){
			
			for(int i=0;i<n-L+1;i++){
				
				int j=i+L-1;
				cost[i][j]=Integer.MAX_VALUE;
				
				for(int r=i;r<=j;r++){
					// c = cost when keys[r] becomes root of this subtree
		            int c = ((r > i)? cost[i][r-1]:0) + ((r < j)? cost[r+1][j]:0) + sumOf(freq, i, j);
		            if(c<cost[i][j]){
		            	cost[i][j]=c;
		            }
				}
			}
		}
		
		return cost[0][n-1];
	}
	
	/*
	 * Given a Binary Tree, find size of the Largest Independent Set(LIS) in it.
	 *  A subset of all tree nodes is an independent set if there is no edge between 
	 *  any two nodes of the subset.
		For example, consider the following binary tree. 
		The largest independent set(LIS) is {10, 40, 60, 70, 80} and size of the LIS is 5.
		
		Solution: In CLRS com.ds.tryouts package
	 */
	
	
	//public int LISS(TreeNode<Integer> root){
	
	
	//}
	
	private static final int NUM_OF_STATIONS=4;
	
	public void carAssembly(int [][] costPerStation, int[][] transferCost, int [] entry, int[] exit){
		int t1[]=new int [NUM_OF_STATIONS];
		int t2[]=new int [NUM_OF_STATIONS];
		
		t1[0]=entry[0]+costPerStation[0][0];
		t2[0]=entry[1]+costPerStation[1][0];
		
		for(int i=1;i<NUM_OF_STATIONS;i++){
			
			t1[i]=Math.min((t1[i-1]+costPerStation[0][i]),(t2[i-1]+transferCost[1][i]+costPerStation[0][i]));
			t2[i]=Math.min((t2[i-1]+costPerStation[1][i]),(t1[i-1]+transferCost[0][i]+costPerStation[1][i]));
		}
		
		System.out.println(t1[NUM_OF_STATIONS-1]+exit[0]);
		System.out.println(t2[NUM_OF_STATIONS-1]+exit[1]);

	}
	
	
	public int minInsertionToFormPalindrome(char[] str, int l, int h){
		
		if(l>h) return Integer.MAX_VALUE;
		if(l==h) return 0;
		
		if(l==h-1) return str[l]==str[h]?0:1;
		
		return str[l]==str[h]?minInsertionToFormPalindrome(str, l+1, h-1):Math.min(minInsertionToFormPalindrome(str, l, h-1), minInsertionToFormPalindrome(str, l+1, h))+1; 
		
	}
	
	public int minInsertionsToFormPalindromeDP(char[] str){
		int n=str.length;
		int table[][]=new int [n][n];
		
		for(int gap=1;gap<n;gap++){
			for(int l=0, h=gap;h<n;l++,h++)
				table[l][h]=str[l]==str[h]?table[l+1][h-1]:Math.min(table[l+1][h], table[l][h-1])+1;
		}
		return table[0][n-1];
	}
	
	public int longestCommonSubstring(char [] X, char[] Y){
		
		int m=X.length;
		int n=Y.length;
		
		int table[][]=new int [m+1][n+1];
		int result=0;
		
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				
				if(i==0||j==0)
					table[i][j]=0;
				
				else if(X[i-1]==Y[j-1]){
					table[i][j]=table[i-1][j-1]+1;
					result=Math.max(table[i][j], result);
				}
				else
					table[i][j]=0;
				
			}
		}
		return result;
		
	}
	//Not working...
	public int diceThrowRec(int sum, int numberOfDice, int numberOfFaces){
		
		if(sum<1) return 0;
		if(numberOfDice==1) return sum<=numberOfFaces?1:0;
		
		int numberOfWays=0;
		
		for(int i=1;i<=numberOfFaces;i++){
			numberOfWays+=diceThrowRec(sum-i	, numberOfDice-1 , numberOfFaces);
		}
		
		return numberOfWays;
		
	}
	
	
	public int diceThrowDP(int sum, int numberOfDice, int numberOfFaces){
		
		int table[][]=new int [numberOfDice+1][sum+1];
		
		for(int i=0;i<=numberOfDice && i<= sum;i++){
			table[0][i]=0;
			table[1][i]=1;
		}
		
		for(int i=2;i<=numberOfDice;i++){
			for(int j=1;j<=sum;j++){
				
				for(int k=0;k<=numberOfFaces && k<=j;k++)
				{
					table[i][j]+=table[i-1][j-k];
				}
			}
		}
		
		print(table);
		return table[numberOfDice][sum];
		
	}
	
	/*
	 * Problem statement: Consider a row of n coins of values v1 . . . vn, where n is even. 
	 * We play a game against an opponent by alternating turns. 
	 * In each turn, a player selects either the first or last coin from the row, 
	 * removes it from the row permanently, and receives the value of the coin. 
	 * Determine the maximum possible amount of money we can definitely win if we move first.
	 * 
	 * 
	 * Solution: Recursive solution:
	 * 
	 * Either we choose the Vi th item or the Vjth item
	 * 
	 * F(i,j)= Max(Vi+ min(F(i+2,j),F(i+1,j-1))
	 * 			Vj+min(F(i+1,j-1),F(i,j-2)))
	 * 
	 * F(i,j)=Vi if i==j
	 * F(i,j)=Max(vi, vj) i==j-1
	 * 
	 */
	
	
	public int optimalStrategyForAGame(int arr[]){
		
		int table[][]=new int[arr.length][arr.length];
		
		for(int gap=0;gap<arr.length;gap++){
			for(int i=0,j=gap;j<arr.length;i++,j++){
				
				int x=i+2<=j?table[i+2][j]:0;
				int y=i+1<=j-1?table[i+1][j-1]:0;
				int z=i<=j-2?table[i][j-2]:0;
				table[i][j]=Math.max(arr[i]+Math.min(x,y), arr[j]+Math.min(y,z));
			
			}
		}
		return table[0][arr.length-1];
		
	}
	
	private boolean dictionaryHas(String s){
		Hashtable<String,String> dict=new Hashtable<String,String>();
		
		String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","like","ice","cream"};
		
		for(String t:dictionary)
		dict.put(t, t);
		
		return dict.containsValue(s);
	}
	//Not working...
	public boolean wordBreak(String str){
		
		int size=str.length();
		if(size==0) return true;
		
		for(int i=1;i<=size;i++){
			if(dictionaryHas(str.substring(0, i)) && wordBreak(str.substring(i, size-i)))
					return true;
		}
		
		return false;
		
		
	}
	
	
	
	
	
	public boolean isInterleaved(char[] A, char[] B, char[] C){
		
		boolean IL[][]=new boolean [A.length+1][B.length+1];
		
		if(C.length!=A.length+B.length) return false;
		
		
		for(int i=0;i<=A.length;i++){
			for(int j=0;j<=B.length;j++){
				
				//A B empty
				if(i==0||j==0) IL[i][j]=true;
				
				else if(i==0|| B[j-1]==C[j-1]) IL[i][j]=IL[i][j-1];
				else if(j==0|| A[i-1]==C[i-1]) IL[i][j]=IL[i-1][j];
				
				else if(A[i-1] == C[i+j-1] && B[j-1] != C[i+j-1]) IL[i][j]=IL[i-1][j];
				else if(B[j-1] == C[i+j-1] && A[i-1] != C[i+j-1]) IL[i][j]=IL[i][j-1];
				
				else if(A[i-1] == C[i+j-1] && B[j-1] == C[i+j-1]) IL[i][j]=IL[i-1][j]||IL[i][j-1];
				
			}
		}
		return IL[A.length][B.length];
		
	}
	
	public int editDistanceRecursive(char[] X, char[] Y, int m, int n){
		if(m==0 && n==0) return 0;
		if(m==0) return n;
		if(n==0) return m;
		
		int left=editDistanceRecursive(X, Y, m, n-1)+1;
		int right=editDistanceRecursive(X, Y, m-1, n)+1;
		
		//int temp=(X[m-1]==Y[m-1])?0:1;
		int corner=editDistanceRecursive(X, Y, m-1, n-1)+(X[m-1]==Y[n-1]?0:1);
		
		return min(left,right,corner);
	}
	
	
	public static void main(String...a){
		
		int A[]={0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
		int[] denom={1,2,4,8};
		
		String s = "geeks";
	
		//Box arr[] = { new Box(4, 6, 7), new Box(1, 2, 3),  new Box(4, 5, 6),  new Box(10, 12, 32) };
		
		int B[][]={{0,1,1,0,1},{1,1,0,1,0},{0,1,1,1,0},{1,1,1,1,0},{1,1,1,1,1},{0,0,0,0,0}};
		
		int S[][]={{-1,2,3},{-4,5,6},{-7,8,9}};
		//int arr[] = {1, 101, 2, 3, 100, 4, 5};
		//int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		
		int arr[]={8,15,3,7};
		Pair[] p={new Pair(5,24),new Pair(15,28),new Pair(27,40),new Pair(39,60),new Pair(50,90),};
		
		
		
		//int arr[] = {3, 1, 5, 9, 12};
		int [] keys={3,12,20};
		int [] freq={34,8,50};
		
		int perStation[][] = {{4, 5, 3, 2}, {2, 10, 1, 4}};
		int transfer[][] = {{0, 7, 4, 5},{0, 9, 2, 8}};
		int e[] = {10, 12}, x[] = {18, 7};
		
		DynamicProgramming dp=new DynamicProgramming();
		
		
		System.out.println(dp.editDistanceRecursive("ABC".toCharArray(), "CBA".toCharArray(), 3, 3));
		//System.out.println(dp.isInterleaved("XXY".toCharArray(), "XXZ".toCharArray(), "XXXXZY".toCharArray()));
		//System.out.println(dp.wordBreak("samsungandmango"));
		
		//System.out.println(dp.optimalStrategyForAGame(arr));
		
		//System.out.println(dp.diceThrowDP(6, 3, 8));
		//System.out.println(dp.longestCommonSubstring("geeksforgeeks".toCharArray(), s.toCharArray()));
		
		//System.out.println(dp.minInsertionToFormPalindrome(s.toCharArray(), 0, s.length()-1));
		
		//System.out.println(dp.minInsertionsToFormPalindromeDP(s.toCharArray()));
		//System.out.println(s.length()-dp.LCSWithDP(s.toCharArray(), new StringBuffer(s).reverse().toString().toCharArray(), s.length()-1, s.length()-1));
		//dp.carAssembly(perStation, transfer, e, x);
		
		//System.out.println(dp.boxStacking(arr));
		//System.out.println(dp.optimalBSTWithDP(keys,freq));
		//System.out.println(dp.naiveUglyNumberChecker(301));
		
		//System.out.println(dp.maxLengthChainOfPairs(p));
		//System.out.println(dp.partitionProb(arr));
		//System.out.println(dp.palindromePartition(s.toCharArray()));
		
		//System.out.println(dp.lbsWithDP(arr));
		
		//System.out.println(dp.maxIncSubsequenceSum(arr));
		//System.out.println(dp.eggDropDP(2, 36));
		
		
		
		char X[] = "AGGTAB".toCharArray();
		char Y[] = "GXTXAYB".toCharArray();
		//System.out.println(dp.LCSWithDP(X,Y, X.length	, Y.length));
		
		int cost[][] = { {1, 2, 3},
                		 {4, 8, 2},
                		 {1, 5, 3}};
		
		//System.out.println(dp.binomialCoffDP(6, 4));
		
		//System.out.println(dp.minCostPathRecursive(cost, 0, 0));
		
		//System.out.println(dp.coinChangeRec(denom, denom.length-1, 5));
		
		//System.out.println(dp.micCostPathDP(cost));
		
		//dp.maxSquareSizedSubMatrix(B);
		
		//System.out.println(dp.LIS(A));
		
		//System.out.println(dp.minHopsToEnd(A));
		
		//dp.findMaxSubmatrixSum(S);
		//dp.collectApplesInMatrix(S);
		//dp.subsetSum(A, 15);
		//System.out.println(dp.maxContiguousSum(A));
		//for(int i=0;i<dp.table.length;i++){
			//dp.table[i]=1;
		//}
		
		//for(int i=0;i<dp.catalanTable.length;i++){
			//dp.catalanTable[i]=1;
		//}
		//System.out.println(dp.catalanNumbers(2));
		//int s[]={1,2,4,8};
		//int v[]={-1,-1,-1,-1};
		
		//dp.integerKnapsack(s, v, 10);
		//dp.zeroOneknapsack(s, v, 10, s.length);
		
		//System.out.println(dp.minDist(A, 7, 8));
		
		//dp.subsetSum(A,12);
		//dp.table[0]=1;
		//System.out.println(dp.makingChange(4, denom));
		
		//System.out.println(dp.coinChangeRecursive(6, denom,4));
		//dp.makingCoinChange(6, denom);
		//dp.makingChange1(s, v, 9);
		//for(int i: dp.table)System.out.print(i +" ");
		
		//System.out.println(dp.LIS(A));
	}
}
