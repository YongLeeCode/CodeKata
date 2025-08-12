package lv2;

public class 피로도 {
	static int result = 0;
	private static int solution(int[][] dungeons, int k) {
		boolean[] visited = new boolean[dungeons.length];
		dfs(k, dungeons, 0, visited);
		return result;
	}

	private static void dfs(int k, int[][] dungeons, int depth, boolean[] visited) {
		result = Math.max(result, depth);
		if(depth == dungeons.length) return;

		for(int i = 0; i < dungeons.length; i++) {
			if(!visited[i]) {
				if(k >= dungeons[i][0]) {
					visited[i] = true;
					dfs(k - dungeons[i][1], dungeons, depth + 1, visited);
					visited[i] = false;
				}
			}
		}
	}
	public static void main(String[] args) {
		//[[80,20],[50,40],[30,10]]
		int[][] dungeons ={{80,20}, {50,40}, {30,10}};
		System.out.println(solution(dungeons, 80));

	}
}
