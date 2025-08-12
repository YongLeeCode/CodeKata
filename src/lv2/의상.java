package lv2;

import java.util.HashMap;
import java.util.Map;

/**
 * 이 문제는 경우의 수만 잘 파악하면 쉽게 풀 수 있었던 문제다.
 * 처음에는 안 입었을 때는 어떡하지? 라는 고민 때문에 못 풀었는데 이것도 하나의 경우의 수에 집어 넣었어야했다.
 * 예를들면 headgear에 장착하는 옷이 3개면 안 입었을 경우까지 총 4가지 경우의 수, eyewear가 2개면 착용 안했을 경우까지 3가지 경우의 수.
 * 이 둘을 조합해서 한다면 4*3 = 12가 될 것이다.
 * 하지만 최소 한가지는 착용한다고 했으니 -1을 해줘야한다. 그러므로 12 -1  = 11이 정답이 된다.
 *
 */
public class 의상 {
	private static int solution(String[][] clothes) {
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < clothes.length; i++) {
			if(map.containsKey(clothes[i][1])) {
				map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
			} else {
				// 스타트를 2로 한 이유는 미착용도 고려했다.
				map.put(clothes[i][1], 2);
			}
		}

		//곱해야하니 1로 시작
		int answer = 1;
		for(String key : map.keySet()) {
			int value = map.get(key);
			answer *= value;
		}
		return answer - 1;
	}
	public static void main(String[] args) {
		//[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes));
	}
}
