package com.last.spoj;

import java.util.Scanner;

public class Feynman {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {
			int num = sc.nextInt();
			if (num == 0)
				break;
			System.out.println((int) printNumber(num));

		}
		sc.close();
	}

	private static double printNumber(int n) {

		return (n * (n + 1) * (2 * n + 1)) / 6;

	}
}

