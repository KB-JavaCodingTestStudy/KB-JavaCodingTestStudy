import java.io.*;

public class Main {
    static int r, c, maxLen = 0;
    static char[][] arr;
    static boolean[] visited = new boolean[26];  // 알파벳 A~Z 방문 여부
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void dfs(int x, int y, int depth) {
        int index = arr[x][y] - 'A';
        visited[index] = true;
        maxLen = Math.max(maxLen, depth);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                int nextCharIndex = arr[nx][ny] - 'A';
                if (!visited[nextCharIndex]) {
                    dfs(nx, ny, depth + 1);
                    visited[nextCharIndex] = false;  // 백트래킹
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        r = Integer.parseInt(rc[0]);
        c = Integer.parseInt(rc[1]);

        arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            arr[i] = line.toCharArray();
        }

        dfs(0, 0, 1);
        System.out.println(maxLen);
    }
}
