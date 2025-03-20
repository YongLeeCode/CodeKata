import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author : yong
 * @packageName : PACKAGE_NAME
 * @fileName : 뒤에있는_큰수찾기
 * @date : 3/20/25
 * @description : https://school.programmers.co.kr/learn/courses/30/lessons/154539
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/20/25        yong       최초 생성
 */
public class 뒤에있는_큰수찾기 {
    public static void solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int n = numbers.length;
        int[] answer = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            int curr = numbers[i];
            while(!stack.empty() && stack.peek() <= curr) {
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(curr);
        }

        System.out.println(Arrays.toString(answer));
    }
    public static void main(String[] args) {
        int[] numbers = {9, 1, 5, 3, 6, 2};
        solution(numbers);
    }
}
