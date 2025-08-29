package lv2;

public class n진수_게임 {
	private static String solution(int n, int t, int m, int p) {
		StringBuilder allNumbers = new StringBuilder();
		StringBuilder answer = new StringBuilder();
		int num = 0;
		while(allNumbers.length() < t * m) {
			allNumbers.append(Integer.toString(num, n).toUpperCase());
			num++;
		}
		for(int i = p - 1; answer.length() < t; i += m) {
			answer.append(allNumbers.charAt(i));
		}

		return answer.toString();
	}
	public static void main(String[] args) {
		//정답: "0111"
		System.out.println(solution(2, 4, 2, 1));
	}
}
