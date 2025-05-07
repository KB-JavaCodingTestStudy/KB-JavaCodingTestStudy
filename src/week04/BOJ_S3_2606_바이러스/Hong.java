import java.io.*;
import java.util.*;

public class Hong {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int m = Integer.parseInt(br.readLine()); // 연결 수

        visited = new boolean[n + 1];

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);

        System.out.println(count - 1); // 1번 컴퓨터 제외
    }

    static void dfs(int node) {
        visited[node] = true;
        count++;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
