package week08.BOJ_G4_11657_타임머신;

/* ================================================================
 *
 * Problem  : 타임머신_G4
 * Author   : 김혜지
 * Date     : 2025년 06월 04일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - N개의 도시와 M개의 버스가 있다.
 * - 각 버스는 한 도시에서 다른 도시로 이동하며 이동 시간이 주어진다. ( 이동 시간은 0이거나 음수일 수도 있다. )
 * -> 1번 도시에서 나머지 모든 도시로 가는 가장 빠른 시간을 구해야 한다.
 *
 * # 입력
 * - 1행 : 도시 수 N, 버스 노선 수 M
 * - M행 : 버스 노선 정보 (시작 도시, 도착 도시, 시간)
 *
 * # 출력
 * - 1번 도시에서 각 도시까지의 최단 시간 출력
 * - 도달할 수 없거나 음수 사이클이 존재하면 -1 출력
 *
 * 💻 알고리즘 설계
 * 1. 초기화 : 시작 도시(1)에서 자기 자신까지의 거리를 0으로 설정하고, 나머지 도시까지의 거리를 무한대로 설정한다.
 * 2. 최단 경로 갱신
 *    : 모든 간선에 대해 최단 거리를 갱신한다. ( N - 1번 반복 : 최단 경로는 최대 N - 1개의 간선을 가질 수 있기 때문 )
 * 3. 음수 사이클 감지
 *    : N - 1번 반복 후에 모든 간선에 대해 다시 한 번 최단 경로를 갱신한다.
 *      만약 다시 갱신이 일어난다면 음수 사이클이 존재하는 것이다.
 *
 * ⏰ 시간복잡도
 * - O(NM)
 * ================================================================
 */

import java.io.*;
import java.util.*;

public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<int[]> edges = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int[] eTemp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edges.add(eTemp);
        }

        long[] dist = new long[n+1]; // 1번부터
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0; // 1번 노드 시작

        for(int i = 0; i < n -1 ; i++){
            for(int[] edge : edges){
                int from = edge[0];
                int to = edge[1];
                int w = edge[2];

                if(dist[from] != Long.MAX_VALUE && dist[from] + w < dist[to]){
                    dist[to] = dist[from] + w;
                }
            }
        }

        boolean hasMinus = false;
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            if (dist[from] != Long.MAX_VALUE && dist[from] + weight < dist[to]) {
                hasMinus = true;
                break;
            }
        }

        if(hasMinus){
            System.out.println(-1);
        }else{
            for(int i = 2; i <= n; i++){
                if(dist[i] != Long.MAX_VALUE){
                    System.out.println(dist[i]);
                }else{
                    System.out.println(-1);
                }
            }
        }
    }
}
