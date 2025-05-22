import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제 설명
가수의 수 n명과 m개의 PD가 정한 부분 순서가 주어질 때,
모든 순서를 만족하는 전체 순서를 구하는 위상 정렬 문제입니다.

접근 방식
각 순서를 그래프 간선으로 표현 (a → b 의미: a가 b보다 먼저)
degree[] 배열로 각 노드의 진입 차수 추적
진입 차수가 0인 노드부터 DFS 기반으로 위상 정렬 수행
순서 정렬이 불가능한 경우(사이클 존재): -1 출력

시간 복잡도
입력 처리: O(n + m)
위상 정렬: O(n + e) (e: 간선 수, 최대 n^2까지 가능)
→ 전체 시간 복잡도는 O(n + e)
 */
public class Main {
    static boolean[] visited;
    static int[] result;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new List[n+1];
        visited = new boolean[n+1];
        result = new int[n];
        count = 0;
        for (int i = 0; i <= n; i++)  graph[i] = new ArrayList<>();
        int [] degree = new int[n+1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int node = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());
                graph[node].add(next);
                degree[next]++;
                node = next;
            }
        }

        Queue<Integer> que= new ArrayDeque<>();
        for(int i=1;i<=n;i++) {
            if(degree[i]==0) que.offer(i);
        }
        for(int i = 1; i <= n; i++) {
            if(visited[i]) continue;
            if(degree[i] == 0) {
//                topologicalSort(i,degree,graph);
                que_tps(i, degree, graph, que);
            }
        }
        if(count != n) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int v: result) {
            sb.append(v).append("\n");
        }
        System.out.println(sb.toString());

    }
    public static void topologicalSort(int cur, int[]degree, List<Integer>[] graph) {
        List<Integer> list = graph[cur];
        visited[cur] = true;
        for(int next : list) {
            degree[next]--;
        }
        for(int i=1; i <= degree.length-1; i++) {
            if(visited[i]) continue;
            if(degree[i] == 0) {
                result[count++] = i;
                topologicalSort(i,degree,graph);
            }
        }
    }

    public static void que_tps(int cur, int[]degree, List<Integer>[] graph, Queue<Integer> que) {
        while (!que.isEmpty()) {
            int next = que.poll();
            visited[next] = true;
            result[count++] = next;
            for(int v : graph[next]) {
                degree[v]--;
                if(!visited[v] && degree[v] == 0) { que.offer(v);}
            }
        }
    }
}
