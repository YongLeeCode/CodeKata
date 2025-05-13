import java.util.Arrays;

public class 기사단원의무기 {
	public static void main(String[] args) {
		System.out.println(solution2(10, 3, 2));
	}

	// O(N^2)이라 시간초과 문제 발생
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

	public static int solution2(int number, int limit, int power) {
		int[] divisorCount = new int[number + 1];

		// 배수를 활용해 약수 개수 계산
		for (int i = 1; i <= number; i++) {
			for (int j = i; j <= number; j += i) {
				divisorCount[j]++;
			}
		}

		int total = 0;
		for (int i = 1; i <= number; i++) {
			if (divisorCount[i] > limit) {
				total += power;
			} else {
				total += divisorCount[i];
			}
		}

		return total;
	}
}
