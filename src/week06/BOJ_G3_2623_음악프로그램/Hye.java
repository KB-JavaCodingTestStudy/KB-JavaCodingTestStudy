package week06.BOJ_G3_2623_음악프로그램;

/* ================================================================
 *
 * Problem  : 음악프로그램_G3
 * Author   : 김혜지
 * Date     : 2025년 05월 20일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - 프로그램에서 가수의 출연 순서 정하기
 * - 보조 PD마다 담당한 가수의 출연 순서를 정해오면
 *   프로그램 PD가 이 순서들을 모아 전체 가수의 순서를 정함
 *
 * # 입력
 * - 1행 : 가수의 수 N과 보조 PD의 수 M ( 가수 번호 : 1 ~ N )
 * - 2행~ : 맨 앞에는 보조 PD가 담당한 가수의 수, 그 뒤로 그 가수들의 순서
 * - ( 1 <= N <= 1000 ) & ( 1 <= M <= 100 )
 *
 * # 출력
 * - 프로그램 PD가 정한 전체 가수의 순서 ( 만약 불가능할 경우 0 출력 )
 *
 * 💻 알고리즘 설계
 * 1. 가수의 수 n과 보조 PD의 수 m 입력 받기
 * 2. 각 보조 PD가 담당하는 가수의 수를 입력 받고, 가수의 순서 정보를 그래프로 저장
 * 3. 차수가 0인 노드를 큐에 넣기
 * 4. 큐에서 꺼낸 노드를 result에 추가한 후, 해당 노드와 연결되어 있는 노드의 차수 감소
 * 5. 큐가 빌 때까지 3~4 반복
 * 6. 만약 result의 크기가 n 보다 작을 경우 - 사이클 존재 : 0 출력
 * 7. 이외에는 result안의 값 출력
 *
 * ⏰ 시간복잡도
 * - O(V+E)
 * -> V : 노드 수, E : 간선 수
 *
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
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] degree = new int[n+1];

        for(int i =  0; i < m ; i ++){
            st = new StringTokenizer(br.readLine());
            int nn = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());

            for(int j = 1; j < nn; j++){
                int temp = Integer.parseInt(st.nextToken());
                graph.get(prev).add(temp);
                degree[temp]++;
                prev = temp;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for(int i=1; i <=n; i++){
            if(degree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            result.add(now);

            for(int nx : graph.get(now)){
                degree[nx]--;
                if(degree[nx] == 0){
                    queue.add(nx);
                }
            }
        }

        if(result.size() != n ){
            System.out.println(0);
        }else{
            for(int num : result){
                System.out.println(num);
            }
        }
    }
}
