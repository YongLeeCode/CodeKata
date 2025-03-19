/**
 * @author : yong
 * @packageName : PACKAGE_NAME
 * @fileName : 모음사전
 * @date : 3/19/25
 * @description : https://school.programmers.co.kr/learn/courses/30/lessons/84512
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/19/25        yong       최초 생성
 */
public class 모음사전 {
    private static int answer = 0;
    private static int index = 0;
    public static int solution(String word) {
        wordsIndex(word, "");
        return index;
    }

    public static void wordsIndex(String word, String current) {
        if(current.length() >= 5) {
            return;
        }

        if(word.equals(current)) {
            answer = index;
            return;
        }

        index++;

        wordsIndex(word, current + "A");
        wordsIndex(word, current + "E");
        wordsIndex(word, current + "I");
        wordsIndex(word, current + "O");
        wordsIndex(word, current + "U");
    }

    public static void main(String[] args) {
        String word = "AAE";
        int result = solution(word);
        System.out.println(result);
    }
}
