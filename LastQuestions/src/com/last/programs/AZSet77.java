package com.last.programs;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class AZSet77 {

	public int greaterPalindrome(String num){
		
		int nextP=0;
		
		if(all9s(num)) {nextP=Integer.valueOf(num)+2; return nextP;}

		
		String orig=new String(num);
		int l=num.length();
		for(int i=0,j=l-1;i<l/2;i++,j--){
			System.out.println("Replacing...");
			num=num.replace(num.charAt(j), num.charAt(i));
			
			
		}
		//Check for all 9s after this step
		System.out.println("Num after repalcing"+num);
		System.out.println("Original"+orig);
		
		if(all9s(num)) return Integer.valueOf(num);
		
		char[] num1=num.toCharArray();
		
		if(Integer.valueOf(orig)>Integer.valueOf(num)){
			
			int i=l/2;
			if(num1[i]=='9'){
				
				int j=i;
				while(num1[j]=='9'){num1[j]= '0';j--;}
				
				if(j>=0){
					num1[j]=(char)(num1[j]+1);
					num1[num1.length-1-j]=num1[j];
				}
				
				

			}
			else{
				
				if(l%2==0){
					System.out.println("i:"+i);
					char c=num.charAt(i);
					num1[i] =(char)(c+1);
					
					System.out.println("Num after final1:"+num);
					i--;
					System.out.println("i:"+i);
					c=num.charAt(i);
					num1[i] =(char)(c+1);
					System.out.println("Num after final2:"+num);
				}
				else{
					char c=num.charAt(i);
					num1[i] =(char)(c+1);
					
				}
			}
		}
			
	
		return Integer.valueOf(new String(num1));
		
		
	}
	
	private boolean all9s(String num){
		boolean flag=true;
		for(char c:num.toCharArray()){
			if(c!='9'){
				flag=false;
			}
		}
		return flag;
	}
	
	public void nextPalindrome(String num){
		
		String left=num.substring(0, num.length()/2);
		String right=num.substring(num.length()/2, num.length());
		
		System.out.println(left);
		System.out.println(right);
		
		int l=Integer.valueOf(left);

		int r=Integer.valueOf(right);
		
		//
		for(int i=left.length()-1,j=0;i>0;i--,j++){
			
			if(right.charAt(j)>left.charAt(i)) {l++; break;}
			else if(right.charAt(j)<left.charAt(i)) break;
		}
		
		//reverse the left array
		char[] leftR=new char[left.length()];
		int k=0;
		for(int i=left.length()-1;i>=0;i--){
			leftR[k++]=left.charAt(i);
		}
		System.out.println(left+new String(leftR));
		
	}
	
	public ArrayList<String> generateChildren(String word){
		
		ArrayList<String> children=new ArrayList<String>();
		
		
		for(int i=0;i<word.length();i++){
			char [] w=word.toCharArray();
			//int c=w[i]-65;
			for(int j=0;j<26;j++){
				//if(j!=c) {
				w[i]=(char)(65+j);
				children.add(new String(w));
			
				//}
			}
		}
		
		
		
		
		return children;
	}
	
	
	
	public void navigateStrings(String s1, String s2){
		
		Queue<String> q=new LinkedList<String>();
		Hashtable<String,String> visited=new Hashtable<String,String>();
		s1=s1.toUpperCase();
		s2=s2.toUpperCase();
		
		q.add(s1);
		visited.put(s1,s1);
		
		while(!q.isEmpty()){
			String temp=q.remove();
			System.out.println("Temp:"+temp);
			if(temp.equals(s2)){
				System.out.println("Found Element...");
				return;
			}
			else{
				for(String child: generateChildren(temp)){
					if(visited.contains(child)==false){
						q.add(child);
						
					}
				}
			}
			visited.put(temp, temp);
		}
		
		System.out.println("Not Found Element...");
	}
	
	
	public boolean navigateThroughDFS(String s1, String s2, Hashtable<String, String> visited){
		
		if(s1.equals(s2)) {
			
			return true;
		}
		else{
			System.out.println("s1:"+s1 +"s2: "+s2);
			visited.put(s1, s1);
			
			for(String child: generateChildren(s1)){
				if(visited.contains(child)==false){
					return navigateThroughDFS(child, s2, visited);
					
				}
			}
		}
		return false;
				
	}
	

	public void compressString(String str){
		
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<str.length();){
			
			char temp=str.charAt(i);
			int j=i; int count=0;
			while( j<str.length()&&str.charAt(j)==temp){
				count++;
				j++;
			}
			sb.append(temp);
			sb.append(count);
			i=j;
		}
	System.out.println(sb.toString());	
	}
	
	public static void main(String...a){
		
		AZSet77 obj=new AZSet77();
		
		LinkedList<Integer> l1=new LinkedList<Integer>();

		LinkedList<Integer> l2=new LinkedList<Integer>();
		l1.add(4);
		l1.add(9);
		l1.add(3);
		
		l2.add(2);
		l2.add(1);
		l2.add(4);
		
		
		obj.nextPalindrome("990");
		//System.out.println(obj.greaterPalindrome("999"));

		//System.out.println(obj.greaterPalindrome("9979"));
		//System.out.println(obj.greaterPalindrome("22994"));

		//obj.nextPalindrome("1994");
		//System.out.println(obj.generateChildren("pell".toUpperCase()));
		//obj.navigateStrings("aa", "zz");
		//System.out.println(obj.navigateThroughDFS("AAA", "ZZZ", new Hashtable<String, String>()));
		
		//obj.compressString("aabbccddeeffgg");
	}
	
}
