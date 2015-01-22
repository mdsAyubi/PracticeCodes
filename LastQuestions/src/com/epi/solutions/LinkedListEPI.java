package com.epi.solutions;


public class LinkedListEPI<E extends Comparable<E>> {

	public Node<E> mergeSortedList(Node<E> a, Node<E> b){
		Node<E> result=null;
		if(a==null) return b;
		if(b==null) return a;
		
		if((Integer)a.getData()<(Integer)b.getData()){
			result=a;
			result.next=mergeSortedList(a.next, b);
		}
		else{
			result=b;
			result.next=mergeSortedList(a, b.next);
		}
		return result;
	}
	
public Node<E> findBeginningOfCycle(Node<E> head){
		
		Node<E> slow=head, fast=head;
		
		boolean hasLoop=false;
		
		while(slow != null && fast != null){
			fast=fast.next;
			
			if(slow==fast) hasLoop=true;
			if(fast==null) hasLoop=false;
			
			fast=fast.next;
			if(slow==fast) hasLoop=true;
			slow=slow.next;
			
		}
		
		if(hasLoop){
			
			slow=head;
			
			while(fast!=slow){
				slow=slow.next;
				fast=fast.next;
			}
			return slow;
		}
		return null;
		
		
	}
	
	public boolean hasLoops(Node<E> head){
		
		Node<E> slow=head,fast=head;
		
		while(slow!=null&&fast!=null){
			
			
			fast=fast.next;
			if(slow==fast) return true;
			if(fast==null) return false;
			
			fast=fast.next;
			if(slow==fast) return true;
			
			slow=slow.next;
		}
		
		return false;
	}
	
private Node<E> _getIntersectionPoint(int d, Node<E>head1, Node<E>head2){
		
		Node<E> cur1=head1;
		Node<E> cur2=head2;
		
		for(int i=0;i<d;i++){
			if(cur1==null) return null;
			cur1=cur1.next;
		}
		
		while(cur1!=null && cur2!=null){
			if(cur1.getData().equals(cur2.getData()))return cur1;
			cur1=cur1.next;
			cur2=cur2.next;
		}
		return null;
	}
	
public int getCount(Node<E> head){
	
	int count=0;
	while(head!=null){
		count++;
		head=head.next;
	}
	return count;
}
	
	public Node<E> intersectionPoint(Node<E> head1, Node<E> head2){
		
		int count1=getCount(head1);
		int count2=getCount(head2);
		
		if(count1>count2){
			return _getIntersectionPoint((count1-count2), head1,head2);
		}
		if(count2>count1){
			return _getIntersectionPoint((count2-count1), head2,head1);
		}
		return null;
		
	}
	
	
}
