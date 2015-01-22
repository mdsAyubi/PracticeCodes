package com.clrs.chapters.chap24;

import java.util.Hashtable;
import java.util.PriorityQueue;

public class ShortestPath {

	int[] distance;
	int[] predecessor;
	
	public ShortestPath(int[][] G){
		
	}
	
	
	public void initializeSingleSource(int[][]G, int source){
		distance=new int[G.length];
		predecessor=new int[G.length];
		
		for(int i=0;i<distance.length;i++){
			distance[i]=Integer.MAX_VALUE;
			predecessor[i]=-1;
		}
		distance[source]=0;
		
	}
	
	public void relaxEdge(int u,int v, int[][]G){
		if(distance[v]>distance[u]+G[u][v]){
			distance[v]=distance[u]+G[u][v];
			predecessor[v]=u;
		}
	}
	
	public boolean bellmanFord(int[][]G, int source){
		
		initializeSingleSource(G, source);
		for(int i=0;i<G.length;i++){
			
			for(int j=0;j<G.length;j++){
				for(int k=0;k<G[j].length;k++){
					if(G[j][k]!=-1){
						relaxEdge(j, k, G);
					}
				}
			}
			
		}
		
		for(int u=0;u<G.length;u++){
			for(int v=0;v<G[u].length;v++){
				if(distance[v]>distance[u]+G[u][v]){
					return false;
				}
			}
		}
	return true;
		
	}
	
	public void dijkstra(int[][]G,int source){
		
		initializeSingleSource(G, source);
		Hashtable<Integer, Integer> S=new Hashtable<Integer,Integer>();
		PriorityQueue<Integer> Q=new PriorityQueue<Integer>();
		
		for(int i=0;i<G.length;i++){
			Q.add(i);
		}
		
		while(Q.size()!=0){
			
			int u=Q.remove();
			S.put(u, u);
			
			for(int v=0;v<G[u].length;v++){
				if(G[u][v]!=-1){
					relaxEdge(u, v, G);
				}
			}
			
		}
		
	}
	public static void main(String...a){

		int [][] G={{-1,4,-1,-1,2},{4,-1,5,1,-1},{-1,5,-1,6,3},{-1,1,6,-1,-1},{2,-1,3,-1,-1}};
		ShortestPath sh=new ShortestPath(G);
		
		//System.out.println(sh.bellmanFord(G, 0));
		sh.dijkstra(G,0);
		
		for(int i:sh.distance){
			System.out.print(" "+i);
		}
	}
	
}
