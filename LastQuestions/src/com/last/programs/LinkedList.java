package com.last.programs;

//import com.ds.tryouts.LinkedList;
import com.last.programs.Node;

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
	
	
	public int getCount(Node<E> head){
		
		int count=0;
		while(head!=null){
			count++;
			head=head.next;
		}
		return count;
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
		
		if(l1!=null || l2!=null){
			add(l1==null?null:l1.next,l2==null?null:l2.next);
		}
		int s=carry + (l1 != null?l1.getData():0) + (l2 != null?l2.getData():0);
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
	

	public Node<E> getNthNode(Node<E> head, int n){
		
		int index=0;
		while(head!=null){
			
			if(n==index)
				return head;
			head=head.next;
			index++;
		}
		return null;
	}
	
	public void deleteNodeWhenOnlyItsPointerIsGiven(Node<E> node){
		
		Node<E> temp=node.next;
		node.setData(temp.getData());
		node.next=temp.next;
		
		//free temp now..garbage collected
		temp=null;
		
	}
	
	
	public Node<E> middleOfLL(Node<E> head){
		
		Node<E> slow=head;
		Node<E> fast=head;
		if(head!=null){
			
			while(fast!=null && fast.next!=null){
				fast=fast.next.next;
				slow=slow.next;
			}
		}
		return slow;
		
	}
	
	
	public boolean isPalindromeUsingStack(Node<E> head){
		
		Node<E> temp=head;
		Stack<Node<E>> s=new Stack<Node<E>>();
		while(temp!=null){
			s.push(temp);
			temp=temp.next;
		}
		while(!s.isEmpty()){
			if(s.pop()!=head)
				return false;
			
			head=head.next;
		}
		return true;
	}
	
	
	public boolean isPalindromeRec(Node<E> left, Node<E> right){
		
		if(right==null) return true;
		
		boolean isp=isPalindromeRec(left, right.next);
		if(isp==false) return false;
		
		
		System.out.println("Cpmapring:"+left.getData()+" And: "+right.getData());
		boolean isp1=left.getData().equals(right.getData());
		left=left.next;
		
		return isp1;
		
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
	
	public void removeDuplicatesInSortedList(Node<E> head){
		
		Node<E> current=head;
		//Node<E> next=head.next;
		while(current.next!=null){
			
			if(current.getData().equals(current.next.getData())){
				current.next=current.next.next;
			}
			else
			current=current.next;	
		}
		
	}
	//For unsorted...best use hashing
	
	public Node<E> moveLastToFront(Node<E> head){
		
		Node<E> secondLast=null;
		Node<E>last=head;
		
		while(last.next!=null){
			
			secondLast=last;
			last=last.next;
		}
		
		secondLast.next=null;
		
		last.next=head;
		head=last;
		return head;
		
	}
	
	//Intersection of two sorted linked lists
	
	public Node<E> intersectionOfSortedLists(Node<E> head1, Node<E> head2){
		
		
		if(head1==null||head2==null) return null;
		
		String s1=(String)head1.getData();
		String s2=(String)head2.getData();
		
		if(s1.compareTo(s2)<0){
			intersectionOfSortedLists(head1.next, head2);
		}
		if(s1.compareTo(s2)>0){
			intersectionOfSortedLists(head1, head2.next);
		}
		
		Node<E> temp=new Node<E>();
		temp.setData(head.getData());
		
		temp.next=intersectionOfSortedLists(head1.next, head2.next);
		
		return temp;
		
		
	}
	
	
	public void deleteAlternate(Node<E> head){
		
		if(head==null) return;
		
		Node<E> node=head.next;
		
		if(node==null) return;
		
		head.next=node.next;
		
		deleteAlternate(head.next);
		
	}
	
	public void separateEvenOddPos(){
		
		LinkedList<E> a=new LinkedList<E>();
		LinkedList<E> b=new LinkedList<E>();
		Node<E> aTail=this.head;
		a.head=aTail;
		
		Node<E> bTail=this.head.next;
		b.head=bTail;
		Node<E> current=bTail.next;
		
		while(current!=null){
			
			aTail.next=current;
			aTail=current;
			
			if(current.next!=null){
				current=current.next;
				bTail.next=current;
				bTail=current;
			}
			if(current.next!=null)
				current=current.next;
			else break;
		}
		
	System.out.println(a.toString());
	System.out.println(b.toString());
	
	}
	
	
	public Node<E> reverseKNode(Node<E> head, int k){
		
		Node<E> current=head;
		Node<E> prev=null;
		Node<E> next=null;
		int count=0;
		
		while(current!=null && count<k){
			
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			count++;
			
		}
		/* next is now a pointer to (k+1)th node 
	       Recursively call for the list starting from current.
	       And make rest of the list as next of first node */
		if(next!=null)
			head.next=reverseKNode(next	, k);
		return prev;
		
		
	}
	
	public Node<E> reverseAlternateKNodes(Node<E> head, int k){
		
		Node<E> current=head;
		Node<E> prev=null,next=null;
		int count =0;
		
		while(current!=null && count<k){
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			count++;
		}
		
		if(head!=null) head.next=current;
		count=0;
		while(current!=null && count<k)current=current.next;
		
		if(current!=null) current.next=reverseAlternateKNodes(current.next, k);
		
		return prev;
	}
	
	//delete node if there is a higher node to the right
	
	public Node<E> deleteHigherNodes(Node<E> head){
		
		Node<E> reversedHead=recursiveReverseList(head);
		
		Node<E> current=reversedHead;
		Node<E> max=current;
		
		while(current!=null && current.next!=null){
			
		String cur=(String)(current.next.getData());	
		String maxNode=(String)(max.getData());	
			if(cur.compareTo(maxNode)<0){
				current.next=current.next.next;
			}
			else{
				current=current.next;
				max=current;
			}
		}
		return recursiveReverseList(reversedHead);
		
		
	}
	
	public Node<E> separateEvenOdd(Node<E> head){
		
		Node<E> endPointer=head; //beginning of end
		Node<E> prev=null;
		
		while(endPointer.next!=null)endPointer=endPointer.next;
		
		Node<E> newEnd=endPointer;
		Node<E> current=head;
		
		Integer d=(Integer)current.getData();
		while(d%2!=0 && current!=endPointer){
			newEnd.next=current;
			current=current.next;
			newEnd.next.next=null;
			newEnd=newEnd.next;
			d=(Integer)current.getData();
		}
		
		if((Integer)current.getData()%2==0){
			
			head=current;
			
			while(current!=endPointer){
				
				if((Integer)current.getData()%2==0){
					prev=current;
					current=current.next;
				}
				else{
					prev.next=current.next;
					current.next=null;
					newEnd.next=current;
					newEnd=current;
					current=prev.next;
				}
			}
		}
		else{
			prev=current;
		}
		if (newEnd!=endPointer && (Integer)current.getData()%2!=0)
	    {
	        prev.next = endPointer.next;
	        endPointer.next = null;
	        newEnd.next = endPointer;
	    }
	    return head;
	}
	
	//l2 is sorted in increasing order l3 is sorted in decreasing order
	
	public boolean findTriplet(LinkedList<E> l1,LinkedList<E> l2,LinkedList<E> l3, Integer n ){
		
		Node<E> a=l1.head;
		
		while(a!=null){
			
			Node<E> b=l2.head;
			Node<E> c=l3.head;
			
			Integer sum=(Integer)a.getData() + (Integer)b.getData() + (Integer)c.getData();
			
			if(sum==n){
				System.out.println(a.toString());
				System.out.println(b.toString());
				System.out.println(c.toString());
				return true;
			}
			
			if(sum<n)
				b=b.next;
			else c=c.next;
			
		a=a.next;	
		}
		System.out.println("Not found");
		return false;
		
	}
	
	
	public Node<E> rotateList(Node<E> head, int k){
		
		Node<E> current=head;
		int count=0;
		
		while(current!=null && count<k){
			current=current.next;
			count++;
		}
		System.out.println("Current Node:"+current.toString());
		
		Node<E> kthNode=current;
		
		while(current.next!=null) current=current.next;
		
		System.out.println("Current Node:"+current.toString());
		
		
		current.next=head;
		
		head=kthNode.next;
		kthNode.next=null;
		return head;
	}
	
	public Node<E> sort012List(LinkedList<E> list){
		
		Integer count[]=new Integer[3];
		
		for(int i=0;i<count.length;i++)count[i]=new Integer(0);
		
		Node<E> current=list.head;
		while(current!=null){
			int data=(Integer)(current.getData());
			System.out.println(data);
			count[data]++;
			current=current.next;
		}
		
		for(int i=1;i<count.length;i++) count[i]+=count[i-1];
		
		for(int i:count) System.out.print(i+" ");
		
		System.out.println();
		
		current=list.head; int k=0;
		while(current!=null){
			
			if(k<count[0]) current.setData((E)new Integer(0));
			else if(k>=count[0] && k<count[1]) current.setData((E)new Integer(1));
			else if(k>=count[1]) current.setData((E)new Integer(2));
			
			k++;
			current=current.next;
		}
		return list.head;
		
	}
	
	public  void mergeListAtAlternatePos(LinkedList<E> l1, LinkedList<E> l2){
		
		Node<E> firstListCurrent=l1.head;
		Node<E> secondListCurrent=l2.head;
		
		Node<E> firstListNextPointer=null;
		Node<E> secondListNextPointer=null;
		
		while(firstListCurrent!=null && secondListCurrent!=null){
			
			firstListNextPointer=firstListCurrent.next;
			secondListNextPointer=secondListCurrent.next;
			
			firstListCurrent.next=secondListCurrent;
			secondListCurrent.next=firstListNextPointer;
			
			firstListCurrent=firstListNextPointer;
			secondListCurrent=secondListNextPointer;
		}
		l2.head=secondListCurrent;
		System.out.println(l1.toString());
		System.out.println(l2.toString());
		
		
	}
	
	public Node<E> addTwoLists(Node<E> first, Node<E> second){
		
		LinkedList<E> r= new LinkedList<E>();
		Node<E> result=null;
		Node<E> prev=result;
		
		while(first !=null || second!=null){
			
			
			Integer sum= carry + (first != null?(Integer)first.getData():0) + (second != null?(Integer)second.getData():0);
			carry= sum>10?1:0;
			
			sum=sum%10;
			
			Node<E> temp= new Node<E>();
			temp.setData((E)sum);
			
			if(result==null)
				result=temp;
			else
				prev.next=temp;
			prev=temp;
			if(first!=null) first= first.next;
			if(second!=null) second = second.next;
		}
		
		if(carry > 0){
			Node<E> temp= new Node<E>();
			temp.setData((E)new Integer(carry));
			prev.next=temp;
		}
		r.head=result;
		System.out.println(r.toString());
		return result;
	}
	
	
	public static void main(String...a){
		
		
	LinkedList<Integer> ll=new LinkedList<Integer>();
	LinkedList<Integer> l2=new LinkedList<Integer>();
	LinkedList<Integer> l3=new LinkedList<Integer>();
	//LinkedList<Integer> l2=new LinkedList<Integer>();
	//LinkedList<String> ll=new LinkedList<String>();
	
	l3.addFirst(1);
	l3.addFirst(2);
	l3.addFirst(3);
	l3.addFirst(4);
	l2.addFirst(8);
	l2.addFirst(7);
	l2.addFirst(6);
	l2.addFirst(5);
	
		
		ll.addFirst(0);
		ll.addFirst(1);
		ll.addFirst(1);
		ll.addFirst(2);
		ll.addFirst(8);
		ll.addFirst(9);
		//ll.addFirst("7");
		//ll.addFirst("8");
		//System.out.println(l3.toString());
		//System.out.println(l2.toString());
		System.out.println("l1"+ll.toString());
		System.out.println("l3"+l3.toString());
		
		ll.addTwoLists(ll.head, l3.head);
		ll.add(ll.head, l3.head);
		//System.out.println("l3"+l3.toString());
		//System.out.println("l2"+l2.toString());
		
		//ll.mergeListAtAlternatePos(ll, l2);
		
		//ll.head=ll.sort012List(ll);
		//ll.findTriplet(ll, l2, l3, 20);
		//ll.head=ll.rotateList(ll.head, 3);
		//ll.deleteAlternate(ll.head);
		//ll.separateEvenOddPos();
		
		//ll.head=ll.deleteHigherNodes(ll.head);
		//l3.head=l3.separateEvenOdd(l3.head);
		//ll.head=ll.reverseKNode(ll.head, 2);
		//ll.head=ll.reverseAlternateKNodes(ll.head, 2);
		//ll.head=ll.recursiveReverseList(ll.head);
		//System.out.println(ll.toString());
		/*
		l2.addFirst("1");
		l2.addFirst("2");
		l2.addFirst("3");
		l2.addFirst("3");
		l2.addFirst("2");
		l2.addFirst("1");
		l2.addFirst("4");
		l2.addFirst("5");
		l2.addFirst("8");
		*/
		//System.out.println(l2.toString());
		
		
		//ll.head=ll.moveLastToFront(ll.head);
		
		//System.out.println(ll.intersectionPoint(ll.head, l2.head));
		//System.out.println(ll.getCount(ll.head));
		//System.out.println(ll.middleOfLL(ll.head).toString());
		//System.out.println(ll.isPalindromeRec(ll.head, ll.head));
		//ll.deleteNodeWhenOnlyItsPointerIsGiven(ll.getNthNode(ll.head, 2));
		
		//System.out.println(ll.toString());
		//System.out.println(ll.getNthNode(ll.head, 2).toString());
		
		//ll.removeFirst();
		//ll.removeLast();
		//ll.addFirst("yello");
		//ll.addLast("world2");
		//System.out.println(ll.toString());
		
		/*
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
		*/
		
		//l3.head=l3.mergeSortedList(ll.head, l2.head);
		//System.out.println(l3.toString());
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
