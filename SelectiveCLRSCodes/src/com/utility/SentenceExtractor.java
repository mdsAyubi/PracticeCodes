package com.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;
public class SentenceExtractor
{
	public static String path="D:/outofstem.txt";
	 public static String input;
	public static String readFileToString(String pathToFile) throws Exception{
        StringBuilder strFile = new StringBuilder();
        FileReader fr=new FileReader(pathToFile);
        BufferedReader reader = new BufferedReader(fr);
        char[] buffer = new char[512];
        int num = 0;
        while((num = reader.read(buffer)) != -1){
            String current = String.valueOf(buffer, 0, num);
            strFile.append(current);
            buffer = new char[512];
        }
        reader.close();
        return strFile.toString();
    }
	
public static void main(String args[])throws Exception
{
	//input=readFileToString(path);
	
	String input1="genet disord ill caus abnorm genom, condit present birth (congenit). genet disord rare affect person thousand million. genet disord herit, i.e., pass parent' gene. non-herit genet disord, defect caus new mutat chang dna. case, defect herit it occur germ line. diseas, form cancer, caus inherit genet condit peopl, new mutat peopl, environment caus peopl. whether, extent person genet defect abnorm suffer diseas affect environment factor event person's develop.";
	
	//String input1="This is a test. Mr Jordan likes out test. He has a PH.D.";
	//String[] mySentences=new String[100];
ArrayList<String> rawSentences=new ArrayList<String>();
	//int k=0;
BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
String source = input1;
iterator.setText(source);
int start = iterator.first();
for (int end = iterator.next();
    end != BreakIterator.DONE;
    start = end, end = iterator.next()) {
  //System.out.println(source.substring(start,end)); 
	String currentSentence=source.substring(start,end);
  //mySentences[k++]=source.substring(start,end);
  rawSentences.add(currentSentence);
  	}
//System.out.println(k);

//TextPreprocessor obj=new TextPreprocessor();

ArrayList<String> cleanedSentences=new ArrayList<String>();
	for(String s: rawSentences){
		System.out.println(s);
		//cleanedSentences.add(obj.gePreprocessedText());
		
	}

	for(String s: cleanedSentences){
		System.out.println(s);
	}

}
}