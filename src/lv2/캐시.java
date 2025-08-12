package lv2;
//카카오 블라인드 테스트 2018 1차

import java.util.LinkedList;

public class 캐시 {
	private static int solution(int cacheSize, String[] cities) {
		LinkedList<String> list = new LinkedList<>();
		int result = 0;

		for(String city : cities) {
			city = city.toLowerCase();
			if(list.contains(city)) {
				list.remove(city);
				list.addLast(city);
				result += 1;
			} else {
				list.addLast(city);
				if(list.size() > cacheSize) {
					list.removeFirst();
				}
				result += 5;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(solution(4, new String[]{"Seoul", "Busan", "Incheon", "Daegu", "INcheon"} ) );
	}
}
