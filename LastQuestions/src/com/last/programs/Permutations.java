package com.last.programs;

public class Permutations {
    /**
     * Accepts an array of <b>ints</b> and reorders it's elements
     * to receive lexicographically next permutation
     *
     * @param p permutation
     * @return false, if given array is lexicographically last permutation, true otherwise
     */
    public static boolean nextPermutation(int[] p) {
        int a = p.length - 2;
        while (a >= 0 && p[a] >= p[a + 1]) {
            a--;
        }
        System.out.println("a:"+a);
        if (a == -1) {
            return false;
        }
        int b = p.length - 1;
        while (p[b] <= p[a]) {
            b--;
        }
        System.out.println("b:"+b);
        int t = p[a];
        p[a] = p[b];
        p[b] = t;
        for (int i = a + 1, j = p.length - 1; i < j; i++, j--) {
            t = p[i];
            p[i] = p[j];
            p[j] = t;
        }
        return true;
    }
    
    public static void main(String...a){
    	int[] arr={8,5,10,1,2,3,4,9,7,6};
    	for(int i: arr){
    		System.out.print(" "+i);
    	}
    	
    	Permutations.nextPermutation(arr);
    	System.out.println();
    	for(int i: arr){
    		System.out.print(" "+i);
    	}
    }
}