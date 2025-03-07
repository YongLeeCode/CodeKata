package dfs;

public class Stemina {
    public static int a = 0;
    public static boolean[] visited;
    public static void solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, visited, dungeons);

        System.out.println(a);
    }

    public static void dfs(int depth, boolean[] visited, int[][] dungeons) {
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, visited, dungeons);
                visited[i] = false;
            }
        }
        a = Math.max(depth, a);
    }

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        solution(k, dungeons);
    }
}
