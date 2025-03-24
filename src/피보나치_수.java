/**
 * @author : yong
 * @packageName : PACKAGE_NAME
 * @fileName : 피보나치_수
 * @date : 3/21/25
 * @description : https://school.programmers.co.kr/learn/courses/30/lessons/12945
 */
public class 피보나치_수 {
//    public static int solution(int n) {
//        int n1 = 0; // 1
//        int n2 = 1; // 2
//        int remain = 1234567;
//
//        if(n == 1) {
//            return 0;
//        }
//        for(int i = 2; i <= n; i++) {
//            int temp = n2;
//            n2 = (n2 % remain) + (n1 % remain);
//            n1 = temp;
//        }
//
//        return n2 % remain;
//    }


    public static int solution(int n) {
        return fibonacci(0, 1, 2, n);
    }

    private static int fibonacci(int num1, int num2, int index, int n) {
        int remain = 1234567;
        int temp = num2;
        num2 = (num1 % remain) + (num2 % remain);
        num1 = temp;

        if(index == n) {
            return num2 % remain;
        }

        return fibonacci(num1, num2, index + 1, n);
    }

    public static void main(String[] args) {
        solution(5);
    }
}
