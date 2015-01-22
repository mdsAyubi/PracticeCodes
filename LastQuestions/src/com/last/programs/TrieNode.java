package com.last.programs;

import java.util.HashMap;

public class TrieNode {

	Character value;
	HashMap<Character, TrieNode> children;
	boolean bIsEnd;
	
	public TrieNode(Character v){
		value=v;
		bIsEnd=false;
		children=new HashMap<Character, TrieNode>();
	}
	
	public boolean isEnd(){
		return bIsEnd;
	}
	public HashMap<Character, TrieNode> getChildren(){
		return children;
	}
	public void setIsEnd(){
		bIsEnd=true;
	}
	public Character getValue(){
		return value;
	}
	
}
