package study.week05.BOJ_S1_1697_숨바꼭질;

import java.util.*;
import java.io.*;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 05월 11일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 출발 지점 n과 도착 지점 k가 주어진다.
 *  - 현재 지점을 x라고 할 때, x-1, x+1, 2x 중 하나를 선택해 이동하여 최단 횟수로 k에 도달해야 한다.
 *
 * # 입력
 *  - line 1: n k
 *
 * # 출력
 *  - n에서 출발하여 k에 도달하기 위한 최단 횟수 출력
 *
 * 💻 알고리즘 설계
 *  - n이 k보다 큰 경우 -> x-1을 사용해야만 도달할 수 있으므로 최단 횟수는 n - k로 결정된다.
 *  - 각 위치를 하나의 정점으로 생각하면, 현재 위치 x에서 x-1, x+1, 2x 중 하나의 정점으로 이동할 수 있는 그래프 문제가 된다.
 *  - 최단 거리를 찾는 문제이므로 bfs를 사용한다. 큐에 넣는것은 정점 번호가 될 것이며, visited 대신 dist를 사용하여 거리를 측정한다.
 *  - 각 정점까지의 거리를 측정할 dist 배열은 2k 크기면 충분하다. 그 이상은 n이 2x를 통해서 도달할 수 없기 때문이다.
 *
 * ================================================================
 */

public class Lee {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        // n이 k보다 크거나 같은 경우 : 거리는 n-k로 결정
        if (n >= k) {
            bw.write((n - k) + "");

            bw.flush();

            bw.close();
            br.close();

            return;
        }

        // dist 크기는 2k (그 이상은 2x를 통해 갈 필요가 없기 때문이다.)
        int[] dist = new int[k * 2];
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while(!q.isEmpty()) {
            int cur = q.poll();

            // x+1로 이동
            if(cur + 1 < k * 2 && dist[cur + 1] == 0) {
                dist[cur + 1] = dist[cur] + 1;
                q.add(cur + 1);
            }

            // x-1로 이동
            if(cur - 1 >= 0 && dist[cur - 1] == 0) {
                dist[cur - 1] = dist[cur] + 1;
                q.add(cur - 1);
            }

            // 2x로 이동
            if(cur * 2 < k * 2 && dist[cur * 2] == 0) {
                dist[cur * 2] = dist[cur] + 1;
                q.add(cur * 2);
            }

            // k까지의 거리가 측정됐다면 그 값을 리턴하고 종료
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
