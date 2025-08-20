package lv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 전화번호_목록 {
	private static boolean solution2(String[] phone_book) {
		Arrays.sort(phone_book);
		for (int i = 0; i < phone_book.length - 1; i++) {
			if(phone_book[i].length() <= phone_book[i + 1].length()) {
				if(phone_book[i].equals(phone_book[i+1].substring(0, phone_book[i].length()))) return false;
			}
		}
		return true;
	}
	private static boolean solution1(String[] phone_book) {
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
		String[] phone_book = {"119", "118","128", "97674223", "1195524421", "129"};
		System.out.println(solution2(phone_book));
	}
}
