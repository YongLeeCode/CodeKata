package lv1;

import java.util.Arrays;

/**
 *
 */
public class 예산 {
	private static int solution(int[] d, int budget) {
		int result = 0;
		Arrays.sort(d);
		for(int i = 0; i < d.length; i++) {
			result += d[i];
			if(result > budget) return i;
		}
		return d.length;
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[] {6,2,3,5,4,1,7}, 12));
	}
}
