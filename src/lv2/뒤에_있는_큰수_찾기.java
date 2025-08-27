package lv2;

import java.util.Arrays;
import java.util.Stack;

public class 뒤에_있는_큰수_찾기 {

	//시간복잡도를 줄이기 위한 스텍 사용 방법
	private static int[] solution2(int[] numbers) {
		Stack<int[]> stack = new Stack<>();
		int[] result = new int[numbers.length];
		Arrays.fill(result, -1);

		for(int i = 0; i < numbers.length; i++) {
			int curr = numbers[i];
			while(!stack.isEmpty()) {
				int[] top = stack.peek();
				if(top[1] >= curr) break;
				result[top[0]] = curr;
				stack.pop();
			}
			stack.push(new int[]{i, curr});
		}
		return result;
	}

	//이 방법은 시간복잡ㄷ가 n^2이라고한다.
	//그래서 시간초과로 이 방법은 실패했다.
	private static int[] solution(int[] numbers) {
		boolean[] changed = new boolean[numbers.length];
		int[] result = new int[numbers.length];
		for(int i = 0; i < numbers.length - 1; i++) {
			for(int j = i; j < numbers.length; j++) {
				if(numbers[i] < numbers[j] && !changed[i]) {
					result[i] = numbers[j];
					changed[i] = true;
				}
			}
		}

		for(int i = 0; i < numbers.length; i++) {
			if(!changed[i]) {
				result[i] = -1;
			}
		}

		return result;
	}
	public static void main(String[] args) {

	}
}
