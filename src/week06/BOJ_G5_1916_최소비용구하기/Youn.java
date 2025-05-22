import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제 설명: N개의 도시와 M개의 버스 정보가 주어질 때, 특정 시작 도시에서 도착 도시까지의 최소 비용을 구하는 문제입니다. (단방향, 가중치 있음)

입력 조건:
도시 수 N ≤ 1,000
버스 수 M ≤ 100,000

풀이 방식:
다익스트라 알고리즘(Dijkstra) 사용 (음수 간선 없음)
두 가지 방식 구현:
- recur_dijkstra: 재귀 기반
- pq_dijkstra: 우선순위 큐 기반

자료구조:
인접 리스트(List<Entity>[])로 그래프 구성
distance[] 배열로 최단 거리 저장
visited[] 배열로 중복 방문 방지
 */

public class N_1916 {
    static boolean[] visited;
    static class Entity implements Comparable<Entity> {
        int node;
        int dist;

        public Entity(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Entity o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n= Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Entity>[] list = new List[n+1];
        visited = new boolean[n+1];
        for(int i=0;i<=n;i++){
            list[i] = new ArrayList<>();
        }

        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            list[start].add(new Entity(end, dist));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        recur_dijkstra(list, distance,start);
        System.out.println(distance[end]);

//        System.out.println(pq_dijkstra(list, start, distance)[end]);
    }
    // 재귀 사용
    public static void recur_dijkstra(List<Entity>[] list, int [] distance, int cur){
        if(cur<0){
            return;
        }
        visited[cur] = true;
        for(Entity e: list[cur]){
            distance[e.node] = Math.min(distance[e.node], distance[cur] + e.dist);
        }
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=0;i<distance.length;i++){
            if(visited[i]){continue;}
            if(min > distance[i]){ min = distance[i]; idx = i;}
        }

        recur_dijkstra(list, distance, idx);
    }
    public static int[] pq_dijkstra(List<Entity>[] list, int start, int [] distance){
        PriorityQueue<Entity> pq = new PriorityQueue<>();
        pq.add(new Entity(start, 0));

        while(!pq.isEmpty()){
            Entity cur = pq.poll();
            if(visited[cur.node]) continue;
            if(distance[cur.node] < cur.dist) continue;

            visited[cur.node] = true;
            for(Entity next: list[cur.node]){
                distance[next.node] = Math.min(distance[next.node], distance[cur.node] + next.dist);
                pq.add(new Entity(next.node, distance[next.node]));
            }
        }
        return distance;
    }
}
