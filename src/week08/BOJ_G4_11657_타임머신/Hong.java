import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, time;

        Edge(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }

    static int N, M;
    static ArrayList<Edge> edges = new ArrayList<>();
    static long[] dist;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시 수
        M = Integer.parseInt(st.nextToken()); // 버스 수

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, time));
        }

        if (bellmanFord(1)) {
            // 음수 사이클 없음
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    System.out.println(-1);
                } else {
                    System.out.println(dist[i]);
                }
            }
        } else {
            // 음수 사이클 있음
            System.out.println(-1);
        }
    }

    static boolean bellmanFord(int start) {
        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // N - 1번 반복
        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.time) {
                    dist[edge.to] = dist[edge.from] + edge.time;
                }
            }
        }

        // 음수 사이클 검사
        for (Edge edge : edges) {
            if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.time) {
                return false; // 음수 사이클 존재
            }
        }

        return true;
    }
}
