package com.last.programs;

import java.util.Comparator;

public class MyCustomStringComparator<String> implements Comparator<String> {
	
	public int compare(String X, String Y)
    {
		
		StringBuffer XY=new StringBuffer();
		XY.append(X);
		XY.append(Y);
		
		 
	    // then append X at the end of Y
		StringBuffer YX=new StringBuffer();
		YX.append(Y);
		YX.append(X);
		
		
		
	    // Now see which of the two formed numbers is greater
	    return YX.toString().compareToIgnoreCase(XY.toString());
    }

}
