import java.util.HashMap;
import java.util.Map;

/**
 * @packageName    : PACKAGE_NAME
 * @fileName       : 성격_유형_검사하기
 * @author         : yong
 * @date           : 4/12/25
 * @description    :
 */
public class 성격_유형_검사하기 {
	public static String solution(String[] survey, int[] choices) {
		Map<Character, Integer> personalities = new HashMap<>();
		char[] arr = {'R', 'T', 'F', 'C', 'M', 'J', 'A', 'N'};
		for(char per : arr) {
			personalities.put(per, 0);
		}

		for(int i = 0; i < survey.length; i++) {
			int point = Math.abs(choices[i] - 4); // 4는 중립
			if (choices[i] < 4) {
				char p = survey[i].charAt(0); // 비동의 → 첫 번째 문자
				personalities.put(p, personalities.get(p) + point);
			} else if (choices[i] > 4) {
				char p = survey[i].charAt(1); // 동의 → 두 번째 문자
				personalities.put(p, personalities.get(p) + point);
			}
		}

		StringBuilder result = new StringBuilder();
		if(personalities.get('R') >= personalities.get('T')) result.append('R');
		else result.append('T');

		if(personalities.get('C') >= personalities.get('F')) result.append('C');
		else result.append('F');

		if(personalities.get('J') >= personalities.get('M')) result.append('J');
		else result.append('M');

		if(personalities.get('A') >= personalities.get('N')) result.append('A');
		else result.append('N');

		return result.toString();
	}

	private static int getPoints(int n) {
		if(n == 1 || n == 7) return 3;
		else if(n == 2 || n == 6) return 2;
		else if(n == 3 || n == 5) return 1;
		else return 0;
	}

	public static void main(String[] args) {
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choice = {5, 3, 2, 7, 5};
		System.out.println(solution(survey, choice));
	}
}
