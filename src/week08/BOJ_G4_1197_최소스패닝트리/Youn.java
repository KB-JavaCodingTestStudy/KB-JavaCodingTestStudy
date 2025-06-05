package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
무방향 그래프에서 모든 정점을 연결하면서 간선의 가중치 합이 최소가 되도록 선택하는 MST 구하기
정점 개수 V와 간선 개수 E가 주어지고, 각 간선의 양 끝 정점과 가중치가 주어짐
MST를 구성하는 간선들의 가중치 총합을 출력

-우선순위 큐를 사용해 간선을 가중치 기준으로 정렬하여 저장한다.
- 유니온-파인드 알고리즘으로 두 정점이 연결되어 있지 않으면 연결하고 비용을 더한다.
- 간선이 n-1개가 될 때까지 반복해 MST를 구성하고, 총 비용을 출력한다.
 */
public class N_1197 {
    static PriorityQueue<Node> pq;
    static int[] connect;
    static class Node {
        int start, end, weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        pq= new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        connect = new int[n+1];
        for(int i=1; i<=n; i++){
            connect[i] = i;
        }

        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.add(new Node(start, end, weight));
        }

        int edges = 0;
        int total =0;
        while(edges<n-1){
            Node node = pq.poll();
            if(union(node.start, node.end)){
                total+=node.weight;
                edges++;
            }else continue;
        }
        System.out.println(total);

    }
    public static boolean union(int u, int v){
        int rootA = find(u);
        int rootB = find(v);

        if(rootA==rootB){return false;}

        connect[rootA]=rootB;
        return true;
    }
    public static int find(int u){
        if(connect[u]==u) return u;

        connect[u]=find(connect[u]);
        return connect[u];
    }
}
