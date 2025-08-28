package lv2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 방문_길이 {
	private static int solution(String dirs) {
		Set<String> set = new HashSet<>();
		Map<Character, int[]> map = new HashMap<>();
		map.put('U', new int[]{0, 1});
		map.put('D', new int[]{0, -1});
		map.put('L', new int[]{-1, 0});
		map.put('R', new int[]{1, 0});

		int result = 0;
		int[] curr = {0, 0};

		for(char c : dirs.toCharArray()) {
			int[] next = map.get(c);
			int dx = curr[0] + next[0];
			int dy = curr[1] + next[1];

			if(dx < -5 || dx > 5 || dy < -5 || dy > 5) continue;

			String path1 = "" + curr[0] + curr[1] + "->" + dx + dy;
			String path2 = "" + dx + dy + "->" + curr[0] + curr[1];

			if(!set.contains(path1) && !set.contains(path2)) {
				set.add(path1);
				set.add(path2);
				result++;
			}

			curr[0] = dx;
			curr[1] = dy;
		}

		return result;
	}
	public static void main(String[] args) {

	}
}
