public class 부족한금액계산하기 {
	public static long solution(int price, int money, int count) {
		long answer = 0;
		for(int i = 1; i < count + 1; i++) {
			answer += price * i;
		}

		return answer - money;
	}

	public static void main(String[] args) {
		System.out.println(solution(3, 20, 4));
	}
}
