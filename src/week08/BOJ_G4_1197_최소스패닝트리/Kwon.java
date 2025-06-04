.
import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight; // 가중치 오름차순 정렬
        }
    }

    static int[] parent;

    // find 연산 - 대표 노드 찾기
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 경로 압축
    }

    // union 연산 - 두 노드를 연결
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false; // 이미 연결되어 있으면 false
        parent[rootB] = rootA; // 병합
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken()); // 정점 수
        int e = Integer.parseInt(st.nextToken()); // 간선 수

        List<Edge> edgeList = new ArrayList<>();
        parent = new int[v + 1];

        // 대표 노드 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

  
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(from, to, weight));
        }

        // 간선 정렬
        Collections.sort(edgeList);

        // MST 만들기
        int totalWeight = 0;
        int edgeCount = 0;

        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                totalWeight += edge.weight;
                edgeCount++;
                if (edgeCount == v - 1) break; // MST는 정점 수 - 1개의 간선만 필요
            }
        }

        System.out.println(totalWeight);
    }
}

