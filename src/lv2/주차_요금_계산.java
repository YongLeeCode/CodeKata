package lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 주차_요금_계산 {
	private static int[] solution(int[] fees, String[] records) {
		int[] answer = {};
		Map<String, Integer> parkingTime = new HashMap<>();
		Map<String, Boolean> checkout = new HashMap<>();
		List<String> list = new ArrayList<>();
		int baseTime = fees[0];
		int baseFee = fees[1];
		int extraTime = fees[2];
		int extraFee = fees[3];

		for(int i = 0; i < records.length; i++) {
			String[] record = records[i].split(" ");
			String inout = record[2];
			String car = record[1];
			String[] time = record[0].split(":");
			int cal = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
			if(inout.equals("IN")) {
				if(!parkingTime.containsKey(car)) {
					list.add(car);
				}
				parkingTime.put(car, parkingTime.getOrDefault(car, 0) - cal);
				checkout.put(car, false);
			} else if(inout.equals("OUT")) {
				parkingTime.put(car, parkingTime.getOrDefault(car, 0) + cal);
				checkout.put(car, true);
			}
		}

		for(Map.Entry<String, Boolean> entry : checkout.entrySet()) {
			if(!entry.getValue()) {
				parkingTime.put(entry.getKey(), parkingTime.getOrDefault(entry.getKey(), 0) + (23 * 60 + 59));
			}
		}

		int[] result = new int[list.size()];
		list.sort((a, b) -> a.compareTo(b));
		for(int i = 0; i < result.length; i++) {
			String car = list.get(i);
			int p = parkingTime.get(car);
			if(p < baseTime) {
				result[i] = baseFee;
			} else {
				int extraParkingTime = p - baseTime;
				result[i] = baseFee+ (int) Math.ceil((double) extraParkingTime / extraTime) * extraFee;

			}

		}
		return result;
	}
	public static void main(String[] args) {

	}
}
