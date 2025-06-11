package week09.BOJ_G3_11437_LCA;

/* ================================================================
 *
 * Problem  : LCA_G3
 * Author   : 김혜지
 * Date     : 2025년 06월 11일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - N개의 정점으로 이루어진 트리가 주어진다. 트리의 각 정점은 1번부터 N번까지 번호가 매겨져 있으며, 루트는 1번이다.
 *   두 노드의 쌍 M개가 주어졌을 때, 두 노드의 가장 가까운 공통 조상이 몇 번인지 출력한다.
 *
 * # 입력
 * - 1행 : 노드의 개수 N
 * - N-1행 : 트리 상에서 연결된 두 정점
 * - 가장 가까운 공통 조상을 알고싶은 쌍의 개수 M
 * - M행 : 정점 쌍
 *
 * # 출력
 * - M개의 줄에 차례대로 입력받은 두 정점의 가장 가까운 공통 조상을 출력한다.
 *
 * ⏰ 시간복잡도
 * - O(MN)
 * ================================================================
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Hye {
    static List<Integer>[] tree;
    static int[] parent;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        parent = new int[N+1];
        depth = new int[N+1];

        dfs(1,0);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(M-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 길이를 같게 맞춤
            while(depth[a] > depth[b]) a = parent[a];
            while(depth[b] > depth[a]) b = parent[b];

            // 공통 조상 찾기
            while( a!=b ){
                a = parent[a];
                b = parent[b];
            }

            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int curr, int par){
        parent[curr] = par;
        depth[curr] = depth[par] + 1;

        for(int next : tree[curr]){
            if(next != par) {
                dfs(next, curr);
            }
        }
    }
}
