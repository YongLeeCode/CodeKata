import java.util.Arrays;

public class 비밀지도 {
	public static String[] solution(int n, int[] arr1, int[] arr2){
		String[] arr3 = new String[n];
		for(int i = 0; i < n; i++) {
			arr3[i] = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i])).replace(" ", "0");
			arr3[i] = arr3[i].replace("1", "#").replace("0", " ");
		}
		return arr3;
	}

	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		System.out.println(Arrays.toString(solution(n, arr1, arr2)));
	}
}
