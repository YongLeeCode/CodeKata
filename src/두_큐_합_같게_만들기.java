import java.util.LinkedList;
import java.util.Queue;

public class 두_큐_합_같게_만들기 {
    public static int solution(int[] q1, int[] q2) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        int total = 0;
        int q1Sum = 0;
        int q2Sum = 0;
        int move = 0;

        for(int i = 0; i < q1.length; i++) {
            queue1.add(q1[i]);
            total += q1[i];
            q1Sum += q1[i];
        }

        for(int i = 0; i < q2.length; i++) {
            queue2.add(q2[i]);
            total += q2[i];
            q2Sum += q2[i];
        }

        if(total % 2 == 1) {
            return -1;
        }

        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            if(q1Sum == q2Sum) {
                return move;
            }
            int higherSum = Math.max(q1Sum, q2Sum);

            if(q1Sum == higherSum) {
                int moveNum = queue1.poll();
                queue2.add(moveNum);
                move++;

                q1Sum -= moveNum;
                q2Sum += moveNum;

                if(moveNum > Math.floor(total / 2)) {
                    return -1;
                }
            } else if(q2Sum == higherSum) {
                int moveNum = queue2.poll();
                queue1.add(moveNum);
                move++;

                q2Sum -= moveNum;
                q1Sum += moveNum;

                if(moveNum > total / 2) {
                    return -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] queue1 = {3,2,7,2};
        int[] queue2 = {4,6,5,1};
        int result = solution(queue1, queue2);
        System.out.println(result);
    }
}
