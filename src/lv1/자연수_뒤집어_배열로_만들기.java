package lv1;

/**
 *
 * 문제 설명
 * - 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
 *
 * 제한 조건
 * - n은 10,000,000,000이하인 자연수입니다.
 */

/**
 * 제한 사항에 N의 범위가 100,000,000 이하의 자연수라고 명시한 이유는?
 *
 * 풀이:
 * 1. long -> String으로 변환
 * 2. String을 split으로 String[]으로 구분
 * 3. For loop을 사용하여 int[]에 저장
 *
 * what I searched:
 *
 */

import java.util.*;

public class 자연수_뒤집어_배열로_만들기 {
	public static int[] solution(long n) {
		int index = 0;
		String[] strNum = String.valueOf(n).split("");
		int[] answer = new int[strNum.length];

		for(int i = strNum.length - 1; i >= 0; i--) {
			answer[index] = Integer.parseInt(strNum[i]);
			index++;
		}
		return answer;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(12345)));
	}
}
