package lv1;

/**
 *문제 설명
 *  - 자연수 n이 매개변수로 주어집니다. n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요. 답이 항상 존재함은 증명될 수 있습니다.
 *
 * 제한사항
 *  - 3 ≤ n ≤ 1,000,000
 */

/**
 * 나의 풀이 방법(코드 작성 전)
 * 1. for loop 이용해 가장 작은 정수인 1을 시작으로 나머지가 1이 나올 때까지 값을 찾기
 * 2. 하지만 위에서 하는 방법을 하면 O(N)이다. 이 반복작업에서 거의 반을 줄이기 위해선 n의 값의 반까지만 for loop을 돌리고 리턴이 안되었을 경우에만 n-1을 리턴한다.
 */
public class 나머지가_1이_되는_수_찾기 {
	private static int solution(int n) {
		for(int i = 1; i < n / 2; i++) {
			if(n % i == 1) return i;
		}
		return n - 1;
	}
	public static void main(String[] args) {
		System.out.println(solution(19));
	}
}
