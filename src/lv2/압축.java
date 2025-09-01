package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 압축 {
	private static int[] solution(String msg) {
		List<Integer> answer = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		int num = 1;
		for(char c = 'A'; c <= 'Z'; c++) {
			map.put("" + c, num++);
		}
		int index = 0;
		while(index < msg.length()) {
			StringBuilder w = new StringBuilder();
			w.append(msg.charAt(index));
			int next = index + 1;

			//가장 긴 문자
			while(next < msg.length() && map.containsKey(w.toString())) {
				w.append(msg.charAt(next));
				next++;
			}

			if(!map.containsKey(w.toString())) {
				String prev = w.substring(0, w.length() - 1);
				answer.add(map.get(prev));
				map.put(w.toString(), num++);
				index += prev.length();
			} else {
				answer.add(map.get(w.toString()));
				index += w.length();
			}
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("KAKAO")));
	}
}
