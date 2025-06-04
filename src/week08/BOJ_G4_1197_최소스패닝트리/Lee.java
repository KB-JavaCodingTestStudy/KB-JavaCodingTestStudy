package algorithm.BOJ1197최소스패닝트리;

import java.util.*;
import java.io.*;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 가중치 그래프에서 최소 신장 트리를 찾고 그 가중치 합을 구한다.
 *
 * # 입력
 *  - line 1: V E
 *  - line 2~E+1: a b c (노드 a, b를 연결하는 가중치 c인 간선을 의미)
 *
 * # 출력
 *  - 최소신장트리의 가중치 합
 *
 * 💻 알고리즘 설계
 *  - 크루스칼 알고리즘을 통해 최소 신장트리를 구하는 과정에서 가중치 합을 함께 계산한다.
 *  - ... 적을게 없는데?
 *
 * ================================================================
 */

public class Main {

    static int[] parent;

    static int find(int n) {
        if (parent[n] != n)
            parent[n] = find(parent[n]);

        return parent[n];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;

        if (a < b) {
            parent[b] = a;
        }
        else {
            parent[a] = b;
        }
    }

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

        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);

        parent = new int[V+1];
        for(int i = 1; i <= V; i++)
            parent[i] = i;

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.c, e2.c));
        for(int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            pq.add(new Edge(a, b, c));
        }

        int weight = 0;
        while(!pq.isEmpty()) {
            Edge e = pq.poll();

            if (find(e.a) == find(e.b)) continue;   // 사이클이므로 건너뛴다.

            union(e.a, e.b);
            weight += e.c;
        }

        bw.write(weight + "");
        bw.flush();

        bw.close();
        br.close();

    }
}
