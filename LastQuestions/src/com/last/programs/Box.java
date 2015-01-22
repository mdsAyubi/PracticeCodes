package com.last.programs;

public class Box implements Comparable<Box>{

	int h;
	int w;
	int d;
	
	public Box(int h, int d, int w){
		this.h=h;
		this.d=d;
		this.w=w;
	}

	public Box(){
		h=d=w=0;
	}
	
	@Override
	public int compareTo(Box that) {
		// TODO Auto-generated method stub
		
		return (that.d*that.w - this.d*this.w);
	}
	
	public String toString(){
		return "{"+h+"*"+w+"*"+d+"}";
	}
	
	
}
