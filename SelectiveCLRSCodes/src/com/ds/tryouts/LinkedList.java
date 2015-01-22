package com.ds.tryouts;

public class LinkedList<E> {
	
	int size;
	Node<E> head;
	//Node<E> tail;
	
	public LinkedList(){
		head=null;
		size=0;
	}
	
	public boolean isEmpty(){
		return head==null;
	}
	
	public void addFirst(E elem){
		Node<E> node=new Node<E>(elem,head);
		
		head=node;
		size++;
	}
	
	public Node<E> reverseList(Node<E> head){
		
		Node<E> nextNode=null, temp=null;
		
		while(head!=null){
			nextNode=head.next;
			head.next=temp;
			temp=head;
			head=nextNode;
		}
		return temp;
		
	}
	
	public void listFromEnd(Node<E> head){
		if(head!=null){
			listFromEnd(head.next);
			System.out.println(head.getData());
		}
	}
	
	public Node<E> recursiveReverseList(Node<E> head){
		
		if(head==null) return null;
		
		if(head.next==null) return head;
		
		Node<E> secondElement=head.next;
		head.next=null;
		
		Node<E> reversedList=recursiveReverseList(secondElement);
		secondElement.next=head;
		
		return reversedList;
		
	}
	
	public void addLast(E elem){
		Node<E> node=new Node<E>(elem,null);
		
		Node<E> temp=this.head;
		
		while(temp.getNext()!=null){
			temp=temp.getNext();
		}
		temp.next=node;
		size++;
	}
	public E removeFirst(){
		
		E data=null;
		
		if(isEmpty()){
			data=null;
		}
		else{
			data=head.getData();
			head=head.getNext();
		}
		size--;
		return data;
	}
	public E removeLast(){
		
		E data=null;
		if(isEmpty()){
			data=null;
		}
		
		else if(size==1){
			data=head.getData();
			head=null;
			size--;
		}
		
		else{
			Node<E> temp=head;
			
			while(temp.getNext().getNext()!=null){
				temp=temp.getNext();
			}
			data=temp.next.getData();
			temp.next=null;
			size--;
		}
		
		return data;
	}
	
	
public String toString(){
		
		Node<E> temp=this.head;
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		while(temp!=null){
			sb.append(temp.getData()+",");
			temp=temp.getNext();
			//System.out.print("In to string"+temp.getData());
		}
		sb.append("}");
		return sb.toString();
		
	}

	public Node<E> rearrangePositiveNegative(){
		
		Node<E> item=this.head;
		//Node<E> prev=head;
		int k=1;
		int inittialSize=size;
		while(k<inittialSize){
			
			if((Integer)(item.next.getData())<0){
				item=item.next;
				//continue;
			}
			else{
				E temp=item.next.getData();
				item.next=item.next.next;
				addLast(temp);
			}
			k++;
		}
		return head;
		
	}
	
	public void nthNodeFromEnd(Node<E> head, int n){
		
		Node<E> temp=head,nthNode=head;
		int i=0;
		while(i<n){
			temp=temp.next;
			i++;
		}
		while(temp!=null){
			temp=temp.next;
			nthNode=nthNode.next;
		}
		
		System.out.println(nthNode.getData());
	}
	
	int carry=0;
	public void add(Node<Integer> l1, Node<Integer> l2){
		
		if(l1.next!=null&&l2.next!=null){
			add(l1.next,l2.next);
		}
		int s=(l1.getData()+l2.getData()+carry);
		System.out.println(s%10);
		carry=s/10;
		
		
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
	
	public void isEvenOrOdd(){
		
		Node<E> head=this.head;
		while(head!=null&&head.next!=null){
			
			head=head.next.next;
		}
		if(head==null){
			System.out.println("Even");
			
		}
		else{
			System.out.println("Odd");
		}
	}
	
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
	
	
	public void pairWiseSwap(Node<E> head){
		
		if(head==null || head.next==null){
			return;
		}
		else{
			Node<E> temp=head.next;
			head.next=temp.next;
			temp.next=head;
			pairWiseSwap(head.next);
		}
		
	}
	public static void main(String...a){
		
	LinkedList<Integer> ll=new LinkedList<Integer>();
	LinkedList<Integer> l2=new LinkedList<Integer>();
	LinkedList<Integer> l3=new LinkedList<Integer>();
	//LinkedList<Integer> l2=new LinkedList<Integer>();
		//LinkedList<String> ll=new LinkedList<String>();
		
		/*
		ll.addFirst("hello");
		ll.addLast("world");
		ll.addFirst("yello");
		//ll.addLast("world2");
		System.out.print(ll.toString());
		*/
		//ll.removeFirst();
		//ll.removeLast();
		//ll.addFirst("yello");
		//ll.addLast("world2");
		//System.out.println(ll.toString());
		
		
		ll.addFirst(11);
		ll.addFirst(9);
		ll.addFirst(7);
		ll.addFirst(5);
		ll.addFirst(3);
		ll.addFirst(1);
		
		
		l2.addFirst(12);
		l2.addFirst(10);
		l2.addFirst(8);
		l2.addFirst(6);
		l2.addFirst(4);
		l2.addFirst(2);
		
		
		l3.head=l3.mergeSortedList(ll.head, l2.head);
		System.out.println(l3.toString());
		//System.out.println(ll.toString());
		
		//ll.listFromEnd(ll.head);
		//ll.isEvenOrOdd();
		//ll.head=ll.reverseList(ll.head);
		//ll.head=ll.recursiveReverseList(ll.head);
		//System.out.println(ll.toString());
		
		//System.out.println(ll.reverseList(ll.head));
		//ll.nthNodeFromEnd(ll.head,2);
		//LinkedList<Integer> obj=new LinkedList<Integer>();
		//obj.add(ll.head, l2.head);
		//ll.addFirst(5);
		//ll.rearrangePositiveNegative();
		//System.out.println(ll.toString());
	}

}
