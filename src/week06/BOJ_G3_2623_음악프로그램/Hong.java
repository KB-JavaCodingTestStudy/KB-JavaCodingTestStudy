import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 가수 수
        int M = Integer.parseInt(br.readLine()); // PD 수

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        int[] indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int k = Integer.parseInt(br.readLine()); // 이 PD가 담당한 가수 수
            st = new StringTokenizer(br.readLine());

            int prev = Integer.parseInt(st.nextToken());
            for (int j = 1; j < k; j++) {
                int next = Integer.parseInt(st.nextToken());
                graph.get(prev).add(next);
                indegree[next]++;
                prev = next;
            }
        }

        // 위상 정렬 시작
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);

            for (int next : graph.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        if (result.size() == N) {
            for (int num : result) System.out.println(num);
        } else {
            System.out.println(0); // 불가능한 경우
        }
    }
}


