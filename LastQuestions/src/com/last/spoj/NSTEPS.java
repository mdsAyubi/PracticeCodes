package com.last.spoj;
import java.util.Scanner;

//Not accepted code...some formatting issue
public class NSTEPS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfTests = sc.nextInt();
		String line = sc.nextLine();

		for (int i = 0; i < numOfTests; i++) {
			line = sc.nextLine();
			String[] tokens = line.split("\\s+");
			int x = Integer.parseInt(tokens[0]);
			int y = Integer.parseInt(tokens[1]);

			System.out.println(printNumber(x, y));

		}
		sc.close();
	}

	private static String printNumber(int x, int y) {

		return (Math.abs(x - y) == 2 || Math.abs(x - y) == 0) ? ((x % 2 == 0 && y % 2 == 0) ? (x + y)
				+ ""
				: ((x % 2 != 0 && y % 2 != 0) ? ((x + y) - 1) + ""
						: "No Number"))
				: "No Number";

	}
}
