package lv1;

public class 최소직사각형 {
	private static int solution(int[][] sizes) {
		int longer = 0;
		int shorter = 0;

		for(int i = 0; i < sizes.length; i++) {
			System.out.println(sizes[i][0]);
			System.out.println(sizes[i][1]);
			int longerSize = Math.max(sizes[i][0], sizes[i][1]);
			int shorterSize = Math.min(sizes[i][0], sizes[i][1]);

			if(longerSize > longer) longer = longerSize;
			if(shorterSize > shorter) shorter = shorterSize;
		}
		return longer * shorter;
	}
	public static void main(String[] args) {
		//[[60, 50], [30, 70], [60, 30], [80, 40]]
		solution(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}});
	}
}
