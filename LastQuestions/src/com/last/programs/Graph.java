package com.last.programs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph<E> {

	int V;
	HashMap<E,ArrayList<E>> adjList;
	
	public Graph(int V) {
		// TODO Auto-generated constructor stub
		this.V=V;
		adjList=new HashMap<E,ArrayList<E>>(V);
		
		
	
	}
	
	public void addEdge(E u, E v){
		
		if(adjList.get(u)==null){
			ArrayList<E> temp=new ArrayList<E>();
			temp.add(v);
			adjList.put(u, temp);
		}
		else{
			adjList.get(u).add(v);
		}
		
		if(adjList.get(v)==null){
			ArrayList<E> temp=new ArrayList<E>();
			temp.add(u);
			adjList.put(v, temp);
		}
		else{
			adjList.get(v).add(u);
		}
		
		
		
	}
	
	
public void BFSDriver(E source){
		
		Hashtable<E,Boolean> visited= new Hashtable<E,Boolean>(this.V);
		
		for(E keys: adjList.keySet()){
			visited.put(keys, false);
			
		}
		BFS(source, visited);
	}
	
	
	
	
	public void BFS(E source,Hashtable<E, Boolean> visited){
		
		Queue<E> q=new ArrayDeque<E>();
		q.add(source);
		visited.put(source, true);
		
		while(!q.isEmpty()){
			
			E currentItem=q.remove();
			System.out.print(" "+currentItem.toString());
			
			for(E key: adjList.get(currentItem)){
				
				if(visited.get(key)==false){
					q.add(key);
					visited.put(key, true);
				}
			}
		}
		
	}
	
	public boolean isReachable(E source, E destination){
		if(source==destination) return true;
		
		Hashtable<E,Boolean> visited= new Hashtable<E,Boolean>(this.V);
		
		for(E keys: adjList.keySet()){
			visited.put(keys, false);
		}
		
		visited.put(source, true);
		com.last.programs.Queue<E> q= new com.last.programs.Queue<E>();
		q.enqueue(source);
		
		while(!q.isEmpty()){
			
			E u= q.dequeue();
			for(E currentItem: adjList.get(u)){
				
				if(currentItem.equals(destination)) return true;
				if(visited.get(currentItem)==false){
					visited.put(currentItem, true);
					q.enqueue(currentItem);
				}
			}
		}
		return false;
	}
	
	public void DFSDriver(E source){
		
		Hashtable<E,Boolean> visited= new Hashtable<E,Boolean>(this.V);
		
		for(E keys: adjList.keySet()){
			visited.put(keys, false);
			
		}
		DFS(source, visited);
	}
	public void DFS(E source, Hashtable<E, Boolean> visited){
		
		visited.put(source, true);
		System.out.println(source+" ");
		
		for(E currentItem:adjList.get(source)){
			if(visited.get(currentItem)==false){
				DFS(currentItem,visited);
			}
		}
		
	}
	
	public void printGraph(){
		
		System.out.println(adjList.toString());
		
	}
	
	public void cyclicDriver(E source){
		Hashtable<E,Boolean> visited= new Hashtable<E,Boolean>(this.V);
		
		for(E keys: adjList.keySet()){
			visited.put(keys, false);
			
		}
		System.out.println(isCyclic(source, visited, null));
		
	}
	
	//cycle in an undirected graph
	
	public boolean isCyclic(E source, Hashtable<E, Boolean> visited, E parent){
		visited.put(source, true);
		
		for(E currentItem: adjList.get(source)){
			if(visited.get(currentItem)==false){
				if(isCyclic(currentItem, visited, parent)){
					return true;
				}
			}
			else if(currentItem!=parent){
				return true;
			}
		}
		return false;
	}
	
	
	public void topologicalSort(E source, Hashtable<E, Boolean> visited, Stack<E> s){
		
		visited.put(source, true);
		
		for(E currentItem:adjList.get(source)){
			if(visited.get(currentItem)==false){
				topologicalSort(currentItem, visited, s);
			}
		}
		s.push(source);
		
		
	}
	
	public void topologicalSortDriver(E source){
		
		Hashtable<E,Boolean> visited= new Hashtable<E,Boolean>(this.V);
		Stack<E> s=new Stack<E>();
		for(E keys: adjList.keySet()){
			visited.put(keys, false);
			
		}
		topologicalSort(source, visited, s);
		
		for(E item:s){
			System.out.print(" "+item);
		}
		
	}
	
	private boolean isCyclicInDirectedGraphUtil(E v,Hashtable<E, Boolean> visited, Hashtable<E, Boolean> recStack){
		
		if(visited.get(v)==false){
			
			visited.put(v, true);
			recStack.put(v, true);
			
			for(E currentItem: adjList.get(v)){
				if(visited.get(currentItem)==false && isCyclicInDirectedGraphUtil(currentItem, visited, recStack))
					return true;
				else if(recStack.get(currentItem)) return true;
			}
		}
		recStack.put(v, false);
		return false;
	}
	
	public boolean isCyclicInDirectedGraph(){
		
		//boolean visited[] =new boolean[this.V];
		//boolean recStack[] =new boolean[this.V];
	
		Hashtable<E, Boolean> visited=new Hashtable<E, Boolean>();
		Hashtable<E, Boolean> recStack=new Hashtable<E, Boolean>();
		
		for(E i: adjList.keySet()){
			
			visited.put(i, false);
			recStack.put(i, false);
		}
		
		for(E i: adjList.keySet()){
			if(isCyclicInDirectedGraphUtil(i,visited, recStack))
				return true;
		}
		return false;
	}
	
	public boolean isBipartite(E source){
		
		com.last.programs.Queue<E> q= new com.last.programs.Queue<E>();
		
		Hashtable<E, Integer> color=new Hashtable<E, Integer>();
		for(E item: adjList.keySet()) color.put(item, -1); // no color assigned
		
		q.enqueue(source);
		color.put(source, 1);
		
		while(!q.isEmpty()){
			
			E u=q.dequeue();
			for(E currentItem: adjList.get(u)){
				if(color.get(currentItem)==-1){
					color.put(currentItem, 1-color.get(u));
					q.enqueue(currentItem);
				}
				else if(color.get(u)==color.get(currentItem)){
					return false;
				}
			}
		}
		return true;
	}
	
	public void longestPathInDAG(E source){
		
		Hashtable<E,Boolean> visited= new Hashtable<E,Boolean>(this.V);
		Stack<E> s=new Stack<E>();
		
		for(E keys: adjList.keySet()){
			visited.put(keys, false);
			
		}

		for(E keys: adjList.keySet()){
			if(visited.get(keys)==false)
				topologicalSort(keys, visited, s);
		}
		System.out.println(s.toString());
		Hashtable<E, Integer> dist=new Hashtable<E, Integer>();
		
		for(E keys: adjList.keySet()){
			dist.put(keys, Integer.MIN_VALUE);
		}
		dist.put(source, 0);
		
		while(!s.isEmpty()){
			
			E u = s.pop();
			
			if(dist.get(u)!=Integer.MIN_VALUE){
				
				for(E currentItem: adjList.get(u)){
					if(dist.get(currentItem)< dist.get(u)+1)
						dist.put(currentItem, dist.get(u)+1); // not carrying weight
				}
			}
		}
			System.out.print(dist.toString());
	}
	

	public void shortestPathInDAG(E source){
		
		Hashtable<E,Boolean> visited= new Hashtable<E,Boolean>(this.V);
		Stack<E> s=new Stack<E>();
		
		for(E keys: adjList.keySet()){
			visited.put(keys, false);
			
		}

		for(E keys: adjList.keySet()){
			if(visited.get(keys)==false)
				topologicalSort(keys, visited, s);
		}
		System.out.println(s.toString());
		Hashtable<E, Integer> dist=new Hashtable<E, Integer>();
		
		for(E keys: adjList.keySet()){
			dist.put(keys, Integer.MAX_VALUE);
		}
		dist.put(source, 0);
		
		while(!s.isEmpty()){
			
			E u = s.pop();
			
			if(dist.get(u)!=Integer.MAX_VALUE){
				
				for(E currentItem: adjList.get(u)){
					if(dist.get(currentItem) > dist.get(u)+1)
						dist.put(currentItem, dist.get(u)+1); // not carrying weight
				}
			}
		}
		
		
			System.out.print(dist.toString());
		
		
	}

	
	
	public void swap(E a , E b){
		E temp=a;
		a=b;
		b=temp;
	}
	
	
	private Graph<E> getTranspose(){
		
		Graph<E> transpose=new Graph<E>(this.V);
		
		for(E keys:adjList.keySet()){
			for(E adjacentNodes: adjList.get(keys)){
				
				transpose.addEdge(adjacentNodes, keys);
			}
		}
		return transpose;
		
	}
	
	public boolean isStronglyConnected(){
		
		
		Hashtable<E,Boolean> visited= new Hashtable<E,Boolean>(this.V);
		
		for(E keys: adjList.keySet()){
			visited.put(keys, false);
			
		}
		this.DFS((E)new String("Delhi"), visited);
		
		System.out.println(visited.toString());
		
		if(visited.containsValue(false)) return false;
		
		Graph<E> g=this.getTranspose();
		
		System.out.println(g.toString());
		System.out.println("Transpose done...");
		for(E keys: adjList.keySet()){
			visited.put(keys, false);
		}
		
		g.DFS((E)new String("Delhi"), visited);
		
		if(visited.containsValue(false)) return false;
		
		return true;
		
	}
	
	public String toString(){
		
		StringBuilder str=new StringBuilder();
		
		str.append(" [ ");
		for(E keys: adjList.keySet()){
			str.append(" "+keys);
			str.append(" : ");
			str.append(adjList.get(keys).toString()+" ");
		}
		str.append(" ] ");
		return str.toString();
	}
	int time=0;
	private void APUtil(E u, 
			Hashtable<E,Boolean> visited, 
			Hashtable<E,Integer> disc,
			Hashtable<E,Integer> low,
			Hashtable<String,String> parent,
			Hashtable<E,Boolean> ap
			){
		
		time++;
		visited.put(u,true);
		int children=0;
		
		disc.put(u, time);
		low.put(u, time);
		
		for(E v: adjList.get(u)){
			
			if(visited.get(v)==false){
				children++;
				parent.put((String)v, (String)u);
				APUtil(v, visited, disc, low, parent, ap);
				
				// Check if the subtree rooted with v has a connection to
	            // one of the ancestors of u
				low.put(u, Math.min(low.get(u), low.get(v)));
				
				if(parent.get(u).equals("None") && children >1)
					ap.put(u, true);
				if( !parent.get(u).equals("None") && low.get(v) >= disc.get(u))
					ap.put(u, true);
			}
			else if( v != parent.get(u))
				low.put(u, Math.min(low.get(u), disc.get(v)));
		}
		
	}
	
	public void articulationPointDriver(){
		
		Hashtable<E,Boolean> visited= new Hashtable<E,Boolean>(this.V);
		Hashtable<E,Integer> disc= new Hashtable<E,Integer>(this.V);
		Hashtable<E,Boolean> ap= new Hashtable<E,Boolean>(this.V);
		
		Hashtable<String, String> parent= new Hashtable<String,String>(this.V);
		Hashtable<E,Integer> low= new Hashtable<E,Integer>(this.V);
		
		
		for(E keys: adjList.keySet()){
			visited.put(keys, false);
			parent.put((String)keys,"None");
			ap.put(keys, false);
		}
		for(E keys: adjList.keySet()){
			if(visited.get(keys)==false){
				APUtil(keys,visited,disc,low, parent,ap );
			}
			
		}
		
		System.out.println(ap.toString());
		
	}
	
	
	public boolean isBiconnected(){
		
		Hashtable<E,Boolean> visited= new Hashtable<E,Boolean>(this.V);
		Hashtable<E,Integer> disc= new Hashtable<E,Integer>(this.V);
		Hashtable<E,Boolean> ap= new Hashtable<E,Boolean>(this.V);
		
		Hashtable<String, String> parent= new Hashtable<String,String>(this.V);
		Hashtable<E,Integer> low= new Hashtable<E,Integer>(this.V);
		
		
		for(E keys: adjList.keySet()){
			visited.put(keys, false);
			parent.put((String)keys,"None");
			ap.put(keys, false);
		}
		APUtil((E)new String("Delhi"),visited,disc,low, parent,ap );
		
		if(visited.containsValue(false)) return false;
		if(ap.containsValue(true)) return false;
		
		return true;
		
	}
	
	
	private void bridgeUtil(E u, 
			Hashtable<E,Boolean> visited, 
			Hashtable<E,Integer> disc,
			Hashtable<E,Integer> low,
			Hashtable<String,String> parent,
			Hashtable<E,Boolean> ap
			){
		
		time++;
		visited.put(u,true);
		int children=0;
		
		disc.put(u, time);
		low.put(u, time);
		
		for(E v: adjList.get(u)){
			
			if(visited.get(v)==false){
				children++;
				parent.put((String)v, (String)u);
				bridgeUtil(v, visited, disc, low, parent, ap);
				
				// Check if the subtree rooted with v has a connection to
	            // one of the ancestors of u
				low.put(u, Math.min(low.get(u), low.get(v)));
				
				if(parent.get(u).equals("None") && children >1){
					ap.put(u, true);
					System.out.println(u + " -> "+ v);
				}
				if( !parent.get(u).equals("None") && low.get(v) >= disc.get(u)){
					ap.put(u, true);
					System.out.println(u + " -> "+ v);
				}
			}
			else if( v != parent.get(u))
				low.put(u, Math.min(low.get(u), disc.get(v)));
		}
		
	}
	
	public void bridgeDriver(){
		
		Hashtable<E,Boolean> visited= new Hashtable<E,Boolean>(this.V);
		Hashtable<E,Integer> disc= new Hashtable<E,Integer>(this.V);
		Hashtable<E,Boolean> ap= new Hashtable<E,Boolean>(this.V);
		
		Hashtable<String, String> parent= new Hashtable<String,String>(this.V);
		Hashtable<E,Integer> low= new Hashtable<E,Integer>(this.V);
		
		
		for(E keys: adjList.keySet()){
			visited.put(keys, false);
			parent.put((String)keys,"None");
			ap.put(keys, false);
		}
		for(E keys: adjList.keySet()){
			if(visited.get(keys)==false){
				bridgeUtil(keys,visited,disc,low, parent,ap );
			}
			
		}
		
		System.out.println(ap.toString());
		
	}
	
	public void eulerianStatus(){
		
		Hashtable<E,Boolean> visited= new Hashtable<E,Boolean>(this.V);
		
		for(E keys: adjList.keySet()){
			visited.put(keys, false);
		}
		
		DFS((E)adjList.keySet().toArray()[0], visited);
		
		if(visited.containsValue(false)) {
			System.out.println("No connected graph");
		}
		
		int odd=0;
		
		for(ArrayList<E> list:adjList.values()){
			
			if(list.size() %2 ==1) odd++;
		}
		if(odd>2)
			System.out.println("Graph is not Eulerian");
		if(odd==0)
			System.out.println("Eulerian");
		if(odd==1)
			System.out.println("Euler path");
		if(odd==2)
			System.out.println("Euler cycle");
	}
	
public void fillOrder(E source, Hashtable<E, Boolean> visited, Stack<E> s){
		
		visited.put(source, true);
		System.out.println(source+" ");
		
		for(E currentItem:adjList.get(source)){
			if(visited.get(currentItem)==false){
				DFS(currentItem,visited);
			}
		}
		s.push(source);
		
	}
	
	public void printSCC(){
		Hashtable<E,Boolean> visited= new Hashtable<E,Boolean>(this.V);
		
		for(E keys: adjList.keySet()){
			visited.put(keys, false);
		}
		
		Stack<E> s=new Stack<E>();
		fillOrder((E)adjList.keySet().toArray()[0], visited, s);
		
		Graph<E> transpose=this.getTranspose();
		
		for(E keys: adjList.keySet()){
			visited.put(keys, false);
		}
		while(!s.isEmpty()){
			 E v= s.pop();
			 
			 if(visited.get(v)==false){
				 transpose.DFS(v, visited);
				 System.out.println();
			 }
		}
		
	}

	
	public void transitiveClosure(boolean[][] G){
		
		boolean [][] reachable=new boolean[G.length][G.length];
		
		for(int i=0;i<G.length;i++){
			for(int j=0;j<G.length;j++){
				reachable[i][j]=G[i][j];
			}
		}
		
		for(int i=0;i<G.length;i++){
			for(int j=0;j<G.length;j++){
				for(int k=0;k<G.length;k++){
					reachable[i][j]=reachable[i][j]||(G[i][k] && G[k][j]);
				}
			}
		}
	
		for(int i=0;i<G.length;i++){
			for(int j=0;j<G.length;j++){
				System.out.println(reachable[i][j]);
			}
			System.out.println();
		}
	
		
	}
	
	private boolean isSafeGrid(int row, int col, boolean[][] visited, int[][] G){
		
		return (row>=0 && row<G.length && col >=0 && col < G.length && G[row][col]==1 && !visited[row][col]);
		
	}
	int rowNbr[] = {-1, -1, -1,  0, 0,  1, 1, 1};
    int colNbr[] = {-1,  0,  1, -1, 1, -1, 0, 1};
    
	private void DFSArray(int[][]G, int i, int j, boolean[][] visited){
		
		
	    visited[i][j]=true;
	    
	    
	    for(int k=0;k<8;k++){
	    	System.out.println(isSafeGrid(i+rowNbr[k], j+colNbr[k],visited,G));
	    	if(isSafeGrid(i+rowNbr[k], j+colNbr[k],visited,G))
	    		DFSArray(G, i+rowNbr[k], j+colNbr[k], visited);
	    }
		
	}
	
	
	public void countIslands(int [][]G){
		
		boolean [][] visited=new boolean[G.length][G.length];
		
		/*
		for(int i=0;i<G.length;i++){
			for(int j=0;j<G.length;j++){
				System.out.println(visited[i][j]);
			}
			System.out.println();
		}
		*/
		int count=0;
		
		for(int i=0;i<G.length;i++){
			for(int j=0;j<G.length;j++){
				if(G[i][j]==1 && visited[i][j]==false){
					DFSArray(G, i , j, visited);
					count++;
				}
			}
		}
		
		System.out.println("Count:"+count);
		
	}
	
	private boolean bfsArray(int[][] G, int s, int t, int[] parent){
		
		boolean[] visited=new boolean[G.length];
		java.util.Queue<Integer> q=new java.util.LinkedList<Integer>();
		
		q.add(s);
		visited[s]=true;
		parent[s]=-1;
		while(!q.isEmpty()){
			
			int u = q.poll();
			for(int v=0;v<G.length;v++){
				
				if(visited[v]==false && G[u][v] > 0){
					
					q.add(v);
					parent[v]=u;
					visited[v]=true;
				}
			}
		}
		return (visited[t]==true);
		
	}
	/*
	 * Normally works as ford fulkerson for max flow, but if edge weights are 1. then can be used
	 * to calculate disjoint edge paths from source to destination
	 */
	public int fordFulkersonMaxFlow(int[][] G, int s, int t){
		
		int[][] rG=new int[G.length][G.length];
		
		for(int i=0;i<G.length;i++){
			for(int j=0;j<G.length;j++){
				rG[i][j]=G[i][j];
			}
		}
		
		int[] parent=new int[G.length];
		int maxFlow=0;
		
		for(int i=0;i<parent.length;i++)
			parent[i]=Integer.MIN_VALUE;
		
		System.out.println("Before while");
		
		while(bfsArray(rG, s, t, parent)){
			
			int pathFlow=Integer.MAX_VALUE;
			
			// Find minimum residual capacity of the edges along the
	        // path filled by BFS. Or we can say find the maximum flow
	        // through the path found.
			for(int v=t;v!=s;v=parent[v]){
				int u= parent[v];
				pathFlow=Math.min(pathFlow, rG[u][v]);
			}
			
			for(int v=t;v!=s;v=parent[v]){
				int u=parent[v];
				rG[u][v]-=pathFlow;
				rG[v][u]+=pathFlow;
			}
			maxFlow+=pathFlow;
		}
		
		return maxFlow;
	}
	
	public void dfsArr(int [][]G, int s, boolean[]visited){
		
		visited[s]=true;
		for(int v=0;v<G.length;v++){
			if(!visited[v] && G[s][v] > 0){
				dfsArr(G, v, visited);
			}
		}
	}
	
	public void minCut(int[][] G, int s, int t){
		
		int[][] rG=new int[G.length][G.length];
		
		for(int i=0;i<G.length;i++){
			for(int j=0;j<G.length;j++){
				rG[i][j]=G[i][j];
			}
		}
		
		int[] parent=new int[G.length];
		int maxFlow=0;
		
		for(int i=0;i<parent.length;i++)
			parent[i]=Integer.MIN_VALUE;
		
		System.out.println("Before while");
		
		while(bfsArray(rG, s, t, parent)){
			
			int pathFlow=Integer.MAX_VALUE;
			
			// Find minimum residual capacity of the edges along the
	        // path filled by BFS. Or we can say find the maximum flow
	        // through the path found.
			for(int v=t;v!=s;v=parent[v]){
				int u= parent[v];
				pathFlow=Math.min(pathFlow, rG[u][v]);
			}
			
			for(int v=t;v!=s;v=parent[v]){
				int u=parent[v];
				rG[u][v]-=pathFlow;
				rG[v][u]+=pathFlow;
			}
			maxFlow+=pathFlow;
		}
		
		System.out.println("Min Cut Val:"+ maxFlow);
		
		// Flow is maximum now, find vertices reachable from s
		boolean[] visited=new boolean[G.length];
		dfsArr(	rG	, s, visited);
		
		
		for(int i=0;i< G.length;i++){
			for(int j=0;j<G.length;j++){
				if(visited[i] && !visited[j] && G[i][j] > 0){
					System.out.println(i+" "+j);
				}
			}
		}
	}
	
	private boolean bpm(int[][] G, int u, boolean[] seen , int[] matchR){
		
		for(int v=0;v<G.length;v++){
			if(!seen[v] && G[u][v] > 0){
				seen[v]=true;
				
				if(matchR[v] < 0 || bpm(G, matchR[v], seen, matchR)){
					matchR[v]=u;
					return true;
				}
			}
		}
		return false;
	}
	
	
	public void maxBipartiteMatching(int[][] G){
		
		boolean[] seen=new boolean[G.length];
		int[] matchR=new int[G.length];
		
		for(int i=0;i<matchR.length;i++) matchR[i]=-1;
		
		int result=0;
		
		for(int u=0;u<G.length;u++){
			Arrays.fill(seen,false);
			
			if(bpm(G, u, seen, matchR)) result++;
		}
		
		System.out.println("Result:"+result);
		
	}
	
	
public void channelAssignment(int[][] G){
		
		boolean[] seen=new boolean[G.length];
		int[] matchR=new int[G.length];
		
		for(int i=0;i<matchR.length;i++) matchR[i]=-1;
		
		int result=0;
		
		for(int u=0;u<G.length;u++){
			Arrays.fill(seen,false);
			
			if(bpm(G, u, seen, matchR)) result++;
		}
		
		System.out.println("Result:"+result);
		for (int x=0; x<matchR.length; x++)
	        if (matchR[x]+1!=0)
	            System.out.println( "T" + (matchR[x]+1) + "-> R" + (x+1));
	}
	
//A naive recursive function to count walks from u to v with k edges
	public int countEdges(int[][] G, int u , int v, int k){
		
		if(k==0 && u==v) return 1;
		if(k==1 && G[u][v] == 1) return 1;
		if(k<0) return 0;
		
		int count=0;
		
		for(int i=0;i<G.length;i++){
			
			if(G[u][i] == 1){
				count+=countEdges(G, i, v, k-1);
			}
		}
		return count;
	}

	public static void main(String...s){
		
		Graph<String> g= new Graph<String>(5);
		g.addEdge("Delhi", "Mumbai");
		//g.addEdge("Delhi", "Kolkata");
		g.addEdge("Delhi", "Shimla");
		//g.addEdge("Kolkata", "Mumbai");
		g.addEdge("Kolkata","Shimla");
		//g.addEdge("Mumbai", "Shimla");
		
		int table[][] = {{0, 2, 0}, {3, 0, 1}, {2, 4, 0}};
		int M[][]= {  {1, 1, 0, 0, 0},
		        {0, 1, 0, 0, 1},
		        {1, 0, 0, 1, 1},
		        {0, 0, 0, 0, 0},
		        {1, 0, 1, 0, 1}
		    };
		
		int G[][] = { {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
              };
		 
		int graph[][] = { {0, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0}
              };

		
		int bpGraph[][] = {  {0, 1, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1}
              };

		
		//g.channelAssignment(table);
		//g.maxBipartiteMatching(bpGraph);
		//g.countIslands(M);
		
		//g.minCut(G, 0, 5);
		
		//System.out.println(g.fordFulkersonMaxFlow(graph, 0, 7));
		//g.printGraph();
		//g.DFSDriver("Delhi");
		//g.BFSDriver("Delhi");
		g.cyclicDriver("Delhi");
		//g.topologicalSortDriver("Delhi");
		//System.out.println(g.isCyclicInDirectedGraph());
		//System.out.println(g.isBipartite("Delhi"));
		//g.longestPathInDAG("Delhi");
		//g.shortestPathInDAG("Delhi");
		
		//g.articulationPointDriver();
		
		//System.out.println(g.isBiconnected());
		
		//g.printSCC();
		//g.eulerianStatus();
		//g.bridgeDriver();
		//System.out.println(g.isStronglyConnected());
		//System.out.println(g.isReachable("Delhi", "Sa"));
	}
}
