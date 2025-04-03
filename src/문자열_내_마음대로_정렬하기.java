import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author : yong
 * @packageName : PACKAGE_NAME
 * @fileName : 문자열_내_마음대로_정렬하기
 * @date : 4/3/25
 * @description :
 */
public class 문자열_내_마음대로_정렬하기 {
    public static String[] solution(String[] strings, int n) {
        return Arrays.stream(strings).sorted((a, b) -> {
            if(a.charAt(n) == b.charAt(n)) {
                return a.compareTo(b);
            }
            return a.charAt(n) - b.charAt(n);
        }).toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 0;

        System.out.println(Arrays.toString(solution(strings, n)));
    }
}
