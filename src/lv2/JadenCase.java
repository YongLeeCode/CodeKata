package lv2;

public class JadenCase {
	private static String solution2(String s) {
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;

		for(char c : s.toCharArray()) {
			if(c == ' ') {
				isFirst = true;
				sb.append(c);
			} else {
				if(isFirst) {
					sb.append(Character.toUpperCase(c));
					isFirst = false;
				} else {
					sb.append(Character.toLowerCase(c));
				}
			}
		}
		return sb.toString();
	}

	//첫번째로 풀었던 방법은 실패
	/**
	 * 이유는?
	 * 연속된 공백
	 * - s.split(" ")는 "a b" (공백 2개) → ["a", "", "b"] 로 쪼개버립니다.
	 * - String.join(" ", …)하면 원래 공백 수가 달라져서 테스트 케이스에서 틀려요.
	 * 빈 문자열 처리
	 * - 단어가 빈 문자열("")인데 substring(0, 1)을 호출하면 StringIndexOutOfBoundsException 터집니다.
	 * 숫자나 특수문자 시작
	 * - "3people unFollowed me" 같은 입력에서 "3people" → "3people" 그대로 둬야 정답인데, 지금 코드는 "3people"이 "3people" 그대로 되지만, replaceFirst 때문에 의도치 않게 이상해질 수 있어요.
	 */
	private static String solution1(String s) {
		String[] words = s.toLowerCase().split(" ");

		for(int i = 0; i < words.length; i++) {
			words[i] = words[i].replaceFirst(words[i].substring(0, 1), words[i].substring(0, 1).toUpperCase());
		}
		return String.join(" ", words);

	}
	public static void main(String[] args) {
		System.out.println(solution2("3people unFollowed me"));
	}
}
