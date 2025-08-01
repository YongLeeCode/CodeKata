package lv1;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
	private static int solution(int[] nums) {
		// 전체 포켓몬의 반절
		int half = nums.length / 2;
		Set<Integer> set = new HashSet<>();
		for(int i : nums) {
			set.add(i);
		}
		return set.size() < half ? set.size() : half;
	}

	public static void main(String[] args) {
		solution(new int[] {3,1,2,3});
	}
}
