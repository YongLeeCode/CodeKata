package lv2;

import java.util.Arrays;

public class 주식_가격 {

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
		Arrays.toString(solution1(new int[]{1, 2, 3, 2, 3}));
	}
}
