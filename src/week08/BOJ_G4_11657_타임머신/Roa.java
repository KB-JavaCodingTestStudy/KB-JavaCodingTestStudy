import java.io.*;
import java.util.*;

class Edge {
    int from, to, cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class Roa {
    static final long INF = Long.MAX_VALUE;
    static int N, M;
    static List<Edge> edges = new ArrayList<>();
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 받기
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0; // 1번 도시에서 시작

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, cost));
        }

        // 벨만-포드 수행
        boolean negativeCycle = false;
        for (int i = 1; i <= N; i++) {
            for (Edge e : edges) {
                if (dist[e.from] != INF && dist[e.to] > dist[e.from] + e.cost) {
                    dist[e.to] = dist[e.from] + e.cost;
                    if (i == N) {
                        // N번째에도 갱신 발생 → 음수 사이클 존재
                        negativeCycle = true;
                    }
                }
            }
        }

        // 결과 출력
        if (negativeCycle) {
            System.out.println("-1");
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) System.out.println("-1");
                else System.out.println(dist[i]);
            }
        }
    }
}
