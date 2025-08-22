package lv2;

public class 다음_큰_수 {
	//bitCount를 사용하면 1이 몇개인지 알 수 있어서 빠르다.
	private static int solution2(int n) {
		int count = Integer.bitCount(n);
		int answer = n + 1;
		while (count < n) {
			int curr = Integer.bitCount(answer);
			if(curr == count) return answer;
			answer++;
		}
		return 0;
	}

	//toBinaryString으로 변환했을 때
	private static int solution1(int n) {
		int answer = n + 1;
		String s = Integer.toBinaryString(n);
		int countOne = 0;
		for (char c : s.toCharArray()) {
			if (c == '1') {
				countOne++;
			}
		}

		while (answer > n) {
			String b = Integer.toBinaryString(answer);
			int countBOne = 0;
			for (char c : b.toCharArray()) {
				if (c == '1') {
					countBOne++;
				}
			}
			if (countBOne == countOne) {
				return answer;
			}
			answer++;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(solution1(10));
		System.out.println(solution2(10));
	}
}
