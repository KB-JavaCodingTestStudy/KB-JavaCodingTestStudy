import java.io.*;
import java.util.*;

public class Main {
    static int[] parent; //union find 용 부모 배열

    // Find 연산
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // Union 연산
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;
        parent[rootB] = rootA;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] edges = new int[e][3]; // 간선 정보 저장
        parent = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 간선 입력 
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken()); // from
            edges[i][1] = Integer.parseInt(st.nextToken()); // to
            edges[i][2] = Integer.parseInt(st.nextToken()); // weight
        }

        // 가중치 기준 오름차순 정렬
        Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));

        int total = 0;
        int count = 0;

        //정렬된 간선 리스트 순회하면서 최소 신장 트리 구성
        for (int i = 0; i < e; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int weight = edges[i][2];

            if (union(from, to)) {  //사이클이 생기지 않으면
                total += weight;    //간선 가중치 추가
                count++;            //간선 수 추가
                if (count == v - 1) break;  //간선이 정점-1 이면 모든 정점 연결 -> 완성
            }
        }

        System.out.println(total);
    }
}
