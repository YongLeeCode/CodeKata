import java.util.*;

/**
 * @author : yong
 * @packageName : PACKAGE_NAME
 * @fileName : 롤케이크_자르기
 * @date : 3/24/25
 * @description : https://school.programmers.co.kr/learn/courses/30/lessons/132265
 */
public class 롤케이크_자르기 {
    public static int solution(int[] toppings) {
        Map<Integer, Integer> cake1 = new HashMap<>();
        Map<Integer, Integer> cake2 = new HashMap<>();
        int count = 0;

        for(int topping : toppings) {
            cake1.put(topping, cake1.getOrDefault(topping, 0) + 1);
        }

        for(int topping : toppings) {
            cake2.put(topping, cake2.getOrDefault(topping, 0) + 1);

            if(cake1.containsKey(topping)) {
                if(cake1.get(topping) == 1) {
                    cake1.remove(topping);
                } else {
                    cake1.put(topping, cake1.get(topping) - 1);
                }
            }

            if(cake1.size() == cake2.size()) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] toppings = {1, 2, 1, 3, 1, 4, 1, 2};
        int result = solution(toppings);
        System.out.println(result);
    }
}
