import java.io.*;
import java.util.*;

public class Main {
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 

        List<Edge> edges = new ArrayList<>();

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, cost));
        }

        // 벨만-포드 초기화
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0; // 1번 도시에서 시작

        boolean negativeCycle = false;

        // 정점 수 - 1번 반복
        for (int i = 1; i <= n; i++) {
            for (Edge e : edges) {
                if (dist[e.from] == INF) continue;

                // 더 짧은 경로 발견 시 갱신
                if (dist[e.to] > dist[e.from] + e.cost) {
                    dist[e.to] = dist[e.from] + e.cost;

                    // N번째 반복에서도 값이 갱신되면 → 음수 사이클 존재
                    if (i == n) {
                        negativeCycle = true;
                    }
                }
            }
        }

        if (negativeCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                if (dist[i] == INF) {
                    System.out.println(-1);
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }
     static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
