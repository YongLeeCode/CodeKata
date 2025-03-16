/**
 * packageName    : PACKAGE_NAME
 * fileName       : 타겟_넘버
 * author         : yong
 * date           : 3/16/25
 * programmersUrl : https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * description    : dfs/bfs 문제
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/16/25        yong       최초 생성
 */
public class 타겟_넘버 {
    public static int answer = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int result = solution(numbers, target);
        System.out.println(result);
    }
    public static int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }

    private static void dfs(int index, int sum, int[] numbers, int target) {
        if (numbers.length == index) {
            if (target == sum) {
                answer++;
            }
            return ;
        }

        dfs(index + 1, sum + numbers[index], numbers, target);
        dfs(index + 1, sum - numbers[index], numbers, target);

    }
}
