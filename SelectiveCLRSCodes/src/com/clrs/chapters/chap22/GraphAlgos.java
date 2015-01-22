package com.clrs.chapters.chap22;

import java.util.LinkedList;

public class GraphAlgos {
	
	
	public int [][] graphSquare(int[][] G){
		
		for (int i=0;i<G.length;i++){
			for(int j=0;j<G[i].length;j++){
				
				if(i==j||G[i][j]==1) continue;
				else if (checkConnectivity(G,i,j)==true){
					G[i][j]=1;
				}
				
				
			}
		}
		return G;
		
	}
	
	public void print(int[][] G){
		for (int i=0;i<G.length;i++){
			for(int j=0;j<G[i].length;j++){
				System.out.print(G[i][j]+ " ");
			}
			System.out.println();
		}
	}
	private boolean checkConnectivity(int[][] G,int i,int j){
		boolean isConnected = false;
		for (int k=0;k<G.length;k++){
			if(k==i||k==j) continue;
			
			else{
				if (G[i][k]==1 && G[k][i]==1){
					isConnected=true;
					break;
				}
			}
		}
		return isConnected;
		
	}
	public enum colorConst{WHITE,GRAY,BLACK};
	public void bfs(int [][]G, int source, int[] distance, int[] predecessor){
		
		
		//0 means WHITE
		//1 means GRAY
		//2 means BLACK
		
		int[] color=new int[G.length];
		//colorConst c;
		
		for(int i=0;i<G.length;i++){
			color[i]=0;
			distance[i]=Integer.MAX_VALUE;
			predecessor[i]=-1;
			
		}
		color[source]=1;
		distance[source]=0;
		predecessor[source]=-1;
		
		LinkedList<Integer> q=new LinkedList<Integer>();
		q.addLast(source);
		System.out.print("Queue is:"+q);
		while(!q.isEmpty()){
			System.out.println("Queue is:"+q);
			int u=q.removeFirst();
			
				for(int v=0;v<G[u].length;v++){
					if(G[u][v]==1){
						if (color[v]==0){
							color[v]=1;
							q.addLast(v);
							distance[v]=distance[u]+1;
							predecessor[v]=u;
						
						}
					}
				}
			color[u]=2;
		}
	}
	
	public static void main(String...a){
		
		int [][] Gr={{0,1,1,0,1},{1,0,0,1,0},{1,0,0,1,0},{0,1,1,0,1},{1,0,0,1,0}};
		
		GraphAlgos gr=new GraphAlgos();
		//int[][] Grs = gr.graphSquare(Gr);
		
		//gr.print(Grs);
		int[] distance=new int[Gr.length];
		int[] predecessor=new int[Gr.length];
		gr.bfs(Gr, 0, distance, predecessor);
		
		for(int i:distance){
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i:predecessor){
			System.out.print(i+" ");
		}
		System.out.println("path from 0 to 3");
		gr.printPath(Gr, predecessor, 0, 3);
		System.out.println("Explore Path");
		//gr.explorePath(Gr, 0);
		
		System.out.println("DFS");
		gr.dfs(Gr, 0);

		
		
	}

	public void printPath(int[][]G, int[] predecessor,int source, int destination){
		if(source==destination){
			System.out.print(" "+source);
			
		}
		else if(predecessor[destination]==-1){
			System.out.print(" No Path ");
		}
		else{
			printPath(G,predecessor,source,predecessor[destination]);
			System.out.print(" "+destination);
		}
		
		
	}
	
	public void explorePath(int[][] G, int source){
		
		if(getMinEdgesRepetition(G,source)>=3)
		{
			System.out.print(" "+source);
			return;
		}
		else{
			System.out.print(" "+source);
			explorePath(G, getMinEdgesRepetition(G,source));
			
		}
			
	}
	
	private int getMinEdgesRepetition(int [][]G, int source){
		
		int min=Integer.MAX_VALUE;
		for(int i=0;i<G[source].length;i++){
			if(G[source][i]==0) continue;
			else if(G[source][i]<min){
				min=i;
				
			}
	
		}
		
		G[source][min]++;
		System.out.print(" Min= "+min+" "+"Status"+G[source][min]);
		return min;
	}
	
	public void dfs(int[][]G, int source){
		int [] pie=new int[G.length];
		int color[]=new int[G.length];
		
		for(int i=0;i<pie.length;i++)
		{
			color[i]=0;  // WHITE
			pie[i]=-1;
		}
		
		DFSvisit(G,source, color, pie);
		
		
	}
	
	private void DFSvisit(int[][]G,int source, int[] color, int[] pie){
		
		color[source]=1;
		
		for(int i=0;i<G[source].length;i++){
			
			if(G[source][i]==0) continue;
			else{
				if(color[i]==0){
					pie[i]=source;
					System.out.print(" "+i);
					DFSvisit(G, i, color, pie);
				}
			}
		}
		color[source]=2;
		
	}
	
}
