import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); 


        List<Integer>[] graph = new ArrayList[n + 1];
        int[] indegree = new int[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        // PD가 정한 순서 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());

            for (int j = 1; j < count; j++) {
                int next = Integer.parseInt(st.nextToken());
                graph[prev].add(next);
                indegree[next]++;
                prev = next;
            }
        }

        // 위상 정렬 시작_0부터
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int current = q.poll();
            result.add(current);

            for (int next : graph[current]) {
                indegree[next]--;
                if (indegree[next] == 0) q.add(next);
            }
        }

        // 사이클이 있는 경우 result의 크기가 n보다 작음
        if (result.size() != n) {
            System.out.println(0);
        } else {
            for (int singer : result) {
                System.out.println(singer);
            }
        }
    }
}
