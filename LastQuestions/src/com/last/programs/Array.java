package com.last.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class Array {

	public boolean checkForPairWithSumX(int[] arr,int sum){
		Hashtable<Integer, Integer> seen=new Hashtable<Integer, Integer>();
		
		for(int i=0;i<arr.length;i++){
			if(sum-arr[i] > 0 && seen.containsKey(sum-arr[i])){
				return true;
			}
			else
				seen.put(arr[i], arr[i]);
		}
	
	return false;
	}
	
	public int majorityElement(int A[]){
		
		int count=0, element=Integer.MIN_VALUE;
		
		for(int i=0;i<A.length;i++){
			if(count==0){
				element=A[i];
				count=1;
			}
			else if(element==A[i]){
				count++;
			}
			else{
				count--;
			}
		}
		return element;
		
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
	//median of two sorted arrays
	public int findMedian(int[] A, int[] B, int left, int right){
		
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
	
	
	public int getOddOccurrence(int ar[], int ar_size)
	{
	     int i;
	     int res = 0; 
	     for (i=0; i < ar_size; i++)     
	        res = res ^ ar[i];
	      
	     return res;
	}
	
	public int[] leftRotate(int arr[], int d, int n)
	{
	  int i;
	  for (i = 0; i < d; i++)
	    leftRotatebyOne(arr, n);
	  
	  return arr;
	}
	
	private void swap(int arr[], int fi, int si, int d)
	{
	   int i, temp;
	   for(i = 0; i<d; i++)   
	   {
	     temp = arr[fi + i];
	     arr[fi + i] = arr[si + i];
	     arr[si + i] = temp;
	   }     
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
	
	public void leftRotateByBlockSwap(int arr[], int d, int n)
	{
	  int i, j;
	  if(d == 0 || d == n)
	    return;
	  i = d;
	  j = n - d;
	  while (i != j)
	  {
	    if(i < j) /*A is shorter*/
	    {
	      swap(arr, d-i, d+j-i, i);
	      j -= i;
	    }
	    else /*B is shorter*/
	    {
	      swap(arr, d-i, d, j);
	      i -= j;
	    }
	    // printArray(arr, 7);
	  }
	  /*Finally, block swap A and B*/
	  swap(arr, d-i, d, i);
	}
	
	private void leftRotatebyOne(int arr[], int n)
	{
	  int i, temp;
	  temp = arr[0];
	  for (i = 0; i < n-1; i++)
	     arr[i] = arr[i+1];
	  arr[i] = temp;
	}
	
	public void printLeaders(int arr[])
	{
	  int maxFromRight =  arr[arr.length-1];
	  int i;
	 
	  System.out.println(maxFromRight);   
	  for(i = arr.length-2; i >= 0; i--)
	  {
	    if(maxFromRight < arr[i])
	    {
	       System.out.println(arr[i]);
	       maxFromRight = arr[i];
	    }
	  }    
	}
	
	private int merge(int[] A,int p,int q,int r){
		int inversion=0;
		int n1=q-p+1;
		int n2=r-q;
		int i=0,j=0,k=0;
		int	L[]=new int[n1+1];
		int R[]=new int[n2+1];
		
		
		
		for(i=0;i<n1;i++){
			L[i]=A[p+i];
		}
		L[n1]=Integer.MAX_VALUE;
		for(j=0;j<n2;j++){
			R[j]=A[q+j+1];
		}
		R[n2]=Integer.MAX_VALUE;
		
		System.out.println("Left Array");
		//print(L);

		System.out.println("Right Array");
		//print(R);
		
		i=0;j=0;
		for(k=p;k<=r;k++){
			if(L[i]<=R[j]){
				A[k]=L[i++];
				inversion++;
			}
			else
				A[k]=R[j++];
		}
	return inversion;	
	}
	
	
	public int countInversions(int[] A, int p, int r ){
		int inversions = 0;
		if (p < r){
		int q=	(p + r)/2;

		inversions = inversions +countInversions(A, p, q);
		inversions = inversions +countInversions(A, q + 1, r );
		inversions = inversions +merge(A, p, q, r );
		}
		return inversions;
	}
	
	void minAbsSumPair(int arr[], int n)
	{
	  // Variables to keep track of current sum and minimum sum
	  int sum, min_sum = Integer.MAX_VALUE;
	 
	  // left and right index variables
	  int l = 0, r = n-1;
	 
	  // variable to keep track of the left and right pair for min_sum
	  int min_l = l, min_r = n-1;
	 
	  /* Array should have at least two elements*/
	  if(n < 2)
	  {
	    System.out.printf("Invalid Input");
	    return;
	  }
	 
	  /* Sort the elements */
	  Arrays.sort(arr);
	 
	  while(l < r)
	  {
	    sum = arr[l] + arr[r];
	 
	    /*If abs(sum) is less then update the result items*/
	    if(Math.abs(sum) < Math.abs(min_sum))
	    {
	      min_sum = sum;
	      min_l = l;
	      min_r = r;
	    }
	    if(sum < 0)
	      l++;
	    else
	      r--;
	  }
	 
	  System.out.printf(" The two elements whose sum is minimum are %d and %d",
	          arr[min_l], arr[min_r]);
	}
	
	/* Function to print first smallest and second smallest elements */
	void print2Smallest(int arr[], int arr_size)
	{
	    int i, first, second;
	 
	    /* There should be atleast two elements */
	    if (arr_size < 2)
	    {
	    	System.out.printf(" Invalid Input ");
	        return;
	    }
	 
	    first = second = Integer.MAX_VALUE;
	    for (i = 0; i < arr_size ; i ++)
	    {
	        /* If current element is smaller than first then update both
	          first and second */
	        if (arr[i] < first)
	        {
	            second = first;
	            first = arr[i];
	        }
	 
	        /* If arr[i] is in between first and second then update second  */
	        else if (arr[i] < second && arr[i] != first)
	            second = arr[i];
	    }
	    if (second == Integer.MAX_VALUE)
	        System.out.printf("There is no second smallest element\n");
	    else
	    	System.out.printf("The smallest element is %d and second Smallest element is %d\n",
	               first, second);
	}
	
	public int maxDiff(int[] A){
		
		int minElement=A[0];
		int maxDiff=Integer.MIN_VALUE;
		
		for(int i=0;i<A.length;i++){
			
			int diff=A[i]-minElement;
			
			if(diff>maxDiff) maxDiff=diff;
			
			if(A[i]<minElement) minElement=A[i];
		}
		return maxDiff;
	}
	
	public void intersectionOfSortedArray(int[]A, int[]B){
		
		int i=0, j=0;
		
		while(i<A.length && j< B.length){
			
			if(A[i]<B[i]) i++;
			else if(B[i]<A[i]) j++;
			else
			{
				System.out.println(A[i]);
				i++;j++;
			}
		}
	}
	
	public int ceilOfXInArr(int[] A, int x, int low, int high){
		
		if(x<A[low]) return A[low];
		
		if(x>A[high]) return -1;
		
		int mid=(low+high)/2;
		
		if(x==A[mid]) return A[mid];
		
		else if(x>A[mid]){
			if(mid+1 <= high && x<=A[mid+1])
				return A[mid+1];
			else
				return ceilOfXInArr(A, x, mid+1, high);
		}
		else{
		if(mid-1 >= low && x >= A[low])
				return A[mid-1];
			else
				return ceilOfXInArr(A, x, low, mid-1);
		}
		
	}
	
	public void prodcutArrayPuzzle(int[] A){
		
		int prod[] =new int [A.length];
		int temp=1;
		
		for(int i=0;i<A.length;i++){
			prod[i]=1;
		}
		
		for(int i=0;i<A.length;i++){
			prod[i]=temp;
			temp*=A[i];
		}
		temp=1;
		for(int i=A.length-1;i>=0;i--){
			prod[i]*=temp;
			temp*=A[i];
		}
		
		for(int i=0;i<A.length;i++){
			System.out.print(" "+prod[i]);
		}
	}
	
	public void separateEvenOdd(int[]A){
		
		int left=0;
		int right= A.length-1;
		
		while(left<right){
			
			while(A[left]%2==0&&left<right)left++;
			while(A[right]%2==1&&left<right)right--;
			
			if(left<right){
				int temp=A[left];
				A[left]=A[right];
				A[right]=temp;
				
				left++;right--;
			}
			
			
		}
		for(int i:A){
			System.out.println(i+" ");
		}
		
	}
	
	private void swap(int[]A, int i, int j){
		int temp=A[i];
		A[i]=A[j];
		A[j]=temp;
	}
	
	public void separate012(int[] A){
		int low=0, mid=0, high=A.length-1;
		
		while(mid<=high){
			switch(A[mid]){
			
			case 0: swap(A,low,mid);low++;mid++;break;
			case 1:mid++; break;
			case 2: swap(A,mid,high);high--;break;
			
			}
		}
		
		//print(A);
	}
	
public void findUnsortedArray(int [] A){
		
		int start=0,end=0;
		int i;
		for(i=0;i<=A.length-2;i++){
			if(A[i]>A[i+1]){
				start=i; break;
			}
		}
		if(i==A.length-1){
			System.out.println("Completelty Sorted..");
			return;
		}
		for(i=A.length-1;i>0;i--){
			if(A[i]<A[i-1]){
				end=i; break;
			}
		}
		
		System.out.println("Start: "+start+" End: "+end);
		int min=A[start];
		for(i=start;i<=end;i++){
			if(A[i]<min)
				min=A[i];
		}
		int max=A[start];
		for(i=start;i<=end;i++){
			if(A[i]>max)
				max=A[i];
		}
		
		for(i=0;i<=start;i++){
			if(A[i]>min)
				{start=i;break;}
		}
		for(i=A.length-1;i>=end+1;i--){
			if(A[i]<max)
				{end=i;break;}
		}
		
		
		System.out.println("Start: "+start+" End: "+end);
		
		
	}
	
	public void detectDuplicates(int[] A){
	
	for(int i=0;i<A.length;i++){
		
		System.out.println("A[i]= "+A[i]+" A[A[i]]"+A[Math.abs(A[i])]);
		if(A[Math.abs(A[i])]<0){
			System.out.println("Duplicate"+A[i]);
			break;
			//return;
		}
		
		else{
			System.out.println("Else part");
			A[A[i]]=-A[A[i]];
		}
	}
	System.out.println("No duplicates");
	}

	public int equilibrium(int arr[], int n)
	{
	   int sum = 0;      // initialize sum of whole array
	   int leftsum = 0; // initialize leftsum
	   int i;
	 
	   /* Find sum of the whole array */
	   for (i = 0; i < n; ++i)
	        sum += arr[i];
	 
	   for( i = 0; i < n; ++i)
	   {
	      sum -= arr[i]; // sum is now right sum for index i
	 
	      if(leftsum == sum)
	        return i;
	 
	      leftsum += arr[i];
	   }
	 
	    /* If no equilibrium index found, then return 0 */
	    return -1;
	}
	/*
	 * Given a sorted array of n integers where each integer is in the range from 0 to m-1 and m > n. 
	 * Find the smallest number that is missing from the array.
	 */
	public int findSmallestMissing(int array[], int start, int end) {
		 
	    if(start  > end)
	      return end + 1;
	 
	    if (start != array[start])
	      return start;
	 
	    int mid = (start + end) / 2;
	 
	    if (array[mid] > mid)
	      return findSmallestMissing(array, start, mid);
	    else
	      return findSmallestMissing(array, mid + 1, end);
	}
	
	private int getMin(int[]A){
		int min=A[0];
		
		for(int i=0;i<A.length;i++){
			if(A[i]<min)
				min=A[i];
		}
		return min;
	}
	
	private int getMax(int[]A){
		int max=A[0];
		
		for(int i=0;i<A.length;i++){
			if(A[i]>max)
				max=A[i];
		}
		return max;
	}
	
	
	public boolean isConsecutive(int[] A){
		
		int min=getMin(A);
		int max=getMax(A);
		
		boolean visited[]=new boolean[A.length];
		
		if(max-min+1==A.length){
			
			for(int i=0;i<A.length;i++){
				
				if(visited[A[i]-min]==true) return false;
				
				else visited[A[i]-min]=true;
			}
			return true;
		}
		else return false;
	}
	
	
	//Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
	public int getMinIMinusJ(int[]A){
		
		int LMin[] = new int[A.length];
		int RMax[] = new int[A.length];
		int maxDiff=Integer.MIN_VALUE;
		
		LMin[0]=A[0];
		for(int i=1;i<A.length;i++){
			LMin[i] = Math.min(LMin[i-1], A[i]);
		}
		
		RMax[0]=A[A.length-1];
		for(int i=A.length-2;i>=0;i--){
			RMax[i] = Math.max(RMax[i+1], A[i]);
		}
		
		int i=0, j=0;
		while( i < A.length && j< A.length){
			
			if(LMin[i] < RMax[j]){
				maxDiff= Math.max(maxDiff, j-i);
				j++;
			}
			else
				i++;
		}
		return maxDiff;
		
	}
	public void printKMax(int arr[], int n, int k)
	{
	    int j, max;
	 
	    for (int i = 0; i <= n-k; i++)
	    {
	        max = arr[i];
	 
	        for (j = 1; j < k; j++)
	        {
	            if (arr[i+j] > max)
	               max = arr[i+j];
	        }
	        System.out.printf("%d ", max);
	    }
	}
	 
	public boolean isSubsetArray(int[] A, int [] B){
		
		//B is the smaller array
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		for(int i:B) table.put(i, i);
		
		for(int i=0;i<A.length;i++){
			if(!table.contains(A[i]))
				return false;
		}
		return true;
		
	}
	
	//Given an unsorted array arr[] and two numbers x and y, 
	//find the minimum distance between x and y in arr[]. 
	
	public int minDistanceBetweenNumbers(int[] A, int x, int y){
		int i=0;
		int prev=0;
		int minDist=Integer.MAX_VALUE;
		
		for( i=0;i<A.length;i++){
			if(A[i]==x || A[i] == y){
				prev=i;
				break;
			}
		}
		
		for(;i<A.length;i++){
			
			if(A[i]==x || A[i] == y){
				if(A[prev]!=A[i] && (i-prev) < minDist){
					minDist = i-prev;
					prev=i;
				}
				else prev=i;
			}
		}
		return minDist;
	}
	
	//One is missing and other is repeating
	public void getTwoElements(int arr[], int n)
	{
	  int xor1;   /* Will hold xor of all elements and numbers from 1 to n */
	  int set_bit_no;  /* Will have only single set bit of xor1 */
	  int i;
	  int x = 0;
	  int y = 0;
	 
	  xor1 = arr[0];
	 
	  /* Get the xor of all array elements elements */
	  for(i = 1; i < n; i++)
	     xor1 = xor1^arr[i];
	 
	  /* XOR the previous result with numbers from 1 to n*/
	  for(i = 1; i <= n; i++)
	     xor1 = xor1^i;
	 
	  /* Get the rightmost set bit in set_bit_no */
	  set_bit_no = xor1 & ~(xor1-1);
	 
	  /* Now divide elements in two sets by comparing rightmost set
	   bit of xor1 with bit at same position in each element. Also, get XORs
	   of two sets. The two XORs are the output elements.
	   The following two for loops serve the purpose */
	  for(i = 0; i < n; i++)
	  {
	    if((arr[i] & set_bit_no) == 1)
	     x = x ^ arr[i]; /* arr[i] belongs to first set */
	    else
	     y = y ^ arr[i]; /* arr[i] belongs to second set*/
	  }
	  for(i = 1; i <= n; i++)
	  {
	    if((i & set_bit_no)==1)
	     x = x ^ i; /* i belongs to first set */
	    else
	     y = y ^ i; /* i belongs to second set*/
	  }
	 
	  /* Now *x and *y hold the desired output elements */
	  System.out.println(x +" "+ y);
	}
	
	//arr[i]=i
	public int fixedPointInArray(int arr[], int low, int high)
	{
	    if(high >= low)
	    {
	        int mid = (low + high)/2;  /*low + (high - low)/2;*/
	        if(mid == arr[mid])
	            return mid;
	        if(mid > arr[mid])
	            return fixedPointInArray(arr, (mid + 1), high);
	        else
	            return fixedPointInArray(arr, low, (mid -1));
	    }
	 
	    /* Return -1 if there is no Fixed Point */
	    return -1;
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
	public int recursivePeek(int []A, int first, int last){
		
		if(first==last){
			return A[first];
		}
		else if(first==last-1){
				return Math.max(A[first], A[last]);
		 }
		else {
			
			int mid=(first+last)/2;
			
			if(A[mid-1]<A[mid]&& A[mid]>A[mid+1]) return A[mid];
				
			
			else if(A[mid-1]<A[mid]&& A[mid]<A[mid+1]) first=mid+1;
			
				
			else if(A[mid-1]>A[mid]&& A[mid]>A[mid+1]) last=mid-1;
		}
		return recursivePeek(A, first, last);
		 
	}
	
	public void constructLowerArray (int arr[], int []countSmaller, int n)
	{
	  int i, j;
	 
	  // initialize all the counts in countSmaller array as 0
	  for  (i = 0; i < n; i++)
	     countSmaller[i] = 0;
	 
	  for (i = 0; i < n; i++)
	  {
	    for (j = i+1; j < n; j++)
	    {
	       if (arr[j] < arr[i])
	         countSmaller[i]++;
	    }
	  }
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
	
	public int subArraySum(int arr[], int n, int sum)
	{
    /* Initialize curr_sum as value of first element
       and starting point as 0 */
    int curr_sum = arr[0], start = 0, i;
 
    /* Add elements one by one to curr_sum and if the curr_sum exceeds the
       sum, then remove starting element */
    for (i = 1; i <= n; i++)
    {
        // If curr_sum exceeds the sum, then remove the starting elements
        while (curr_sum > sum && start < i-1)
        {
            curr_sum = curr_sum - arr[start];
            start++;
        }
 
        // If curr_sum becomes equal to sum, then return true
        if (curr_sum == sum)
        {
        	System.out.printf ("Sum found between indexes %d and %d", start, i-1);
            return 1;
        }
 
        // Add this element to curr_sum
        if (i < n)
          curr_sum = curr_sum + arr[i];
    }
 
    // If we reach here, then no subarray
    System.out.printf("No subarray found");
    return 0;
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
	
	// returns true if there is triplet with sum equal
	// to 'sum' present in A[]. Also, prints the triplet
	public boolean find3Numbers(int A[], int arr_size, int sum)
	{
	    int l, r;
	 
	    /* Sort the elements */
	    Arrays.sort(A);
	    /* Now fix the first element one by one and find the
	       other two elements */
	    for (int i = 0; i < arr_size - 2; i++)
	    {
	 
	        // To find the other two elements, start two index variables
	        // from two corners of the array and move them toward each
	        // other
	        l = i + 1; // index of the first element in the remaining elements
	        r = arr_size-1; // index of the last element
	        while (l < r)
	        {
	            if( A[i] + A[l] + A[r] == sum)
	            {
	                System.out.printf("Triplet is %d, %d, %d", A[i], A[l], A[r]);
	                return true;
	            }
	            else if (A[i] + A[l] + A[r] < sum)
	                l++;
	            else // A[i] + A[l] + A[r] > sum
	                r--;
	        }
	    }
	 
	    // If we reach here, then no triplet was found
	    return false;
	}
	
public void findTwoNonRepeatingInArray(int[] A){
		
		int xor=0;
		int setBit=0;
		int x=0,y=0;
		
		for(int i:A) xor^=i;
		
		setBit=xor & ~(xor-1);
		
		for(int i=0;i<A.length;i++){
			
			if((A[i] & setBit)==1)
				x=x^A[i];
			else
				y=y^A[i];
		}
		System.out.println(x);
		System.out.println(y);
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

public int maxSubarrayProduct(int arr[], int n)
{
    // max positive product ending at the current position
    int maxEndingHere = 1;
 
    // min negative product ending at the current position
    int minEndingHere = 1;
 
    // Initialize overall max product
    int maxSoFar = 1;
 
    /* Traverse throughout the array. Following values are maintained after the ith iteration:
       max_ending_here is always 1 or some positive product ending with arr[i]
       min_ending_here is always 1 or some negative product ending with arr[i] */
    for (int i = 0; i < n; i++)
    {
        /* If this element is positive, update max_ending_here. Update
           min_ending_here only if min_ending_here is negative */
        if (arr[i] > 0)
        {
            maxEndingHere = maxEndingHere*arr[i];
            minEndingHere = Math.min (minEndingHere * arr[i], 1);
        }
 
        /* If this element is 0, then the maximum product cannot
           end here, make both max_ending_here and min_ending_here 0
           Assumption: Output is always greater than or equal to 1. */
        else if (arr[i] == 0)
        {
            maxEndingHere = 1;
            minEndingHere = 1;
        }
 
        /* If element is negative. This is tricky
           max_ending_here can either be 1 or positive. min_ending_here can either be 1 
           or negative.
           next min_ending_here will always be prev. max_ending_here * arr[i]
           next max_ending_here will be 1 if prev min_ending_here is 1, otherwise 
           next max_ending_here will be prev min_ending_here * arr[i] */
        else
        {
            int temp = maxEndingHere;
            maxEndingHere = Math.max (minEndingHere * arr[i], 1);
            minEndingHere = temp * arr[i];
        }
 
        // update max_so_far, if needed
        if (maxSoFar <  maxEndingHere)
          maxSoFar  =  maxEndingHere;
    }
 
    return maxSoFar;
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
	//print(mc);
	return max;
}

/*Given an array of n integers, find the 3 elements such that a[i] < a[j] < a[k] and i < j < k in 0(n) time. 
If there are multiple such triplets, then print any one of them.
*/	
	public void findTriplet(int []A){
	
		int smaller[] = new int[A.length];
		int greater[] = new int[A.length];
		
		int min=0;
		int max=A.length-1;
		
		smaller[0]=-1;
		for(int i=1;i<A.length;i++){
			
			if(A[i]<A[min]){
				min=i;
				smaller[i]=-1;
			}
			else smaller[i]=min;
		}
		greater[A.length-1]=-1;
		for(int i=A.length-2;i>=0;i--){
			
			if(A[i]>A[max]){
				max=i;
				greater[i]=-1;
			}
			else greater[i]=max;
		}
		
		for(int i=0;i<A.length;i++){
			if(smaller[i] !=-1 && greater[i] != -1){
				System.out.println(A[smaller[i]]+" "+A[i]+" "+A[greater[i]]);
				return;
			}
		}
		System.out.println("No such element");
	}
	// This function Prints the starting and ending indexes of the largest subarray 
	// with equal number of 0s and 1s. Also returns the size of such subarray.
	int findSubArray(int arr[], int n)
	{
	    int sum = 0;
	    int maxsize = -1, startindex=0;
	 
	    // Pick a starting point as i
	    for (int i = 0; i < n-1; i++)
	    {
	        sum = (arr[i] == 0)? -1 : 1;
	 
	        // Consider all subarrays starting from i
	        for (int j = i+1; j < n; j++)
	        {
	            sum+=(arr[j] == 0)? -1:1;
	 
	            // If this is a 0 sum subarray, then compare it with
	            // maximum size subarray calculated so far
	            if(sum == 0 && maxsize < j-i+1)
	            {
	                maxsize = j - i + 1;
	                startindex = i;
	            }
	        }
	    }
	    if ( maxsize == -1 )
	        System.out.printf("No such subarray");
	    else
	    	System.out.printf("%d to %d", startindex, startindex+maxsize-1);
	 
	    return maxsize;
	}
	
	/* Function to replace every element with the
	   next greatest element */
	
	public int[] replaceWithRightGreatest(int[] A){
		
		int maxSoFar=A[A.length];
		A[A.length-1]=-1;
		int temp=0;
		
		for(int i=A.length-2;i>=0;i--){
			
			temp=A[i];
			A[i]=maxSoFar;
			
			if(maxSoFar<temp) maxSoFar=temp;
			
		}
		return A;
		
	}
	
	int[][] celeb = {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}};
	private boolean haveAcquiantance(int a, int b) { 
		
		return celeb[a][b]==1;
		
	}
	//looks right...???
	public int celebrityFinder(){
		
		Stack<Integer> stack=new Stack<Integer>();
		
		for(int i=0;i<celeb.length;i++){
			stack.push(i);
		}
		
		int A = stack.pop();
		int B = stack.pop();
		while(stack.size!=1){
			
			if(haveAcquiantance(A, B))
				A = stack.pop();
			else
				B=stack.pop();
		}
		
		int C=stack.pop();
		System.out.println(stack.toString());
		
		if(haveAcquiantance(C, B)) C=B;
		if(haveAcquiantance(C, A)) C=A;
		
		for(int i=0;i<celeb.length;i++){
			if(!haveAcquiantance(i, C))
				return -1;
		}
		return C;
		
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
	
	// A function to generate a random permutation of arr[]
	public void randomize ( int arr[] )
	{
	 
	    // Start from the last element and swap one by one. We don't
	    // need to run for the first element that's why i > 0
	    for (int i = arr.length-1; i > 0; i--)
	    {
	        // Pick a random index from 0 to i
	        int j = (int)(Math.random() % (i+1));
	 
	        // Swap arr[i] with the element at random index
	        swap(arr,i, j);
	    }
	}
	
	void insertionSort(int A[], int size)
	{
	   int i, key, j;
	   for (i = 1; i < size; i++)
	   {
	       key = A[i];
	       j = i-1;
	 
	       /* Move elements of A[0..i-1], that are greater than key, to one 
	          position ahead of their current position.
	          This loop will run at most k times */
	       while (j >= 0 && A[j] > key)
	       {
	           A[j+1] = A[j];
	           j = j-1;
	       }
	       A[j+1] = key;
	   }
	}
	
	public int maxCircularSum (int a[], int n)
	{
	   // Case 1: get the maximum sum using standard kadane's algorithm
	   int max_kadane = kadane(a, n);
	 
	   // Case 2: Now find the maximum sum that includes corner elements.
	   int max_wrap  =  0, i;
	   for(i=0; i<n; i++)
	   {
	        max_wrap += a[i]; // Calculate array-sum
	        a[i] = -a[i];  // invert the array (change sign)
	   }
	 
	   // max sum with corner elements will be:
	   // array-sum - (-max subarray sum of inverted array)
	   max_wrap = max_wrap + kadane(a, n);
	 
	   // The maximum circular sum will be maximum of two sums
	   return (max_wrap > max_kadane)? max_wrap: max_kadane;
	}
	 
	// Standard Kadane's algorithm to find maximum subarray sum
	// See http://www.geeksforgeeks.org/archives/576 for details
	public int kadane (int a[], int n)
	{
	    int max_so_far = 0, max_ending_here = 0;
	    int i;
	    for(i = 0; i < n; i++)
	    {
	        max_ending_here = max_ending_here + a[i];
	        if(max_ending_here < 0)
	            max_ending_here = 0;
	        if(max_so_far < max_ending_here)
	            max_so_far = max_ending_here;
	    }
	    return max_so_far;
	}
	
	
	// Function to count all possible triangles with arr[] elements
	public int findNumberOfTriangles(int arr[], int n)
	{
	    // Sort the array elements in non-decreasing order
	    Arrays.sort(arr);
	 
	    // Initialize count of triangles
	    int count = 0;
	 
	    // Fix the first element.  We need to run till n-3 as the other two elements are
	    // selected from arr[i+1...n-1]
	    for (int i = 0; i < n-2; ++i)
	    {
	        // Initialize index of the rightmost third element
	        int k = i+2;
	 
	        // Fix the second element
	        for (int j = i+1; j < n; ++j)
	        {
	            // Find the rightmost element which is smaller than the sum
	            // of two fixed elements
	            // The important thing to note here is, we use the previous
	            // value of k. If value of arr[i] + arr[j-1] was greater than arr[k],
	            // then arr[i] + arr[j] must be greater than k, because the
	            // array is sorted.
	            while (k < n && arr[i] + arr[j] > arr[k])
	               ++k;
	 
	            // Total number of possible triangles that can be formed
	            // with the two fixed elements is k - j - 1.  The two fixed
	            // elements are arr[i] and arr[j].  All elements between arr[j+1]
	            // to arr[k-1] can form a triangle with arr[i] and arr[j].
	            // One is subtracted from k because k is incremented one extra
	            // in above while loop.
	            // k will always be greater than j. If j becomes equal to k, then
	            // above loop will increment k, because arr[k] + arr[i] is always
	            // greater than arr[k]
	            count += k - j - 1;
	        }
	    }
	 
	    return count;
	}
	
	int rowNbr[] = {-1, -1, -1,  0, 0,  1, 1, 1};
    int colNbr[] = {-1,  0,  1, -1, 1, -1, 0, 1};
    
	private void DFSArray(int[][]G, int i, int j, boolean[][] visited){
		
		
	    visited[i][j]=true;
	    
	    
	    for(int k=0;k<8;k++){
	    	System.out.println(isSafeGrid(i+rowNbr[k], j+colNbr[k],visited,G));
	    	if(isSafeGrid(i+rowNbr[k], j+colNbr[k],visited,G))
	    		DFSArray(G, i+rowNbr[k], j+colNbr[k], visited);
	    }
		
	}
	
private boolean isSafeGrid(int row, int col, boolean[][] visited, int[][] G){
		
		return (row>=0 && row<G.length && col >=0 && col < G.length && G[row][col]==1 && !visited[row][col]);
		
	}
	
	
	public void countIslands(int [][]G){
		
		boolean [][] visited=new boolean[G.length][G.length];
		
		/*
		for(int i=0;i<G.length;i++){
			for(int j=0;j<G.length;j++){
				System.out.println(visited[i][j]);
			}
			System.out.println();
		}
		*/
		int count=0;
		
		for(int i=0;i<G.length;i++){
			for(int j=0;j<G.length;j++){
				if(G[i][j]==1 && visited[i][j]==false){
					DFSArray(G, i , j, visited);
					count++;
				}
			}
		}
		
		System.out.println("Count:"+count);
		
	}
	
	// Binary search
	private int getCeilIndex(int A[], int T[], int l, int r, int key) {
	   int m;
	 
	   while( r - l > 1 ) {
	      m = l + (r - l)/2;
	      if( A[T[m]] >= key )
	         r = m;
	      else
	         l = m;
	   }
	 
	   return r;
	}
	
	
	int LongestIncreasingSubsequence(int A[], int size) {
		   // Add boundary case, when array size is zero
		   // Depend on smart pointers
		 
		   int []tailIndices = new int[size];
		   int []prevIndices = new int[size];
		   int len;
		 
		 
		   tailIndices[0] = 0;
		   prevIndices[0] = -1;
		   len = 1; // it will always point to empty location
		   for( int i = 1; i < size; i++ ) {
		      if( A[i] < A[tailIndices[0]] ) {
		         // new smallest value
		         tailIndices[0] = i;
		      } else if( A[i] > A[tailIndices[len-1]] ) {
		         // A[i] wants to extend largest subsequence
		         prevIndices[i] = tailIndices[len-1];
		         tailIndices[len++] = i;
		      } else {
		         // A[i] wants to be a potential condidate of future subsequence
		         // It will replace ceil value in tailIndices
		        int pos = getCeilIndex(A, tailIndices, -1, len-1, A[i]);
		 
		        prevIndices[i] = tailIndices[pos-1];
		        tailIndices[pos] = i;
		      }
		   }
		   System.out.println("LIS of given input");
		   for( int i = tailIndices[len-1]; i >= 0; i = prevIndices[i] )
		      System.out.println(" "+A[i]);
		   System.out.println();
		 
		 
		   return len;
		}
	
public int circularTour(Stations[] arr){
		
		int start=0;
		int end=1;
		
		int n=arr.length;
		
		int currentPetrol=arr[start].petrol-arr[start].distance;
		
		
		/* Run a loop while all petrol pumps are not visited.
	      And we have reached first petrol pump again with 0 or more petrol */
		while(end!=start || currentPetrol<0){
			
			
			// If curremt amount of petrol in truck becomes less than 0, then
	        // remove the starting petrol pump from tour
			while( currentPetrol<0 && end!=start){
				currentPetrol-=arr[start].petrol- arr[start].distance;
				start=(start+1)%n;
				
				if(start==0) return -1;
			}
			
			//add a petrol pump
			currentPetrol+=arr[end].petrol-arr[end].distance;
			end=(end+1)%n;
		}
		String a="hello";
		String b="g";
		String x=a+b;
		return start;
		
	}
	
//The main function that prints the arrangement with the largest value.
//The function accepts a vector of strings
	void printLargest(List<String> arr)
	{
		// Sort the numbers using library sort function. The function uses
		// our comparison function myCompare() to compare two strings.
		// See http://www.cplusplus.com/reference/algorithm/sort/ for details
		Collections.sort(arr, new MyCustomStringComparator<String>());

		for (int i=0; i < arr.size() ; i++ )
			System.out.print(""+arr.get(i));
	}
	
	
	int maxCrossingSum(int arr[], int l, int m, int h)
	{
	    // Include elements on left of mid.
	    int sum = 0;
	    int left_sum = Integer.MIN_VALUE;
	    for (int i = m; i >= l; i--)
	    {
	        sum = sum + arr[i];
	        if (sum > left_sum)
	          left_sum = sum;
	    }
	 
	    // Include elements on right of mid
	    sum = 0;
	    int right_sum = Integer.MIN_VALUE;
	    for (int i = m+1; i <= h; i++)
	    {
	        sum = sum + arr[i];
	        if (sum > right_sum)
	          right_sum = sum;
	    }
	 
	    // Return sum of elements on left and right of mid
	    return left_sum + right_sum;
	}
	 
	// Returns sum of maxium sum subarray in aa[l..h]
	int maxSubArraySum(int arr[], int l, int h)
	{
	   // Base Case: Only one element
	   if (l == h)
	     return arr[l];
	 
	   // Find middle point
	   int m = (l + h)/2;
	 
	   /* Return maximum of following three possible cases
	      a) Maximum subarray sum in left half
	      b) Maximum subarray sum in right half
	      c) Maximum subarray sum such that the subarray crosses the midpoint */
	   return Math.max(Math.max(maxSubArraySum(arr, l, m),
	              maxSubArraySum(arr, m+1, h)),
	              maxCrossingSum(arr, l, m, h));
	}
	
	
	// The main function that takes a set of intervals, merges
	// overlapping intervals and prints the result
	public void mergeIntervals(List<Interval>intervals)
	{
	    // Test if the given set has at least one interval
	    if (intervals.size() <= 0)
	        return;
	 
	    // Create an empty stack of intervals
	    Stack<Interval> s = new Stack<Interval>();
	 
	    // sort the intervals based on start time
	    Collections.sort(intervals, new Interval());
	 
	    // push the first interval to stack
	    s.push(intervals.get(0));
	 
	    // Start from the next interval and merge if necessary
	    for (int i = 1 ; i < intervals.size(); i++)
	    {
	        // get interval from stack top
	        Interval top = s.peek();
	 
	        // if current interval is not overlapping with stack top,
	        // push it to the stack
	        if (top.end < intervals.get(i).start)
	        {
	            s.push( intervals.get(i) );
	        }
	        // Otherwise update the ending time of top if ending of current 
	        // interval is more
	        else if (top.end < intervals.get(i).end)
	        {
	            top.end = intervals.get(i).end;
	            s.pop();
	            s.push(top);
	        }
	    }
	 
	    // Print contents of stack
	    System.out.println("The Merged Intervals are: ");
	    while (!s.isEmpty())
	    {
	        Interval t = s.peek();
	        System.out.println("[ " +t.start +"," + t.end + "]" );
	        s.pop();
	    }
	 
	    return;
	}
	
	
	// Returns maximum repeating element in arr[0..n-1].
	// The array elements are in range from 0 to k-1
	public int maxRepeating(int[] arr, int n, int k)
	{
	    // Iterate though input array, for every element
	    // arr[i], increment arr[arr[i]%k] by k
	    for (int i = 0; i< n; i++)
	        arr[arr[i]%k] += k;
	 
	    // Find index of the maximum repeating element
	    int max = arr[0], result = 0;
	    for (int i = 1; i < n; i++)
	    {
	        if (arr[i] > max)
	        {
	            max = arr[i];
	            result = i;
	        }
	    }
	 
	    /* Uncomment this code to get the original array back
	       for (int i = 0; i< n; i++)
	          arr[i] = arr[i]%k; */
	 
	    // Return index of the maximum element
	    return result;
	}
	
	// This function finds the buy sell schedule for maximum profit
	public void stockBuySell(int price[], int n)
	{
	    // Prices must be given for at least two days
	    if (n == 1)
	        return;
	 
	    int count = 0; // count of solution pairs
	 
	    // solution vector
	    Interval sol[]=new Interval[n/2 + 1];
	 
	    for(int k=0;k<sol.length;k++)sol[k]=new Interval();
	    
	    // Traverse through given price array
	    int i = 0;
	    while (i < n-1)
	    {
	        // Find Local Minima. Note that the limit is (n-2) as we are
	        // comparing present element to the next element. 
	        while ((i < n-1) && (price[i+1] <= price[i]))
	            i++;
	 
	        // If we reached the end, break as no further solution possible
	        if (i == n-1)
	            break;
	 
	        // Store the index of minima
	        sol[count].start = i++;
	 
	        // Find Local Maxima.  Note that the limit is (n-1) as we are
	        // comparing to previous element
	        while ((i < n) && (price[i] >= price[i-1]))
	            i++;
	 
	        // Store the index of maxima
	        sol[count].end = i-1;
	 
	        // Increment count of buy/sell pairs
	        count++;
	    }
	 
	    // print solution
	    if (count == 0)
	        System.out.printf("There is no day when buying the stock will make profit\n");
	    else
	    {
	       for (int j = 0; j < count; j++)
	    	   System.out.printf("Buy on day: %d\t Sell on day: %d\n", sol[j].start, sol[j].end);
	    }
	 
	    return;
	}
	
	
	// The main function that rearranges elements of given array.  It puts 
	// positive elements at even indexes (0, 2, ..) and negative numbers at 
	// odd indexes (1, 3, ..).
	public void rearrange(int arr[], int n)
	{
	    // The following few lines are similar to partition process
	    // of QuickSort.  The idea is to consider 0 as pivot and
	    // divide the array around it.
	    int i = -1;
	    for (int j = 0; j < n; j++)
	    {
	        if (arr[j] < 0)
	        {
	            i++;
	            swap(arr,i, j);
	        }
	    }
	 
	    // Now all positive numbers are at end and negative numbers at
	    // the beginning of array. Initialize indexes for starting point
	    // of positive and negative numbers to be swapped
	    int pos = i+1, neg = 0;
	 
	    // Increment the negative index by 2 and positive index by 1, i.e.,
	    // swap every alternate negative number with next positive number
	    while (pos < n && neg < pos && arr[neg] < 0)
	    {
	        swap(arr,neg, pos);
	        pos++;
	        neg += 2;
	    }
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
	
	
		// A binary search based function that returns index of a peak element
		int findPeakUtil(int arr[], int low, int high, int n)
		{
		    // Fin index of middle element
		    int mid = low + (high - low)/2;  /* (low + high)/2 */
		 
		    // Compare middle element with its neighbours (if neighbours exist)
		    if ((mid == 0 || arr[mid-1] <= arr[mid]) &&
		            (mid == n-1 || arr[mid+1] <= arr[mid]))
		        return mid;
		 
		    // If middle element is not peak and its left neighbor is greater than it
		    // then left half must have a peak element
		    else if (mid > 0 && arr[mid-1] > arr[mid])
		        return findPeakUtil(arr, low, (mid -1), n);
		 
		    // If middle element is not peak and its right neighbor is greater than it
		    // then right half must have a peak element
		    else return findPeakUtil(arr, (mid + 1), high, n);
		}
		
		
		// Function which pushes all zeros to end of an array.
		void pushZerosToEnd(int arr[], int n)
		{
		    int count = 0;  // Count of non-zero elements
		 
		    // Traverse the array. If element encountered is non-zero, then
		    // replace the element at index 'count' with this element
		    for (int i = 0; i < n; i++)
		        if (arr[i] != 0)
		            arr[count++] = arr[i]; // here count is incremented
		 
		    // Now all non-zero elements have been shifted to front and 'count' is
		    // set as index of first 0. Make all elements 0 from count to end.
		    while (count < n)
		        arr[count++] = 0;
		}
		// Returns true if arr[] has a subarray with sero sum
	    static Boolean printZeroSumSubarray(int arr[])
	    {
	        // Creates an empty hashMap hM
	        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
	         
	        // Initialize sum of elements
	        int sum = 0;        
	         
	        // Traverse through the given array
	        for (int i = 0; i < arr.length; i++)
	        {   
	            // Add current element to sum
	            sum += arr[i];
	             
	            // Return true in following cases
	            // a) Current element is 0
	            // b) sum of elements from 0 to i is 0
	            // c) sum is already present in hash map
	            if (arr[i] == 0 || sum == 0 || hM.get(sum) != null)                            
	               return true;
	             
	            // Add sum to hash map
	            hM.put(sum, i);
	        }    
	         
	        // We reach here only when there is no subarray with 0 sum
	        return false;
	    }        
		
	 // Returns length of smallest subarray with sum greater than x.
	 // If there is no subarray with given sum, then returns n+1
	 int smallestSubWithSum(int arr[], int n, int x)
	 {
	     // Initialize current sum and minimum length
	     int curr_sum = 0, min_len = n+1;
	  
	     // Initialize starting and ending indexes
	     int start = 0, end = 0;
	     while (end < n)
	     {
	         // Keep adding array elements while current sum
	         // is smaller than x
	         while (curr_sum <= x && end < n)
	             curr_sum += arr[end++];
	  
	         // If current sum becomes greater than x.
	         while (curr_sum > x && start < n)
	         {
	             // Update minimum length if needed
	             if (end - start < min_len)
	                 min_len = end - start;
	  
	             // remove starting elements
	             curr_sum -= arr[start++];
	         }
	     }
	     return min_len;
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
		
		private void printArray(int[] arr, int i){
			
			for(int j=0;j<i;j++){
				System.out.print(" "+arr[j]);
			}
			System.out.println();
		}
		
		// This function returns true if woman 'w' prefers man 'm1' over man 'm'
		boolean wPrefersM1OverM(int prefer[][], int w, int m, int m1)
		{
		    // Check if w prefers m over her current engagment m1
		    for (int i = 0; i < prefer.length; i++)
		    {
		        // If m1 comes before m in lisr of w, then w prefers her
		        // cirrent engagement, don't do anything
		        if (prefer[w][i] == m1)
		            return true;
		 
		        // If m cmes before m1 in w's list, then free her current
		        // engagement and engage her with m
		        if (prefer[w][i] == m)
		           return false;
		    }
		    return false;
		}
		
		// Prints stable matching for N boys and N girls. Boys are numbered as 0 to
		// N-1. Girls are numbereed as N to 2N-1.
		public void stableMarriage(int prefer[][])
		{
			int N=prefer.length;
		    // Stores partner of women. This is our output array that
		    // stores paing information.  The value of wPartner[i]
		    // indicates the partner assigned to woman N+i.  Note that
		    // the woman numbers between N and 2*N-1. The value -1
		    // indicates that (N+i)'th woman is free
		    int wPartner[] = new int [N];
		 
		    // An array to store availability of men.  If mFree[i] is
		    // false, then man 'i' is free, otherwise engaged.
		    boolean mFree[]= new  boolean[N];
		 
		    // Initialize all men and women as free
		    
		    for(int i=0;i<N;i++){
		    	wPartner[i]=-1;
		    	mFree[i]=false;
		    }
		    
		    int freeCount = N;
		 
		    // While there are free men
		    while (freeCount > 0)
		    {
		        // Pick the first free man (we could pick any)
		        int m;
		        for (m = 0; m < N; m++)
		            if (mFree[m] == false)
		                break;
		 
		        // One by one go to all women according to m's preferences.
		        // Here m is the picked free man
		        for (int i = 0; i < N && mFree[m] == false; i++)
		        {
		            int w = prefer[m][i];
		 
		            // The woman of preference is free, w and m become
		            // partners (Note that the partnership maybe changed
		            // later). So we can say they are engaged not married
		            if (wPartner[w-N] == -1)
		            {
		                wPartner[w-N] = m;
		                mFree[m] = true;
		                freeCount--;
		            }
		 
		            else  // If w is not free
		            {
		                // Find current engagement of w
		                int m1 = wPartner[w-N];
		 
		                // If w prefers m over her current engagement m1,
		                // then break the engagement between w and m1 and
		                // engage m with w.
		                if (wPrefersM1OverM(prefer, w, m, m1) == false)
		                {
		                    wPartner[w-N] = m;
		                    mFree[m] = true;
		                    mFree[m1] = false;
		                }
		            } // End of Else
		        } // End of the for loop that goes to all women in m's list
		    } // End of main while loop
		 
		 
		    // Print the solution
		    System.out.println("Woman   Man");
		    for (int i = 0; i < N; i++)
		       System.out.println(i+N + " " + wPartner[i] );
		}
		
		public static void main(String...crazy){
		
		Array a=new Array();
		//int[] arr={12, 11, 10, 5, 6, 2, 30};
		int[] brr={5,1,3,4,6,7,3,4,5,6,7,88};
		
		String s=null;
		//System.out.println(a.checkForPairWithSumX(arr, 25));
		//System.out.println(a.maxDiff(arr));
		//a.intersectionOfSortedArray(arr, brr);
		//System.out.println(a.ceilOfXInArr(arr, 87, 0, arr.length-1));
		//a.prodcutArrayPuzzle(arr);
		//a.findTriplet(arr);
		//System.out.println(a.getMinIMinusJ(arr));
		//System.out.println(a.isConsecutive(arr));
		//System.out.println(a.celebrityFinder());
		
		
		List<String> arr=new ArrayList<String>();
		 
	    //output should be 6054854654
	    arr.add("54");
	    arr.add("546");
	    arr.add("548");
	    arr.add("60");
	    a.printLargest(arr);
		
		
	}
}


class Interval implements Comparator<Interval>{
	
	int start;
	int end;
	@Override
	public int compare(Interval o1, Interval o2) {
		// TODO Auto-generated method stub
		return o1.start-o2.start;
	}
	
	
}