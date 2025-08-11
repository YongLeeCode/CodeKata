package lv2;

//어찌보면 이 문제에서 left와 right이 long타입이란 것을 보았을 때 눈치챘어야했을 것이다.
//
//제한사항
// 1 ≤ n ≤ 107
// 0 ≤ left ≤ right < n2
// right - left < 105

import java.util.Arrays;

// answer[(int) (i - left)] =  Math.max((int)i/n, (int)i%n) + 1;
// answer[(int) (i - left)] =  (int)Math.max(i/n, i%n) + 1;
// 이 둘의 차이를 기억해야한다.
// 만약 첫번째로 한다면 long -> int로 변환되면서 일부 수가 잘릴 수 있다. 그러므로 처리를 다 한 후에 int로 변환해줘야한다.
public class n2_배열자르기 {
	private static int[] solution(int n, long left, long right) {
		int[] answer = new int[(int) (right - left + 1)];
		for(long i = left; i <= right; i++) {
			answer[(int)(i - left)] = (int)Math.max(i/n, i%n) + 1;
		}
		return answer;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3, 2, 5)));
	}
}
