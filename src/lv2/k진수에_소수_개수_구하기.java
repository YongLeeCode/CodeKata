package lv2;

public class k진수에_소수_개수_구하기 {
	private static int solution(int n, int k) {
		int answer = 0;
		String[] ss = Integer.toString(n, k).split("0");
		for(String s : ss) {
			if(!s.equals("") && isPrime(Long.parseLong(s))) answer++;
		}

		return answer;
	}

	private static boolean isPrime(long n) {
		if(n <= 1) return false;
		if(n == 2) return true;
		if(n % 2 == 0) return false;

		for(int i = 3; i <= Math.sqrt(n); i+=2) {
			if(n % i == 0) return false;
		}

		return true;
	}

	public static void main(String[] args) {
		//정답: 3
		System.out.println(solution(437674, 3));
	}
}
