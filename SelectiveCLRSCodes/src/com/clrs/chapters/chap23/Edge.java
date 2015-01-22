package com.clrs.chapters.chap23;

public class Edge implements Comparable<Edge> {

	String source;
	String destination;
	int edgeWeight;
	
	public Edge(String s, String g, int e){
		source=s;
		destination=g;
		edgeWeight=e;
	}
	
	public String getSource(){
		return source;
	}
	public String getDestination(){
		return destination;
	}
	public long getEdgeWeight(){
		return edgeWeight;
	}
	public int compareTo(Edge that){
		
		//System.out.println("This wait:"+this.edgeWeight);
		//System.out.println("That wait:"+that.edgeWeight);
		if(this.edgeWeight-that.edgeWeight==0) return 0;
		else if(this.edgeWeight-that.edgeWeight>0) return 1;
		else return -1;
		
	}
	public String toString(){
		return "{"+source+":->"+destination+"}";
	}
}
