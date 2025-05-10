package study.week05.BOJ_S1_1697_숨바꼭질;

import java.util.*;
import java.io.*;

public class Lee {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        if (n >= k) {
            bw.write((n - k) + "");

            bw.flush();

            bw.close();
            br.close();

            return;
        }

        int[] dist = new int[k * 2];
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(cur + 1 < k * 2 && dist[cur + 1] == 0) {
                dist[cur + 1] = dist[cur] + 1;
                q.add(cur + 1);
            }

            if(cur - 1 >= 0 && dist[cur - 1] == 0) {
                dist[cur - 1] = dist[cur] + 1;
                q.add(cur - 1);
            }

            if(cur * 2 < k * 2 && dist[cur * 2] == 0) {
                dist[cur * 2] = dist[cur] + 1;
                q.add(cur * 2);
            }

            if(dist[k] != 0) {
                bw.write("" + dist[k]);

                bw.flush();
                bw.close();
                br.close();

                return;
            }
        }

    }
}
