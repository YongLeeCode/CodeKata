import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @packageName    : PACKAGE_NAME
 * @fileName       : K진수에_소수_개수_구하기
 * @author         : yong
 * @date           : 3/17/25
 * @programmerURL  : https://school.programmers.co.kr/learn/courses/30/lessons/92335
 * @description    : 프로그래머스 k진수에 소수 개수 구하기 문제
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/17/25        yong       최초 생성
 */
public class K진수에_소수_개수_구하기 {
    public static void main(String[] args) {
        int test = 2;

        String three = Integer.toString(test, 3);
        String[] result = three.split("0");
        System.out.println(Arrays.toString(result));

        int count = 0;
        for (String s : result) {
            if (s.equals("1") || s.trim().isEmpty()) {
                continue;
            } else {
                long num = Long.parseLong(s);
                if (isPrime(num)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean isPrime (long a){

        if(a<2) return false;

        for(int i=2;i<=Math.sqrt(a);i++){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }

}
