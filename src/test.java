public class test {
	//옹알이
	public static int solution(String[] babbling) {
		String[] sounds = {"aya", "ye", "woo", "ma"};
		int count = 0;

		for(String b : babbling) {
			boolean isValid = true;
			String lastword = "";
			while(!b.isEmpty()) {
				boolean matched = false;
				for(String sound : sounds) {
					if(b.startsWith(sound) && !sound.equals(lastword)) {
						b = b.substring(sound.length());
						lastword = sound;
						matched = true;
						break;
					}
				}
				if(!matched) {
					isValid = false;
					break;
				}
			}
			if(isValid) {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		String[] babblings = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		System.out.println(solution(babblings));
	}
}
