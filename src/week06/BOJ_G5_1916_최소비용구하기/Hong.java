import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 도시 수
        int m = Integer.parseInt(br.readLine()); // 버스 수

        // 인접 리스트
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[] { b, c });
        }

        // 출발지와 도착지
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 최소 비용 테이블
        int[] dist = new int[n + 1];
        Arrays.fill(dist, MAX);
        dist[start] = 0;

        // PriorityQueue: [도시 번호, 누적 비용]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] { start, 0 });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int now = current[0];
            int cost = current[1];

            if (dist[now] < cost) continue;

            for (int[] next : graph.get(now)) {
                int nextCity = next[0];
                int nextCost = next[1];

                if (dist[nextCity] > dist[now] + nextCost) {
                    dist[nextCity] = dist[now] + nextCost;
                    pq.offer(new int[] { nextCity, dist[nextCity] });
                }
            }
        }

        System.out.println(dist[end]);
    }
}
