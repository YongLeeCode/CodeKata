package lv2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 가장큰수 {
	private static String solution(int[] numbers) {
		String sorted = Arrays.stream(numbers).boxed().sorted((a,b)-> {
			int v1 = Integer.parseInt(a + "" + b);
			int v2 = Integer.parseInt(b + "" + a);

			return Integer.compare(v2, v1);
		}).map(String::valueOf)
			.collect(Collectors.joining(""));
		if(sorted.charAt(0) == '0') return "0";
		return sorted;
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
	}
}
