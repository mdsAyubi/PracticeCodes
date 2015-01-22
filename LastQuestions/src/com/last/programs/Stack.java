package com.last.programs;


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
	
	public void reverseStack(Stack<E> s){
		
		E temp=null;
		
		if(!s.isEmpty()){
			temp=s.pop();
			reverseStack(s);
		}
		insertAtBottom(s,temp);
		
	}
	
	private void insertAtBottom(Stack<E> s, E t){
		
		E temp=null;
		if(s.isEmpty()){
			s.push(t);
		}
		else{
			temp=s.pop();
			insertAtBottom(s, t);
			push(temp);
		}
	}
	
	public void spanOfStock(int []A){
		
		Stack<Integer> s=new Stack<Integer>();
		s.push(A[0]);
		
		int[]S=new int[A.length];
		
		for(int i=0;i<S.length;i++) S[i]=1;
		
		int count=0;
		
		for(int i=1;i<A.length;i++){
			
			count=1;
			while(!s.isEmpty() && s.peek()<A[i]){
				s.pop();
				count++;
			}
			S[i]=s.isEmpty()?(i+1):(i-size);
			
			s.push(A[i]);
			
		}
		for(int i: S){
			System.out.print(" "+i);
		}
		
		
	}
	
	public static void main(String...a){
		
		Stack<Integer> s = new Stack<Integer>();
		
		System.out.println("Before Adding Size= "+s.getSize());
		System.out.println("Empty:"+s.isEmpty());
		
		int[] A={100, 80, 60, 70, 60, 75, 85};
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		
		
		//System.out.println(s.toString());
		
		//s.reverseStack(s);
		s.spanOfStock(A);
		//System.out.println(s.toString());
		
		//System.out.println("1st pop"+s.pop());
		//System.out.println("2nd pop"+s.pop());
		//System.out.println("3rd pop"+s.pop());
		
		//System.out.println("After popping= "+s.getSize());
		//System.out.println("Empty:"+s.isEmpty());
		
	}
}
