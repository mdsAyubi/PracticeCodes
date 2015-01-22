package com.clrs.chapters.chap5;

public class Chapter5 {

	int x=getx();
	private int biasedRandom(){
		
		double p=0.4;
		double r=Math.random();
		
		if(r<p) return 0;
		else
			return 1;
		
		
	}
	
	public Chapter5() {
		// TODO Auto-generated constructor stub
		
		System.out.println(x);
	}
	int getx(){return 10;}
	
	int p=random01();
	
	
	public int random01(){
		
		double x=biasedRandom();
		double y=biasedRandom();
		
		if(x==y) return 0;
		else
			return 1;
		
	}
	
	public int randomAB(int a,int b){
		
		return (int)(a+(Math.random()*(b-a)));
	}
	
	public static void main(String...args){
		Chapter5 ch=new Chapter5();
		//int count0=0;
	/*	
	for(int i=0;i<1000;i++){
		
		if(0==ch.random01())
			count0++;
	}
	System.out.println(count0);
		System.out.println(ch.randomAB(5, 15));
	*/
	}
	
	
}
