package lv3;

import java.util.LinkedList;
import java.util.Queue;

// 스케일 두배로 만들어 가장자리에 붙어있는 것들 해결하기
public class 아이템_줍기 {
	private static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int startX = characterX * 2;
		int startY = characterY * 2;
		int endX = itemX * 2;
		int endY = itemY * 2;
		boolean[][] visited = new boolean[101][101];
		int[][] map = new int[101][101];

		for(int[] r : rectangle) {
			int x1 = r[0] * 2;
			int y1 = r[1] * 2;
			int x2 = r[2] * 2;
			int y2 = r[3] * 2;

			for(int i = x1; i <= x2; i++) {
				for(int j = y1; j <= y2; j++) {
					map[i][j] = 1;
				}
			}
		}

		for(int[] r : rectangle) {
			int x1 = r[0] * 2;
			int y1 = r[1] * 2;
			int x2 = r[2] * 2;
			int y2 = r[3] * 2;
			for(int i = x1 + 1; i <= x2 - 1; i++) {
				for(int j = y1 + 1; j <= y2 - 1; j++) {
					map[i][j] = 0;
				}
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{startX, startY, 0});
		visited[startX][startY] = true;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int x = curr[0];
			int y = curr[1];
			int dist = curr[2];
			if(x == endX && y == endY) return dist / 2;

			for(int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < 101 && ny < 101) {
					if(map[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.offer(new int[]{nx, ny, dist + 1});
					}
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
		System.out.println(solution(rectangle, 1, 3, 7, 8));
	}
}
