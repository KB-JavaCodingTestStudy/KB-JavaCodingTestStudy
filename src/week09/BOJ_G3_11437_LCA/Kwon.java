import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> tree = new ArrayList<>();
    static int[] parent;
    static int[] depth;
    static int[] visited;
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n+1; i++) {
            tree.add(new ArrayList<>());
        }
        parent = new int[n + 1];
        depth = new int[n + 1];
        visited = new int[n + 1];

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        dfs(1,0);

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(lca(a,b));
        }
    }

   //깊이, 부모 저장을 위한 dfs 코드
    static void dfs(int current, int d) {
        visited[current] = 1;
        depth[current] = d;

        for(int next : tree.get(current)) {
            if(visited[next] == 0) {
                parent[next] = current;
                dfs(next, d + 1);
            }
        }
    }

    //최소 공통 조상 구하기
    static int lca(int a, int b) {
      
        //두 노드의 깊이가 같을 때 까지, 더 깊은 노드를 한 칸 높이기
        while(depth[a] > depth[b]) { a = parent[a]; }
        while (depth[b] > depth[a]) { b = parent[b]; }

        //두 노드의 높이가 같으면, 두 노드가 만날 때까지 위로 전진
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
      
        //a == b
        return a;
    }
}

