import java.util.Arrays;

public class 가장가까운숫자찾기 {
	public static int[] solution(String s) {
		int[] answer = new int[s.length()];
		Arrays.fill(answer, -1);

		for(int i = s.length()-1 ; i >= 0 ; i--){
			char charI = s.charAt(i); // I 에 대한 문자
			for(int j = 0 ; j<i; j++){
				char charJ = s.charAt(j); // J에 대한 문자
				if(charI == charJ)
					answer[i] = i-j;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("banana")));
	}
}
