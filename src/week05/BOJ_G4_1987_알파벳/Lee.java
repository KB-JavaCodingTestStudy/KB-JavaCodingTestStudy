package study.week05.BOJ_G4_1987_알파벳;

import java.util.*;
import java.io.*;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - R * C 크기의 보드칸이 있고, 각 칸에는 알파벳 대문자가 하나씩 적혀있다.
 *  - (1,1) 번째 칸에서 시작하여, 한번 지났던 알파벳을 다시 지나지 않고 이동할 수 있는 경로의 최대 길이를 구한다.
 *
 * # 입력
 *  - line 1: R C
 *  - line 2~R+1: R줄에 걸쳐 각 줄마다 C개의 알파벳 (보드의 각 칸에 적힌 알파벳 문자열)
 *
 * # 출력
 *  - 같은 알파벳을 중복해서 지나지 않는 경로의 최대 길이 출력
 *
 * 💻 알고리즘 설계
 *  - dfs를 이용하여 백트레킹 방식으로 각 경로를 탐색한다.
 *  - 현재 도착한 칸의 알파벳을 visited에 기록하여 중복을 방지한다.
 *  - 백트레킹으로 이미 지났던 칸을 되돌아 올때는 visited에서 제거한다.
 *  - 칸을 진행할 때마다 1을 더한 값을 재귀 호출 caller에 전달한다.
 *  - next_dist는 이후 재귀호출로 계산될 거리 중, 가장 큰 값을 의미한다.
 *
 * ================================================================
 */

public class Lee {

    static int R, C;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static String[] board;
    static boolean[] visited;
    static Queue<int[]> queue;

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    public static int order(int r, int c) {
        return board[r].charAt(c) - 'A';
    }

    public static int dfs(int r, int c) {

        visited[order(r, c)] = true;

        int next_dist = 0;

        for (int i = 0; i < 4; i++) {
            int nextRow = r + dr[i];
            int nextCol = c + dc[i];

            if(isValid(nextRow, nextCol) && !visited[order(nextRow, nextCol)]) {
                next_dist = Math.max(next_dist, dfs(nextRow, nextCol));
            }
        }

        visited[order(r, c)] = false;

        return next_dist + 1;
    }

    public static void main(String[] args) throws IOException {

        ///// input /////

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line1 = br.readLine().split(" ");

        R = Integer.parseInt(line1[0]);
        C = Integer.parseInt(line1[1]);

        board = new String[R];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine();
        }

        ///// imple /////

        visited = new boolean[26];
        queue = new LinkedList<>();

        int dist = dfs(0, 0);

        bw.write(dist + "");
        bw.flush();

        bw.close();
        br.close();
    }
}
