package lv2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 귤_고르기 {
	//Map 사용해서
	private static int solution(int k, int[] tangerine) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int t : tangerine) {
			map.put(t, map.getOrDefault(t, 0) + 1);
		}
		List<Integer> list = new ArrayList<>(map.values());
		list.sort(Comparator.reverseOrder());
		int picked = 0;
		int answer = 0;
		for(int i = 0; i < list.size(); i++) {
			picked += list.get(i);
			answer++;
			if(picked >= k) break;
		}
		return answer;
	}
	public static void main(String[] args) {
		System.out.println(solution(1, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
	}
}
