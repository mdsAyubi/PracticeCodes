package com.clrs.chapters.chap25;


public class AllPairShortestPath {

	
	public int[][] floydWarshall(int G[][]){
		
		int[][] D=G;
		int n=G.length;
		
		for (int k=0;k<n;k++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(D[i][j]!=-1)
					D[i][j]=Math.min(D[i][j], D[i][k]+D[k][j]);
				}
			}
		}
		
		return D;
	}
	
	/*Function to put all 0s on left and all 1s on right*/
	public void segregate0and1(int arr[], int size)
	{
	  /* Initialize left and right indexes */
	  int left = 0, right = size-1;     
	 
	  while(left < right)
	  {
	     /* Increment left index while we see 0 at left */
	     while(arr[left] == 0 && left < right)
	        left++;
	 
	     /* Decrement right index while we see 1 at right */
	     while(arr[right] == 1 && left < right)
	        right--;
	 
	    /* If left is smaller than right then there is a 1 at left
	      and a 0 at right.  Exchange arr[left] and arr[right]*/
	     if(left < right)
	     {
	       arr[left] = 0;
	       arr[right] = 1;
	       left++;
	       right--;
	     }
	  }
	}   
	
	
	public static void main(String...a){

		int [][] G={{0,3,8,999,-4},{999,0,999,1,7},{999,4,0,999,999},{2,999,-5,0,999},{999,999,999,6,0}};
		AllPairShortestPath sh=new AllPairShortestPath();
		
		//System.out.println(sh.bellmanFord(G, 0));
		int[][] d=sh.floydWarshall(G);
		
		for(int i=0;i<d.length;i++){
			for(int j=0;j<d[i].length;j++){
				System.out.print(" "+d[i][j]);
			}
			System.out.println();
		}
		
		
	}

	
}
