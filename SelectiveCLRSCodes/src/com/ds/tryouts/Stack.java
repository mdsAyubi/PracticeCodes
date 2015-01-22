package com.ds.tryouts;

public class Stack<E> {

	protected Node<E> top;
	protected int size;
	
	public Stack(){
		this.top=null;
		this.size=0;
		
	}
	
	public int getSize(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return top==null;
	}
	
	public void push(E elem){
		Node<E> newNode=new Node<E>(elem,top);
		this.top=newNode;
		this.size++;
		
		
		
	}
	public E pop(){
		if(this.isEmpty()){
			return null;
		}
		
		Node<E> temp=this.top;
		this.top=top.getNext();
		this.size--;
		return temp.getData(); 
		
	}
	
	public String toString(){
		
		Node<E> temp=this.top;
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		while(temp!=null){
			sb.append(temp.getData()+",");
			temp=temp.getNext();
			
		}
		sb.append("}");
		return sb.toString();
		
	}
	
	
	public E peek(){
		if(this.isEmpty()){
			return null;
		}
		else{
			return this.top.getData();
		}
	}
	
	public static void main(String...a){
		
		Stack<Integer> s = new Stack<Integer>();
		
		System.out.println("Before Adding Size= "+s.getSize());
		System.out.println("Empty:"+s.isEmpty());
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		
		
		System.out.println(s.toString());
		
		System.out.println("1st pop"+s.pop());
		System.out.println("2nd pop"+s.pop());
		System.out.println("3rd pop"+s.pop());
		
		System.out.println("After popping= "+s.getSize());
		System.out.println("Empty:"+s.isEmpty());
		
	}
}
