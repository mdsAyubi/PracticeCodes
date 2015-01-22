package com.epi.solution;

import java.util.ArrayList;

public class PrimitiveType {

	
	public int parity(int n){
		
		int count=0;
	
		while(n!=0){
			
			count+=(n)&(0x1);
			
			n=n>>1;
		}
		if(count%2==0) return 0;
		else return 1;
		
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
	
	
	public void reverseBits(int v){
		int y=0;
		
		y=y|v&0x1;
		v>>=1;

		while(v>0){
			//System.out.print(" "+(((v<<1)&0x8000)>>31));
			y<<=1;
			y= y | ((v>>1)&0x1);
			
			v>>=1;
			
		}
		
		System.out.println(y);
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
				int pos=(int)(Math.log((x&~(x-1))));
				
				System.out.print(list.get(pos));
				
				x=x&(x-1);
				if(x!=0){
					System.out.print(",");
				}
					
				
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
		
		int num=0,k=0;
		
		for(int i=0;i<arr.length;i++){
			
			num=num*10+(arr[i]-'0');
		}
		
		return num;
		
		
	}
	
	String s="0123456789abcdefghijklmnopqrstuvwxyz";
	
	public void anyBaseConverter(int num, int b1, int b2){
		
		char[] arr=s.toCharArray();
		char num2=0;
		ArrayList<String> l=new ArrayList<String>();
		while(num>0){
			
			int r=num%b2;
			num2=arr[r];
			//System.out.print(num2);
			l.add(0, num2+"");
			
			num/=b2;
		}
		
		for(String s: l)
		System.out.print(s);
		
		
	}
	
	
	public void columnDecode(String a){
		char[] arr=a.toCharArray();
		int code=0;
		for(int i=arr.length-1;i>=0;i--){
			code=code*26+arr[i]-'a'+1;
		}
		
		System.out.println(code);
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
		//System.out.println(pt.parity(11));
		
		//pt.diagMatrix(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
		//System.out.println(pt.closestSameWeightInteger(5));
		//pt.swapBits1(109, 1, 5);
		//pt.powerSet(l);
		
		//pt.toStringFromInt(500);
		//System.out.println(pt.stringToInt("-908"));
		//pt.anyBaseConverter(25, 10, 26);
		//pt.columnDecode("aa");
		//pt.divide(27, 4);
		//System.out.println(pt.gcd(40, 100));
		
		pt.shift1(new int[]{2,1,-3,-7,-2,4,7,-1});
	}
	
	
}
