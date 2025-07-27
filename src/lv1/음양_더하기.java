package lv1;

/**
 *문제 설명
 *  - 어떤 정수들이 있습니다.
 *  - 이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다.
 *  - 실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 *  - absolutes의 길이는 1 이상 1,000 이하입니다.
 *    - absolutes의 모든 수는 각각 1 이상 1,000 이하입니다.
 *  - signs의 길이는 absolutes의 길이와 같습니다.
 *    - signs[i] 가 참이면 absolutes[i] 의 실제 정수가 양수임을, 그렇지 않으면 음수임을 의미합니다.
 */

/**
 * 나의 풀이 방법(코드 작성 전)
 * 1. int answer을 선언한다.
 * 2. absoluties와 signs의 길이는 같으므로 이 둘의 길이와 같은 for loop을 만든다.
 * 3. for loop 안에서 if 문을 사용하여 sign과 함께 음수인지 양수인지 확인한다.
 * 4. 선언했던 answer에 그 값을 더 한다.
 */

public class 음양_더하기 {
	private static int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;

		for (int i = 0; i < signs.length; i++) {
			if (signs[i]) {
				answer += absolutes[i];
			} else {
				answer -= absolutes[i];
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 3, 4, 5}, new boolean[] {true, false, true, false, true}));
	}
}
