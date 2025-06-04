import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    // Find 연산
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // Union 연산
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;
        parent[rootB] = rootA;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] edges = new int[e][3]; // 간선 정보 저장
        parent = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 간선 입력 
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken()); // from
            edges[i][1] = Integer.parseInt(st.nextToken()); // to
            edges[i][2] = Integer.parseInt(st.nextToken()); // weight
        }

        // 가중치 기준 정렬
        Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));

        int total = 0;
        int count = 0;

        for (int i = 0; i < e; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int weight = edges[i][2];

            if (union(from, to)) {
                total += weight;
                count++;
                if (count == v - 1) break;
            }
        }

        System.out.println(total);
    }
}
