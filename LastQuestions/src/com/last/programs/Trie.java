package com.last.programs;

import java.util.HashMap;

public class Trie {

	TrieNode root;
	
	public Trie (){
		root=new TrieNode((char)(0));
	}
	
	public void insert(String word){
		
		int length=word.length();
		TrieNode crawler=root;
		
		
		for(int level=0;level<length;level++){
			
			Character ch = word.charAt(level);
			HashMap<Character, TrieNode> child = crawler.getChildren();
			
			if(child.containsKey(ch)){
				crawler = child.get(ch);
			}
			else{
				TrieNode temp = new TrieNode(ch);
				child.put(ch, temp);
				crawler = child.get(ch);
			}
		}
		crawler.setIsEnd();
		
	}
	
	public String getMatchingPrefix(String word){
		
		int length=word.length();
		TrieNode crawler = root;
		StringBuilder result = new StringBuilder();
		
		int prevMatch=0;
		for(int level=0; level<length;level++){
			
			Character ch = word.charAt(level);
			HashMap<Character, TrieNode> child = crawler.getChildren();
			
			if( child.containsKey(ch) ){
				result.append(ch);
				
				crawler = child.get(ch);
				
				if(crawler.isEnd()) prevMatch= level+1;
			}
			else
				break;
		}
		
		if(!crawler.isEnd())
			return result.substring(prevMatch).toString();
		else
			return result.toString();
	}
	
	
	public static void main(String...d){
		Trie dict = new Trie();        
        dict.insert("are");
        dict.insert("area");
        dict.insert("base");
        dict.insert("cat");
        dict.insert("cater");        
        dict.insert("basement");
         
        String input = "caterer";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));              
 
        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));                      
         
        input = "are";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));              
 
        input = "arex";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));              
 
        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));                      
         
        input = "xyz";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));   
	}
}
