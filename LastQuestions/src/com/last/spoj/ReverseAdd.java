package com.last.spoj;

import java.util.Scanner;

public class ReverseAdd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfTests = sc.nextInt();
		String line = sc.nextLine();

		for (int i = 0; i < numOfTests; i++) {
			line = sc.nextLine();
			String[] tokens = line.split("\\s+");
			int num1 = Integer.parseInt(tokens[0]);
			int num2 = Integer.parseInt(tokens[1]);

			System.out.println(reverse(reverse(num1) + reverse(num2)));

		}
		sc.close();

	}

	private static int reverse(int num) {

		StringBuilder sb = new StringBuilder(num + "");

		int k = sb.length();
		while (sb.charAt(k - 1) == '0')
			k--;

		StringBuilder newSb = new StringBuilder(sb.substring(0, k));
		return Integer.parseInt(newSb.reverse().toString());

	}
}
