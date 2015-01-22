package com.last.programs;

public class Matrix {

	
	/* Searches the element x in mat[][]. If the element is found, 
    then prints its position and returns true, otherwise prints 
    "not found" and returns false */
public int search(int mat[][], int n, int x)
{
   int i = 0, j = n-1;  //set indexes for top right element
   while ( i < n && j >= 0 )
   {
      if ( mat[i][j] == x )
      {
         System.out.printf("\n Found at %d, %d", i, j);
         return 1;
      }
      if ( mat[i][j] > x )
        j--;
      else //  if mat[i][j] < x
        i++;
   }
 
   System.out.printf("\n Element not found");
   return 0;  // if ( i==n || j== -1 )
}

public void spiralPrint(int m, int n, int a[][])
{
    int i, k = 0, l = 0;
 
    /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
    */
 
    while (k < m && l < n)
    {
        /* Print the first row from the remaining rows */
        for (i = l; i < n; ++i)
        {
        	System.out.printf("%d ", a[k][i]);
        }
        k++;
 
        /* Print the last column from the remaining columns */
        for (i = k; i < m; ++i)
        {
        	System.out.printf("%d ", a[i][n-1]);
        }
        n--;
 
        /* Print the last row from the remaining rows */
        if ( k < m)
        {
            for (i = n-1; i >= l; --i)
            {
            	System.out.printf("%d ", a[m-1][i]);
            }
            m--;
        }
 
        /* Print the first column from the remaining columns */
        if (l < n)
        {
            for (i = m-1; i >= k; --i)
            {
            	System.out.printf("%d ", a[i][l]);
            }
            l++;    
        }        
    	}
	}


void modifyMatrix(int mat[][])
{
	int R=mat.length;
	int C=mat[0].length;
    int row[]=new int[R];
    int col[]=new int[C];
 
    int i, j;
 
    /* Store the rows and columns to be marked as 1 in row[] and col[]
       arrays respectively */
    for (i = 0; i < R; i++)
    {
        for (j = 0; j < C; j++)
        {
            if (mat[i][j] == 1)
            {
                row[i] = 1;
                col[j] = 1;
            }
        }
    }
 
    /* Modify the input matrix mat[] using the above constructed row[] and
       col[] arrays */
    for (i = 0; i < R; i++)
    {
        for (j = 0; j < C; j++)
        {
            if ( row[i] == 1 || col[j] == 1 )
            {
                mat[i][j] = 1;
            }
        }
    }
}

//The main function that prints given matrix in diagonal order
void diagonalOrder(int matrix[][])
{
	
	int ROW=matrix.length;
	int COL=matrix[0].length;
	
 // There will be ROW+COL-1 lines in the output
 for (int line=1; line<=(ROW + COL -1); line++)
 {
     /* Get column index of the first element in this line of output.
        The index is 0 for first ROW lines and line - ROW for remaining
        lines  */
     int start_col =  Math.max(0, line-ROW);

     /* Get count of elements in this line. The count of elements is
        equal to minimum of line number, COL-start_col and ROW */
      int count = Math.min(Math.min(line, (COL-start_col)), ROW);

     /* Print elements of this line */
     for (int j=0; j<count; j++)
         System.out.printf("%5d ", matrix[Math.min(ROW, line)-j-1][start_col+j]);

     /* Ptint elements of next diagonal on next line */
     System.out.println();
 }
}

//Function to print alternating rectangles of 0 and X
void fill0X(int m, int n)
{
 /*  k - starting row index
     m - ending row index
     l - starting column index
     n - ending column index
     i - iterator    */
 int i, k = 0, l = 0;

 // Store given number of rows and columns for later use
 int r = m, c = n;

 // A 2D array to store the output to be printed
 char a[][]=new char[m][n];
 char x = 'X'; // Iniitialize the character to be stoed in a[][]

 // Fill characters in a[][] in spiral form. Every iteration fills
 // one rectangle of either Xs or Os
 while (k < m && l < n)
 {
     /* Fill the first row from the remaining rows */
     for (i = l; i < n; ++i)
         a[k][i] = x;
     k++;

     /* Fill the last column from the remaining columns */
     for (i = k; i < m; ++i)
         a[i][n-1] = x;
     n--;

     /* Fill the last row from the remaining rows */
     if (k < m)
     {
         for (i = n-1; i >= l; --i)
             a[m-1][i] = x;
         m--;
     }

     /* Print the first column from the remaining columns */
     if (l < n)
     {
         for (i = m-1; i >= k; --i)
             a[i][l] = x;
         l++;
     }

     // Flip character for next iteration
     x = (x == '0')? 'X': '0';
 }

 // Print the filled matrix
 for (i = 0; i < r; i++)
 {
     for (int j = 0; j < c; j++)
    	 System.out.printf("%c ", a[i][j]);
     System.out.println();
 }
}

}