package com.last.programs;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.google.common.collect.MinMaxPriorityQueue;
import com.google.common.collect.Ordering;

public class AzSet75 {

	
	//Brute force solution
	public void longestPalindromicSubstring(String s){
		
		int max=0;
		String p="";
		for(int i=0;i<s.length();i++){
			for(int j=i;j<s.length();j++){
				if(isPalindrome(s.substring(i, j+1))){
					if(j-i>max){
						max=j-i;
						p=s.substring(i,j+1);
					}
						
				}
				
			}
		}
		System.out.println(p);
	}
	
	public boolean isPalindrome(String s){
		
		for(int i=0,j=s.length()-1;i<s.length()/2;i++,j--){
			if(s.charAt(i)!=s.charAt(j)){
				return false;
			}
		}
		
		return true;
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
	
	
	public void numberOfTwos(int n){
		
		StringBuilder s=new StringBuilder();
		
		for(int i=0;i<=n;i++){
			s.append(i);
		}
		
		int count=0;
		
		for(char ch: s.toString().toCharArray()){
			if(ch=='2') count++;
		}
		System.out.println(count);
	}
	
	public void sumOfDifference(int[] A){
		
		int sum1=0,sum2=0;
		
		ArrayList<Integer> bag1=new ArrayList<Integer>();
		ArrayList<Integer> bag2=new ArrayList<Integer>();
		
		for(int i: A){
			
			if(sum1<=sum2) {sum1+=i;bag1.add(i);}
			else {sum2+=i;bag2.add(i);}
			
			
		}
		
		System.out.println("sum1:"+sum1);
		System.out.println(bag1);
		
		
		System.out.println("sum2:"+sum2);
		System.out.println(bag2);
		
	}
	public int printMin(int[] A, int low, int high){
		int min=A[low];
		
		for(int i=low;i<high;i++){
			if(min>A[i])
				min=A[i];
		}
		return min;
	}
	
	
public void printSlidingMin(int [] A, int k){
		
		int low=0, high=k;
		int min=A[low];
		
		
		while(high<A.length){
			
			if(min<A[low]) min=printMin(A, low, high);
			if(A[high]<min) min=A[high];
			System.out.print(" "+min);
			low++;high++;
		}
		
	}

public void printMaxZeroes(int[][] A){
	
	int i=0, j=A[0].length-1;
	int count=0;
	String s="";
	while(j>=0&&i<A.length){
		if(A[i][j]==0) {count++;j--;}
		
		else{
			i++;
		}
	}
	
	System.out.println(count);
	
}
	

public void printSlidingoptimized(int[] A, int k){
	
	//PriorityQueue heap=new PriorityQueue();
	MinMaxPriorityQueue<Integer> h=MinMaxPriorityQueue.orderedBy(Ordering.natural()).create();
	for(int i=0;i<k;i++){
		h.add(A[i]);
	}
	System.out.print(" "+h.peek());
	for(int i=k;i+k<A.length;i++){
		h.add(A[i]);h.remove(A[i-k]);
		System.out.print(" "+h.peek());
	}
}

	public static void main(String...a){
		AzSet75 obj=new AzSet75();
		String s="amma";
		int[] A={4,5,8,9,11,7,6,2,1,4,3,12,0,1};
		
		int I[][]={{1,1,1,0,0,0},{1,1,0,0,0,0},{1,0,0,0,0,0},{1,1,1,0,0,0}};
		
		//System.out.println(obj.isPalindrome("madamsss"));
		//obj.longestPalindromicSubstring("imamadam");
		//System.out.println(obj.lps(s.toCharArray(), 0, s.length()-1));
		//System.out.println(obj.lpsDP(s.toCharArray()));
		//obj.numberOfTwos(100);
		//obj.sumOfDifference(A);
		//obj.printSlidingMin(A, 2);
		//System.out.println();
		//obj.printSlidingoptimized(A,2);
		//System.out.println(obj.printMin(A, 0, A.length-1));
		obj.printMaxZeroes(I);
	}
}
