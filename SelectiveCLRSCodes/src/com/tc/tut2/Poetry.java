package com.tc.tut2;

import java.util.Hashtable;
import java.util.StringTokenizer;

public class Poetry {

	public String rhymeScheme(String[] poem){
		
		
		int k=0,j=0;
		String lastWord=null;
		String pattern=null;
		Hashtable<String,String> patternTable=new Hashtable<String,String>();
		//StringBuilder rhymebuilder=new StringBuilder();
		char[] rhymeScheme=new char[poem.length];
		
		for(int i=0;i<poem.length;i++){
			
			if(checkEmpty(poem[i])){
				if(!patternTable.contains(" ")){
					patternTable.put(" ", " ");
				}
				
				rhymeScheme[i]=' ';
				continue;
			}
			else {
				
				lastWord=getLastWord(poem[i]);
				int vowelIndex=getVowelIndex(lastWord);
				
				pattern=lastWord.substring(vowelIndex).toLowerCase();
				System.out.println("Pattern Is:"+pattern);
				if(!patternTable.containsKey(pattern)){
					char rhyme=(char)(97+(k++));
						if(rhyme>122){
							
							rhyme=(char)(65+(j++));
									
						}
					
					patternTable.put(pattern, rhyme+"");
					rhymeScheme[i]=rhyme;
				}
				else{
					rhymeScheme[i]=patternTable.get(pattern).charAt(0);
				}
			}
		}
	return new String(rhymeScheme);
	}
	
private String getLastWord(String line){
	System.out.println("Line is:"+line);
	StringTokenizer st=new StringTokenizer(line," ");
	String last;
	int numberOfTokens=st.countTokens();
	for(int i=0;;i++){
		last=st.nextToken();
		if(i==numberOfTokens-1)
			break;
	}
	System.out.println("Last Token:"+last);
	return last;
}
	
private int getVowelIndex(String word1){
	String word=word1.toLowerCase();
	int index=-1;
	for(int i=0;i<word.length();i++){
		if(word.charAt(i)=='a'||word.charAt(i)=='e'||word.charAt(i)=='i'||word.charAt(i)=='o'||word.charAt(i)=='u'){
			index=i;
			break;
		}
	}
	System.out.println("Vowel Index:"+index);
	return index;
	
}

private boolean checkEmpty(String line){
	boolean empty=true;
	for(int i=0;i<line.length();i++){
		if(line.charAt(i)!=' '){
			empty=false;
			break;
	
		}
	}
	return empty;
}

public static void main(String...a){
	
	Poetry p=new Poetry();
	//String[] poem={"I hope this problem","is a whole lot better than","this stupid haiku"};
	String[] poem={"This poem has uppercase letters",
			 "In its rhyme scheme",
			 "Alpha", "Blaster", "Cat", "Desert", "Elephant", "Frog", "Gulch", 
			 "Horse", "Ireland", "Jam", "Krispy Kreme", "Loofah", "Moo", "Narf",
			 "Old", "Pink", "Quash", "Rainbow", "Star", "Tour", "Uvula", "Very",
			 "Will", "Xmas", "Young", "Zed", "deception", "comic", "grout",
			 "oval", "cable", "rob", "steal", "steel", "weak"};
	System.out.println(p.rhymeScheme(poem));
	
	
	
}


}
