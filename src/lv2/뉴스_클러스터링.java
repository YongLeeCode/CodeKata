package lv2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 뉴스_클러스터링 {
	private static int solution(String str1, String str2) {
		Map<String, Integer> map1 = new HashMap<>();
		for(int i = 0; i < str1.length() -1; i++) {
			char c1 = Character.toUpperCase(str1.charAt(i));
			char c2 = Character.toUpperCase(str1.charAt(i+1));
			if(c1 < 'A' || c1 > 'Z' || c2 < 'A' || c2 > 'Z') continue;
			String s = c1 + "" + c2;
			map1.put(s, map1.getOrDefault(s, 0) + 1);
		}

		Map<String, Integer> map2 = new HashMap<>();
		for(int i = 0; i < str2.length() -1; i++) {
			char c1 = Character.toUpperCase(str2.charAt(i));
			char c2 = Character.toUpperCase(str2.charAt(i+1));
			if(c1 < 'A' || c1 > 'Z' || c2 < 'A' || c2 > 'Z') continue;
			String s = c1 + "" + c2;
			map2.put(s, map2.getOrDefault(s, 0) + 1);
		}

		Set<String> all = new HashSet<>();
		all.addAll(map1.keySet());
		all.addAll(map2.keySet());

		int interaction = 0;
		int union = 0;
		for(String key : all) {
			int count1 = map1.getOrDefault(key, 0);
			int count2 = map2.getOrDefault(key, 0);
			interaction += Math.min(count1, count2);
			union += Math.max(count1, count2);
		}
		double jaccard = union == 0 ? 1.0 : (double) interaction / union;
		return (int) (jaccard * 65536);

	}

	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french"));
	}
}
