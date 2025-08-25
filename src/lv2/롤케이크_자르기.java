package lv2;

import java.util.HashSet;
import java.util.Set;

public class 롤케이크_자르기 {
	//생각한 방법은 루프를 이중으로 쓰는 것이 한번만 쓰는것이다.
	public static int solution2(int[] topping) {
		int[] aSide = new int[topping.length];
		int[] bSide = new int[topping.length];

		Set<Integer> aSideSet = new HashSet<>();
		for(int i = 0; i < topping.length; i++) {
			aSideSet.add(topping[i]);
			aSide[i] = aSideSet.size();
		}

		Set<Integer> bSideSet = new HashSet<>();
		for(int i = topping.length - 1; i >= 0; i--) {
			bSideSet.add(topping[i]);
			bSide[i] = bSideSet.size();
		}

		int count = 0;
		for(int i = 0; i < topping.length - 1; i++) {
			if(aSide[i] == bSide[i + 1]) count++;
		}

		return count;
	}

	// 문제는 풀렸지만, 시간초과로 실패한다.
	// 이 방법은 시간복잡도가 n^2이다. 그리고 제한사항에서는 토핑 길이가 1,000,000까지 가능하기 최대 1,000,000^2가 되므로 시간초과가 걸린다.
	public static int solution1(int[] topping) {
		int answer = 0;
		for(int i = 0; i < topping.length; i++) {
			answer += isFair(i, topping);
		}
		return answer;
	}

	//solution1을 위한 메서드
	private static int isFair(int cuttingLocation, int[] topping) {
		Set<Integer> aSide = new HashSet<>();
		Set<Integer> bSide = new HashSet<>();

		for(int i = 0; i <= cuttingLocation; i++) {
			aSide.add(topping[i]);
		}
		for(int i = cuttingLocation + 1; i < topping.length; i++) {
			bSide.add(topping[i]);
		}

		return aSide.size() == bSide.size() ? 1 : 0;
	}

	public static void main(String[] args) {
		System.out.println(solution1(new int[] {1,2,3,4,5,6,7,8,9}));
		System.out.println(solution2(new int[] {1,2,3,4,5,6,7,8}));
	}
}
