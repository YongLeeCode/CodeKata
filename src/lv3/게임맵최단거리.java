package lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
	private static int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;
		boolean[][] visited = new boolean[n][m];

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		Queue<int[]> queue = new LinkedList<>();

		//x, y, distance
		queue.offer(new int[]{0, 0, 1});
		//출발지
		visited[0][0] = true;

		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int x = curr[0];
			int y = curr[1];
			int distance = curr[2];

			if(x == n - 1 && y == m - 1) return distance;

			for(int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && maps[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.offer(new int[]{nx, ny, distance + 1});
				}
			}
		}

		return -1;
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
	}
}
