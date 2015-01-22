package com.ds.tryouts;

import java.util.Arrays;

public class SearchingNew {


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

public void findMissing(int[] A, int n){
	
	int X=0,Y=0;
	
	for(int i: A){
		X^=i;
	}
	for(int i=0;i<=n;i++){
		Y^=i;
	}
	
	System.out.println("Missing = "+(X^Y));
	
}

public void closestToZeroSum(int [] A){
	
	Arrays.sort(A);
	
	int i=0,j=A.length-1;
	int positiveSum=Integer.MAX_VALUE;
	int negativeSum=Integer.MIN_VALUE;
	
	int temp=0;
	while(i<j){
		temp=A[i]+A[j];
		
		if(temp>0){
			if(temp<positiveSum) positiveSum=temp;
		

		j--;
		}
		
		else if(temp<0){
			if(temp>negativeSum) 
			{	
				negativeSum=temp;
				i++;
			}
		}
		else{
			System.out.println(A[i]+" "+A[j]);
		}
	}
	int closest=Math.abs(negativeSum)>positiveSum?positiveSum:negativeSum;
	System.out.println("Closed Sum="+closest);
	
}

public int findPeek(int[] A){
	
	int first=0;
	int last=A.length-1;
			
	while(first<=last){
		
		if(first==last){
			return A[first];
		}
		else if(first==last-1){
			return Math.max(A[first], A[last]);
		}
		else {
			int mid=first+(last-first)/2;
			
			if(A[mid-1]<A[mid]&& A[mid]>A[mid+1]){
				return A[mid];
			}
			else if(A[mid-1]<A[mid]&& A[mid]<A[mid+1]){
				first=mid+1;
			}
			else if(A[mid-1]>A[mid]&& A[mid]>A[mid+1]){
				last=mid-1;
			}
			else return Integer.MIN_VALUE;
		}
	}
	return 0;
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

public int findPivot(int[] A, int first, int last){
	
	if(first==last) return A[first];
	
	else if(first==last-1) return Math.max(A[first], A[last]);
	
	else{
		int mid=first+(last-first)/2;
		if(A[first]>=A[last]){
			return findPivot(A, first, mid);
		
		}
		else return findPivot(A, mid, last);
	}
}

public int findFirstOccurrence(int[] A, int low, int high, int data){
	
	int mid;
	if(high>=low){
		mid = low + (high-low)/2;
		
		if(A[mid]==data) return mid;
		else if(A[mid]>data) return findFirstOccurrence(A, low, mid-1, data);
		else return findFirstOccurrence(A, mid+1, high, data);
	}
	
	return -1;
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

private void print(int []A){
	for(int i:A){
		System.out.print(i+" ");
	}

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
	
	print(A);
}

//number of trailing zeores in n!

public int trailingZeroes(int n){
	int count=0;
	
	if(n<0) return -1;
	
	for(int i=5;n/i>0;i*=5){
		count+=n/i;
	}
	return count;
}



public static void main(String...a){
	SearchingNew obj=new SearchingNew();
	
	int[] A={-4,5,-9,11,12,14,3,2,1}; 
	
	int [] B={1,1,1,1,1,0,0,0,0,0,0,0};
	
	//System.out.println(obj.findFirstOccurrence(B, 0, B.length-1, 0));
	//int [] A={1,2,0};
	//obj.detectDuplicates(A);
	
	//obj.findMissing(A);
	//obj.closestToZeroSum(A);
	//System.out.println(obj.findPivot(A, 0, A.length-1));
	//System.out.println(obj.recursivePeek(A, 0, A.length-1));
	//System.out.println(obj.majorityElement(A));
	//obj.separateEvenOdd(A);
	//obj.separate012(A);
	int n=10;
	System.out.println("Number of Zeroes:"+obj.trailingZeroes(n));
}



}
