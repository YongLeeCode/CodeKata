package lv2;

import java.util.Stack;
/**
 * 스플릿
 * 없을 때, 괄호 짝이 아닐 때 스택에 집어 넣기
 * 짝이 맞을 때 스택에서 제거
 */

/**
 * 효율성 테스트 실패
 * 원인은?
 * String을 split하면서 성능 문제 발생
 * split이 불필요한 배열 생성과 많은 메모리 할당을 유발하기 때문
 */
public class 옳바른_괄호 {
	private static boolean solution1(String s) {
		String[] ps = s.split("");
		Stack<String> stack = new Stack<>();

		for(String p : ps) {
			if (stack.isEmpty() && p.equals(")")){
				return false;
			}

			if(p.equals("(")) {
				stack.push(p);
			} else {
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	private static boolean solution2(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println( solution1("()()"));
		System.out.println( solution2("()()"));
	}
}
