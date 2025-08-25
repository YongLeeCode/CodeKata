package lv2;

public class 멀리뛰기 {
	//dfs로는 2^n이여서 시간초과 문제 생김
	//dp로 해결
	private static long solution(int n) {
		if(n <= 2) return n;
		long prev1 = 1;
		long prev2 = 2;
		long curr = 0;

		for(int i = 3; i <= n; i++) {
			curr = (prev1 + prev2) % 1234567;
			prev1 = prev2;
			prev2 = curr;
		}

		return curr;
	}
	public static void main(String[] args) {
		System.out.println(solution(999));
	}
}
