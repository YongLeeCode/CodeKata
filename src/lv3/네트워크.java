package lv3;

public class 네트워크 {
	private static int solution(int n, int[][] computers) {
		boolean[] visited = new boolean[n];
		int count = 0;

		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				dfs(i, visited, computers);
				count++;
			}
		}
		return count;
	}
	private static void dfs(int n, boolean[] visited, int[][] computers) {
		visited[n] = true;
		for(int i = 0; i < computers.length; i++) {
			if(!visited[i] && computers[n][i] == 1) {
				dfs(i, visited, computers);
			}
		}
	}


	public static void main(String[] args) {
		System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
	}
}
