import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시 
        int m = Integer.parseInt(br.readLine()); // 버스 

        // 인접 리스트 구성
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new int[]{to, cost});
        }

        // 출발-도착 도시
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 최소 비용 저장 배열
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // 다익스트라용 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int now = current[0];
            int costSoFar = current[1];

            if (costSoFar > dist[now]) continue;

            for (int[] next : graph[now]) {
                int nextCity = next[0];
                int nextCost = next[1];

                if (dist[nextCity] > dist[now] + nextCost) {
                    dist[nextCity] = dist[now] + nextCost;
                    pq.offer(new int[]{nextCity, dist[nextCity]});
                }
                
            }
        }

        System.out.println(dist[end]);
    }
}
