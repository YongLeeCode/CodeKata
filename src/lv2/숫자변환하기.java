package lv2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 숫자변환하기 {
	//bfs
	private static int solution2(int x, int y, int n) {
		if(x > y) return -1;
		if(x == y) return 0;
		Queue<int[]> queue = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		queue.offer(new int[]{x, 0});

		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int v = curr[0];
			int t = curr[1];

			if(y == v) return t;
			int[] next = new int[]{v + n, v * 2, v * 3};
			for(int i : next) {
				if(i > y) continue;
				if(set.contains(i)) continue;
				set.add(i);
				queue.offer(new int[]{i, t + 1});
			}
		}
		return -1;
	}

	//dfs로는 시간초과 발생
	private static int turn = 99999;
	private static int soluton1(int x, int y, int n){
		int answer = 0;

		dfs(x, y, n, 0);
		return turn;
	}

	private static void dfs(int curr, int y, int n, int t) {
		if(y < curr) return;
		if(y == curr) {
			turn = Math.min(t, turn);
			return;
		}

		dfs(curr + n, y, n, t + 1);
		dfs(curr * 2, y, n, t + 1);
		dfs(curr * 3, y, n, t + 1);
		if(turn > 9999) {
			turn = -1;
		}
	}
	public static void main(String[] args) {

	}
}
