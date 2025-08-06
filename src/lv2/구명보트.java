package lv2;

import java.util.Arrays;

/**
 * 정렬을 한 후, 최댓값을 집어넣고 만약 최솟값이 가능하면 함께 태워서 지운ㄷ.
 * 이렇게 했을 경우 -> 정렬하면서 O(NlogN), 제거하면서 O(N) => 최종 O(NlogN)
 *
 * 실수한 부분 Arrays.sort()의 경우 오름차순이였다. 예시(5, 3, 2, 4, 1) -> 1, 2, 3, 4, 5
 */

public class 구명보트 {
	private static int solution(int[] people, int limit) {
		Arrays.sort(people);

		int x = 0;
		int y = people.length - 1;
		int count = 0;

		while (x <= y) {
			if (limit >= people[x] + people[y]) {
				x++;
			}
			count++;
			y--;

		}

		return count;
	}

	public static void main(String[] args) {
		solution(new int[] {7,4,5,6}, 10);
	}
}
