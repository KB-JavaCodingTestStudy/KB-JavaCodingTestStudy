package week04.BOJ_S3_2606_바이러스;

/* ================================================================
 *
 * Problem  : 바이러스_S3
 * Author   : 김혜지
 * Date     : 2025년 05월 07일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - 1번 컴퓨터에 웜 바이러스가 걸린 상태로, 1번 컴퓨터를 통해 감염되는 컴퓨터의 수 구하기
 *
 * # 입력
 * - 1행 : 컴퓨터의 수
 * - 2행 : 연결되어 있는 컴퓨터 쌍의 수
 * - 3행~ : 연결되어 있는 컴퓨터 쌍
 *
 * # 출력
 * - 바이러스에 걸리게 되는 컴퓨터의 수 출력
 *
 * 💻 알고리즘 설계
 * 1. HashMap을 이용하여 컴퓨퓨터 쌍(간선)의 정보를 인접 리스트로 변환한다.
 * 2. DFS를 이용하여 시작 노드(1)부터 시작하여 방문하지 않은 다음 노드를 찾는다.
 *    -> 이때 아직 방문하지 않은 노드를 찾았을 경우 count에 1을 더한다.
 * 3. count를 출력한다.
 *
 * ⏰ 시간복잡도
 * - O(N + M)
 * -> N - 정점의 수
 * -> M - 간선의 수
 * ================================================================
 */

import java.io.*;
import java.util.*;

public class Hye {
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int computer = Integer.parseInt(br.readLine());

        int connect = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1; i<= computer; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<connect; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Set<Integer> visited = new HashSet<>();

        dfs(graph, visited, 1);

        bw.write(count + "");
        bw.flush();
        bw.close();

        br.close();

    }

    public static void dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int curVertex){
        visited.add(curVertex);

        for(int nextVertex : graph.get(curVertex)){
            if(!visited.contains(nextVertex)){
                count++;
                dfs(graph, visited, nextVertex);
            }
        }
    }
}
