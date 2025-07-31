package lv1;

import java.util.Map;

public class 숫자_문자열과_영단어 {
	static Map<String, Integer> map = Map.of(
		"one", 1,
		"two", 2,
		"three", 3,
		"four", 4,
		"five", 5,
		"six", 6,
		"seven", 7,
		"eight", 8,
		"nine", 9,
		"zero", 0
	);

	private static int solution(String s) {
		String[] str = s.split("");
		String n = "";
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (isNumber(str[i])) {
				result += str[i];
				continue;
			}

			n += str[i];

			if (map.containsKey(n)) {
				result += map.get(n);
				n = "";
			}

		}

		return Integer.parseInt(result);
	}

	private static boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution("one4seveneight"));
	}
}
