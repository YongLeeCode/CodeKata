import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class 푸드파이터 {

    public String solution(int[] food) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                list.add(i);
                stack.add(i);
            }
        }
        list.add(0);

        while (!stack.empty()) {
            list.add(stack.pop());
        }
        String str = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
        System.out.println(str);
        return str;
    }
}
