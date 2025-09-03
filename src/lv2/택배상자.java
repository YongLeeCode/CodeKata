package lv2;

import java.util.Stack;

public class 택배상자 {
	private static int solution(int[] order) {
		int i = 0;
		int answer = 0;
		int n = order.length;
		Stack<Integer> stack = new Stack<>();

		for(int box = 1; box <= n; box++) {
			if(box == order[i]) { // 메인 벨트 -> 트럭
				answer++;
				i++;

				while(!stack.isEmpty() && stack.peek() == order[i]) {
					stack.pop();
					i++;
					answer++;
				}
			} else {
				stack.push(box);
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[]{4, 3, 1, 2, 5}));
	}
}
