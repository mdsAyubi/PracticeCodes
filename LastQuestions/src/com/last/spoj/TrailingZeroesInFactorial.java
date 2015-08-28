package com.last.spoj;

import java.util.Scanner;

public class TrailingZeroesInFactorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfTests = sc.nextInt();
		String line = sc.nextLine();

		for (int i = 0; i < numOfTests; i++) {
			line = sc.nextLine();
			String[] tokens = line.split("\\s+");
			int num1 = Integer.parseInt(tokens[0]);

			System.out.println(printTrailingZeroes(num1));

		}
		sc.close();

	}

	private static int printTrailingZeroes(int num) {

		int zeroes = 0;
		while (num >= 1) {
			zeroes += num / 5;
			num = num / 5;
		}
		return zeroes;
	}
}
