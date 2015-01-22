package com.last.programs;

public class Searching {
	
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
	
	public static void main(String...a){
		Searching s=new Searching();
		//int A[]={1,2,3,4,5,412,3456,24566,1234567};
		//int Arr[]={15,16,19,20,25,1,3,4,5,7,10,14};
		int Arr[]={2,3,4,4,5,5,5,5,6,7,8,8,9};
		//int A[][]={{1,2,3},{4,5,6},{7,8,9}};
		int A[][]={{1,1,0,0,0,0},{1,0,1,1,1,0},{1,0,0,0,0,0},{1,1,1,1,0,0}};
		
		//System.out.println(s.serachMaxOrMinPoint(A));
		//System.out.println(s.searchInRotatedSortedArray(Arr,0,Arr.length-1,16));
		//System.out.println(s.findFirstOccurence(Arr,0,Arr.length-1,5));
		//s.findInSortedMAtrix(A,6);
		s.findMaxZeroesInMatrix(A);
		
	}
}
