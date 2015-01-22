package com.last.programs;


public class Node1<E> {
	
	
	private E data;
	Node1<E> next;
	
	public Node1(){
		this.data=null;
		this.next=null;
	}
	public Node1(E data,Node1<E> next){
		this.data = data;
		this.next = next;
		
	}
	
	public E getData(){
		return this.data;
	}
	public Node1<E> getNext(){
		return this.next;
	}
	
	public void setData(E data){
		this.data=data;
	}
	public void setNext(Node1<E> next){
		this.next=next;
	}
	//LinkedList<String> l=new LinkedList<String>();
		
}
