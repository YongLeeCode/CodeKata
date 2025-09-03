package lv2;

public class 땅따먹기 {

	//dp
	private static int solution2(int[][] land) {
		for(int i = 1; i < land.length; i++) {
			land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
			land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
			land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
			land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
		}
		return Math.max(land[land.length - 1][0], Math.max(land[land.length - 1][1], Math.max(land[land.length - 1][2], land[land.length - 1][3])));
	}

	// dfs 방법은 O(3^n)이다.
	// 이유는 4가지 열이 있고 다음 행에서는 3가지 중 하나를 선택할 수 있다.
	// 매번 3가지 행 중 하나를 선택할 수 있기 때문에 4 * 3^n이라고 할 수 있다.
	// 그러므로 시간초과로 이 방법으로 해결 불가능
	static int maxNum = 0;
	private static int solution1(int[][] land) {
		for(int i = 0; i < land[0].length; i++) {
			dfs(land, 0, i, land[0][i]);
		}

		return maxNum;
	}

	private static void dfs(int[][] land, int depth, int prevCol, int curr) {
		if(land.length -1 <= depth) {
			maxNum = Math.max(maxNum, curr);
			return;
		}
		for(int i = 0; i < land[0].length; i++) {
			if(i != prevCol) {
				dfs(land, depth + 1, i, curr + land[depth + 1][i]);
			}
		}

	}
	public static void main(String[] args) {
		int[][] land = {{1,2,3, 5},{4,5,6,10},{7,8,9,22}};
		System.out.println(solution1(land));
		System.out.println(solution2(land));
	}
}
