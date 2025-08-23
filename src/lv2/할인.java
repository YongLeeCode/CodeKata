package lv2;

import java.util.HashMap;
import java.util.Map;

public class 할인 {
	//map.equals(temp)로 힙 안에 있는 데이터값이 동일한지 알수있더라...
	private static int solution(String[] want, int[] number, String[] discount) {
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < want.length; i++) {
			map.put(want[i], number[i]);
		}
		int answer = 0;
		for(int i = 0; i <= discount.length - 10; i++) {
			Map<String, Integer> temp = new HashMap<>();
			for(int j = 0; j < 10; j++) {
				temp.put(discount[i+j], temp.getOrDefault(discount[i+j], 0) + 1);
			}
			if(temp.equals(map)) {
				answer++;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3, 2, 2, 2, 1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
		System.out.println(solution(want, number, discount));
	}
}
