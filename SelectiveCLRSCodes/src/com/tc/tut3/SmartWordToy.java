package com.tc.tut3;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class SmartWordToy {

	
	public int minPresses(String start, String finish, String[] forbid){
		
		int dist[] = new int[1+Integer.parseInt("zzzz",26)] ;
		int queue[] = new int[1+Integer.parseInt("zzzz",26)];
		
		int queuePut = 0, queueGet = 0 ;
		
		for(String f:forbid){
			
			dist[Integer.parseInt(f,26)]=-10;
		}
		
		queue[queuePut++]=Integer.parseInt(start,26);
		dist[Integer.parseInt(start,26)]=1;
		
		/*
		int target = Integer.parseInt(finish,26) ;
		while (queueGet < queuePut) {
		   int pos = queue[queueGet++] ;
		   if (pos == target)
		      return dist[pos] - 1 ;
		   for (int delta=-1; delta<=1; delta += 2)
		      for (int i=0; i<4; i++) {
		         int npos = ...calc next position...
		    if (dist[npos] == -1) {
		       dist[npos] = dist[pos] + 1 ;
		            queue[queuePut++] = npos ;
		         }
		      }
		}
		*/
		return -1 ;
		
		
		
	}
	
	
	
	
	public int minPresses1(String start, String finish, String[] forbid){
		
		Hashtable<String,String> visited = new Hashtable<String, String>();
		LinkedList<String> Q= new LinkedList<String>();
		
		Q.addLast(start);
		
		int numberOfPresses=0;

		int a=Integer.parseInt("aaaa", 26);
		
		
		System.out.println("Integer Encoding: "+a);
		while(!Q.isEmpty()){
			
			String temp=Q.removeFirst();
			
			System.out.println("Removed from Queue: "+temp);
			if(visited.containsKey(temp)==false){
				System.out.println("Visited table does not contain: "+temp);
				if(temp.equals(finish)){
					System.out.println(temp+" is equal to"+ finish);
					return numberOfPresses++;
				}
				
				else{
					ArrayList<String> children=generateChildren(temp, forbid);
					numberOfPresses++;
					for(String child: children){
						Q.addLast(child);
					}
				}
			
			}
			
			
			visited.put(temp, temp);
		}
		return -1;
	}
	
	private ArrayList<String> generateChildren(String start,String[] forbid){
		
		ArrayList<String> children=new ArrayList<String>();

		for(int i=0;i<start.length();i++){
			
			StringBuilder temp=new StringBuilder(start);
			
			char f=(char)((int)temp.charAt(i)+1);
			char b=(char)((int)temp.charAt(i)-1);
			
			if((int)f==124) f='a';//if((int)f==96)	b='z';
			if((int)b==96)	b='z';//if((int)b==124) f='a';
			
			System.out.println("f: "+f);
			System.out.println("b: "+b);
			
			
			if(checkValidity(i,f,forbid)==true)
			{ 
				System.out.println(temp.charAt(i));
				String forward=(temp.replace(i, i+1, f+"").toString());
				children.add(forward);
				System.out.println("Forward: "+forward);
			
			}
			
			
			if(checkValidity(i,b,forbid)==true){
				String backward=(temp.replace(i, i+1, b+"").toString());
				children.add(backward);
				System.out.println("Backward: "+backward);
			}
			
			temp.delete(0, temp.length());
			//System.out.println("For"+temp.replace(temp.charAt(i), temp.charAt(i), f+"").toString());
			//System.out.println("Back"+temp.replace(temp.charAt(i), temp.charAt(i), b+"").toString());

		}
			
		for(String child:children){
			System.out.print(child+" ");
		}
		return children;
		
	}
	
	private boolean checkValidity(int letterNumber, char letter,String[] forbid){
		
		boolean isValid=true;
		for(String s: forbid){
			
			String[] t=s.split(" ");
			
			for(String token:t)		
			{	
				//System.out.println("Token:" +token);

			}
			
			
				if(t[letterNumber].contains(letter+"")==true){
				isValid=false;
				break;
			
				}
				
		}
		return isValid;
		
	}

public static void main(String...a){
	String start ="aaaa";
	String finish="bbbb";
	//String[] forbid={"a a a z", "a a z a", "a z a a", "z a a a", "a z z z", "z a z z", "z z a z", "z z z a"};
	String[] forbid={};
	SmartWordToy sm=new SmartWordToy();
	
	System.out.println(sm.minPresses(start, finish, forbid));
}
	
}
