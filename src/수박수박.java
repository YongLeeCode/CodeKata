public class 수박수박 {
    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                sb.append("수");
            } else {
                sb.append("박");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
         String result = solution(5);
         System.out.println(result);
    }
}
