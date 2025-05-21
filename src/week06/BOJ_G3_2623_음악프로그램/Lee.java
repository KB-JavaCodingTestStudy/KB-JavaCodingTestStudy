package study.week06.BOJ_G3_2623_음악프로그램;

import java.util.*;
import java.io.*;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 05월 21일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - n명의 가수와 m명의 보조 PD가 있다. 각 가수들은 1~n번의 번호가 매겨져 있다.
 *  - 각 보조 PD가 정한 가수들의 출연 순서를 모두 만족하는 출연 순서를 번호로 출력한다. 만약 불가능하면 0을 출력한다.
 *
 * # 입력
 *  - line 1: n m (n: 음악프로그램, m: 보조 PD)
 *  - line 2~m+1: k a1 a2 ... ak (k: 해당 라인에 나올 가수의 수, a1~ak: k명의 가수 (출연 순서))
 *
 * # 출력
 *  - 출연 순서대로 가수 번호를 한줄에 하나씩 출력
 *
 * 💻 알고리즘 설계
 *  - 처음 보조 PD들이 정한 순서에 따라 방향 그래프를 구성한다.
 *  - 해당 그래프를 토대로 위상 정렬 알고리즘을 수행하여 순서를 따로 저장해둔다.
 *  - 만약 도중에 사이클이 생기는 경우, 0을 출력하고 프로그램을 종료한다.
 *  - 사이클 없이 위상 정렬을 모두 마치면 저장해둔 순서에 따라 가수 번호를 차례로 출력한다.
 *
 * ================================================================
 */

public class Main {
    public static void main(String[] args) throws IOException {

        //////////////////////// input ////////////////////////

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        List<Integer>[] list = new List[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int[] degree = new int[n+1];    // 진입 차수

        // m번 반복
        for (; m > 0; m--) {
            int[] order = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for(int i = 1; i < order.length - 1; i++) {
                list[order[i]].add(order[i+1]);
                degree[order[i+1]]++;
            }
        }

        //////////////////////// imple ////////////////////////

        // 진입 차수 0인 정점을 큐에 넣고 시작한다.
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(degree[i] == 0) {
                q.add(i);
            }
        }

        // 결과를 순서대로 저장할 배열
        int[] result = new int[n];

        // n번 반복
        for(int i = 0; i < n; i++) {
          
            // 다 돌기전에 큐가 비어버리면 사이클 발생
            if(q.isEmpty()) {
                System.out.println(0);
                return;
            }

            int cur = q.poll();
            result[i] = cur;  // 현재 방문한 노드 (진입 차수 == 0)를 결과 배열에 순서대로 저장. 

            // 연결된 다음 노드의 진입 차수 - 1, 만약 0이 되면 큐에 넣음. 
            for(int next : list[cur]) {
                degree[next]--;

                if(degree[next] == 0) {
                    q.add(next);
                }
            }
        }

        // 결과 출력
        for(int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }

        br.close();
    }
}

