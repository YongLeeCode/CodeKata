package lv2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class 괄호_회전하기 {
	private static int solution(String s) {
		Map<Character, Character> set = new HashMap<>();
		int count = 0;

		set.put(')', '(');
		set.put(']', '[');
		set.put('}', '{');

		for(int i = 0; i < s.length(); i++) {
			Stack<Character> stack = new Stack<>();
			for(int j = 0; j < s.length(); j++) {
				int x = (j + i) % s.length();
				if(!stack.isEmpty() && stack.peek() == set.get(s.charAt(x))) {
					stack.pop();
				} else {
					stack.add(s.charAt(x));
				}
			}
			if(stack.isEmpty()) count++;
		}

		return count;
	}
	// public static int solution(String s) {
	// 	Map<Character, Character> set = new HashMap<>();
	// 	Queue<Character> p = new LinkedList<>();
	// 	Stack<Character> stack = new Stack<>();
	// 	for(int i = 0; i < s.length(); i++) {
	// 		p.add(s.charAt(i));
	// 	}
	//
	// 	for(int i = 0; i < s.length(); i++) {
	// 		char x = p.poll();
	// 		if(!stack.isEmpty() && stack.peek() == set.get(x)) {
	// 			stack.pop();
	// 		}   else {
	// 			stack.add(x);
	// 		}
	// 	}
	// 	if(stack.isEmpty()) return 1;
	//
	// 	return -1;
	// }

	public static void main(String[] args) {
		System.out.println(solution("[](){}"));
	}
}
