package lv2;

import java.util.Arrays;

public class 카펫 {
	private static int[] solution(int yellow, int brown) {
		int total = yellow + brown;

		for(int width = 3; width <= total; width++) {
			if(total % width != 0) continue;

			int height = total / width;
			if(height > width) continue;
			if((height - 2) * (width - 2) == yellow) {
				return new int[]{width, height};
			}
		}
		return new int[]{0,0};
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(2, 10)));
	}
}
