package com.cf.progs;

public class APSequence {
	
	public void convertToAP(int[] A, int N, int K){
		
		int d=0,a0=0,ch=0,oldChange=0;
		for(int i=1;i<=K+1;i++){
			
			for(int j=Math.max(i, N-K-i+1);j<=N;j++){
				
				if(j<A.length && i<A.length && j!=i&&(A[j]-A[i])%(j-i)==0){
					d=(A[j]-A[i])/(j-i);
					a0=A[i]-d*i;
					
					for(int m=0;m<=N;m++) ch=m==(A[i]+d*m)?ch:++ch;
					if(ch<=K)
						oldChange=ch<oldChange?ch:oldChange;
				}
			}
			
		}
		System.out.println(a0 +" "+d);
		
	}
	
	private int[] getCountOfDigits(int K, int[] digits){
		
		while(K>0){
			int r=K%10;
			digits[r]++;
			K/=10;
		}
		return digits;
	}
	
	public void sumOfDistinctDigits(int N){
		assert N>=1;
		int[] digits=new int[10];
								
		int sum=0;
		for(int l=1;l<N;l++){
			for(int r=l+1;r<=N;r++){
				
				System.out.println("L="+l+" R="+r);
				for(int k=l;k<=r;k++){
					getCountOfDigits(k,digits);
					for(int c=0;c<digits.length;c++){
						if(digits[c]==1)
							System.out.println(c);
						sum+=digits[c]==1?c:0;
					}
				}
			}
		}
		System.out.println(sum%1000000007);
		
	}
	public static void main(String[] args) {
		int [] A = {1,2,1,4};
		APSequence obj = new APSequence();
		//obj.convertToAP(A, 4	, 2);
		obj.sumOfDistinctDigits(7);
	}

}
