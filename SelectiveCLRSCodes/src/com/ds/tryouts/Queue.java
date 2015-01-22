package com.ds.tryouts;

public class Queue<E> {
	
	protected Node<E> F;
	protected Node<E> R;
	
	private int size;
	
	public Queue(){
		this.F=this.R=null;
		size=0;
	}
	
	public boolean isEmpty(){
		
		return (this.F==null && this.R==null);
		
	}
	
	public void enqueue(E elem){
		
		Node<E> node= new Node<E>(elem,null);
		
		if(this.isEmpty()){ //
			this.F=this.R=node;
			//System.out.println("is emoty");
		}
		else{
			//System.out.println("is not emoty");
			R.next=node;
			R=node;
			//last=node;
		}
		//System.out.println(size);
		size++;
		
		
	}
	
	public E dequeue(){
		E data=null;
		if(this.isEmpty()){ // no item
			data = null;
		}
		
		else if(F==R){ // 1 item
			data=F.getData();
			F=R=null;
			//return data;
		}
		else{
			data=F.getData();
			F=F.getNext();
		}
		size--;
		return data;
		
		
	}
	
	public int getSize(){
		return this.size;
	}
	
public String toString(){
		
		Node<E> temp=this.F;
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
	
public static void main(String...a){
		
		Queue<Integer> q = new Queue<Integer>();
		
		System.out.println("Before Adding Size= "+q.getSize());
		System.out.println("Empty:"+q.isEmpty());
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		System.out.println(q.toString());
		
		System.out.println("1st pop"+q.dequeue());
		System.out.println("2nd pop"+q.dequeue());
		System.out.println("3rd pop"+q.dequeue());
		
		System.out.println("After popping= "+q.getSize());
		System.out.println("Empty:"+q.isEmpty());
		
	}
	

}
