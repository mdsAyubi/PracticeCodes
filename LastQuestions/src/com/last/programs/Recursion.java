package com.last.programs;

public class Recursion {

	public void printArray(int[] A, int low, int high){
		
		if(low==high) return;
		else{
			System.out.println(A[low]);
			printArray(A, low+1, high);
		}
	}
	
	public void printArrayReverse(int[] A, int low, int high){
		
		if(low==high) return;
		else{
			System.out.println(A[low]);
			printArrayReverse(A, low+1, high);
		}
	}
	
	public int factorial(int n) {
		if(n==1) return 1;
		else return n*factorial(n-1);
	}
	
	public int fibonnaci(int n){
		if (n<=1) return n;
		else return fibonnaci(n-1)+fibonnaci(n-2);
	}
	
	/*
	 We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. 
	 Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
	 */
	public int bunnyEars2(int bunnies) {
		  if( bunnies ==0 ) return 0;
		  else{
			  return (bunnies%2==0?3:2)+bunnyEars2(bunnies-1);
		  }
		}
	
	/*
	 * Count 7 in a number
	 */
	
	public int count7(int n) {
	
		if(n!=0){
			return (n%10==7?1:0)+count7(n/10);
		}
		return 0;
	}
	/*
	Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string. 
	*/
	
	public int countX(String str,int index) {
	
		if(index==str.length()) return 0;
		else{
			return (str.charAt(index)=='x'?1:0)+countX(str,index+1);
		}
		
	}
	
	public int countX(String str) {
		if(str.length()==0) return 0;
		else
		return (str.charAt(str.length()-1)=='x'?1:0)+countX(str.substring(0,str.length()-1));
	}
	
	/*
	 * Given a string, compute recursively (no loops) a new string where all appearances of "pi" 
	 * have been replaced by "3.14". 

	 */
	
	
	public String changePi(String str) {
		
		if(str.contains("pi"))
			return changePi(str.replace("pi", "3.14"));
		else return str;
	}

	/*
	 * Number of times 11 comes in an array
	 */
	
	public int array11(int[] nums, int index) {
	
		if(index == nums.length) return 0;
		else return (nums[index]==11?1:0) + array11(nums, index+1);
	
	}
	
	/*
	 * Given a string, compute recursively a new string where identical chars 
	 * that are adjacent in the original string are separated from each other by a "*". 

pairStar("hello") → "hel*lo"
pairStar("xxyy") → "x*xy*y"
pairStar("aaaa") → "a*a*a*a"
	 */
	
	public String pairStar(String str) {
	
		int len=str.length();
		if(len==0) return str;
		else if(len > 1){
			if(str.charAt(len-1) == str.charAt(len-2))
				return pairStar(str.substring(0,len-1))+"*"+str.substring(len-1) ;
		}
		return pairStar(str.substring(0,len-1))+str.substring(len-1);
	}
	
	/*
	 * Count recursively the total number of "abc" and "aba" substrings that appear in the given string.
	 * countAbc("abc") -> 1
		countAbc("abcxxabc") -> 2
		countAbc("abaxxaba")-> 2
	 */
	
	public int countAbc(String str) {
		if(str.length()<=2) return 0;
		else if(str.contains("abc")|| str.contains("aba")){
			System.out.println(str.length()+ "string is:"+str);
			int count=0;
			
			if(str.contains("abc")) {str=str.replaceFirst("abc", "");count=1;}
			if(str.contains("aba")) {str=str.replaceFirst("aba", "");count=1;}
			return count + countAbc(str);		
		}
		else{
			return countAbc(str.substring(0,str.length()-1));
		}
	}
	
	/*
	 * 
	Given a string, compute recursively the number of times lowercase "hi" appears in the string, 
	however do not count "hi" that have an 'x' immedately before them. 

	countHi2("ahixhi") -1
	countHi2("ahibhi") - 2
	countHi2("xhixhi") - 0
	 */
	
	public int countHi2(String str) {
		
		if(str.length()==0) return 0;
		else if ((str.contains("hi")&&str.indexOf("hi")==0)||str.contains("hi")&&str.charAt(str.indexOf("hi")-1)!='x'){
			return 1 + countHi2(str.substring(str.indexOf("hi")+2));
		}
		else return countHi2(str.substring(str.indexOf("hi")+2));
	}
	
	
	//Given a string, compute recursively a new string where all the 'x' chars have been removed. 
	
	public String noX(String str) {
	
		if(str.length()==0) return str;
		if(str.contains("x"))
				return noX(str.replaceFirst("x", ""));
		return str;
	}

	
	public boolean groupSum5(int start, int[] nums, int target) {
		  if(target == 0) return true;
		  else if(start == nums.length && target != 0) return false;
		  
		  if((start%5==0 && nums[start+1]!=1)){
			  System.out.println("Added "+nums[start]);
			  return groupSum5(start+1, nums, target-nums[start]);
		  }
		  
		  else if(groupSum5(start+1, nums, target)) return true;
		  else if(groupSum5(start+1, nums, target-nums[start])) return true;
		  
		  else return false;
			  
		  
		}

	public boolean groupSum(int start, int[] nums, int target) {
		  if(target == 0) return true;
		  if(start == nums.length && target != 0) return false;
		  
		  
		  if(groupSum(start+1, nums, target)||groupSum(start+1, nums, target-nums[start]))
			  return true;
		  return false;
		  
		}

	
	
	
	public static void main(String[] args) {
		Recursion r = new Recursion();
		//r.printArray(new int[]{1, 2, 3,4},0,4);
		//System.out.println(r.factorial(5));
		//System.out.println(r.fibonnaci(5));
		//System.out.println(r.bunnyEars2(2));
		//System.out.println(r.countX(""));
	
		//System.out.println(r.pairStar("abba"));
		//System.out.println(r.countAbc("abaabc"));
		//System.out.println(r.countHi2("hihxhi"));
		//System.out.println(r.noX("xaxb"));
		
		System.out.println(r.groupSum5(0, new int[]{2, 5, 10, 4}, 19)); 
	}
}
