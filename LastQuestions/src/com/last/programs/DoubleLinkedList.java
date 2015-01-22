package com.last.programs;

public class DoubleLinkedList<E extends Comparable<E>> {

	DLLNode<E> head;
	
	public DoubleLinkedList(){
		head=null;
	}
	
	public DLLNode<E> addLastElement(E data){
		DLLNode<E> newNode=new DLLNode<E>(data);
		if(head == null){
			head=newNode;
		}
		else{
			DLLNode<E> temp=this.head;
			while(temp.next != null)temp=temp.next;
			
			temp.setLastNode(newNode);
		}
		return head;
	}
	
	
	public DLLNode<E> addFirstElement(E data){
		DLLNode<E> newNode=new DLLNode<E>(data);
		
		newNode.next=this.head;
		this.head.prev=newNode;
		this.head=newNode;
		
		return this.head;
	}
	
	public void printReverse(){
		DLLNode<E> temp=this.head;
		System.out.println("Reverse");
		while(temp.next != null) temp=temp.next;
		
		while(temp != null) {
			System.out.print(" "+temp.data);
			temp=temp.prev;
		
		}
	}
	
	public void printDLL(){
		DLLNode<E> temp=this.head;
		while(temp != null){
			System.out.print(" "+temp.data);
			temp=temp.next;
		}
	}
	
	/*
	 * All you gotta do is swap the next and prev pointers...and tada...reversed
	 */
	public DLLNode<E> reverseDLL(DLLNode<E> head){
		
		DLLNode<E> current=head;
		DLLNode<E> temp=null;
		while(current!=null){
			
			temp=current.prev;
			current.prev=current.next;
			current.next=temp;
			
			current=current.prev;
		}
		
		if(temp!=null) head=temp.prev;
		return head;
				
	}

	public DLLNode<E> DLLtoBST(DLLNode<E> head, int n){
		

		if(head!=null){
			if(n<=0) return null;
			
			DLLNode<E> left= DLLtoBST(head, n/2);
			
			DLLNode<E> root=head;
			
			root.prev=left;
			
			head=head.next;
			
			root.next=DLLtoBST(head, n-n/2-1);
			
			return root;
		}
		else return null;
		
	}
	
	
	
	public static void main(String...a){
		DoubleLinkedList<String> dll= new DoubleLinkedList<String>();
		
		dll.addLastElement("Hello1");
		dll.addLastElement("Hello2");
		dll.addLastElement("Hello3");
		dll.addLastElement("Hello4");
		
		dll.addFirstElement("Hello0");
		dll.addFirstElement("Hello-1");
		dll.addLastElement("Hello5");
		
		dll.printDLL();
		
		dll.head=dll.DLLtoBST(dll.head, 7);
		//dll.head=dll.reverseDLL(dll.head);
		System.out.println();
		dll.printDLL();
		//dll.printReverse();
	}

	@Override
	public String toString() {
		return "DoubleLinkedList [head=" + head + "]";
	}

	public DLLNode<E> getHead() {
		return head;
	}

	public void setHead(DLLNode<E> head) {
		this.head = head;
	}
	
}
