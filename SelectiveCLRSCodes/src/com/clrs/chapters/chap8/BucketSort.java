package com.clrs.chapters.chap8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

	public List<Integer> bucketSort (ArrayList<Integer> list){
		
		ArrayList<Integer>[] bucket;
		
		bucket=new ArrayList[10];
		
		for(int i=0;i<10;i++){
			bucket[i]=new ArrayList<Integer>();
		}
		
		
		for(Integer i:list){
			
			bucket[i/10].add(i);
			
		}
		list.clear();
		
		for(ArrayList<Integer> l:bucket){
			Collections.sort(l);
			list.addAll(l);
		}
		
		//System.out.println("Sorted List:"+list.toString());
		return list;
		
	}
	
	public static void main(String...args){
		//int A[]={15,11,12,41,13,22,27,14,35,46,57,53,74,95,16,67,98,4};
		Integer A[]={78,17,23,39,26,72,94,21,12,68};
		
		ArrayList<Integer> l=new ArrayList<Integer>();
		
		for(int i:A){
			l.add(i);
		}
		
		BucketSort b=new BucketSort();
		b.bucketSort(l);
		for(int i:l){
			System.out.print(i+" ");
		}
		//System.out.print("Num in range:"+c.numberInRange(A, 2, 7, 100));
		
		
	}
	
}
