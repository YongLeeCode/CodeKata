package lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 짝지어_제거하기 {
	// public static int solution(String s) {
	// 	List<Character> arr = new ArrayList<>();
	// 	for(int i = 0; i < s.length(); i++) {
	// 		arr.add(s.charAt(i));
	// 	}
	//
	// 	while(arr.size() > 0) {
	// 		for(int i = 0; i < arr.size() - 1; i++) {
	// 			if(arr.get(i) == arr.get(i + 1)) {
	// 				arr.remove(i + 1);
	// 				arr.remove(i);
	// 				break;
	// 			};
	// 		}
	// 		return 0;
	// 	}
	// 	return 1;
	// }

	private static int solutionWithStack(String s) {
		Stack<Character> stack = new Stack<>();

		for(int i  = 0; i < s.length(); i++) {
			if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
				stack.pop();
			} else {
				stack.push(s.charAt(i));
			}
		}

		if(stack.isEmpty()) return 1;
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(solutionWithStack("aabbcc"));
	}
}
