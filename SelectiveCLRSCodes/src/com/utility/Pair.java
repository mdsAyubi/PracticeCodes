package com.utility;

public class Pair<T extends Number> {
	
	private T a;
	private T b;
	
	public Pair(T a,T b){
		this.a=a;
		this.b=b;
	}

	public Number distance(Pair<T> that, String dName){
		Double d=0.0;
		if(dName=="Manhattan"){
			
				d=Math.abs((this.getA().doubleValue()-that.getA().doubleValue())+(this.getB().doubleValue()-that.getB().doubleValue()));
			
		}
		
		if(dName=="Euclidean"){
			
			d=Math.pow(this.getA().doubleValue()-that.getA().doubleValue(),2)+
			Math.pow(this.getB().doubleValue()-that.getB().doubleValue(),2);
		}
		return d;
		
		
		
	}
	
	
	public String toString(){
		return "{"+a.toString()+":"+b.toString()+"}";
	}
	
	public  T getA(){
		return this.a;
	}
	
	public  T getB(){
		return this.b;
	}
	
	public void setA(T a){
		this.a=a;
	}
	public void setB(T b){
		this.b=b;
	}
	
	
	public static void main(String...args){
		
		//Pair<String> p1=new Pair<String>(new String("hello"),new String("gbrld"));
		//Pair<String> p2=new Pair<String>("hello","gaeat");
		
		//System.out.println(p1.toString());
		//System.out.println(p2.toString());
		//System.out.println(p1.compareTo(p2));
		
		
	}

	
/*
	public int compareTo(Pair<T> that) {
		// TODO Auto-generated method stub
		if(this.a.compareTo(that.a)==0){
			return this.b.compareTo(that.b);
		}
		else
			return this.a.compareTo(that.a);
	}
*/

}
