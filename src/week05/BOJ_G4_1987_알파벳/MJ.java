package week05.BOJ_G4_1987_알파벳;

import java.io.*;
import java.util.*;

/* ================================================================
 *
 * Author   : 남민주
 *
 * ================================================================
 * 📌 문제 분석 요약
 *
 * # 입력
 * -  grid 크기(가로*세로)
 * - grid 깂
 *
 * # 출력
 * - 중복되지 않는 가장 많이 갈 수 있는 경우
 *
 * 💻 알고리즘 설계
 * -  grid 값을 입력받기
 *  - 26 크기의 중복여부를 확인하는 boolean 배열 선언
 *      - 알파벳 개수: 26
 *  - dfs 함수 생성
 *      - max 를 현재와 원래 값을 비교(더 큰 값으로 업데이트)
 *      - 방문한 적이 없는 즉, 중복된 알파벳인 경우
 *          - 상하좌우의 값이 존재하는 경우에 대하여
 *              - 해당 위치 방문 여부 true 로 업데이트
 *              - dfs 실행(이때 이동거리+1)
 *              - 해당 위치 방문 여부 다시 false 로 하여 백트래킹
 *  (알파벳으로는 배열의 인덱스가 될 수 없으므로 -'A' 하여 0번부터 인덱스로 지정될 수 있도록 한다.)
*
 * ================================================================
 */

public class MJ {
    public static final int dx[] = {0, 0, 1, -1};
    public static final int dy[] = {1, -1, 0, 0};
    public static String[] grid;
    public static int R, C, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = xy[0];
        C = xy[1];
        grid = new String[R];
        for (int i = 0; i < R; i++) {
            grid[i] = br.readLine();
        }

        boolean[] visited = new boolean[26];
        visited[grid[0].charAt(0) - 'A'] = true;
        dfs(0, 0, visited, 1);

        bw.write(String.valueOf(max));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int x, int y, boolean[] visited, int count) {
        max = Math.max(max, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                int nextChar = grid[nx].charAt(ny) - 'A';
                if (!visited[nextChar]) {
                    visited[nextChar] = true;
                    dfs(nx, ny, visited, count + 1);
                    visited[nextChar] = false; // 백트래킹
                }
            }
        }
    }
}
