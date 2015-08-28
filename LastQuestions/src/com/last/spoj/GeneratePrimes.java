package com.last.spoj;

import java.util.Scanner;

public class GeneratePrimes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfTests = sc.nextInt();
		String line = sc.nextLine();

		for (int i = 0; i < numOfTests; i++) {
			line = sc.nextLine();
			String[] tokens = line.split("\\s+");
			int begin = Integer.parseInt(tokens[0]);
			int end = Integer.parseInt(tokens[1]);

			printPrimes(begin, end);
			System.out.println();
		}
		sc.close();

	}

	private static void printPrimes(int begin, int end) {
		for (int i = begin; i <= end; i++) {
			boolean isPrime = true;
			if (i == 1)
				continue;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime == true)
				System.out.println(i);
		}
	}
}
