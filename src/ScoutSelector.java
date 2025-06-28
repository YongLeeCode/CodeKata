import java.util.*;

public class ScoutSelector {
	public static void main(String[] args) {
		int[][] data = {
			{1111, 1, 5, 3},
			{2222, 2, 4, 1},
			{-1, -1, -1, -1},
			{3333, 6, 2, 5},
			{-3, -1, -1, -1}
		};

		int[] result = selectPlayers(data);
		System.out.println(Arrays.toString(result)); // [2222, 3333]
	}

	public static int[] selectPlayers(int[][] data) {
		List<Integer> selected = new ArrayList<>();
		List<int[]> candidates = new ArrayList<>();

		for (int[] entry : data) {
			int id = entry[0];

			if (id > 0) {
				// 선수면 후보군에 추가
				candidates.add(entry);
			} else {
				// 스카우터일 경우
				int statIndex = getStatIndex(id); // 1 = 공격, 2 = 수비, 3 = 스피드
				if (statIndex == -1)
					continue;

				int maxStat = Integer.MIN_VALUE;
				int selectedId = -1;

				for (int[] player : candidates) {
					if (player[statIndex] > maxStat) {
						maxStat = player[statIndex];
						selectedId = player[0];
					}
				}

				if (selectedId != -1) {
					selected.add(selectedId);
				}

				// 스카우터 처리 이후에는 후보군 초기화
				candidates.clear();
			}
		}

		// 리스트를 배열로 변환
		return selected.stream().mapToInt(Integer::intValue).toArray();
	}

	private static int getStatIndex(int scoutId) {
		return switch (scoutId) {
			case -1 -> 1; // 공격
			case -2 -> 2; // 수비
			case -3 -> 3; // 스피드
			default -> -1;
		};
	}
}
