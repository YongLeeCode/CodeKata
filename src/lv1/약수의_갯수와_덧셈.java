package lv1;

/**
 * 문제 설명
 * - 두 정수 left와 right가 매개변수로 주어집니다.
 *   left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고,
 *   약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 *  - 1 ≤ left ≤ right ≤ 1,000
 *
 * 이번 코테 문제로 배운 것
 *  - 자바 Math Method를 알아두면 좋을 것 같다.
 *    그래서 블로그로 정리해봤다. https://velog.io/@yong-lee/Java-Math-Method
 */
public class 약수의_갯수와_덧셈 {
	private static int solution(int left, int right) {
		int answer = 0;
		for (int i = left; i <= right; i++) {
			if (Math.sqrt(i) == (int)Math.sqrt(i)) {
				answer -= i;
			} else {
				answer += i;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(13, 17));
	}
}
