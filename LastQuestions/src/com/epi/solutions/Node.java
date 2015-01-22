package com.epi.solutions;


public class Node<E>  {
	
	
	private E data;
	Node<E> next;
	
	public Node(){
		this.data=null;
		this.next=null;
	}
	public Node(E data,Node<E> next){
		this.data = data;
		this.next = next;
		
	}
	
	public String toString(){
		return data.toString();
	}
	
	public E getData(){
		return this.data;
	}
	public Node<E> getNext(){
		return this.next;
	}
	
	public void setData(E data){
		this.data=data;
	}
	public void setNext(Node<E> next){
		this.next=next;
	}
	//LinkedList<String> l=new LinkedList<String>();
	
		
}
