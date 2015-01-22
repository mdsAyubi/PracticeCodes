package com.last.programs;

public class BitAlgo {

	
	/*
	 * Find elements appearing once when others are appearing thrice. 
	 * This is not finding lonely element when others appear even number of times.
	 * Challenging...
	 */
	public int findElementAppearingOnce(int[] A){
		
		int ones=0,twos=0;
		int common_mask=0;
		
		for(int i=0;i<A.length;i++){
			twos=twos|(ones&A[i]);
			ones=ones^A[i];
			common_mask=~(ones&twos);
			ones=ones&common_mask;
			twos=twos&common_mask;
			System.out.println("Ones:"+ones+" Tows:"+twos);
		}
		return ones;
	}
	
	private int countSetBits(int n){
		
		int count = 0;
		while(n>0){
			if((n&1)==1)
				count++;
			n>>=1;
		}
		return count;
	}
	
	private int countSetBitsKRWay(int n){
		
		int count=0;
		while(n>0){
			n=n & (n-1);
			count++;
		}
		return count;
	}
	
	public int swapBits(int x, int i, int j, int n){
		
		int xor = ((x>>i)^(x>>j)) &((1<<n)-1);
		
		return x^((xor<<i)|(xor<<j));
	}
	
	public int setBitsFrom1toN(int n){
		int sum=0;
		for(int i=1;i<=n;i++){
			sum+=countSetBitsKRWay(i);
		}
		return sum;
	}
	
	public int add(int x, int y){
		
		while(y!=0){
			int carry=x&y;
			x=x^y;
			y=carry<<1;
		}
		return x;
	}
	
	
	public int closestSameWeightInteger(int x){
		
		for(int i=0;i<32;i++){
			
			if((x>>i&1)!=((x>>i+1)&1)){
				x=x^(1<<i)|(1<<(i+1));
				return x;
			}
			
		}
		return -1;
		
	}
	
	public int addOneToNumber(int x){
		
		int m=1;
		while((x&m)>0){
			x=x^m; //flip the bit
			m<<=1;
		}
		x^=m; //flip right most zero now
		return x;
	}
	public int smallest(int a, int b, int c){
		
		int smallestNum=0;
		while((a>0 && b>0 && c>0)){
			a--;b--;c--;smallestNum++;
		}
		return smallestNum;
	}
	public int smallestByBit(int x, int y){
		
		return y+((x-y)&((x-y)>>31));
	}
	
	public int multiplyBy3_5(int n){
		
		return (n<<1) + n + (n>>1);
	}
	
	public int turnOffRightmostbit(int n){
		
		return n&(n-1);
	}
	
	public boolean powerOf4(int n){
		
		int count=0;
		if( (n &(n-1))==0){
			
			while(n > 1){
				n>>=1;
				count++;
			}
			if(count%2==0) return true;
			else return false;
			
		}
		return false;
	}
	
	public int abssoluteValue(int n){
		
		return n*(n>>31|1);
	}
	
	public int adsVal(int n){
		int mask=n>>31;
		return (n+mask)^mask;
	}
	
	public int leftCircularRotate(int n, int d){
		
		return (n<<d)|(n>>(32-d));
	}
	public int rightCircularRotate(int n, int d){
		
		return (n>>d) | (n<<(32-d));
	}
	
	/*
	 * The idea is to keep putting set bits of the num in reverse_num until num becomes zero.
	 *  After num becomes zero, shift the remaining bits of reverse_num.
	 */
	
	public int reverserBits(int n){
		
		int reverse=n;
		n>>=1;
		int count =31;
		
		while(n>0){
			
			reverse<<=1;
			reverse|=(n&1);
			n>>=1;
			count--;
		}
		reverse<<=count;
		return reverse;
	}
	
	public void findTwoNonRepeatingInArray(int[] A){
		
		int xor=0;
		int setBit=0;
		int x=0,y=0;
		
		for(int i:A) xor^=i;
		
		setBit=xor & ~(xor-1);
		
		for(int i=0;i<A.length;i++){
			
			if((A[i] & setBit)==1)
				x=x^A[i];
			else
				y=y^A[i];
		}
		System.out.println(x);
		System.out.println(y);
	}
	
	public void binary(int n){
		
		int i=1<<31;
		for(;i>0;i>>=1){
			int temp=n&i;
			if(temp==1)
				System.out.print("1");
			else
				System.out.print("0");
		}
	}
	
	public void binaryNew(int n){
		
		String binary="";
		while(n>0){
			binary=(n%2)+binary;
			n/=2;
		}
		System.out.println(binary);
	}
	
	public int swapEvenOddBits(int n){
		
		int even=n &0xAAAAAAAA;
		int odd= n &0x55555555;
			
		even>>=1;
		odd<<=1;
		return even|odd;
	}
	//wrong question
	public int posOfOnlySetBit(int n){
		
		int i=1;
		int pos=0;
		while((n&i)!=0){
			i<<=1;
			pos++;
		}
		return pos;
	}
	
	public int swapNibbles(int n){
		
		return ((n&0x0F)<<4)|((n&0xF0)>>4);
	}
	
	
	public int nextHigherNumWithSameBits(int x){
		
		int next=0;
		if(x>0){
			
			int rightMostBit=x & (-x);
			System.out.println(rightMostBit);
			
			int nextHighertOneBit=x+rightMostBit;
			System.out.println(nextHighertOneBit);
			
			int rightOnesPattern=x^nextHighertOneBit;
			rightOnesPattern=rightOnesPattern/rightMostBit;
			rightOnesPattern>>=2;
			
			System.out.println(rightOnesPattern);
			
			next=nextHighertOneBit|rightOnesPattern;
			System.out.println(next);
		}
		return next;
		
	}
	
	public static void main(String...a){
		BitAlgo ba=new BitAlgo();
		int[]A={3,3,4,4,5,5,2,3};
		
		
		
		//System.out.println(ba.nextHigherNumWithSameBits(9));
		//System.out.println();
		//System.out.println(ba.swapEvenOddBits(23));
		ba.binaryNew(25);
		//ba.findTwoNonRepeatingInArray(A);
		//System.out.println(ba.abssoluteValue(5));
		//System.out.println(ba.powerOf4(16));
		//System.out.println(ba.turnOffRightmostbit(12));
		//System.out.println(ba.multiplyBy3_5(2));
		//System.out.println(ba.addOneToNumber(4));
		//System.out.println(ba.smallestByBit(1440,34));
		//System.out.println(ba.smallest(2, 3, 4));
		//System.out.println(ba.add(2, 100));
		//System.out.println(ba.swapBits(5, 2, 3,4));
		//System.out.println(ba.setBitsFrom1toN(3));
		//System.out.println(ba.countSetBitsKRWay(15));
		//System.out.println(ba.findElementAppearingOnce(A));
	}
	
}
