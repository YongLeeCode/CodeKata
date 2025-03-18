import java.util.*;

/**
 * @packageName    : PACKAGE_NAME
 * @fileName       : 주차요금계산
 * @author         : yong
 * @date           : 3/18/25
 * @url    : https://school.programmers.co.kr/learn/courses/30/lessons/92341
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/18/25        yong       최초 생성
 */
public class 주차요금계산 {
    public static int[] solution(int[] fees, String[] records) {
         // 0 ~ 180 => 5000
        // 180 + @ => 5000 + (((@ / 10) + 1) * 600)
        // 차 번호별로 해쉬맵 형성

        Map<String, Integer> map = new LinkedHashMap<>();
        int firstTime = fees[0];
        int firstFee = fees[1];
        int extraTime = fees[2];
        int extraFee = fees[3];

        for(String record : records) {
            String[] recInfo = record.split(" ");
            String carPlate = recInfo[1];
            String inOut = recInfo[2];
            String[] time = recInfo[0].split(":");

            int timeResult = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            if(inOut.equals("IN")) {
                map.put(carPlate, map.getOrDefault(carPlate,0) - timeResult);
            } else if (inOut.equals("OUT")) {
                map.put(carPlate, map.getOrDefault(carPlate,0) + timeResult);
            }
        }

        List<Integer> totalFee = new ArrayList<>();
        for(String key : map.keySet()) {
            int minutes = map.get(key);
            if(minutes <= 0) {
                minutes += ((23 * 60) + 59);
            }

            if(minutes <= firstTime) {
                totalFee.add(firstFee);
            } else  {
                totalFee.add(firstFee + (int) (((Math.floor(minutes - firstTime) / extraTime)) * extraFee));
            }
        }

        return totalFee.stream().mapToInt(t -> t).toArray();
    }
    public static void main(String[] args) {
        int[] fees = {1, 461, 1, 10};
        String[] records = {"00:00 1234 IN"};

        int[]  result = solution(fees, records);
        System.out.println(Arrays.toString(result));
    }

}
