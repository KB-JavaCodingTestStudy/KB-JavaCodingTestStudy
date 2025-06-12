package algorithm.BOJ14437_LCA;

import java.util.*;
import java.io.*;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  -
 *
 * # 입력
 *  - line 1: N (노드 개수)
 *  - N-1 lines: a b (서로 연결된 노드)
 *  - line N+1: M (LCA를 확인하려는 노드 쌍의 개수)
 *  - M lines: p q (LCA를 확인하려는 노드 쌍)
 *
 * # 출력
 *  - M개의 줄에 걸쳐 p q의 LCA를 한줄에 하나씩 출력
 *
 * 💻 알고리즘 설계
 *  - 이진 상승 : 각 노드의 1,2,4,8,16,32... 번째 조상 노드를 미리 저장하여 자신의 n번째 조상을 빠르게 찾을 수 있도록 합니다. (ex : 5번째 조상은 1 + 4번째 조상을 조합하여 찾을 수 있습니다.
 *  - 이진 상승을 활용하여 p, q의 공통 조상을 빠르게 찾습니다.
 *  - p가 q보다 더 깊이가 깊다고 하면, q와 깊이가 같은 p의 조상을 찾습니다. 만약 이 p의 조상이 q와 같다면 그것이 LCA가 됩니다.
 *  - 만약 같은 깊이까지 조상을 찾았는데 서로 다른 노드라면, 다시 거슬러 올라가서 공통 조상을 찾습니다.
 *  - 정확히는, 공통 조상이 되지 않는 선에서 (즉, LCA 바로 자식 노드까지) 거슬러 올라갑니다. 이렇게 하는 이유는 LCA가 아닌 LCA의 조상까지 거슬러 올라가버릴 수도 있기 때문입니다.
 *  - LCA의 바로 자식 노드까지 거슬러 올라가면, (즉, 바로 위 조상 노드 = 부모노드가 공통 조상이 된다면) 이제 그들의 부모 노드를 찾아 반환합니다. 그 노드가 LCA 입니다.
 *
 * ================================================================
 */

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int MAX = 17; // log2(100000) ≈ 16.6
    static int[][] parent; // parent[i][j]: i번 노드의 2^j번째 조상
    static int[] depth;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        tree = new List[n + 1];
        depth = new int[n + 1];
        parent = new int[n + 1][MAX + 1];

        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            tree[a].add(b);
            tree[b].add(a);
        }

        // 초기화: 깊이와 1단계 부모 정보
        calcDepth(1, 0);

        // 이진 상승 테이블 구성
        for (int j = 1; j <= MAX; j++) {
            for (int i = 1; i <= n; i++) {
                parent[i][j] = parent[parent[i][j - 1]][j - 1];
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int q = Integer.parseInt(input[1]);

            bw.write(findLCA(p, q) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 루트 노드 부터 dfs를 통해 차례대로 깊이를 계산하는 함수 (루트 깊이 : 1)
    static void calcDepth(int node, int par) {
        depth[node] = depth[par] + 1;
        parent[node][0] = par;
        for (int next : tree[node]) {
            if (next != par) {
                calcDepth(next, node);
            }
        }
    }

    static int findLCA(int a, int b) {
        // a가 더 깊은 쪽이 되도록 순서 변경
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // a가 b와 같은 깊이가 될 때 까지 조상을 거슬러 올라감. (해당 조상을 a에 저장)
        for (int i = MAX; i >= 0; i--) {
            if (depth[a] - (1 << i) >= depth[b]) {
                a = parent[a][i];
            }
        }

        // 같은 깊이가 되었는데 그게 같은 노드라면? 그것이 곧 LCA
        if (a == b) return a;

        // a,b의 공통 조상이 없는 범위까지 최대한 거슬러 올라간다.
        for (int i = MAX; i >= 0; i--) {
            if (parent[a][i] != 0 && parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        // 바로 부모 노드가 공통 조상이 된다.
        return parent[a][0];
    }
}
