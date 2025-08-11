package lv2;

import java.util.Arrays;

/**
 * 이 문제는 어떤 것을 리턴하라는지 이해하기 힘들었다.
 *
 * 조건을 정리하면 이렇다.
 * - 정렬 후, 각 논문을 기준으로 "이 논문 이상의 인용 수를 가진 논문 개수"를 확인
 * - 그 개수(n - i)와 해당 논문의 인용 수(citations[i]) 중 작은 값이 후보 h-index
 * - 그 후보 중 가장 큰 값이 정답
 */
public class h_index {
	public static int solution(int[] citations) {
		//정렬
		Arrays.sort(citations);
		//총 인용되었을 것으로 보이는 논문의 수
		int n = citations.length;
		// h 선언
		int h = 0;

		for(int i = 0; i < n; i++) {
			// 논문에서 인용 수 vs 인용된 논문 수
			int candidate = Math.min(citations[i], n - i);
			//
			h = Math.max(h, candidate);
		}
		return h;
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[]{3,0,6,1,5}));
	}
}
