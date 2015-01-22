package com.last.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AzSet78 {
	
	public void firstRepeated(String in){
		
		char [] arr=in.toLowerCase().toCharArray();
		char[] letter=new char[26];
		
		for(int i=0;i<arr.length;i++){
			letter[arr[i]-97]++;
		}
		for(int i=0;i<arr.length;i++){
			if(letter[arr[i]-97]==1){
				System.out.println(arr[i]);
				break;
			}
		}
		
	}
	char[] p=new char [1024];
	public void parenthesis(int pos, int n, int open, int close){
		
		
		if(close==n){
			System.out.println(new String(p));
			return;
		}
		else{
			if(open>close){
				p[pos]='}';
				parenthesis(pos+1, n, open, close+1);
			}
			if(open<n){
				p[pos]='{';
				parenthesis(pos+1, n, open+1, close);
			}
		}

	}
	
	
	private CountIndex[] getCoutIndex(char[] arr){
		
		CountIndex[] ci=new CountIndex[26];
		
		for(int i=0;i<ci.length;i++){
			ci[i]=new CountIndex();
		}
		
		for(int i=0;i<arr.length;i++){
			(ci[arr[i]-97].count)++;
			if(ci[arr[i]-97].count==1){
				ci[arr[i]-97].firstIndex=i;
			}
		}
		return ci;
	}
	
	int firstRepeatedInStream=Integer.MAX_VALUE;
	public void firstRepeatedInStream(String in){
		char[] arr=in.toLowerCase().toCharArray();
		CountIndex[] ci=new CountIndex[26];
		
		for(int i=0;i<ci.length;i++){
			ci[i]=new CountIndex();
		}
		
		for(int i=0;i<in.length();i++){
			(ci[arr[i]-97].count)++;
			if(ci[arr[i]-97].count==1){
				ci[arr[i]-97].firstIndex=i;
				
			}
			int res=Integer.MAX_VALUE;
			for(int j=0;j<ci.length;j++){
				if(ci[j].count==1&&ci[j].firstIndex<res){
					res=ci[j].firstIndex;
				}
			}
			if(res!=Integer.MAX_VALUE)
			System.out.println(in.charAt(res));
			else{
				System.out.println("None");
			}
		}
		
		
	}
	
	
	
	
	
	
	public void firstRepeatedInOneScan(String in){
		
		CountIndex[] ci=getCoutIndex(in.toLowerCase().toCharArray());
		int res=Integer.MAX_VALUE;
		
		for(int i=0;i<ci.length;i++){
			if(ci[i].count==1&&ci[i].firstIndex<res){
				res=ci[i].firstIndex;
			}
		}
		
		System.out.println(in.charAt(res));
	}
	
	private void permutation(String prefix, String str, ArrayList<String> p, int k) {
	    int n = str.length();
	    if (n == 0) p.add(k++,prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), p, k);
	    }
	}
	
	public int nextGreaterWithSameDigitBF(String i){
		
		
		ArrayList<String> p=new ArrayList<String>();
		permutation("", i, p, 0);
		Collections.sort(p);
		System.out.println(p.toString());
		return Integer.parseInt(p.get(p.indexOf(i)+1));
		
	}
	
	
	public void powerSet(int A[]){
		
		int k=0,p;
		for(int i=1;i<Math.pow(2,A.length);i++){
			
			k=i; p=0;
			while(k>0){
				
				if((k&1)==1){
					System.out.print(" "+A[p]);
				}
				p++;
				k=k>>1;
			}
			
			System.out.println();
		}
	}
	
	private void printThisPermutation(int[] A, int k){
		
		int i=k;int p=0;
		while(i>0){
			if((i&1)==1){
				System.out.print(" "+A[p]);
			}
			i=i>>1;
			p++;
		}
		System.out.println();
	}
	
	
	public void allSubsetWithZeroSum(int[] A){
		int k=0,p=0,sum=0;
		for(int i=0;i<Math.pow(2,A.length);i++){
			
			k=i;sum=0;p=0;
			while(k>0){
				if((k&1)==1){
					sum+=A[p];
				}
				k=k>>1;
				p++;
			}
			if(sum==0){
				printThisPermutation(A,i);
			}
		}
	}
	
	
	public void nextGreaterWithSameDigit(String i){
		
		int [] a=new int[i.length()];
		int j=0;
		for(char c: i.toCharArray()){
			a[j++]=c-48;
		}
		System.out.println(Permutations.nextPermutation(a));
		for(int k:a){
			System.out.print(k);
		}
		
	}
	private void swap(int[] A,int i, int j){
		int temp=A[i];
		A[i]=A[j];
		A[j]=temp;
	}
	public void nextGreaterOptimal(String str){
		int [] arr=new int[str.length()];
		int j=0;
		for(char c: str.toCharArray()){
			arr[j++]=c-48;
		}
		
		//Split the array, right side into longest decreasing sequence
		j=arr.length-1;
		while(j>0){
			if(arr[j-1]>arr[j]) j--;
			else break;
		}
		System.out.println("j:"+j);
		
		int i=j-1; //first digit in the left sequence
		
		int k=j;
		int min=k;
		while(k<arr.length){
			if(arr[k]<arr[min]&&arr[k]>arr[i]){
				min=k;
			}
			k++;
		}
		swap(arr,i,min);
		Arrays.sort(arr, j, arr.length);// sort the left sequence..
		
		for(int m:arr){
			System.out.print(m);
		}
	}
	
	
	public int[] multiplyVeryLongNumbers(char[] a, char[] b){
		
		int[] result = new int[a.length*b.length+1];
		int k = 0;//result.length-1;
		int carry = 0;
		int temp=0;
		int i=0,j=0;
		for(i=0;i<a.length;i++){
			for(j=0;j<b.length;j++){
				temp = (a[i]-'0')*(b[j]-'0') + carry;
				result[i+j]+= temp%10;
				if(result[i+j]>10){
					int t=result[i+j];
					result[i+j]=t%10;
					result[i+j-1]+=t/10;
				}
				carry = temp/10;
				
			}
			result[i+j]+=carry;
		}
		
		for(k=0;k<i+j;k++){
			System.out.print(result[k]);
		}
		System.out.println();
		return Arrays.copyOf(result, i+j-1);
		//System.out.println(new String(result));
		//return new String(result);
		
	}
	
	public static void main(String...a){
		String s="teeetrson";
		AzSet78 obj=new AzSet78();
		int A[] ={1,2,3,-2,-1,4,-5,1 };
		//obj.firstRepeated(s);
		//obj.firstRepeatedInOneScan(s);
		//obj.firstRepeatedInStream(s);
		//System.out.println(s.charAt(obj.firstRepeatedInStream));
		//System.out.println(obj.nextGreaterWithSameDigitBF("5324"));
		//obj.nextGreaterWithSameDigit("123453");
		//obj.nextGreaterOptimal("123453");
		//obj.allSubsetWithZeroSum(A);
		//obj.powerSet(A);
		int[] res = obj.multiplyVeryLongNumbers("10000000000000000000000".toCharArray(), "100".toCharArray());
		for(int i:res){
			System.out.println(i);
		}
		
		//obj.parenthesis(0, 5, 0, 0);
	}

}

class CountIndex{
	int count;
	int firstIndex;
}
