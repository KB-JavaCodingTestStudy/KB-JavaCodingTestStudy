import java.io.*;
import java.util.*;

public class Main {
    static int R, C, max = 0;
    static char[][] board;
    static boolean[] visited = new boolean[26];

    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void dfs(int x, int y, int count) {
        max = Math.max(max, count);

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

            char nextChar = board[nx][ny];
            if (!visited[nextChar - 'A']) {
                visited[nextChar - 'A'] = true;
                dfs(nx, ny, count + 1);
                visited[nextChar - 'A'] = false; // 백트래킹
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            board[i] = line.toCharArray();
        }

        visited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(max);
    }
}
