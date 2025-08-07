package lv2;

public class 타겟_넘버 {
	private static int solution(int[] numbers, int target) {
		return dfs(0, 0, numbers, target);
	}
	private static int dfs(int depth, int sum, int[] numbers, int target) {
		//종료 시점
		if(depth == numbers.length) {
			return sum == target ? 1 : 0;
		}

		int plus = dfs(depth + 1, sum + numbers[depth], numbers, target);
		int minus = dfs(depth + 1, sum - numbers[depth], numbers, target);
		return plus + minus;
	}
	public static void main(String[] args) {
		solution(new int[] {1,1,1,1,1}, 3);
	}
}
