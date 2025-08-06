package lv2;

/**
 * 처음에는 감을 못 잡았지만 역으로 도착지부터 출발지를 확인하니 어떻게 하면 풀 수 있을지 알 수 있었다.
 * 홀수가 나올 시 -1을 해주는 방식, 짝수면 나누기 2를 하여 -1을 몇번 했는지 확인하는 작업이였다.
 *
 */
public class 점프와_순간이동 {

	private static int solution(int n) {
		int count = 0;
		while(n > 0) {
			if(n % 2 == 1) {
				count++;
				n--;
			} else {
				n = n / 2;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(solution(5000));
	}
}
