import java.util.Arrays;

public class 기사단원의무기 {
	public static void main(String[] args) {
		System.out.println(solution(10, 3, 2));
	}

	public static int solution(int number, int limit, int power) {

		int[] arr = new int[number];
		for (int i = 1; i <= number; i++) {
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					arr[i - 1]++;
				}
			}
			if (arr[i - 1] > limit) {
				arr[i - 1] = power;
			}
		}

		return Arrays.stream(arr).sum();
	}
}
