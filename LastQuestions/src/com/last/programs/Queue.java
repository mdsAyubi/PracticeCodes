package com.last.programs;


public class Queue<E> {
	
	protected Node1<E> F;
	protected Node1<E> R;
	
	private int size;
	
	public Queue(){
		this.F=this.R=null;
		size=0;
	}
	
	
	public int circularTour(Stations[] arr){
		
		int start=0;
		int end=1;
		
		int n=arr.length;
		
		int currentPetrol=arr[start].petrol-arr[start].distance;
		
		
		/* Run a loop while all petrol pumps are not visited.
	      And we have reached first petrol pump again with 0 or more petrol */
		while(end!=start || currentPetrol<0){
			
			
			// If current amount of petrol in truck becomes less than 0, then
	        // remove the starting petrol pump from tour
			while( currentPetrol<0 && end!=start){
				currentPetrol-=arr[start].petrol- arr[start].distance;
				start=(start+1)%n;
				
				if(start==0) return -1;
			}
			
			//add a petrol pump
			currentPetrol+=arr[end].petrol-arr[end].distance;
			end=(end+1)%n;
		}
		
		return start;
		
	}
	
	
	public boolean isEmpty(){
		
		return (this.F==null && this.R==null);
		
	}
	
	public void enqueue(E elem){
		
		Node1<E> node= new Node1<E>(elem,null);
		
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
		
		Node1<E> temp=this.F;
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
		
		
		Stations s[]= {new Stations(6, 4), new Stations(3,6), new Stations(7,3)};
		
		System.out.println(q.circularTour(s));
		
		/*
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
		*/
		
	}
	

}


class Stations{
	
	int petrol;
	int distance;
	
	public Stations(int a, int b){
		petrol=a;
		distance=b;
	}
}