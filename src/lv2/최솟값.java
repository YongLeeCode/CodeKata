package lv2;

import java.util.Arrays;
import java.util.Comparator;

public class 최솟값 {
	private static int solution2(int[] A, int[] B) {
		Arrays.sort(A);
		int[] sortedB = Arrays.stream(B)
			.boxed()
			.sorted(Comparator.reverseOrder())
			.mapToInt(Integer::intValue)
			.toArray();
		int answer = 0;
		for(int i = 0; i < A.length; i++) {
			answer += A[i] * sortedB[i];
		}
		return answer;
	}

	private static int solution1(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		int answer = 0;

		for(int i = 0; i < A.length; i++) {
			answer += A[i] * B[B.length-1-i];
		}

		return answer;
	}
	public static void main(String[] args) {
		solution1(new int[] {1,2,3,4,5}, new int[] {6,7,8,9,10});
		solution2(new int[] {1,2,3,4,5}, new int[] {6,7,8,9,10});
	}
}
