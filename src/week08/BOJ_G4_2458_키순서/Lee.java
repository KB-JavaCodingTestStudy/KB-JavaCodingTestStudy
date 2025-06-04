import java.util.*;
import java.io.*;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - n명의 학생들 중 일부 학생들의 키를 비교한 결과가 주어진다.
 *  - 자신의 키가 몇번째로 큰지 확실하게 알 수 있는 학생이 누구인지 알아낸다.
 *
 * # 입력
 *  - line 1: n m
 *  - line 2~m+1: a b (b학생이 a학생보다 키가 크다는 것을 나타냄)
 *
 * # 출력
 *  - 키 순서를 확실히 알 수 있는 학생의 수
 *
 * 💻 알고리즘 설계
 *  - 처음 주어진 입력으로 인접 행렬을 생성한다. (간선 방향은 키가 작은 학생에서 큰 학생 쪽으로)
 *  - 노드 간 이동 가능하면 1, 아니면 0을 저장한다.
 *  - 플로이드 워셜을 통해 이동 가능한 모든 노드쌍을 찾는다.
 *  - 특정 노드 k에 대해 k로 이동 가능한 노드와, k에서 이동 가능한 노드 수를 합한 것이 n-1 이라면 키 순서를 확실하게 알 수 있다. 이 경우 카운트한다.
 *
 * ================================================================
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] graph = new int[n+1][n+1];

        for(; m > 0; m--) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph[a][b] = 1;
        }

        // 플로이드 워셜 돌면서 거리 갱신
        for(int c = 1; c <= n; c++) {
            for(int s = 1; s <= n; s++) {
                for(int e = 1; e <= n; e++) {
                    if(graph[s][c] + graph[c][e] == 2)
                        graph[s][e] = 1;
                }
            }
        }

        int cnt = 0;

        for(int k = 1; k <= n; k++) {
            int sum = 0;
            for(int l = 1; l <= n; l++) {
                sum += graph[l][k];
                sum += graph[k][l];
            }

            if(sum == n-1)
                cnt++;
        }

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
