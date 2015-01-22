package com.epi.solutions;

import java.util.ArrayList;
import java.util.List;

public class PrimitiveType {

	
	public int parity(int n){
		
		int count=0;
		while(n!=0){
			count^=n&1;
			n=n>>1;
		}
		return count;
		
	}
	
	public int parity1(int n){
		int result=0;
		while(n!=0){
			result ^=1; 	//keeps flipping
			n = n&(n-1); //drops lowest set of bits
		}
		return result;
	}
	
	
	
	public int  swapBits(int v, int i, int j){
		int x=v;
		int temp=(((x>>i)&0x1)<<j)|(((x>>j)&0x1)<<i);
		
		System.out.println(" temp="+temp);
		v=v&(~(0x1<<i));
		v=v&(~(0x1<<j));
		
		v=temp|v;
		
		return v;
	}
	
	public void swapBits1(int v, int i, int j){
		
		if((v>>i&0x1)!=(v>>j&0x1)){
			v=v^(0x1<<j|0x1<<i);
		}
		System.out.println(v);
	}
	
	
	public int reverseBits(int v){
		int y=0;
		
		y=y|v&0x1;
		v>>=1;

		while(v>0){
			//System.out.print(" "+(((v<<1)&0x8000)>>31));
			y<<=1;
			y= y | ((v)&0x1);
			
			v>>=1;
			
		}
		
		System.out.println(y);
		return y;
	}

	
	/*
	 * Iterate throught the bits and swap the first bits that differ
	 */
	
	
	public int closestSameWeightInteger(int x){
		
		for(int i=0;i<32;i++){
			
			if((x>>i&1)!=((x>>i+1)&1)){
				x=x^(1<<i)|(1<<(i+1));
				return x;
			}
			
		}
		return -1;
		
	}
	
	
	public void powerSet(ArrayList<String> list){
		
		
		for(int i=0;i<1<<list.size();i++){
			int x=i;
			
			while(x>0){
				int pos=(int)(Math.log((x&~(x-1)))); //get lowest set bit, log gives position
				System.out.print("Pos:"+pos);
				System.out.print(list.get(pos));
				x=x&(x-1);   // removes lowest set bit, runs for 
				if(x!=0)
					System.out.print(",");
			}
			System.out.println();
		}
		
	}
	//Not working
	public void toStringFromInt(int n){
		
		StringBuilder sb= new StringBuilder();
		
		while(n>0){
			int r=n%10;
			sb.append(r);
			n/=10;
		}
		System.out.println(sb.toString());
	}
	
	//Works for positive cases only not - and illegal strings
	public int stringToInt(String str){
		
		char[] arr=str.toCharArray();
		
		int num=0;
		
		for(int i=arr[0]=='-'?1:0;i<arr.length;i++){
			
			num=num*10+(arr[i]-'0');
		}
		
		return arr[0]=='-'?-num:num;
		
		
	}
	
	private boolean isDigit(char c){
		
		return c>=48 && c < 58;
	}
	
	String s="0123456789abcdefghijklmnopqrstuvwxyz";
	
	public void anyBaseConverter(String str, int b1, int b2){
		
		char[] arr=s.toCharArray();
		char num2=0;
		int num=0;
		boolean isNegative = str.charAt(0)=='-';
		
		for(int i=isNegative?1:0;i<str.length();i++){
			char c = str.charAt(i);
			num=num*b1;
			num+=isDigit(c)?c-48:(c-65)+10;
		}
		
		ArrayList<String> l=new ArrayList<String>();
		while(num>0){
			int r=num%b2;
			num2=arr[r];
			l.add(0, num2+"");
			num/=b2;
		}
		if(isNegative)l.add(0,"-");
		for(String s: l)
		System.out.print(s);
		
		
	}
	
	
	public void columnDecode(String a){
		char[] arr=a.toCharArray();
		int code=0;
		for(char c: arr){
			code=code*26+(c-'A'+1);
		}
		
		System.out.println(code);
	}
	
	public String integerToBinary(int n){
		
		StringBuilder sb = new StringBuilder();
		while(n>0){
			sb.insert(0, n&1);
			n>>=1;
		}
		return sb.toString();
		
	}
	
	public String encodeEliasGamma(List<Integer> list){
		
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		
		
		for(Integer i: list){
			String binary = integerToBinary(i);
			temp.append(binary);
			for(int k=0;k<binary.length()-1;k++)
				temp.insert(0,"0");
			sb.append(temp.toString());
			temp.delete(0, temp.capacity());
		}
		return sb.toString();
	}
	
	
	public int gcd(int a,int b){
		
		if(b==0) return a;
		else
			return gcd(b,a%b);
	}
	
	public void divide(int x, int y){
		int q=0, r=0;
		
		while(x-y>0){
			x=x-y;
			q++;
		}
		r=x;
		System.out.println("Q="+q+" R="+r);
		
	}
	
	public int divideRec(int x, int y){
		if(x<y)return 0;
		int pow=0;
		while((y<<pow)<=x)pow++;
		
		int part=1<<pow-1;
		return part|divideRec(x-(y<<(pow-1)), y);
	}
	
	public int addNoOp(int a, int b){
		int k=1; int carryin=0;
		
		int sum=0;
		while(k!=0){
			int ak=a&k;
			int bk=b&k;
			int carryout = (ak&bk)| (ak&carryin)|(bk&carryin);
			sum|=(ak^bk^carryin);
			carryin=carryout<<1;
			k<<=1;
		}
		return sum;
	}
	
	
	public void shift1(int []A){
		
		for(int i=1;i<A.length;i++){
			
			int j=i;int temp=A[i] ;
			while(j>0&&temp<A[j-1]){
				A[j]=A[j-1];
				j--;
			}
			
			A[j]=temp;
			
		}
		
		for(int i:A){
			System.out.print(" "+i);
			
		}
		
	}
	
	
	
	
	
	
	
	
	public static void main(String...a){
		
		
		PrimitiveType pt=new PrimitiveType();
		
		ArrayList<String> l=new ArrayList<String>();
		l.add("hello");
		l.add("world");
		l.add("of");
		l.add("permutations");
		//System.out.println(pt.parity(10));
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(4);
		//System.out.println(pt.encodeEliasGamma(list));
		
		//System.out.println(pt.divideRec(20, 3));
		//System.out.println(pt.addNoOp(12, 18));
		//System.out.println(pt.reverseBits(8));
		//pt.diagMatrix(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
		//System.out.println(pt.closestSameWeightInteger(5));
		//pt.swapBits1(109, 1, 5);
		//pt.powerSet(l);
		
		//pt.toStringFromInt(500);
		//System.out.println(pt.stringToInt("9087878"));
		//pt.anyBaseConverter("-F", 16, 10);
		pt.columnDecode("BAA");
		//pt.divide(27, 4);
		//System.out.println(pt.gcd(40, 100));
		//System.out.println(pt.integerToBinary(25));
		//pt.shift1(new int[]{2,1,-3,-7,-2,4,7,-1});
	}
	
	
}
