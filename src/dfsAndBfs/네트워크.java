package dfsAndBfs;

/*이 문제는 결국 갔던 곳을 마킹하는 것.
마킹 한 곳에서 또 다른 이어지는 곳이 있는지 확인
없으면 뒤로 가서 다른 길 찾아서 마킹

다 했는데 여전히 안 간 곳이 있다면 네트워크 수가 +1 되면서 똑같은 짓 반복

최종적으로 몇 개의 네트워크인지를 리턴
*/
public class 네트워크 {
	public static int solution(int n, int[][] computers) {
		boolean[] isVisisted = new boolean[n];
		int network = 0;
		for(int i = 0; i < n; i++) {
			if(!isVisisted[i]) {
				dfs(i, computers, isVisisted);
				network++;
			}
		}
		return network;
	}
	private static void dfs(int node, int[][] computers, boolean[] isVisisted) {
		isVisisted[node] = true;
		for(int i = 0; i < computers.length; i++) {
			if(computers[node][i] == 1 && !isVisisted[i]) {
				dfs(i, computers, isVisisted);
			}
		}
	}
	public static void main(String[] args) {
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(solution(3, computers));
	}
}
