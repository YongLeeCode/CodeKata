package lv1;

import java.util.*;

/**
 * 문제 설명
 *  - 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
 *    이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
 *    단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,
 *
 *    - arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
 *    - arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
 *  - 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
 *
 * 제한사항
 *  - 배열 arr의 크기 : 1,000,000 이하의 자연수
 *  - 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
 *
 * with stack vs without stack
 *  - 이 문제는 Stack/Queue 카테고리에 있던 문제다.
 *    그런데 없이도 풀 수 있다는 생각이 들어 풀어보았고 실제로 테스트에 모두 성공했다.
 *    그러면 스텍 있을 때 성능은 더 빠를까? 둘을 직접 비교해봤다.
 *    결과는 놀랍게도 스텍 없이가 더 빨랐다.
 *    without stack : 35ms -> solution1
 * 	  with stack : 139ms -> solution2
 *
 * 	- 어째서 solution1이 더 빨랐을까?
 * 	  Stack은 Vector 기반으로 동기화 처리(sync) 비용이 있음
 *    Stack은 내부적으로 Vector를 상속받고 있어서, push(), get() 같은 연산이 Thread-safe하게 동작함.
 *
 *    반면 ArrayList는 동기화를 하지 않아서 오버헤드가 적음 → 싱글 스레드 환경에선 ArrayList가 빠름.
 *    즉, stack.push()와 stack.get() 모두가 ArrayList 대비 더 느림.
 *
 *  - 다른 방법을 찾아본 결과 deque를 추천받았다.
 *     - ArrayDeque는 Stack보다 빠르고 가볍고 안전한 스택 대체재예요.
 *     - 스레드 세이프 하지 않지만, 싱글 스레드 환경에선 더 빠름.
 *     결과:
 *      without stack : 44ms
 * 		with stack : 135ms
 * 		with deque : 92ms
 */

public class 같은_숫자는_싫어 {
	private static int[] solution3(int[] arr) {
		Deque<Integer> stack = new ArrayDeque<>();
		for (int num : arr) {
			if (stack.isEmpty() || stack.peekLast() != num) {
				stack.addLast(num);
			}
		}

		int[] answer = new int[stack.size()];
		int i = 0;
		for (int num : stack) {
			answer[i++] = num;
		}

		return answer;
	}

	private static int[] solution1(int[] arr) {
		int prev =1000001;
		List<Integer> answer = new ArrayList<>();

		for(int i = 0; i < arr.length; i++) {
			if(prev != arr[i]) {
				answer.add(arr[i]);
			}
			prev = arr[i];
		}
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	private static int[] solution2(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		for(int num : arr) {
			if(stack.isEmpty() || stack.peek() != num) {
				stack.push(num);
			}
		}

		int[] answer = new int[stack.size()];
		for(int i = 0; i < stack.size(); i++) {
			answer[i] = stack.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] input = generateLargeInput(1_000_000);

		long startTimeWithoutStack = System.currentTimeMillis();
		solution1(input);
		long endTimeWithoutStack = System.currentTimeMillis();
		System.out.println("without stack : " + (endTimeWithoutStack - startTimeWithoutStack));

		long startTimeWithStack = System.currentTimeMillis();
		solution2(input);
		long endTimeWithStack = System.currentTimeMillis();
		System.out.println("with stack : " + (endTimeWithStack - startTimeWithStack));

		long startTimeWithDeque = System.currentTimeMillis();
		solution3(input);
		long endTimeWithDeque = System.currentTimeMillis();
		System.out.println("with deque : " + (endTimeWithDeque - startTimeWithDeque));
	}

	private static int[] generateLargeInput(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			// 1~5 사이에서 반복되는 숫자 생성
			arr[i] = i % 5;
		}
		return arr;
	}
}
