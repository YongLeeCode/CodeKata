package lv3;

public class 던전보스방_도달_경로의수 {
	private static int count = 0;

	private static int solution(int[][] map) {
		int n = map.length;
		int m = map[0].length;
		boolean[][] visited = new boolean[n][m];

		dfs(n, m, 0, 0, map, visited);

		return count;
	}

	private static void dfs(int n, int m, int x, int y, int[][] map, boolean[][] visited) {
		if(x > n-1 || y > m - 1 || x < 0 || y < 0) return;
		if(visited[x][y]) return;
		if(map[x][y] == 0) return;

		if(x == n - 1 && y == m - 1) {
			count++;
			return;
		}

		visited[x][y] = true;

		dfs(n, m, x + 1, y, map, visited);
		dfs(n, m, x - 1, y, map, visited);
		dfs(n, m, x, y + 1, map, visited);
		dfs(n, m, x, y - 1, map, visited);

		visited[x][y] = false;
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[][]{
			{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1}, {1,1,1,0,1},{0,0,0,0,1}
		}));
	}
}
