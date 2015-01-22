package com.last.programs;


public class DLLNode<E> {

	E data;
	DLLNode<E> next;
	DLLNode<E> prev;
	
	public DLLNode(E data, DLLNode<E> next, DLLNode<E> prev) {
		super();
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	@Override
	public String toString() {
		return "DLLNode [data=" + data
				+ "]";
	}
	
	
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public DLLNode<E> getNext() {
		return next;
	}
	public void setNext(DLLNode<E> next) {
		this.next = next;
	}
	public DLLNode<E> getPrev() {
		return prev;
	}
	public void setPrev(DLLNode<E> prev) {
		this.prev = prev;
	}
	public DLLNode(E data){
		this.data=data;
		this.next=null;
		this.prev=null;
	}
	public void setPreviousNode(DLLNode<E> newNode){
		this.prev=newNode.prev;
		this.next=newNode;
		newNode.prev.next=this;
		newNode.prev=this;
		
	}
	public void setNextNode(DLLNode<E> newNode){
		newNode.next=this.next;
		this.next.prev=newNode;
		newNode.prev=this;
		this.next=newNode;
	}
	public void setLastNode(DLLNode<E> newNode){
		this.next=newNode;
		newNode.next=null;
		newNode.prev=this;
	}
	
}
