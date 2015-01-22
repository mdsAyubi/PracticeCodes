package com.utility;

import java.io.File;
import java.util.Hashtable;
import java.util.Scanner;

public class MorseCode {

	Hashtable<String, String> codeTable;
	
	/*public MorseCode()throws Exception{
		
		Scanner sc=new Scanner(new File("C:\\Users\\ayubi\\workspace\\CLRS\\src\\com\\utility\\code.txt"));
		codeTable= new Hashtable<String,String>();
		while(sc.hasNext()){
			
			String line=sc.nextLine();
			System.out.println("Read Line: "+line);
			
			String[] tokens=line.split("   ");
			System.out.println("Letter:"+tokens[0]+"Code: "+tokens[1]);
			
			codeTable.put(tokens[0], tokens[1]);
		}
		
		System.out.println("Code Table:" +codeTable);
		sc.close();
		
	}*/
	
	
	public String getMorseCode(String input){
		
		StringBuilder morseCode=new StringBuilder();
		
		input=input.toUpperCase();
		for(int i=0;i<input.length();i++){
			
			if(input.charAt(i)==' '){
				morseCode.append("   ");
			}
			else{
				morseCode.append(codeTable.get(input.charAt(i)+""));
			}
		}
		
		
		return morseCode.toString();
	}
	
	//public String getEnglishText(String input){
		
	//}
	/*
     *
	* *
   *   *
	    
	    
	
	*/
	
	public void pattern(){
		
		int row=5; int col=5;
		
		for(int i=0;i<row;i++){
			System.out.print(" ");
		}
		
		System.out.println("*");
		for(int i=1; i<row;i++ ){
			
			
			for(int j=0;j<row-i;j++){
				System.out.print(" ");
			}
			System.out.print("*");
			
			for(int j=0;j<2*(i-1)+1;j++){
				System.out.print(" ");
			}
			System.out.print("*");
			
			System.out.println();
			
		}
		
		for(int i=1; i<row;i++ ){
			
			for(int j=0;j<i;j++){
				System.out.print(" ");
			}
			System.out.print("*");
			
			for(int j=0;j<2*(row-i-1)+1;j++){
				System.out.print(" ");
			}
			System.out.print("*");
			
			System.out.println();
		}
	
		
		for(int i=0;i<row;i++){
			System.out.print(" ");
		}
		
		System.out.println("*");
		
	}
	
	
	public static void main(String...a)throws Exception{
		MorseCode mc= new MorseCode();
		
		mc.pattern();
		//System.out.println("The required Morse Code is:");
		//System.out.println(mc.getMorseCode("helo"));
		
	}
	
}
