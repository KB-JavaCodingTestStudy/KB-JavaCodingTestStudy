import java.io.*;
import java.util.*;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 각 번호가 매겨진 도시가 있고, 그 사이를 이동하는 비용이 주어진다.
 *  - 출발지에서 도착지까지 이동하는데 드는 최소 비용을 구한다.
 *  - 전형적인 다익스트라 문제
 *
 * # 입력
 *  - line 1: n (도시 개수)
 *  - line 2: m (버스 개수 - 갈 수 있는 수단)
 *  - line 3~m+2: a b c (a: 출발지 번호, b: 도착지 번호, c: 버스 비용)
 *  - line m+3: s e (s: 출발지 번호, e: 도착지 번호)
 *
 *
 * # 출력
 *  - s에서 e로 이동하기 위한 최소 비용
 *
 * 💻 알고리즘 설계
 *  -
 *
 *
 * ================================================================
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<int[]>[] map = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for(; m > 0; m--) {
            String[] input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            map[a].add(new int[] {b, c});
        }

        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        int[] cost = dijkstra(map, s);

        System.out.println(cost[e]);

        br.close();
    }

    static int[] dijkstra(List<int[]>[] map, int s) {
        int n = map.length;

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[s] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{s, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            int curVertex = cur[0];
            int curCost = cur[1];

            // 이미 curCost 보다 작은 값으로 dist에 갱신된 상태
            if(cost[curVertex] < curCost) continue;

            for(int[] edge : map[curVertex]) {
                int nextVertex = edge[0];
                int nextCost = edge[1];

                if (cost[nextVertex] > cost[curVertex] + nextCost) {
                    cost[nextVertex] = cost[curVertex] + nextCost;
                    pq.offer(new int[]{nextVertex, cost[nextVertex]});
                }
            }
        }

        return cost;
    }
}
