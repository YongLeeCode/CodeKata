import java.util.Arrays;

public class 로또의최고순위와최저순위 {
	public static int[] solution(int[] lottos, int[] win_nums) {
		Arrays.sort(lottos);
		Arrays.sort(win_nums);
		int count = 0;
		int unidentity = 0;

		for(int i = 0; i < lottos.length; i++) {
			if(lottos[i] == 0) {
				unidentity++;
			} else {
				for(int j = 0; j < win_nums.length; j++) {
					if(win_nums[j] == lottos[i]) {
						count++;
						break;
					}
				}
			}
		}

		return new int[]{prize(count + unidentity), prize(count)};
	}

	private static int prize(int matchedCount) {
		return Math.min(6, 7 - matchedCount);
	}
	public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] winNums = {31, 10, 45, 1, 6, 19};
		System.out.println(Arrays.toString(solution(lottos, winNums)));
	}
}
