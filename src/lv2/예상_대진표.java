package lv2;

/**
 * 예상대진표 문제에서 문제가 되었던 부분은 두가지였다.
 * 1. while의 종료 조건을 어떻게 만들거냐?
 * 2. 홀수 일때 어떻게 나눠서 원하는 값이 나오게 하거냐?
 *
 * 1번같은 경우는 처음에 a+1 != b || a-1 != b 형식으로 했다.
 * 이유는 대진이 성사되는 것은 a와 b가 앞뒤로 같을 때라고 생각했기 때문이다.
 * 하지만 내가 처음 했던 방식의 문제점은 하나가 false가 되어도 하나는 true가 되기 때문이다.
 * 게다가 이게 성공하더라도 종료시점이 빨라서 원하는 카운트가 -1차감된 상태일 것이다.
 *
 * 2번 같은 경우는 int의 속성을 활용해야한다. 5/2를 할 시 2가 나온다. 이 말은 내림형식으로 된다는 뜻이기 때문에 1을 먼저 더한 상태로 하면 원하는 값이 나온다.
 * 4/2 => 2
 * 5/2 => 2
 * 6/2 => 3
 */
public class 예상_대진표 {
	public static int solution(int n, int a, int b)
	{
		int count = 0;

		while(a != b) {
			a = ceilDiv(a);
			b = ceilDiv(b);
			count++;
		}
		return count;
	}

	private static int ceilDiv(int num) {
		return (num + 1) / 2;
	}
}
