import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int max = 100001;
        boolean[] visited = new boolean[max];  //리스트 x, 배열로 방문 체크
        int[] time = new int[max];   //시간체크

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == target) {
                System.out.println(time[now]);
                return;
            }

            int[] next = {now - 1, now + 1, now * 2};
            for (int nx : next) {
                if (nx >= 0 && nx < max && !visited[nx]) {
                    q.add(nx);
                    visited[nx] = true;
                    time[nx] = time[now] + 1;
                }
            }
        }
    }
}
