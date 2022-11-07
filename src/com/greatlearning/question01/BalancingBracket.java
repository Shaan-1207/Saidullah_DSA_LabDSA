package com.greatlearning.question01;

import java.util.*;

public class BalancingBracket {
	// method for checking stack;
	boolean isBalanced(String str) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);

			if (x == '(' || x == '[' || x == '{') {
				stack.push(x);
				continue;
			}

			if (stack.isEmpty())
				return false;
			char check;

			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;

			}

		}

		return (stack.isEmpty());
	}
	
	
	void showIsBalanced() {
		// String valid = "([[{}]])";
		// String invalid = "([[{}]]))";
		
		//Take user input
		Scanner sc = new Scanner(System.in);
		System.out.print("Give an input of expressions: ");
		String userInput = sc.nextLine();
		sc.close();
		
		//Check user input,and print
		if (isBalanced(userInput)) {
			System.out.printf("Given expressions is '%s' it is balanced bracket.", userInput);
		} else
			System.out.printf("Given expressions is '%s' it is not balanced bracket.", userInput);

	}
}
