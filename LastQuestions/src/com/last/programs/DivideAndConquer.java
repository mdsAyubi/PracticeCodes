package com.last.programs;

public class DivideAndConquer {

public int findFirstOccurence(int[] A, int first, int last, int data){
		
		if(last >= first){
			int mid=first+(last-first)/2;
			
			if((A[mid] == data && mid == first) ||(A[mid-1]<data && A[mid] == data)){
				System.out.println("Mid="+mid);
				return mid;
			}
			else if(A[mid] >= data)
				return findFirstOccurence(A,first, mid-1, data);
				
			else return findFirstOccurence(A,mid+1,last, data); 
		}
	return -1;
	}


public int findNumberOfZeroes(int[] A){
	
	if(A.length!=0)
		return A.length-findFirstOccurence(A, 0, A.length-1, 0);
	else
		return 0;
}

/*
 * from an array of n integers such that there exists a number 1<=k<=n such that 
 * A[1]...A[k] is an increasing sequence and A[k_+1] to A[n] is a decreasing sequence.
 * Find k.
 */

public int serachMaxOrMinPoint(int [] A){
	
	int mid, first=0,last=A.length-1;
	
	while( first <= last){
		if(first == last){
			return A[first];
		}
		else if(first == last-1){
			return Math.max(A[first], A[last]);
			
		}
		else{
			mid= first + (last-first)/2;
			
			if(A[mid]>A[mid-1] && A[mid]>A[mid+1])
				return A[mid];
			else if(A[mid]>A[mid-1] && A[mid]<A[mid+1])
				first=mid+1;
			else if(A[mid]<A[mid-1] && A[mid]>A[mid+1])
				last=mid-1;
			else return -1;
			
		}
	}
	return -1;
	
}

public int searchInRotatedSortedArray(int[] A,int start, int finish, int data){
	int mid=start+(finish-start)/2;
	
	if(start>finish) return -1;
	if(data == A[mid]) return mid;
	
	if(A[start] <= A[mid]) {//first half is sorted
	
		if(data <= A[mid] && data >= A[start])
			return searchInRotatedSortedArray(A,start,mid-1,data);
		else return searchInRotatedSortedArray(A,mid+1,finish,data);
	}
	else {
		if(data > A[mid] && data < A[finish])
			return searchInRotatedSortedArray(A,mid+1,finish,data);
		else return searchInRotatedSortedArray(A,start,mid-1,data);
	}
}

public void findInSortedMAtrix(int[][] A, int data){
	
	int N=A.length-1;
	int i=N;
	int j=1;
	
	while(i >= 0 ){
		
		if(A[i][j] == data) {System.out.println(i+ " "+j); break;}
		
		else if(data < A[i][j]){
			i--;
		}
		else j++;
		
	}
	
	
	
}

	public void findMaxZeroesInMatrix(int [][]A){
	
	int i=0;
	int j=A[0].length-1;
	int count=0;
	
		while (j >= 0 && i < A.length){
		
			if(A[i][j] == 0) {j--;count++;}
			else i++;
		}
	System.out.println("Count= "+count);

	
	}
	// Let's take an example function as f(x) = x^2 - 10*x - 20
	// Note that f(x) can be any monotonically increasing function
	int f(int x) { return (x*x - 10*x - 20); }
	
	public int funcBecomesPositiveForFirstTime(){
		
		if(f(0)>0) return 0;
		
		int i=1;
		while(f(i)<0) i*=2;
		
		return binSearch(i/2,i);
	}
	
	private int binSearch(int low, int high){
		
		int mid=(low+high)/2;
		
		if(f(mid)>=0 && (f(mid-1)<0|| low==mid)) return mid;
		
		if(f(mid)<0) return binSearch(mid+1, high);
		else
			return binSearch(low, mid-1);
		
	}
	
	public String addBitString(String num1, String num2){
		String result="";
		
		StringBuilder n1=new StringBuilder(num1);
		StringBuilder n2= new StringBuilder(num2);
		
		int carry=0;
		int length=makeEqualLength(new StringBuilder(n1), new StringBuilder(n2));
		
		System.out.println("n1:"+n1);
		System.out.println("n2:"+n2);
		
		
		for(int i=length-1;i>=0;i--){
			int firstBit=n1.charAt(i)-'0';
			int secondBit=n2.charAt(i)-'0';
			
			int sum=(firstBit^secondBit^carry)+'0';
			result=(char)sum+result;
			
			carry=(firstBit&secondBit) | (secondBit&carry) | (firstBit& carry);
		}
		if(carry==1) result='1'+result;
		
		return result;
	}
	
	
	public int makeEqualLength(StringBuilder str1, StringBuilder str2)
	{
	    int len1 = str1.length();
	    int len2 = str2.length();
	    if (len1 < len2)
	    {
	        for (int i = 0 ; i < len2 - len1 ; i++)
	            str1 = str1.insert(0, "0");
	        return len2;
	    }
	    else if (len1 > len2)
	    {
	        for (int i = 0 ; i < len1 - len2 ; i++)
	            str2 = str2.insert(0, "0");
	    }
	    return len1; // If len1 >= len2
	}
	public int multiplySingleBit(StringBuilder num1, StringBuilder num2){
		
		return (num1.charAt(0)-'0')*(num2.charAt(0)-'0');
	}
	
	public int karatsubaAlgo(String num1, String num2){
		
		StringBuilder s1=new StringBuilder(num1);
		StringBuilder s2= new StringBuilder(num2);
		
		int n=makeEqualLength(s1, s2);
		//int n=s1.length();
		if(n==0) return 0;
		
		if(n==1) return multiplySingleBit(s1, s2);
		
		int fh=n/2;
		int sh=n-fh;
		
		String xl=s1.substring(0, fh);
		String xr=s1.substring(sh);
	
		
		String yl=s2.substring(0, fh);
		String yr=s2.substring(sh);
		
		int p1=karatsubaAlgo(xl, yl);
		int p2=karatsubaAlgo(xr, yr);
		
		int p3=karatsubaAlgo(addBitString(xl,xr), addBitString(yl,yr));
		
		return p1*(1<<(2*sh)) + (p3-p1-p2)*(1<<sh) +p2;
	}
	
	public int findMinInRotatedSortedArray(int []arr, int low, int high){
		
		if(high<low) return arr[0];
		
		if(low==high) return arr[low]; //or arr[high]
		
		int mid=(low+high)/2;
			
		if(mid<high && arr[mid+1]<arr[mid]) return arr[mid+1];
		if(mid>low && arr[mid]<arr[mid-1]) return arr[mid];
			
		if(arr[high]>arr[mid]) return findMinInRotatedSortedArray(arr, low, mid-1);
		else return findMinInRotatedSortedArray(arr, mid+1, high);
		
	}
	
	
	public int maxSubArraySum(int[] A){
		
		int maxEndingHere=0;
		int maxSoFar=0;
		
		for(int i:A){
			maxEndingHere=Math.max(0, maxEndingHere+i);
			maxSoFar=Math.max(maxSoFar, maxEndingHere);
		}
		
		return maxSoFar;
	}
	
	public int medianOfTwoSortedArrays(int []A , int B[]){
		return findMedian(A,B, 0,A.length-1);
	}
	
	private int findMedian(int[] A, int[] B, int left, int right){
		
		if(left>right) return findMedian(B, A, 0, A.length-1);
		
		int i=(left+right)/2;
		int j=A.length-i-1;
		
		if(A[i]> B[j] && (j==A.length-1|| A[i]<=B[j+1])){
			
			if(i==0 || B[j]> A[i-1]) return (A[i]+B[j])/2;
			else return (A[i] + A[i-1])/2;
		}
		/*Search in left half of ar1[]*/
	    else if (A[i] > B[j] && j != A.length-1 && A[i] > B[j+1])
	        return findMedian(A, B, left, i-1);
	 
	    /*Search in right half of ar1[]*/
	    else /* ar1[i] is smaller than both ar2[j] and ar2[j+1]*/
	        return findMedian(A, B, i+1, right);
	}
	
	public int findLastOccurrence(int[] A, int low, int high, int data){
		
		if(low<=high){
			
			int mid=(low+high)/2;
			
			if((mid==A.length-1 || A[mid+1]>data) && A[mid]==data) {
				return mid;
			}
			
			if(A[mid]>data) return findLastOccurrence(A, low, mid-1, data);
			else return findLastOccurrence(A, mid+1, high, data);
			
		}
		return -1;
		
	}
	
	public double power(double x, double y){
		
		if(y==0) return 1;
		
		double temp=Math.pow(x, y/2);
		
		if(y%2==0)
			return temp*temp;
		else{
			if(y>0)
			return x*temp*temp;
			else
				return (temp*temp)/x;
		}
	}
	
	public static void main(String...a){
		
		DivideAndConquer dnc=new DivideAndConquer();
		
		int [] arr={1,2, 2, 3,3,3,3,3,3,3,3,3, 4};
		
		int ar1[] = {1, 12, 15, 26, 38};
	    int ar2[] = {2, 13, 17, 30, 45};
		
	    System.out.println(dnc.findLastOccurrence(arr, 0, arr.length-1, 3));
	    //System.out.println(dnc.medianOfTwoSortedArrays(ar1, ar2));
		//System.out.println(dnc.maxSubArraySum(arr));
		//System.out.println(dnc.findMinInRotatedSortedArray(arr, 0, arr.length-1));
		//System.out.println(dnc.funcBecomesPositiveForFirstTime());
		//System.out.println(dnc.karatsubaAlgo("1100", "1010"));
		
		//System.out.println(dnc.addBitString("1", "1"));
		//System.out.println(dnc.makeEqualLength(new StringBuilder("101"), new StringBuilder("10000")));
		//System.out.println(dnc.multiplySingleBit(new StringBuilder("1"), new StringBuilder("1")));
	}
}
