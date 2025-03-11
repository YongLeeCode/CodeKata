class 약수의_개수와_덧셈 {
    static int solution(int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            boolean even = true;
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    even = false;
                }
            }
            if (even) {
                result += i;
            } else {
                result -= i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int result = solution(13, 17);
        System.out.println(result);
    }
}
