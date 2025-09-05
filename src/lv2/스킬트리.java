package lv2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 스킬트리 {
	private static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		//Map으로 가져와서 스킬 이름: 선행 스킬
		Map<Character, Character> map = new HashMap<>();
		for(int i = 1; i < skill.length(); i++) {
			map.put(skill.charAt(i), skill.charAt(i - 1));
		}

		//set에 입력된 것들
		for(int i = 0; i < skill_trees.length; i++) {
			boolean available = true;
			String s = skill_trees[i];
			Set<Character> set = new HashSet<>();

			for(int j = 0; j < s.length(); j++) {
				if(map.containsKey(s.charAt(j))) {
					if(!set.contains(map.get(s.charAt(j)))) {
						available = false;
						break;
					} else {
						set.add(s.charAt(j));
					}
				} else {
					set.add(s.charAt(j));
				}
			}

			if(available) {
				answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		String skill = "CBD";
		System.out.println(solution(skill, skill_trees));
	}
}
