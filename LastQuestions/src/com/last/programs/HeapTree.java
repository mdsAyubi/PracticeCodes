package com.last.programs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapTree<E> {

	PriorityQueue<E> heap;
	
	public HeapTree(){
		heap=new PriorityQueue<E>();
	}
	
	public void huffmanCoding(PriorityQueue<Integer> heap){
		StringLengthComparator dr=new StringLengthComparator();
		PriorityQueue<Integer> htree=new PriorityQueue<Integer>(100,dr);
		while( heap.size() > 1 ){
			
			PriorityQueue<Integer> top=new PriorityQueue<Integer>(100,dr);
			Integer left=heap.poll();
			Integer right=heap.poll();
			
			top.add((left+right));
			top.add(left);
			top.add(right);
			
			htree.addAll(top);
			
		}
	
		System.out.println(heap.size());
		System.out.println(htree.toString());
		
	}
	
	
	private TreeNodeHeap buildHuffmanTree(int frequency[], String [] letters){
		java.util.Queue<TreeNodeHeap> firstQ=new java.util.LinkedList<TreeNodeHeap>();
		java.util.Queue<TreeNodeHeap> secondQ=new java.util.LinkedList<TreeNodeHeap>();
		
		for(int i=0;i<frequency.length;i++){
			firstQ.add(new TreeNodeHeap(frequency[i],letters[i]));
		}
		System.out.println(firstQ.toString());
		while(!(firstQ.isEmpty() && secondQ.size()==1)){
			
			TreeNodeHeap left=findMinOfTwoQueues(firstQ, secondQ);
			TreeNodeHeap right=findMinOfTwoQueues(firstQ, secondQ);
			
			TreeNodeHeap temp=new TreeNodeHeap(left.frequency+right.frequency,"$");
			temp.left=left;
			temp.right=right;
			
			secondQ.add(temp);
			
		}
		
		return secondQ.peek();
		
		
	}
	
	private TreeNodeHeap findMinOfTwoQueues(java.util.Queue<TreeNodeHeap> f, java.util.Queue<TreeNodeHeap> s){
		if(f.isEmpty()){
			return s.poll();
		}
		if(s.isEmpty()){
			return f.poll();
		}
		if(f.peek().frequency<s.peek().frequency){
			return f.poll();
		}
		else{
			return s.poll();
		}
	}
	
	void printMST(int parent[], int graph[][])
	{
	   
	   for (int i = 1; i < graph.length; i++)
	      System.out.printf("%d - %d    %d \n", parent[i], i, graph[i][parent[i]]);
	}
	
	private void printArray(int []arr, int k){
		for(int i=0;i<k;i++){
			System.out.print(" "+arr[i]);
		}
		System.out.println();
	}
	
	private void printCode(TreeNodeHeap root, int[] arr, int top){
		
		if(root.left!=null){
			arr[top]=0;
			printCode(root.left, arr, top+1);
			
		}
		if(root.right!=null){
			arr[top]=1;
			printCode(root.right, arr, top+1);
		}
		
		if(!root.data.equals("$")){
			System.out.print(root.data+" ");
			printArray(arr,top);
		}
		
	}
	
	public void efficientHuffman(int [] frequency, String[] letters){
		
		TreeNodeHeap tree=buildHuffmanTree(frequency,letters);
		int [] arr=new int [100];
		
		printCode(tree, arr, 0);
	}
	
	
	public void primsMSTAlgo(int [][] G){
		
		int V=G.length;
		int [] key=new int [V];
		boolean MST[]=new boolean[V];
		int []parent=new int[V];
		
		for(int i=0;i<V;i++){
			MST[i]=false;
			key[i]=Integer.MAX_VALUE;
		}
		key[0]=0;
		parent[0]=-1;
		
		
		for(int count=0;count<V-1;count++){
			
			int u=findMin( key, MST);
			
			MST[u]=true;
			System.out.println("U:"+u);
			for(int v=0;v<V;v++){
				
				if(G[u][v]!=0 && MST[v]==false && G[u][v]<key[v]){
					parent[v]=u;
					key[v]=G[u][v];
				}
			}
			
		}
		printMST(parent,G);
		
	}
	
	public void dijkstraSP(int[][] G, int src){
		
		int V=G.length;
		boolean [] spt=new boolean[V];
		int distance[]=new int [V];
		
		
		for(int i=0;i<V;i++){
			spt[i]=false;
			distance[i]=Integer.MAX_VALUE;
		}
		spt[src]=true; 
		distance[src]=0;
		
		
		for(int count=0; count < V; count++){
			
			int u=findMinEdge(distance,spt);
			spt[u]=true;
			
			for(int v=0;v<V;v++){
				
				if(G[u][v]!=0 && distance[u]!=Integer.MAX_VALUE && spt[v]==false &&distance[u]+G[u][v]<distance[v]){
					distance[v]=distance[u]+G[u][v];
				}
				
			}
		}
		printDijkstra(distance);
		
		
	}
	int lookup[]=new int[100];
	public int fib(int n){
		if(lookup[n]==0){
			if(n<=1){
				lookup[n]=n;
			}
			else{
				lookup[n]=fib(n-1)+fib(n-2);
			}
		}
		return lookup[n];
	}
	
	void printDijkstra(int dist[])
	{
	   System.out.printf("Vertex   Distance from Source\n");
	   for (int i = 0; i < dist.length; i++)
		   System.out.printf("%d \t\t %d\n", i, dist[i]);
	}
	 
	
	private int findMinEdge(int key[], boolean mst[]){
		int min=Integer.MAX_VALUE; int min_index=0;
		for(int i=0;i<key.length;i++){
			if(mst[i]==false&& key[i]<min){
				min=key[i]; min_index=i;
			}
		}
		System.out.println("Min Index:"+min_index);
		return min_index;
		
	}
	
	
	
	
	private int findMin(int key[], boolean mst[]){
		int min=Integer.MAX_VALUE; int min_index=0;
		for(int i=0;i<key.length;i++){
			if(mst[i]==false&& key[i]<min){
				min=key[i]; min_index=i;
			}
		}
		System.out.println("Min Index:"+min_index);
		return min_index;
		
	}
	
	
	
	public static void main(String...a){
		
		PriorityQueue<Integer> heap=new PriorityQueue<Integer>();
		int A[]={5, 9, 12, 13, 16, 45};
		String[] letters={"a","b","c","d","e","f"};
		
		//int G[][]={{2,4,6},{2,1,3},{4,1,5},{6,3,5}};
		
		/*
		int G[][] = {{0, 2, 0, 6, 0},
                 {2, 0, 3, 8, 5},
                 {0, 3, 0, 0, 7},
                 {6, 8, 0, 0, 9},
                 {0, 5, 7, 9, 0},
                };
		*/
		
		int G[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 0, 10, 0, 2, 0, 0},
                {0, 0, 0, 14, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
               };
		
		
		
		for(int i: A){
			heap.add(i);
		}
		HeapTree<Integer> obj=new HeapTree<Integer>();
		//obj.huffmanCoding(heap);
		//obj.efficientHuffman(A, letters);
		//obj.primsMSTAlgo(G);
		//obj.dijkstraSP(G, 0);
		//0 1 1 2 3 5 8 13 21
		System.out.println("Fib :"+obj.fib(6));
	}
	
}

class TreeNodeHeap{
	int frequency;
	String data;
	TreeNodeHeap left;
	TreeNodeHeap right;
	
	public TreeNodeHeap(int frequency, String data) {
		// TODO Auto-generated constructor stub
		this.frequency = frequency;
		this.data = data;
		left=right=null;
	}
	
	public String toString(){
		return "{"+data+":"+frequency+"}";
	}
}

class StringLengthComparator implements Comparator<Integer>
{
    @Override
    public int compare(Integer x, Integer y)
    {
        // Assume neither string is null. Real code should
        // probably be more robust
        // You could also just return x.length() - y.length(),
        // which would be more efficient.
        if (x < y)
        {
            return 1;
        }
        if (x > y)
        {
            return -1;
        }
        return 0;
    }
}