package com.tc.tut2;

public class BettingMoney {

	
	//10 20 30
	//20 30 40
	//1
	
	public int moneyMade(int[] amounts, int[] centsPerDollar, int finalResult){
		
		//Calculate the amount which goes to the company
		int sum=0;
		for(int i=0;i<amounts.length;i++){
			
			if(i!=finalResult){
				sum+=amounts[i];
			}
		}
		
		//Calculate the deductions now
		int deductions=amounts[finalResult]*centsPerDollar[finalResult];
		
		return (sum*100)-deductions;
		
	}
	
public static void main(String...a){
	
	int[] ab={100};//{200,300,100};//{10,20,30};
	int b[]={10};//{10,10,10};//{20,30,40};
	int c=0;
	
	BettingMoney bm=new BettingMoney();
	System.out.println(bm.moneyMade(ab, b, c));
}
	
}
