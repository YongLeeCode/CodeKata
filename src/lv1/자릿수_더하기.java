package lv1;

/** 문제 설명
  - 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
  - 예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
 */

/**
 * 설명: 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
 *      예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
 *
 * 제한사항:
 *      N의 범위 : 100,000,000 이하의 자연수
 *
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12931?language=java
 */

/**
 * 제한 사항에 N의 범위가 100,000,000 이하의 자연수라고 명시한 이유는?
 *
 * 풀이:
 * 1. int -> String으로 변환
 * 2. String을 split으로 String[]으로 구분
 * 3. For loop을 사용하여 모두 더하기
 *
 * what I searched:
 * 1. String.valueOf(int)
 * 2. split한 것을 List로 받고 싶다면 Stream을 사용해야 한다.
 * 		예시: List<String> nums = Arrays.stream(strNum.split("")).toList();
 * 3. Integer.parseInt(String)
 */

import java.util.Arrays;
import java.util.List;

public class 자릿수_더하기 {
	private static int solution(int n) {
			int result = 0;
			// 변환
			String strNum = String.valueOf(n);

			// split
			List<String> nums = Arrays.stream(strNum.split("")).toList();
			// String[] nums = strNum.split("");

			// 계산
			for(String num : nums) {
				result += Integer.parseInt(num);
			}

			return result;
	}

	public static void main(String[] args) {
		System.out.println(solution(123));
	}
}
