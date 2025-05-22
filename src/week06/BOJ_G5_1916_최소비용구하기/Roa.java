import java.io.*;
import java.util.*;

public class Roa {
    static class Edge implements Comparable<Edge> {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static List<Edge>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시 수
        int m = Integer.parseInt(br.readLine()); // 버스 수

        graph = new ArrayList[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to   = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end   = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int now = cur.to;
            int nowCost = cur.cost;

            if (dist[now] < nowCost) continue;

            for (Edge next : graph[now]) {
                int totalCost = dist[now] + next.cost;
                if (dist[next.to] > totalCost) {
                    dist[next.to] = totalCost;
                    pq.add(new Edge(next.to, totalCost));
                }
            }
        }
    }
}
