package week08.BOJ_G4_2458_키순서;

/* ================================================================
 *
 * Problem  : 키 순서_G4
 * Author   : 김혜지
 * Date     : 2025년 06월 04일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - 1번부터 N번까지 번호가 붙여져 있는 학생들에 대해 두 학생끼리 키를 비교한 결과의 일부가 주어져 있다.
 *   ( N명의 학생들의 키는 모두 다르다. )
 * -> 이 결과를 통해 자신의 키가 몇 번째인지 알 수 있는 학생들이 모두 몇 명인지 계산하여 출력하는 프로그램을 작성해야 한다.
 *
 * # 입력
 * - 1행 : 학생들의 수 N, 두 학생 키를 비교한 횟수 M
 * - M행 : 두 학생의 키를 비교한 결과를 나타내는 N보다 작거나 같은 서로 다른 양의 정수 a와 b
 *         ( a인 학생이 b인 학생보다 키가 작다. )
 *
 * # 출력
 * - 자신의 키가 몇 번째인지 알 수 있는 학생이 모두 몇 명인지 출력
 *
 * 💻 알고리즘 설계
 * - 모든 쌍에 대해 경로가 존재(간접적으로 비교 가능한지)하는지 확인 ( a < b 이고 b < c 이면 a < c )
 * - 각 학생마다 자신보다 작은 학생 수 + 자신보다 큰 작은 학생 수 = N - 1이라면 자신의 키 순서를 알 수 있음
 *
 * ⏰ 시간복잡도
 * - O(N^3)
 * ================================================================
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n+1][n+1];
        for(int i = 1; i <= m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                    }
                }
            }
        }

        int result = 0;
        for(int i = 1; i <= n; i++){
            int count = 0;
            for(int j = 1; j <= n; j++){
                if(graph[i][j] == 1 || graph [j][i] == 1){
                    count++;
                }
            }

            if(count == n - 1){
                result++;
            }
        }

        System.out.println(result);
    }
}
