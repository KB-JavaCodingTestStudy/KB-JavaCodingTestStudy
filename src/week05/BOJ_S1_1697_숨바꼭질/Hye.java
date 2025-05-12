package week05.BOJ_S1_1697_숨바꼭질;

/* ================================================================
 *
 * Problem  : 숨바꼭질_S1
 * Author   : 김혜지
 * Date     : 2025년 05월 12일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - 수빈이는 현재 점 N ( 0 <= N <= 100,000 )에 있고, 동생은 점 K ( 0 <= K <= 100,000 )에 위치
 * - 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1으로 이동, 순간이동을 한다면 1초 후에 2*X의 위치로 이동
 * - 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하기
 *
 * # 입력
 * - 1행 : 수빈이의 위치 N과 동생의 위치 K ( 0 <= N, K <= 100,000 )
 *
 * # 출력
 * - 수빈이가 동생을 찾는 가장 빠른 시간
 *
 * 💻 알고리즘 설계
 * 1. 수빈이의 위치 N과 동생의 위치 K 입력 받기
 * 2. 거리 배열 dist 생성 - 크기 100,001
 * 3. dist 배열을 -1(미방문)로 채운 후 현재 수빈이의 위치를 거리 0으로 설정
 * 4. BFS를 사용하여 가장 빠른 시간 구하기
 *
 * ⏰ 시간복잡도
 * - O(V+E) : V - 노드 수, E - 간선 수
 * ================================================================
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dist = new int[100001];
        Arrays.fill(dist, -1);
        dist[n] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur == k){
                System.out.println(dist[cur]);
                return;
            }

            for(int nx : new int[]{cur - 1, cur + 1, cur * 2}){
                if(nx >=0 && nx <= 100000 && dist[nx] == -1){
                    dist[nx] = dist[cur] + 1;
                    queue.offer(nx);
                }

            }
        }
    }
}
