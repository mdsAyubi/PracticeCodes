package com.last.programs;

public class Backtracking {
	
	public static final int N=8;
	public static final int M=4;
	
	private boolean solveKnightTour(int x, int y, int [][]solution,int movei, int Xmove[], int Ymove[]){
		
		
		if(movei==N*N) return true;
		
		
		for(int k=0;k<N;k++){
			int nextX=x+Xmove[k];
			int nextY=y+Ymove[k];
			
			if(isSafe(nextX,nextY,solution)){
				
				solution[nextX][nextY]=movei;
				if(solveKnightTour(nextX, nextY, solution, movei+1, Xmove, Ymove)==true)
					return true;
				else solution[nextX][nextY]=-1; //backtracking
			}
		}
		
		return false;
	}
	private boolean isSafe(int i, int j, int[][] sol){
		
		if(i>=0 && i<N && j>=0 && j<N && sol[i][j]==-1) return true;
		
		return false;
	}
	
	private void print(int[][] T){
		for(int i=0;i<T.length;i++){
			for(int j=0;j<T[i].length;j++){
				System.out.print(" "+T[i][j]);
			}
			System.out.println();
		}
	}
	
	public void knightTourSolution(){
		int[][] sol=new int[N][N];
		
		int[] xMove={ 2, 1, -1, -2, -2, -1,  1,  2 };
		int[] yMove={  1, 2,  2,  1, -1, -2, -2, -1 };
		
		 for (int x = 0; x < N; x++)
		        for (int y = 0; y < N; y++)
		            sol[x][y] = -1;
		 
		 sol[0][0]=0;
		 
		 if(solveKnightTour(0, 0, sol, 1, xMove, yMove)==true){
			 System.out.println("Solution found");
			 print(sol);
		 }
		 else {
			 print(sol);
			 System.out.println(" No  Solution found");
		 }
	}
	
	
	
	private boolean isSafeMazePoint(int i, int j, int[][] maze){
		
		if(i>=0 && i<M && j>=0 && j<M && maze[i][j]==1) return true;
		
		return false;
	}
	
	private boolean ratInAMaze(int x, int y, int maze[][], int sol[][]){
		
		if(x==M-1 && y==M-1){
			sol[x][y]=1;
			return true;
		}
		
		if(isSafeMazePoint(x,y,maze)){
			
			sol[x][y]=1; //include in solution
			
			if(ratInAMaze(x+1, y, maze, sol)) return true;
			
			if(ratInAMaze(x, y+1,	 maze, sol)) return true;
			
			sol[x][y]=0; //if none of the above return true
			return  false;
			
		}
		return false;
		
	}
	
	public void solveRatInAMazeProb(){
		int maze[][]  =  { {1, 0, 0, 0},
		        {1, 1, 0, 1},
		        {0, 1, 0, 0},
		        {1, 1, 1, 1}
		    };
		
		int sol[][]=new int [M][M];
		
		if(ratInAMaze(0, 0, maze, sol)){
			 System.out.println("Solution found");
			 print(sol);
		 }
		 else {
			 print(sol);
			 System.out.println(" No  Solution found");
		 }
	}
	
	private boolean isSafeCol(int col, int board[][], int row){
		
		//try row , try left diagonal upper , try left diagonal lower
		
		for(int i=0;i<col;i++){
			if(board[row][i]==1) return false;
		}
		
		/* Check upper diagonal on left side */
	    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
	    {
	        if (board[i][j]==1)
	            return false;
	    }
	 
	    /* Check lower diagonal on left side */
	    for (int i = row, j = col; j >= 0 && i < M; i++, j--)
	    {
	        if (board[i][j]==1)
	            return false;
	    }
	 
	    return true;
		
	}
	
	private boolean nQueenProblem(int board[][], int col){
		
		if(col>=M) return true; //all queens have been placed
		
		for(int i=0;i<M;i++){
			
			if(isSafeCol(col,board, i)){
				board[i][col]=1;
				
				if(nQueenProblem(board, col+1)) return true;
				else 
					board[i][col]=0;
			}
		}
		return false;
	}
	
	private boolean isSafeColor(int vertex, int color[], int graph[][], int c){
		
		for(int i=0;i<graph[vertex].length;i++){
			if(graph[vertex][i]==1 && c==color[i]) return false;
		}
		return true;
	}
	
	//private static final int V=4;
	private boolean graphColoring(int graph[][], int[] color, int v, int m){
		
		if(v==graph.length) return true;
		
		for(int i=1;i<=m;i++){ //try all colors on a vertex
			
			if(isSafeColor(v, color,graph,i)){ //check if this color is safe
				color[v]=i;
				
				if(graphColoring(graph, color, v+1,m)) return true;
				else
					color[v]=0;
			}
			
		}
		return false;
	}
	
	public void solveGraphColoring(){
		int graph[][] = {{0, 1, 1, 1},
		        {1, 0, 1, 0},
		        {1, 1, 0, 1},
		        {1, 0, 1, 0},
		    };
		
		int color[]={0,0,0,0};
		int m=3;// number of colors
		if(graphColoring(graph, color, 0,m)) {
			System.out.println("Solution found...");
			printArr(color);
		}
		else{
			System.out.println("No Solution found...");
			printArr(color);
		}
	}
	
	private void printArr(int[]A){
		for(int i=0;i<A.length;i++)
			System.out.println(" "+A[i]);
		System.out.println();
	}
	
	
	public void solveNQueenProblem(){
		int board[][] = { {0, 0, 0, 0},
		        {0, 0, 0, 0},
		        {0, 0, 0, 0},
		        {0, 0, 0, 0}
		    };
		
		if(nQueenProblem(board, 0)){
			System.out.println("Soliution found...");
			print(board);
		}
		else{
			System.out.println("No Soliution found...");
			print(board);
		}
	}
	
	private boolean isSafeHamPath(int[][] graph, int[] path, int vertex, int nextVertex){
		
		if(graph[path[vertex-1]][nextVertex]==0) return false;
		
		for(int i=0;i<vertex;i++){
			if(path[i]==nextVertex) return false;
		}
		return true;
	}
	
	private boolean hamiltonianCycle(int graph[][], int path[],int vertex){
		
		
		if(vertex==graph.length){
			if(graph[path[vertex-1]][path[0]]==1) return true;
			else return false;
		}
		
		for(int v=1;v<graph.length;v++){
			
			if(isSafeHamPath(graph,path, v,vertex)){
				path[vertex]=v;
				
				if(hamiltonianCycle(graph, path, vertex+1)) return true;
				else
					path[vertex]=-1;
			}
		}
		return false;
		
	}
	
	public void solveHamiltonianCycle(){
		
		int graph1[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
               };
		
		int[] path=new int[graph1.length];
		for (int i = 0; i < path.length; i++)
	        path[i] = -1;
		
		path[0]=0;
		if(hamiltonianCycle(graph1, path, 1)){
			System.out.println("Soliution found...");
			printArr(path);
		}
		else{
			System.out.println("No Soliution found...");
			printArr(path);
		}
		
		
		int graph2[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
               };

		for (int i = 0; i < path.length; i++)
	        path[i] = -1;
		
		path[0]=0;
		if(hamiltonianCycle(graph2, path, 1)){
			System.out.println("Soliution found...");
			printArr(path);
		}
		else{
			System.out.println("No Soliution found...");
			printArr(path);
		}
	}
	
	
	
	private boolean solveSoDoKu(int[][] grid){
		
		Ordinate t=new Ordinate();
		if(!findUnassignedBlock(grid, t))
			return true;
		
		
		for(int i=1;i<=9;i++){
			
			if(isSafe(grid,t,i)){
				grid[t.row][t.col]=i;
				
				if(solveSoDoKu(grid)) return true;
				
				else
					grid[t.row][t.col]=0; // 0 means unassigned
			}
		}
		return false;
	}
	
	private boolean findUnassignedBlock(int[][] grid, Ordinate t){
	
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(grid[i][j]==0){
					t.row=i;t.col=j;
					return true;
				}
			}
		}
		return false;
	}
	
	
	private boolean isSafe(int[][] grid, Ordinate t, int num){
		
		if(usedInRow(grid, t,num) && usedInCol(grid,t,num) && usedInBox(grid,new Ordinate(t.row-t.row%3,t.col-t.col%3),num)){
			return true;
		}
		else return false;
		
	}
	
	private boolean usedInRow(int[][] grid, Ordinate t, int num){
		
		for(int i=0;i<grid[t.row].length;i++){
			if(grid[t.row][i]==num) return false;
		}
		return true;
	}
	private boolean usedInCol(int[][] grid, Ordinate t, int num){
		
		for(int i=0;i<grid.length;i++){
			if(grid[i][t.col]==num) return false;
		}
		return true;
	}
	private boolean usedInBox(int[][] grid, Ordinate t, int num){
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(grid[t.row+i][t.col+j]==num) return false;
			}
		}
		return true;
	}
	
	class Ordinate{
		int row;
		int col;
		
		public Ordinate(int r, int c){
			row=r;
			col=c;
		}
		public Ordinate(){
			row=0;
			col=0;
		}
	}
	
	public void solveSoDoKuGrid(){
		int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		
		if(solveSoDoKu(grid)){
			System.out.println("Solution Found...");
			print(grid);
		}
		else{
			System.out.println("No Solution Found...");
			print(grid);
		}
	}
	
	public void permute(char[] str, int i, int n){
		
		if(i==n) System.out.println(str);
		else{
			for(int j=i;j<=n;j++){
				swap(str, i, j);
				permute(str, i+1, n);
				swap(str, i, j);
			}
		}
	}
	
	private void swap(char[] str, int i, int j){
		char temp=str[i];
		str[i]=str[j];
		str[j]=temp;
	}
	public static void main(String...a){
		Backtracking bt= new Backtracking();
		
		bt.permute("ABCD".toCharArray(), 0, 3);
		
		//bt.solveSoDoKuGrid();
		//bt.solveHamiltonianCycle();
		//bt.knightTourSolution();
		//bt.solveGraphColoring();
		//bt.solveNQueenProblem();
		//bt.solveRatInAMazeProb();
	}

	
}
