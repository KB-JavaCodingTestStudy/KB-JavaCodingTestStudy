package study.week04.BOJ_S3_2606_바이러스;

import java.util.*;
import java.io.*;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 05월 01일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 컴퓨터들이 네트워크로 연결되어 있으며, 그 컴퓨터의 수와 서로 연결된 컴퓨터 쌍이 주어진다.
 *  - 1번 컴퓨터로 인해 바이러스가 퍼져, 네트워크로 연결된 모든 컴퓨터가 감염된다.
 *  - 1번을 제외하고 바이러스에 감염되는 다른 컴퓨터의 수를 파악해야 한다.
 *
 *  # 입력
 *  - line 1 : 컴퓨터의 수 n (노드 개수)
 *  - line 2 : 직접 연결된 컴퓨터 쌍의 수 k (간선 개수)
 *  - line 3~ : 직접 연결된 컴퓨터 번호 쌍 (각 줄 마다)
 *
 *  # 출력
 *  - 감염된 컴퓨터의 수 (1번 제외) 출력
 *
 * 💻 알고리즘 설계
 * - 입력을 잘 받아서 인접 리스트를 생성한다.
 * - 1번 노드부터 시작하여 bfs를 돌리고, 방문한 노드의 수를 카운트 한다.
 * - 1번을 제외하고 카운트 한 수를 출력한다.
 *
 * ================================================================
 */

public class Lee {
    public static void main(String[] args) throws IOException {

        /**
         * 입력받은 값으로 graph (인접 리스트) 및 visited 생성 & 초기화
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[n+1];

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int k = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        /**
         * 1번 노드에서 출발하여 bfs로 visited 기록
         */
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);   // 1번 노드 큐에 삽입
        visited[1] = true;  // visited 기록
        int cnt = 0;    // 바이러스에 감염된 컴퓨터의 수 (1번 컴퓨터는 미포함!)

        while(!queue.isEmpty()) {
            int cur = queue.remove();

            for(int next : graph.get(cur)) {
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }

        bw.write(cnt + "");

        bw.flush();

        br.close();
        bw.close();
    }
}
