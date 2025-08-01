package lv1;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
	public static int[] solution(int[] answers) {
		int[] p1 = {1, 2, 3, 4, 5};
		int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		int[] correctCount = new int[3];

		for (int i = 0; i < answers.length; i++) {
			int a = answers[i];
			if (a == p1[i % 5]) {
				correctCount[0]++;
			}
			if (a == p2[i % 8]) {
				correctCount[1]++;
			}
			if (a == p3[i % 10]) {
				correctCount[2]++;
			}
		}

		int max = Math.max(correctCount[0], Math.max(correctCount[1], correctCount[2]));
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < correctCount.length; i++) {
			if (correctCount[i] == max) {
				list.add(i + 1);
			}
		}
		return list.stream().mapToInt(value -> value).toArray();
	}

	public static void main(String[] args) {
		solution(new int[] {1, 3, 2, 4, 2});
	}
}
