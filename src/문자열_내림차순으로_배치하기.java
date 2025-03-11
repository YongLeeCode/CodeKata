import java.util.Arrays;
import java.util.stream.Collectors;

public class 문자열_내림차순으로_배치하기 {

    public static void solution(String s) {
        String newStr = Arrays.stream(s.split("")).sorted((x, y) -> y.charAt(0) - x.charAt(0)).collect(Collectors.joining());
        System.out.println(newStr);
    }
    public static void main(String[] args) {
        solution("Zbcdefg");
    }
}
