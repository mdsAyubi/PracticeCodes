package com.clrs.chapters.chap23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Kruskal {
	
	public Graph kruskalMST(Graph g){
		
		ArrayList<Edge> listOfEdges=g.getListOfEdges();
		Collections.sort(listOfEdges);
		
		System.out.println("List Of Edges Made");
		System.out.println(listOfEdges.toString());
		
		int[][] mstMatrix=new int[g.getNumberOfEdges()][g.getNumberOfEdges()];
		/*
		for(int i=0;i<mstMatrix.length;i++){
			for(int j=0;j<mstMatrix.length;j++){
				mstMatrix[i][j]=0;
			}
		}
		*/
		//After sorting the edges we need to make a disjoint set of all the vertices. 
		//Then check each and every edge (u,v) to see id they belong to different tress. 
		//If they do, add them to the final tree and delete the tree they came from.
		//Do for all edges.
		
		ArrayList<TreeSet<String>> ds=new ArrayList<TreeSet<String>>();
		
		for(String vertex: g.getListOfVertices()){
			
			TreeSet<String> br=new TreeSet<String>();
			br.add(vertex);
			ds.add(br);
			
		}
		
	
		Graph mst=new Graph(mstMatrix);
		
		
		
		for(Edge e: listOfEdges){
			
			TreeSet<String> sourceTree=findTreeOf(ds,e.source);
			TreeSet<String> destTree=findTreeOf(ds,e.destination);
			
			
			if(sourceTree!=null&&destTree!=null&&sourceTree!=destTree){
				
				mst.addEdge(e);
				sourceTree.addAll(destTree);
				
				ds.remove(destTree);
			
			}
			
		}
		
		return mst;
	}
	
	
	private TreeSet<String> findTreeOf(ArrayList<TreeSet<String>> ds, String vertex){
		
		for(TreeSet<String> tree: ds){
			if(tree.contains(vertex)){
				return tree;
			}
		}
		return null;
		
	}
	
	
	
	public static void main(String...a){
		
		int [][] G={{0,4,0,0,2},{4,0,5,1,0},{0,5,0,6,3},{0,1,6,0,0},{2,0,3,0,0}};
		
		Kruskal kl=new Kruskal();
		Graph g=new Graph(G);
		System.out.println(kl.kruskalMST(g).toString());
	
		//Edge e1=new Edge(2+"",3+"",5);
		//Edge e2=new Edge(2+"",3+"",5);
		
		//System.out.print(e2.compareTo(e1));
	}

}
