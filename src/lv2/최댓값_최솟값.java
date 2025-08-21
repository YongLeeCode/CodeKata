package lv2;

import java.util.Arrays;

public class 최댓값_최솟값 {
	private static String solution2(String s) {
		int maxNum = Integer.MIN_VALUE;
		int minNum = Integer.MAX_VALUE;

		int[] x = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
		for(int num : x) {
			maxNum = Math.max(maxNum, num);
			minNum = Math.min(minNum, num);
		}
		return minNum + " " + maxNum;
	}

	private static String solution1(String s) {
		int maxNum = -99999;
		int minNum = 99999;

		String[] nums =  s.split(" ");
		for(String num : nums) {
			maxNum = Math.max(maxNum, Integer.parseInt(num));
			minNum = Math.min(minNum, Integer.parseInt(num));
		}

		return minNum + " " + maxNum;
	}
	public static void main(String[] args) {
		System.out.println(solution1("1 2 3 4 5"));
		System.out.println(solution2("1 2 3 4 5"));
	}
}
