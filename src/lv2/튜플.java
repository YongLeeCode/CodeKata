package lv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 튜플 {
	private static int[] solution(String s) {
		String[] str = s.replaceAll("\\{", "").replaceAll("}}", "").split("},");
		Set<String> set = new HashSet<>();
		Arrays.sort(str, (x, y) -> x.length() - y.length());
		int[] answer = new int[str.length];
		for(String s1 : str) {
			String[] units = s1.split(",");
			for(String unit : units) {
				if(!set.contains(unit)) {
					set.add(unit);
					answer[set.size() - 1] = Integer.parseInt(unit);
				}
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		System.out.println(Arrays.toString(solution(s)));
	}
}
