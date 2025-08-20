package lv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 전화번호_목록 {
	private static boolean solution(String[] phone_book) {
		Set<String> set = new HashSet<>(Arrays.asList(phone_book));
		for (String number : phone_book) {
			for (int i = 1; i < number.length(); i++) {
				if (set.contains(number.substring(0, i))) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));
	}
}
