public class 바탕화면정리 {
    public static void solution() {
        String[] wallpaper = {".#...", "..#..", "...#."};
        int minX = 50;
        int minY = 50;
        int maxX = 0;
        int maxY = 0;
        for(int x = 0; x < wallpaper.length; x++) {
            String w = wallpaper[x];
            for(int y = 0; y < w.length(); y++) {
                if(w.charAt(y) == '#'){

                }
            }
        }

        System.out.printf("%d %d %d %d", minX, minY, maxX, maxY);
    }
    public static void main(String[] args) {
        solution();
    }
}
