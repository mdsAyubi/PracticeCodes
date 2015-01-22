package com.epi.solutions;

import java.util.Arrays;

public class ArraysAndStrings {

//Prob 6.1	
public void shift(int [] A){
		
		int pivot=3;
		int equal=0,smaller=0,larger=A.length-1;
		
		while(equal<=larger){
			
			if(A[equal]<pivot)
				swap(A,smaller++,equal++);
			else if (A[equal]==pivot) equal++;
			else
				swap(A,equal,larger--);
		}
		for(int i:A){
			System.out.print(" "+i);
		}
		
	}

//Prob 6.3
public int maxRobotTour(int[] A){
	
	int runninMin=Integer.MAX_VALUE;
	int maxHeight=0;
	
	for(int i=0;i<A.length;i++){
		
		maxHeight = Math.max(maxHeight, A[i]-runninMin);
		runninMin = Math.min(runninMin, A[i]);
		
	}
	
	
	return maxHeight;
			
}

public int[] merge(int[] A, int[] B){
	
	int[] result = new int[A.length+B.length];
	int i=0,j=0,k=0;
	
	while(i<A.length&&j<B.length)
		result[k++] = A[i]<B[j]?A[i++]:B[j++];
	
	if(i==A.length)
		while(j<B.length)result[k++]=B[j++];
	if(j==B.length)
		while(i<A.length)result[k++]=A[i++];
	
	return result;
}

public void merge(int[] A, int[] B, int[] res, int i, int j, int k){
	
	if(k==res.length)return;
	if(i<A.length && j< B.length)
		res[k++] = A[i]<B[j]?A[i++]:B[j++];
	res[k++]=(i==A.length)?B[j++]:A[i++];
	merge(A,B,res,i,j,k);
}

public void printArray(int []A, int i, int j){
	for(int k=i;k<=j;k++){
		System.out.print(" "+A[k]);
	}
}

public int[] multiplyVeryLongNumbers(char[] a, char[] b){
	
	int[] result = new int[a.length*b.length+1];
	int k = 0;//result.length-1;
	int carry = 0;
	int temp=0;
	int i=0,j=0;
	for(i=0;i<a.length;i++){
		for(j=0;j<b.length;j++){
			temp = (a[i]-'0')*(b[j]-'0') + carry;
			result[i+j]+= temp%10;
			if(result[i+j]>10){
				int t=result[i+j];
				result[i+j]=t%10;
				result[i+j-1]+=t/10;
			}
			carry = temp/10;
			
		}
		result[i+j]+=carry;
	}
	
	for(k=0;k<i+j;k++)
		System.out.print(result[k]);
	
	System.out.println();
	return Arrays.copyOf(result, i+j-1);
	//System.out.println(new String(result));
	//return new String(result);
	
}

//0 sum subset

public void zeroSumSubset(int[] A){
	
	int[] prefix = new int [A.length];
	prefix[0] = 0;
	for(int i=1;i<A.length;i++){
		prefix[i] += prefix[i-1];
		prefix[i] %= A.length;
	}
	
	int[] table = new int[A.length];
	for(int i=0;i<table.length;i++)table[i]=-1;
	
	for(int i=1; i< prefix.length; i++){
		
		if(prefix[i]==0){
			printArray(A,0,i);
			return;
		}else if(table[prefix[i]]!=-1){
			printArray(A, i, table[prefix[i]]);
			return;
		}
		table[prefix[i]] = i;
	}
}

public static void ReplaceFun(char[] str) {
	int spaceCount = 0, newLength, i = 0;
	int length=str.length;
	for (i = 0; i < length; i++) {
		if (str[i] == ' ') {
			spaceCount++;
		}
	}
	newLength = length + spaceCount * 2;
	char newStr[]=new char[newLength+1];
	newStr[newLength] = '\0';
	int k=0;
	for (i = 0; i < length; i++) {
		if (str[i] == ' ') {
			
			newStr[k++]='%';
			newStr[k++]='2';
			newStr[k++]='0';
			
		} else 
			newStr[k++]= str[i];
	}
	System.out.println(new String(newStr));
}


public void nextPermutation(String str){
	char[] p = str.toCharArray();
	int k = str.length()-2;
	while(k>=0 && p[k]>=p[k+1])
		k--;
	
	System.out.println("K="+k);
	if(k==-1) System.out.println("No permutation possible");
	
	int l=0;
	for(int i=k+1;i<str.length();i++){
		System.out.println("P[i]="+p[i]+" p[k]="+p[k]+" i="+i+" k="+k);
		if(p[i] > p[k]){ l=i;} // finding the ceiling, ie smallest number which is greater than p[k] 
		else{
			break;
		}
	}
	System.out.println("L="+l);
	swap(p,l,k);
	System.out.println("After swapping "+new String(p));
	reverse(p,k+1,p.length-1);
	System.out.println(new String(p));
	
}

public void rotateByIPos(Integer[] A, int i){
	i%=A.length;
	
	reverse(A, 0, A.length-1);
	reverse(A,0,i);
	reverse(A,i,A.length-1);
}

private <T> void reverse(T[] A, int low, int high){
	for(int k=low,j=high;k<=(low+high)/2;k++,j--){
		T temp=A[k];
		A[k]=A[j];
		A[j]=temp;
	}
}

private  void reverse(int[] A, int low, int high){
	for(int k=low,j=high;k<=(low+high)/2;k++,j--){
		int temp=A[k];
		A[k]=A[j];
		A[j]=temp;
	}
}

private  void reverse(char[] A, int low, int high){
	for(int k=low,j=high;k<=(low+high)/2;k++,j--){
		char temp=A[k];
		A[k]=A[j];
		A[j]=temp;
	}
}

private void swap(char []A, int i, int j){
	char temp=A[i];
	A[i]=A[j];
	A[j]=temp;
}

private void swap(int []A, int i, int j){
	int temp=A[i];
	A[i]=A[j];
	A[j]=temp;
}


	public boolean sodokuChecker(int[][] A){
		
		int N = A.length;
		boolean[] isFound = new boolean[N+1];
		
		for(int i=0;i<N;i++){
			Arrays.fill(isFound, false);
			for(int j=0;j<N;j++){
				if(A[i][j]!=0 && isFound[A[i][j]]==true) return false;
				else
					isFound[j]=true;
			}
		}
		
		for(int i=0;i<N;i++){
			Arrays.fill(isFound, false);
			for(int j=0;j<N;j++){
				if(A[j][i]!=0 && isFound[A[i][j]]==true) return false;
				else
					isFound[j]=true;
			}
		}
		
		int M=3; //region size
		for(int i=0;i<N;i+=3){
			for(int j=0;j<N;j+=3){
				Arrays.fill(isFound, false);
				for(int k=0;k<3;k++){
					for(int l=0;l<3;l++){
						System.out.println("k*i="+(i+k)+"l*j="+(j+l));
						if(A[i+k][j+l]!=0 && isFound[A[i+k][j+l]]==true) System.out.println( false);
						else isFound[A[i+k][j+l]]=true;
					}
				}
				
			}
		}
		return true;
		
	}
	
	
	public void printInSpiralorder(int [][]A){
		
		int N = A.length;
		for(int k=0;k<(int)Math.ceil((0.5*A.length));k++){
			
			if(k==N-k-1)System.out.println(A[k][k]);
			
			for (int j=k;j<N-k-1;j++)System.out.println(A[k][j]); // ----->
			
			for(int i=k;i<N-k-1;i++)System.out.println(A[i][N-k-1]); //Downward
			
			for(int j=N-k-1;j>k;j--)System.out.println(A[N-k-1][j]); // <----
			
			for(int i=N-k-1;i>k;i--) System.out.println(A[i][k]);
			
		}
	}

	
	/*public void rotateMatrix(int[][]A){
		int N = A.length;
		for(int i=0;i<A.length;i++){
			for(int j=N-1;j>=0;j--){
				A[j][j] = A[i][j];
			}
		}
		
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[i].length;j++){
				System.out.print("   "+A[i][j]);
			}
			System.out.println();
		}
	}*/
	
	
	public void flipTheColors(boolean[][] color, int x, int y, Pair[] pairs){
		
		boolean currentCellColor = color[x][y];
		color[x][y] = !color[x][y];
		
		for(Pair p:pairs){
			
			int nextX = x+p.n1;
			int nextY = y+p.n2;
			
			if(nextX>=0 && nextX<color.length && nextY>=0 && nextY<color.length && color[nextX][nextY] == currentCellColor)
				flipTheColors(color, nextX, nextY, pairs);
		}
	}
	
	private boolean isDigit(char c){
			return (c>='0' && c<='9');
	}
	
	public String runLengthEncoding(String str){
		int i=0;
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for(i=1;i<str.length();i++){
			if(str.charAt(i)==str.charAt(i-1))
				count++;
			else{
				sb.append(count).append(str.charAt(i-1));
				count=1;
			}
		}
		sb.append(count).append(str.charAt(i-1));
		return sb.toString();
	}
	
	public void runLengthEncodingRec(String str, int index, StringBuilder sb, int count){
		
		if(index == str.length()){sb.append(count).append(str.charAt(index-1));return;}
		if(str.charAt(index)==str.charAt(index-1)) runLengthEncodingRec(str,++index,sb,++count);
		else{
			sb.append(count).append(str.charAt(index-1));
			runLengthEncodingRec(str, ++index, sb,1);
		}
	}
	
	
	public String reverseWordWise(String str){
		
		char[] s = str.toCharArray();
		reverse(s, 0, s.length-1);
		int start = 0,end=0;
		int i=0;
		
		while( end < s.length){
			for(i=start;i<s.length&&s[i]!=' ';i++);
			end=i-1;
			reverse(s,start,end);
			start=i+1;
		}
		reverse(s,start,end);
		return new String(s);
	}
	
	public int simpleRabinKarpSubstr(String s, String t){
		
		if(s.length() > t.length()) 
			return -1; // greater String cant be a substring of a smaller string
		
		int sHash=s.hashCode();
		int tHash=t.hashCode();
		
		if(sHash==tHash && s.equals(t))return 0;
		
		for(int i=s.length();i<t.length();i++){
			String temp = t.substring(i-s.length(), i);
			if(temp.hashCode()==sHash && s.equals(temp)) return i-s.length();
		}
		return -1;
	}
	
	
	public void phoneNumberAcronym(int[] number,String[] mapping, int counter, StringBuilder sb){
		
		if(counter == number.length) {System.out.println(sb.substring(0, counter));return;}
		else{
			for(char c: mapping[number[counter]].toCharArray()){
				sb.insert(counter,c);
				phoneNumberAcronym(number, mapping, counter+1, sb);
			}
	
		}
		
	}
	
	public static void main(String...a){
		int[] A ={2,3,4,8,3};
		int[] B= {1,5,8,9};
		int[][] S={{5,3,0,0,7,0,0,0,0},
				{6,0,0,1,9,5,0,0,0},
				{1,9,8,0,0,0,0,6,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
	};
		
		boolean[][] c = new boolean[2][2];
		c[0][0]=false;
		c[0][1]=true;
		c[1][0]=false;
		c[1][1]=false;
		
		String[] str ={"0","1","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
		
		
		Pair[] p={new Pair(1, 0),new Pair(0, 1),new Pair(-1, 0),new Pair(0, -1)};
		int[][] Spiral ={{1,2,3,4},
						 {5,6,7,8},
						 {9,10,11,12},
						 {13,14,15,16}};
		
		StringBuilder sb = new StringBuilder();
		ArraysAndStrings as=new ArraysAndStrings();
		
		int[] n = {2,3};
		as.phoneNumberAcronym(n, str, 0, sb);
		
		//System.out.println(as.simpleRabinKarpSubstr("oWorl","HelloWorld" ));
		//System.out.println(as.reverseWordWise("Alice Likes Bob"));
		
		//System.out.println(as.runLengthEncoding("aaabbbcccddd"));
		//as.rotateMatrix(Spiral);
		//as.flipTheColors(c, 0, 0, p);
		//as.runLengthEncodingRec("abbcccddddd", 1, sb, 1);
		//System.out.println(sb.toString());
		/*for(int i=0;i<c.length;i++){
			for(int j=0;j<c[i].length;j++){
				System.out.println(c[i][j]);
			}
		}*/
		//as.printInSpiralorder(Spiral);
		//as.shift(new int[]{1,2,3,4,5,});
		//as.ReplaceFun("Hello World Kathy".toCharArray());
		//System.out.println(as.maxRobotTour(A));
		//int[] res = new int[A.length+B.length];
		//System.out.println(as.sodokuChecker(S));
		//as.nextPermutation("1032");
		//as.zeroSumSubset(A);
		//as.merge(A, B,res,0,0,0);
		//for(int i:res)System.out.println(i);
	}

}

class Pair{
	int n1;
	int n2;
	public Pair(int a, int b){
		n1=a;
		n2=b;
	}
}
	

