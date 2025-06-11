import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 그래프 초기화
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 트리 연결 입력
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        depth = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        bfs(1); 

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append("\n");
        }

        System.out.print(sb);
    }


    static void bfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visited[root] = true;
        depth[root] = 0;
        parent[root] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : tree[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = now;
                    depth[next] = depth[now] + 1;
                    queue.add(next);
                }
            }
        }
    }


    static int lca(int a, int b) {
        // 먼저 깊이 맞추기
        while (depth[a] > depth[b]) a = parent[a];
        while (depth[b] > depth[a]) b = parent[b];

        // 공통 조상 찾기
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
}
