package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
부등호 기호(<, >) n개가 주어질 때,
0~9 사이의 서로 다른 숫자들로 만든 n+1자리 수 중
조건을 만족하는 최댓값과 최솟값을 출력하는 문제입니다.

제약
숫자는 중복 없이 사용해야 하며, 부등호 조건을 반드시 만족해야 합니다.

풀이 방식
DFS + 백트래킹을 통해 모든 가능한 수열을 탐색하면서 부등호 조건을 만족하는 경우만 탐색을 이어갑니다.
조건에 맞는 수가 완성되면 max, min을 갱신합니다.

최적화: 큰 수부터 탐색하면 최댓값,
작은 수부터 탐색하면 최솟값을 가장 먼저 찾을 수 있으므로 조기 종료를 통해 탐색량을 줄일 수 있습니다.

시간 복잡도: O(N!) = 3백만(10! = 3628800)번 탐색
 */

public class N_2529 {
    /** MySolve, 완전 탐색
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        max = "0000000000";
        min = "9999999999";

        op = new char[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            op[i]= st.nextToken().charAt(0);
        }

        for (int i = 0; i < 10; i++) {
            visited = new boolean[10];
            visited[i] = true;
            dfs(i, 0, new StringBuilder().append(i));
            visited[i] = false;
        }
        System.out.println(max  + " " + min);
    }

    public static void dfs(int prev, int idx, StringBuilder sb) {
        if (sb.length() == op.length+1) {
            int res = sb.toString().compareTo(max);
            if (res > 0) {
                max = sb.toString();
            }
            res = sb.toString().compareTo(min);
            if (res < 0) {
                min = sb.toString();
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (visited[i] || (op[idx]=='<' && i<prev) ||(op[idx] =='>' && i > prev)) continue;

            visited[i] = true;
            sb.append(i);
            dfs(i, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
     */

    // Backtracking
    static boolean[] visited = new boolean[10];
    static char[] op;
    static String max = null;
    static String min = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        op = new char[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            op[i] = st.nextToken().charAt(0);
        }

        // 작은 수부터 돌면 최소 먼저 찾고
        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            dfs(i, 0, "" + i, true); // true: 최소
            visited[i] = false;
            if (min != null) break;
        }

        // 큰 수부터 돌면 최대 먼저 찾음
        for (int i = 9; i >= 0; i--) {
            visited[i] = true;
            dfs(i, 0, "" + i, false); // false: 최대
            visited[i] = false;
            if (max != null) break;
        }

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int prev, int idx, String num, boolean findMin) {
        if (idx == op.length) {
            if (findMin) min = num;
            else max = num;
            return;
        }

        for (int i = (findMin ? 0 : 9); (findMin ? i <= 9 : i >= 0); i += (findMin ? 1 : -1)) {
            if (visited[i]) continue;

            if (op[idx] == '<' && prev >= i) continue;
            if (op[idx] == '>' && prev <= i) continue;

            visited[i] = true;
            dfs(i, idx + 1, num + i, findMin);
            visited[i] = false;

            if ((findMin && min != null) || (!findMin && max != null)) return; // 조기 종료
        }
    }
}
