//고민한 포인트
/*
* 글자를 나눌때 어떤 식으로 나눠야하지?
* 	생각한 방식 1. 옹알이 글자가 있으면 count++하고 스트링에서 삭제하는 방식
* 		substring을 사용해보자.
* */

public class 옹알이 {
	public static int solution(String[] babbling) {
		int count = 0;
		String[] words = {"aya", "ye", "woo", "ma"};
		for (String b : babbling) {
			String lastWord = "";
			boolean isValid = true;

			while (!b.isEmpty()) {
				boolean matched = false;
				for (String word : words) {
					if (b.startsWith(word) && !word.equals(lastWord)) {
						b = b.substring(word.length());
						lastWord = word;
						matched = true;
						break;
					}
				}
				if (!matched) {
					isValid = false;
					break;
				}
			}

			if (isValid) count++;
		}
		return count;
	}

	public static void main(String[] args) {
		String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		System.out.println(solution(babbling));
	}

}

