package lv2;

public class 모음사전 {
	int result = 0;
	boolean matched = false;

	private void dfs(String curr, String word) {
		char[] letters = {'A', 'E', 'I', 'O', 'U'};

		if(curr.length() > 5) return;
		if (curr.equals(word)) {
			matched = true;
		}
		if(matched) return;
		result++;

		for(char c : letters) {
			dfs(curr + c, word);
		}
	}
	private int solution(String word) {

		dfs("", word);
		return result;
	}
	public static void main(String[] args) {
		모음사전 a = new 모음사전();
		System.out.println(a.solution("I"));
	}
}
