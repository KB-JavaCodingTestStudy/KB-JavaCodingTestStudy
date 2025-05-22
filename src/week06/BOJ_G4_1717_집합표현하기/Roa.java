import java.io.*;
import java.util.*;

public class Roa {
    static int[] parent;

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA; 
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 집합 원소 개수
        int m = Integer.parseInt(st.nextToken()); // 연산 개수

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i; 
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());
            int a  = Integer.parseInt(st.nextToken());
            int b  = Integer.parseInt(st.nextToken());

            if (op == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.print(sb);
    }
}
