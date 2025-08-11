package lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 기능 개발를 생각나는대로 풀어보았다.
 * 눈에 보이는대로 진행률이 100%가 되었을 때 방식으로 완료 방식으로 풀어보았고,
 * 미리 완료되는대 소요되는 날 수를 구하여 풀어보았다.
 * 확실히 날 수로 풀었을 때 코드가 간결해지고 복잡해지지 않았다. 게다가 속도도 2배 이상 빠르다는 것을 알 수 있었다.
 */



public class 기능개발 {
	public static int[] solution2(int[] progresses, int[] speeds) {
		Queue<Integer> q = new LinkedList<>();
		List<Integer> days = new ArrayList<>();
		// 몇 일이 걸릴지 알아낸다.
		for(int i = 0; i < progresses.length; i++) {
			//올림을 해야하므로 ceil
			// 이때 ceil은 double 타입이므로 다시 int로 바꿔줘야함
			q.offer((int)Math.ceil((100 - progresses[i]) / (double)speeds[i]));
		}

		while(!q.isEmpty()) {
			int count = 1;
			int completed = q.poll();

			while(!q.isEmpty() && q.peek() <= completed) {
				count++;
				q.poll();
			}

			days.add(count);
		}

		return days.stream().mapToInt(Integer::intValue).toArray();
	}
	public static int[] solution1(int[] progresses, int[] speeds) {
		Queue<Integer> pq = new LinkedList<>();
		Queue<Integer> ps = new LinkedList<>();
		List<Integer> answer = new ArrayList<>();

		for (int i = 0; i < progresses.length; i++) {
			pq.offer(progresses[i]);
			ps.offer(speeds[i]);
		}

		while (!pq.isEmpty()) {
			//하루동안 진행
			int count_deployment = 0;
			boolean available = true;
			for (int i = 0; i < pq.size(); i++) {
				int p = pq.poll();
				int s = ps.poll();
				if (p + s < 100)
					available = false;
				if (available)
					count_deployment++;
				pq.offer(p + s);
				ps.offer(s);
			}

			//진행으로인한 배포과정
			for (int i = 0; i < count_deployment; i++) {
				pq.poll();
				ps.poll();
			}

			if (count_deployment > 0)
				answer.add(count_deployment);
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		long startS1 = System.nanoTime();
		solution1(new int[] {93, 30, 55}, new int[] {1, 30, 5});
		long endS1 = System.nanoTime();

		long startS2 = System.nanoTime();
		solution2(new int[] {93, 30, 55}, new int[] {1, 30, 5});
		long endS2 = System.nanoTime();

		System.out.println("S1 : " + (endS1 - startS1) + "ns");
		System.out.println("S2 : " + (endS2 - startS2) + "ns");
	}
}
