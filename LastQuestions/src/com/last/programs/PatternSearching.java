package com.last.programs;

import java.util.ArrayList;
import java.util.Arrays;

public class PatternSearching {
	
	public boolean naivePatternSearching(char[] str, char [] pattern){
		
		int i,j;
		for(i=0;i<=str.length-pattern.length;i++){
			
			for(j=0;j<pattern.length;j++){
				
				if(str[i+j]!=pattern[j]){
					break;
				}
			}
			if(j==pattern.length){
				return true;
			}
			
		}
		
		return false;
		
		
	}
	
	public void KMPSearch(String text, String pattern){
		
		char[] str=text.toCharArray();
		char[] pat=pattern.toCharArray();
		
		int s=0,i=0,j=0;
		
		int[] lps=createLPS(pat);
		
		while(i<str.length){
			
			if(str[i]==pat[j]){
				i++;
				j++;
			}
			if(j==pat.length){
				System.out.println("Found at: "+(i-j));
				j=lps[j-1];
			}
			
			else if(str[i]!=pat[j]){
				if(j!=0) j=lps[j-1];
				
				else i++;
			}
			
		}
	}
	
	
	private int[] createLPS(char [] pat){
		
		int [] lps=new int[pat.length];
		int len=0;
		
		lps[0]=0;
		int i=1;
		
		while(i<pat.length){
			if(pat[i]==pat[len]){
				len++;
				lps[i]=len;
				i++;
			}
			else{
				if(len!=0)	len=lps[len-1];
				else{
					lps[i]=0;
					i++;
				}
			}
		}
		return lps;
		
	}
	
	
	public void rabinKarpSearch(String text, String pattern){
		
		int d=256; //Number of characters in ASCII
		int h=1;
		int q=23; // Any prime number
		
		int p=0; //hash of pattern
		int t=0; //hash of text
		
		char[] pat=pattern.toCharArray();
		char[] str=text.toCharArray();
		
		
		for(int i=0;i<pat.length-1;i++){
			h=(h*d)%q;
		}
		System.out.println("Hash h : "+h);
		//Calculate hash of pattern and first patter.length letters of text
		
		for(int i=0;i<pat.length;i++){
			p=(p*d+pat[i])%q;
			t=(t*d+str[i])%q;
		}

		int i=0,j=0;
		for(i=0; i <= str.length-pat.length ; i++){
			
			System.out.println("Found p and t: "+p + "  "+t);	
			
			if(p==t){
				for(j=0;j<pat.length;j++)
					if(pat[j]!=str[i+j]) break;
				
				if(j==pat.length) System.out.println("Found at: "+i);
			}
			
			if(i<str.length-pat.length){
				t= (d*(t-str[i]*h)+str[i+pat.length])%q;
			
				if(t<0) t=t+q;   //make t positive...:)
			}
		}
	}
	
	private int[] badCharacter(char [] pat){
		
		int d=256;// number pf characters in ASCII
		int[] badC=new int[256];
		
		for(int i=0;i<badC.length;i++) badC[i]=-1;
		
		for(int i=0;i<pat.length;i++) badC[pat[i]]=i; //last occurrence of bad character
		
		return badC;
		
	}
	
	
	public void boyerMorrePatternSearchihng(String text, String pattern){
		
		char[] str=text.toCharArray();
		char[] pat=pattern.toCharArray();
		
		int []badC=badCharacter(pat);
		
		int s=0,j=0;
		
		while(s<=str.length-pat.length){
			
			j=pat.length-1;
			
			while(j>=0 && pat[j]==str[s+j]) j--;
					
			if(j<0){
				
				System.out.println("Found at: " +s);
				/* Shift the pattern so that the next character in text
	               aligns with the last occurrence of it in pattern.
	               The condition s+m < n is necessary for the case when
	               pattern occurs at the end of text */
				s += (s+pat.length < str.length)? pat.length-badC[str[s+pat.length]] : 1;
				//break; can use break also...??
			}
			else{
				/* Shift the pattern so that the bad character in text
	               aligns with the last occurrence of it in pattern. The
	               max function is used to make sure that we get a positive
	               shift. We may get a negative shift if the last occurrence
	               of bad character in pattern is on the right side of the
	               current character. */
				s+= Math.max(1, j-badC[str[	s+j]]);
			}
			
		}
		
		
		
	}
	
	private void print(Object[] t){
		for(Object a: t){
			System.out.print(" "+a.toString());
		}
		System.out.println();
	}
	
	public String[] createSuffixArray(String str){
		
		ArrayList<String> temp=new ArrayList<String>();
		for(int i=0;i<str.length();i++){
			temp.add(str.substring(i));
		}
		String[] t=new String[temp.size()];
		Arrays.sort((temp.toArray(t)));
		
		print(t);
		
		return t;
		
	}
	
	public void searchInSuffixArray(String text, String pattern){
		
		String[] suffixArray=createSuffixArray(text);
		
		int l=0, r=suffixArray.length-1;
		
		while(l<=r){
			
			int mid=(l+r)/2;
			
			if(suffixArray[mid].startsWith(pattern)){
				System.out.println("Found at: "+(mid-pattern.length()));
				return;
			}
			
			if(suffixArray[mid].compareTo(pattern)>0) r=mid-1;
			else l=mid+1;
		}
		
		System.out.println("Not Found at:");
	}
	
	
	public static void main(String...a){
		PatternSearching pt=new PatternSearching();
		//System.out.println(pt.naivePatternSearching("hello world is here".toCharArray(), "orlddd".toCharArray()));
	
		String m1="banana";
		String m2="nan";
		
		pt.searchInSuffixArray(m1, m2);
		//pt.KMPSearch(m1, m2);
		
		//pt.rabinKarpSearch(m1, m2);
		//pt.boyerMorrePatternSearchihng(m1, m2);
	}
	

}
