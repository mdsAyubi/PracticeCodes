package com.tc.tut2;

import java.util.Hashtable;

public class UserName {

	public String newMember(String[] existingNames, String newName){
		
		Hashtable<String,String> nametable=new Hashtable<String,String>();
		String finalName=null;
		for(String name:existingNames)
			nametable.put(name, name);
		
		if(!nametable.contains(newName)){
			return newName;
		}
		
		StringBuilder nameBuilder=new StringBuilder();
		nameBuilder.append(newName);
		for(int i=1;i<=100;i++){
			
			String temp=nameBuilder.append(i).toString();
			
			if(!nametable.contains(temp)){
				finalName=temp;
				break;
			}
				
			nameBuilder.delete(newName.length(), nameBuilder.length());
			
		}
		
		return finalName;
		
	}
	
public static void main(String...a){
	
	//String[] names={"MasterOfDisaster", "DingBat", "Orpheus", "WolfMan", "MrKnowItAll"};
	
	String[] names={"Bart4", "Bart5", "Bart6", "Bart7", "Bart8", "Bart9", "Bart10",
			 "Lisa", "Marge", "Homer", "Bart", "Bart1", "Bart2", "Bart3",
			 "Bart11", "Bart12"};
	//String name="TygerTyger";
	String name="Bart";
	UserName un=new UserName();
	
	System.out.println(un.newMember(names, name));
	
	
}
	
}
