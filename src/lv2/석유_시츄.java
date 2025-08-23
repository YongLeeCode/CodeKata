package lv2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class 석유_시츄 {
	private static int solution(int[][] land) {
		int n = land.length;
		int m = land[0].length;
		boolean[][] visited = new boolean[n][m];
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int id = 1;
		int[][] idMap = new int[n][m];
		Map<Integer, Integer> oilSize = new HashMap<>();

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(land[i][j] == 1 && !visited[i][j]) {
					int size = 0;
					visited[i][j] = true;
					idMap[i][j] = id;
					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[]{i, j});

					while(!q.isEmpty()) {
						int[] curr = q.poll();
						int x = curr[0];
						int y = curr[1];
						size++;

						for(int k = 0; k < dx.length; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];

							if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
								if(land[nx][ny] == 1) {
									visited[nx][ny] = true;
									q.offer(new int[]{nx, ny});
									idMap[nx][ny] = id;
								}

							}
						}
					}
					oilSize.put(id, size);
					id++;
				}
			}
		}

		int answer = 0;
		for(int col = 0; col < m; col++) {
			Set<Integer> set = new HashSet<>();
			int sum = 0;
			for(int row = 0; row < n; row++) {
				int compId = idMap[row][col];
				if(compId > 0 && !set.contains(compId)) {
					set.add(compId);
					sum += oilSize.get(compId);
				}
			}
			answer = Math.max(answer, sum);
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(
			solution(new int[][] {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0},{1, 1, 1,
				0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}));
	}

	// 실패 상황
	// private static int solution(int n) {
	//
	// 	//스타팅 지역
	// 	//Math.max()사용하기
	// 	//bfs
	// 	int maxFuel = 0;
	//
	// 	int[] idx = {-1, 1, 0, 0};
	// 	int[] idy = {0, 0, -1, 1};
	//
	// 	Queue<int[]> q = new LinkedList<>();
	//
	// 	for (
	// 		int i = 0;
	// 		i < land.length; i++) {
	// 		int fuel = 0;
	// 		boolean[][] check = new boolean[land.length][land[0].length];
	// 		for (int j = 0; j < land[0].length; j++) {
	// 			if (land[i][j] == 1) {
	// 				q.offer(new int[] {i, j});
	// 			}
	// 		}
	// 		while (!q.isEmpty()) {
	// 			fuel++;
	// 			int[] curr = q.poll();
	// 			int x = curr[0];
	// 			int y = curr[1];
	// 			check[x][y] = true;
	// 			for (int k = 0; k < idx.length; k++) {
	// 				if ((x + idx[k]) >= 0 && (x + idx[k] < land.length) && (y + idy[k]) >= 0 && (y + idy[k]
	// 					< land[0].length)) {
	// 					if (!check[x + idx[k]][y + idy[k]]) {
	// 						check[x + idx[k]][y + idy[k]] = true;
	// 						q.offer(new int[] {x + idx[k], y + idy[k]});
	// 					}
	// 				}
	// 			}
	// 		}
	// 		maxFuel = Math.max(maxFuel, fuel);
	// 	}
	//
	// 	return maxFuel;
	//
	// }
}
