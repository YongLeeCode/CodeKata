package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 프로세스 {
	private static int solution(int[] priorities, int location) {
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0; i < priorities.length; i++) {
			q.offer(new int[]{i, priorities[i]});
		}

		int executionOrder = 0;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int index = curr[0];
			int num = curr[1];

			boolean hasHigherPriority = false;
			for(int[] next : q) {
				if(next[1] > num) {
					hasHigherPriority = true;
					break;
				}
			}
			if(hasHigherPriority) {
				q.offer(curr);
			} else {
				executionOrder++;
				if(location == index) {
					return executionOrder;
				}
			}
		}

		return -1;
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,1,9,1,1,1}, 0));
	}
}
