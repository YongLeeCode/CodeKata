package stack;

import java.util.*;

public class 같은_숫자는_싫어 {

	public static int[] solution(int[] arr) {
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		Integer prevNum = null;

		for (int n : arr) {
			queue.add(n);
		}

		while (!queue.isEmpty()) {
			int num = queue.poll();
			if (prevNum == null || prevNum != num) {
				list.add(num);
			}
			prevNum = num;
		}

		return list.stream().mapToInt(value -> value).toArray();
	}

	public static void main(String[] args) {
		int[] arr = {1,1,3,3,2,1,5,3,3};
		System.out.println(Arrays.toString(solution(arr)));
	}
}
