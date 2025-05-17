import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 뉴스클러스터링 {
	public static int solution(String str1, String str2) {
		Map<String, Integer> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();

		for(int i = 0; i < str1.length() - 1; i++) {
			char c1 = Character.toLowerCase(str1.charAt(i));
			char c2 = Character.toLowerCase(str1.charAt(i + 1));
			String letters = c1+""+c2;
			if (Character.isLetter(c1) && Character.isLetter(c2)) {
				map1.put(letters, map1.getOrDefault(letters, 0) + 1);
			}
		}

		for(int i = 0; i < str2.length() - 1; i++) {
			char c1 = Character.toLowerCase(str2.charAt(i));
			char c2 = Character.toLowerCase(str2.charAt(i + 1));
			String letters = c1+""+c2;
			if (Character.isLetter(c1) && Character.isLetter(c2)) {
				map2.put(letters, map2.getOrDefault(letters, 0) + 1);
			}
		}

		Set<String> all = new HashSet<>();
		all.addAll(map1.keySet());
		all.addAll(map2.keySet());

		int same = 0;
		int diff = 0;
		for(String key: all) {
			int count1 = map1.getOrDefault(key, 0);
			int count2 = map2.getOrDefault(key, 0);
			same += Math.min(count1, count2);
			diff += Math.max(count1, count2);
		}

		if(diff == 0){
			return 65536;
		}
		return (int) ((double) same / diff * 65536);


		// // 실패작
		// List<String> list1 = new ArrayList<>();
		// List<String> list2 = new ArrayList<>();
		// Map<String, Integer> countSame = new HashMap<>();
		//
		// if(str1.isEmpty() && str2.isEmpty()) {
		// 	return 1;
		// }
		//
		// for(int i = 0; i < str1.length() - 1; i++) {
		// 	list1.add(str1.charAt(i)+ "" + str1.charAt(i+1));
		// }
		// for(int i = 0; i < str2.length() - 1; i++) {
		// 	String letters = str2.charAt(i)+ "" + str2.charAt(i+1);
		// 	if(list1.contains(letters) && ) {
		// 		countSame.put(letters, countSame.getOrDefault(letters, 0) + 1);
		// 	} else {
		// 		list2.add(letters);
		// 	}
		// }

	}

	public static void main(String[] args) {
		String str1 = "handshake";
		String str2 = "shake hands";
		System.out.println(solution(str1, str2));
	}
}

