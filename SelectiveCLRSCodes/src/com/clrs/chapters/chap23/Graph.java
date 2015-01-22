package com.clrs.chapters.chap23;

import java.util.ArrayList;
import java.util.Hashtable;

public class Graph {

	int[][] G;
	Hashtable<String,Edge> edges;
	int numOfEdges=0;
	int numOfVertices=0;
	
	public Graph(int[][] G){
		this.G=G;
		this.edges=new Hashtable<String,Edge>();
	
		this.numOfVertices=G.length;
		
		for(int i=0;i<G.length;i++){
			for(int j=0;j<i;j++){
				if(G[i][j]!=0){
					
					edges.put(i+"->"+j, new Edge(i+"",j+"",G[i][j]));
					this.numOfEdges++;
				}
			}
		}
		System.out.println("Number of vertices:"+numOfVertices);
		System.out.println("Number of Edges   :"+numOfEdges);
	}
	
	public int[][] getWeightMatrix(){
		return G;
	}
	public ArrayList<Edge> getListOfEdges(){
		
		ArrayList<Edge> listOfEdges=new ArrayList<Edge>(this.edges.values());
		return listOfEdges;
		
	}
	
	public boolean findEdgeInGraph(Edge e){
		
		return this.edges.contains(e);
	}
	
	public int getNumberOfEdges(){
		return this.numOfEdges;
	}
	
	public int getNumberOfVertices(){
		return this.numOfVertices;
	}
	
	public Graph addEdge(Edge e){
		
		this.edges.put(e.getSource()+":->"+e.getDestination(), e);
		
		//int source=Integer.parseInt(e.getSource());
		//int destination=Integer.parseInt(e.getDestination());
		
		//this.G[source][destination]=e.edgeWeight;
		
		return this;
	}
	
	public Graph removeEdge(Edge e){
		
		this.edges.remove(e);
		int source=Integer.parseInt(e.getSource());
		int destination=Integer.parseInt(e.getDestination());
		
		this.G[source][destination]=0;
		return this;
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("{ ");
		for(Edge e: this.getListOfEdges()){
			sb.append(e.toString());
		}
		sb.append(" }");
		return sb.toString();
		
	}
	
	public ArrayList<String> getListOfVertices(){
		
	
		Hashtable<String,String> v=new Hashtable<String,String>();
		
		for(Edge e: this.getListOfEdges()){
			
			v.put(e.getSource(),e.getSource());
			v.put(e.getDestination(),e.getDestination());
		}
		
		return new ArrayList<String>(v.values());
	}
	
}
