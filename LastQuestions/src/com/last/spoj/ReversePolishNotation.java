package com.last.spoj;

import java.util.Scanner;
import java.util.Stack;

public class ReversePolishNotation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfTests = sc.nextInt();
		String line = sc.nextLine();

		for (int i = 0; i < numOfTests; i++) {
			String expression = sc.nextLine();
			System.out.println(calculateRPN(expression));

		}
		sc.close();
	}

	private static String calculateRPN(String expression) {

		Stack<Character> st = new Stack<Character>();
		StringBuilder output = new StringBuilder();

		for (char ch : expression.toCharArray()) {
			if (isOperand(ch)) {
				output.append(ch);
			} else if (isOperator(ch)) {
				if (priority(ch) < priority(st.peek())) {
					while (priority(st.peek()) < priority(ch)) {
						char poppedChar = st.pop();
						output.append(poppedChar);
					}
				}
				st.push(ch);
			} else if (ch == '(') {
				st.push(ch);
			} else if (ch == ')') {
				while (st.peek() != '(') {
					char poppedChar = st.pop();
					output.append(poppedChar);
				}
				st.pop();
			}
		}
		if (!st.isEmpty()) { // for the remaining items
			char poppedChar = st.pop();
			output.append(poppedChar);
		}

		return output.toString();
	}

	private static int priority(char ch) {
		switch (ch) {
		case '+':
			return 1;
		case '-':
			return 2;
		case '/':
			return 3;
		case '*':
			return 4;
		case '^':
			return 5;
		default:
			return 0; // for (
		}
	}

	private static boolean isOperator(char ch) {
		if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^')
			return true;
		else
			return false;
	}

	private static boolean isOperand(char ch) {
		if (ch >= 'a' && ch <= 'z')
			return true;
		else
			return false;
	}
}
