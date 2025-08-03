package lv2;

public class 이진변환반복하기 {
	private static int[] solution(String s) {
		int transformCount = 0;
		int deletedZeros = 0;

		while (!s.equals("1")) {
			int originalLength = s.length();
			s = s.replaceAll("0", "");

			transformCount++;
			deletedZeros += originalLength - s.length();
			s = Integer.toBinaryString(s.length());

			System.out.println(s);
		}

		int[] answer = {transformCount, deletedZeros};
		return answer;

	}

	public static void main(String[] args) {
		System.out.println(solution("110010101001"));
	}
}
