import java.io.*;
import java.util.*;

public class Roa {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 가수 수
        int m = Integer.parseInt(st.nextToken()); // PD 수

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n + 1]; // 진입차수 배열

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            if (count == 0) continue;

            int from = Integer.parseInt(st.nextToken());
            for (int j = 1; j < count; j++) {
                int to = Integer.parseInt(st.nextToken());
                graph.get(from).add(to);
                inDegree[to]++;
                from = to;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            for (int next : graph.get(current)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 사이클 존재 여부 확인
        if (result.size() != n) {
            System.out.println(0);
        } else {
            for (int singer : result) {
                System.out.println(singer);
            }
        }
    }
}
