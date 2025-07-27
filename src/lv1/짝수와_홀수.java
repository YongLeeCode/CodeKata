package lv1;

/**
 *
 * 문제 설명
 * - 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
 *
 * 제한 조건
 *   - num은 int 범위의 정수입니다.
 *   - 0은 짝수입니다.
 */

/**
 * 풀이:
 * - 2로 나누었을 때, 나머지가 있을 경우 "Odd" 출력
 * - 2로 나누었을 때, 나머지가 없을 경우 "Even" 출력
 */
public class 짝수와_홀수 {
	public static String solution(int num) {
		if(num % 2 == 0) return "Even";
		return "Odd";
	}
	public static void main(String[] args) {
		System.out.println(solution(1));
	}
}
