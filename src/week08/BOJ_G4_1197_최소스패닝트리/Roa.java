import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 경로 압축
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) parent[pa] = pb;
    }

    public static void Roa(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 간선 저장: [from, to, weight]
        int[][] edges = new int[E][3];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken()); // from
            edges[i][1] = Integer.parseInt(st.nextToken()); // to
            edges[i][2] = Integer.parseInt(st.nextToken()); // weight
        }

        // 가중치 기준 정렬
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));

        // Union-Find 초기화
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) parent[i] = i;

        int total = 0;
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];

            if (find(a) != find(b)) {
                union(a, b);
                total += cost;
            }
        }

        System.out.println(total);
    }
}
