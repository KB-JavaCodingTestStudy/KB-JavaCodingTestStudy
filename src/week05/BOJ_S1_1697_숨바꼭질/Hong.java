import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int max = 1000001;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int subin = Integer.parseInt(st.nextToken());  
        int sister = Integer.parseInt(st.nextToken()); 

        int[] visited = new int[max];
        Arrays.fill(visited, -1);


        Queue<Integer> queue = new LinkedList<>();
        queue.offer(subin);
        visited[subin] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == sister) {
                System.out.println(visited[now]);
                return;
            }

            // 순간이동
            if (now * 2 < max && visited[now * 2] == -1) {
                visited[now * 2] = visited[now] + 1;
                queue.offer(now * 2);
            }

            // 뒤로
            if (now - 1 >= 0 && visited[now - 1] == -1) {
                visited[now - 1] = visited[now] + 1;
                queue.offer(now - 1);
            }

            // 앞으로
            if (now + 1 < max && visited[now + 1] == -1) {
                visited[now + 1] = visited[now] + 1;
                queue.offer(now + 1);
            }
        }
    }
}
