package lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
	private static int solution(String begin, String target, String[] words) {
		boolean[] visited = new boolean[words.length];
		Queue<String> qWords = new LinkedList<>();
		Queue<Integer> qTimes = new LinkedList<>();

		qWords.offer(begin);
		qTimes.offer(0);

		while(!qWords.isEmpty()) {
			String currWord = qWords.poll();
			int times = qTimes.poll();

			if(currWord.equals(target)) return times;

			for(int i = 0; i <words.length; i++) {
				if(!visited[i]) {
					int similar = 0;
					for(int j = 0; j< currWord.length(); j++) {
						if(words[i].charAt(j) == currWord.charAt(j)) {
							similar++;
						}
					}
					if(similar == currWord.length() - 1) {
						visited[i] = true;
						qWords.offer(words[i]);
						qTimes.offer(times + 1);
					}
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"} ));
	}
}
