package BOJ.Gold;

import java.io.*;
import java.util.*;

/* ================================================================
 *
 * Problem  : BOJ 11437 - LCA (최소 공통 조상)
 * Author   : 김로아
 * Date     : 2025-06-12
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - N개의 노드로 구성된 트리에서 두 노드의 최소 공통 조상(LCA)을 구하는 문제
 *
 * # 입력
 * - 첫 줄: N (노드 개수, 2 ≤ N ≤ 50,000)
 * - 다음 N-1줄: 트리 간선 정보 (양방향 연결)
 * - 그 다음 M (질의 개수, 1 ≤ M ≤ 10⁴)
 * - 다음 M줄: 공통 조상을 찾을 두 노드 쌍 (u, v)
 *
 * # 출력
 * - 각 질의마다 한 줄씩 최소 공통 조상 출력
 *
 * 💻 알고리즘 설계
 * - DFS로 부모 정보와 각 노드의 깊이(depth) 배열을 미리 설정
 * - 이후 두 노드를 같은 깊이로 맞춘 후, 위로 동시에 이동하면서 LCA 탐색
 *
 * ⏰ 시간복잡도
 * - DFS 탐색: O(N)
 * - 질의 처리: O(N)
 *
 * ================================================================
 */

public class Roa {
    static int N, M;
    static List<Integer>[] tree;
    static int[] parent;   // 각 노드의 부모
    static int[] depth;    // 각 노드의 깊이
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 간선 입력 (양방향)
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        parent = new int[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        // 루트 노드(1번)부터 DFS 시작하여 parent, depth 채움
        dfs(1, 0);

        // 질의 처리
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append('\n');
        }

        System.out.print(sb);
    }

    // DFS로 depth, parent 배열 초기화
    static void dfs(int curr, int d) {
        visited[curr] = true;
        depth[curr] = d;
        for (int next : tree[curr]) {
            if (!visited[next]) {
                parent[next] = curr;
                dfs(next, d + 1);
            }
        }
    }

    // 최소 공통 조상 찾기 (단순 역추적 방식)
    static int lca(int a, int b) {
        // 깊이 같아질 때까지 위로 이동
        while (depth[a] > depth[b]) a = parent[a];
        while (depth[b] > depth[a]) b = parent[b];

        // 공통 조상 만날 때까지 동시 이동
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}
