package lv2;

public class 피보나치_수 {
	private static int solution(int n) {
		if(n < 2) return n;

		long a = 0;
		long b = 1;

		for(int i = 2; i <= n; i++) {
			long temp = b;
			b = (a + b) % 1234567;
			a = temp;
		}
		return (int) b;
	}
	public static void main(String[] args) {
		System.out.println(solution(99));
	}
}
