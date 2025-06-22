package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 하노이의탑 {

	static List<int[]> sequence;

	private static int[][] solution(int n) {
 		sequence = new ArrayList<>();
		hanoi(n, 1, 2, 3);

		int[][] answer = new int[sequence.size()][2];
		for(int i = 0; i < sequence.size(); ++i) {
			int[] cmd = sequence.get(i);
			answer[i][0] = cmd[0];
			answer[i][1] = cmd[1];
		}

		return answer;
	}

	private static void hanoi(int n, int from, int via, int to) {
		if (n == 0) return;

		int[] move = {from, to};
		hanoi(n - 1, from, to, via);
		sequence.add(move);
		hanoi(n - 1, to, via, from);
	}

	public static void main(String[] args) {
		int[][] answer = solution(2);
		System.out.println(Arrays.deepToString(answer));
	}
}
