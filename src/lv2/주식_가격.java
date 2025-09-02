package lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 주식_가격 {

	private static int[] solution3(int[] prices) {
		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[prices.length];
		for(int i = 0; i < prices.length; i++) {
			while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
				int idx = stack.pop();
				answer[idx] = i - idx;
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			int idx = stack.pop();
			answer[idx] = prices.length - 1 - idx;
		}
		return answer;
	}

	private static int[] solution2(int[] prices) {
		Queue<int[]> q = new LinkedList<>();
		int[] answer = new int[prices.length];

		for(int i = 0; i < prices.length; i++) {
			q.offer(new int[]{i, prices[i], i+1});
		}

		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int index = curr[0];
			int price = curr[1];
			int compIndex = curr[2];
			if(index == prices.length - 1) {
				answer[index] = 0;
				continue;
			}
			if(compIndex >= prices.length - 1) {
				answer[index] = compIndex - index;
				continue;
			}
			if(price > prices[compIndex]) {
				answer[index] = compIndex - index;
			} else {
				q.offer(new int[]{index, price, compIndex + 1});
			}
		}
		answer[prices.length - 1] = 0;
		return answer;
	}

	//O(N^2)
	private static int[] solution1(int[] prices) {
		int[] answer = new int[prices.length];
		for(int i = 0; i < prices.length - 1; i++) {
			for(int j = i + 1; j < prices.length; j++) {
				if(prices[i] > prices[j]) {
					answer[i] = j - i;
					break;
				}
				if(j == prices.length - 1) {
					answer[i] = j - i;
				}
			}
		}
		answer[prices.length - 1] = 0;
		return answer;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution1(new int[]{1, 2, 3, 2, 3})));
		System.out.println(Arrays.toString(solution2(new int[]{1, 2, 3, 2, 3})));
		System.out.println(Arrays.toString(solution3(new int[]{1, 2, 3, 2, 3})));
	}
}
