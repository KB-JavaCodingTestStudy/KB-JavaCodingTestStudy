package algorithm.BOJ11657타임머신;

import java.util.*;
import java.io.*;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 각 도시 (노드)와 버스 노선 (간선)이 있다. 버스는 도시에서 도시로 이동하며 걸리는 시간이 0 또는 음수일 수도 있다.
 *  - 1번 도시에서 출발하여 각 도시로 향하는 최단 시간을 구해야 한다.
 *
 * # 입력
 *  - line 1: n m (n: 도시 (노드) 개수, m: 버스 노선 (간선) 개수)
 *  - line 2~m+1: a b c (a: 출발 도시, b: 도착 도시, c: 걸리는 시간)
 *
 * # 출력
 *  - 1번 도시에서 출발해 각 도시로 가는 가장 빠른 시간을 한줄에 하나씩 출력
 *  - 음의 사이클이 있다면 -1 출력
 *
 * 💻 알고리즘 설계
 *  - 특정 노드 하나에서 출발하여 다른 모든 노드까지의 최단 거리를 구해야 하고, 가중치가 음수인 간선이 있으므로 벨만 포드를 사용해야 한다.
 *
 * ================================================================
 */

public class Main {

    static class Edge {
        int a, b, c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean updated = false;
            for (Edge edge : edges) {
                if (dist[edge.a] != Long.MAX_VALUE && dist[edge.a] + edge.c < dist[edge.b]) {
                    dist[edge.b] = dist[edge.a] + edge.c;
                    updated = true;
                }
            }
            if (!updated) break;
        }

        boolean isCycle = false;
        for (Edge edge : edges) {
            if (dist[edge.a] != Long.MAX_VALUE && dist[edge.a] + edge.c < dist[edge.b]) {
                isCycle = true;
                break;
            }
        }

        if (isCycle) {
            bw.write("-1\n");
        } else {
            for (int i = 2; i <= n; i++) {
                if (dist[i] == Long.MAX_VALUE)
                    dist[i] = -1;

                bw.write(dist[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
