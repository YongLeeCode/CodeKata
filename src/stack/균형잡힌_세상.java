package stack;

import java.util.Scanner;
import java.util.Stack;

// 필요한 자료구조
//범위

// 조건 1. "("가 스텍에 있으면 ")"가 나와야 stack에서 해방
// 조건 2. "["가 스텍에 있으면 "]"가 나와야 stack에서 해방

public class 균형잡힌_세상 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s;

		while (true) {
			s = in.nextLine();
			if (s.equals(".")) {    // 종료 조건문
				break;
			}
			System.out.println(solve(s));
		}

	}

	public static String solve(String s) {
		// s는 문장이니 여백으로 나눈다.
		String[] words = s.split(" ");

		Stack<Character> stack = new Stack<>();
		// 반복문
		for(String word : words) {
			if(word.startsWith("(") || word.startsWith("[")) {
				stack.push(word.charAt(0));
			}
			if(word.endsWith(")") || word.endsWith("]")) {
				if(stack.peek() == '(' && word.endsWith(")")) {
					stack.pop();
				}
				if(stack.peek() == '[' && word.endsWith("]")) {
					stack.pop();
				}
			}
		}

		if(stack.empty()) {
			return "Yes";
		}
		return "No";
	}
}

// Stack<Character> stack = new Stack<>();
//
// 		for (int i = 0; i < s.length(); i++) {
//
// char c = s.charAt(i);    // i 번째 문자
//
// // 여는 괄호일 경우 스택에 push
// 			if (c == '(' || c == '[') {
// 	stack.push(c);
// 			}
//
// 				// 닫는 소괄호 일 경우
// 				else if (c == ')') {
//
// 	// 스택이 비어있거나 pop할 원소가 소괄호랑 매칭이 안되는 경우
// 	if (stack.empty() || stack.peek() != '(') {
// 	return "no";
// 	} else {
// 	stack.pop();
// 				}
// 					} else if (c == ']') {
//
// 	// 스택이 비어있거나 pop할 원소가 대괄호랑 매칭이 안되는 경우
// 	if (stack.empty() || stack.peek() != '[') {
// 	return "no";
// 	} else {
// 	stack.pop();
// 				}
// 					}
//
// 					// 그 외의 경우에는 불필요한 문자들이기에 skip한다.
// 					}
//
// 					if (stack.empty()) {
// 	return "yes";
// 	} else {
// 	return "no";
// 	}
