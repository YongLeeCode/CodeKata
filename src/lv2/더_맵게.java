package lv2;

import java.util.*;

public class 더_맵게 {
	private static int solution(int[] scovile, int K) {
		int count = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int s : scovile) {
			pq.offer(s);
		}

		while(!pq.isEmpty()) {
			if(pq.peek() >= K) return count;
			int first = pq.poll();
			if(pq.isEmpty()) return -1;
			int second = pq.poll();
			int newScoville = first + second * 2;
			pq.offer(newScoville);
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		int[] scovile = new int[]{9,2,10,1,3,12};
		int K = 7;
		System.out.println(solution(scovile, K));
	}
}
