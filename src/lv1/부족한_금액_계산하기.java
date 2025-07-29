package lv1;

/**
 * 부족한 금액 게산하기 문제: https://school.programmers.co.kr/learn/courses/30/lessons/82612
 *
 * 문제 설명
 *  - 새로 생긴 놀이기구는 인기가 매우 많아 줄이 끊이질 않습니다.
 *    이 놀이기구의 원래 이용료는 price원 인데, 놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였습니다.
 *    즉, 처음 이용료가 100이었다면 2번째에는 200, 3번째에는 300으로 요금이 인상됩니다.
 *
 *  - 놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return 하도록 solution 함수를 완성하세요.
 *  - 단, 금액이 부족하지 않으면 0을 return 하세요.
 *
 * 제한사항
 *  - 놀이기구의 이용료 price : 1 ≤ price ≤ 2,500, price는 자연수
 *  - 처음 가지고 있던 금액 money : 1 ≤ money ≤ 1,000,000,000, money는 자연수
 *  - 놀이기구의 이용 횟수 count : 1 ≤ count ≤ 2,500, count는 자연수
 *
 * 코딩 작성 전 풀이 방법:
 *   1. count만큼 for loop 돌리기
 *   2. money에서 price*(i + 1) 만큼 차감 / 이때 i는 for loop의 회차
 *   3. Math.abs(result)로 값을 리턴한다.
 *
 * 결과:
 * 	private static long solution(int price, int money, int count) {
 * 		for(int i = 0; i < count; i++) {
 * 			money -= price * (i + 1);
 * 		}
 * 		return Math.abs(money);
 * 	}
 * 	일부 테스트에서 실패했다.
 *
 * 이유는?
 * 원인 1. 금액이 부족하지 않은 상황에는 0으로 리턴하지 않음
 * 원인 2. money는 int 타입이기 때문에  price가 일정 숫자를 넘기면 넣을 수 없다.
 * 그래서 long type으로 사용할 필요가 있었던 것이다.
 *
 */

public class 부족한_금액_계산하기 {
	private static long solution(int price, int money, int count) {
		long result = 0;
		for(int i = 0; i < count; i++) {
			result += price * (i + 1);
		}
		if(result <= money) return 0;
		return result - money;
	}

	public static void main(String[] args) {
		System.out.println(solution(3, 20, 4));
	}
}
