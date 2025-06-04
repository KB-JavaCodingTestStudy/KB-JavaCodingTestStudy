package week08.BOJ_S1_11403_경로찾기;

/* ================================================================
 *
 * Problem  : 경로 찾기_S1
 * Author   : 김혜지
 * Date     : 2025년 06월 04일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - 가중치가 없는 방향 그래프 G가 주어졌을 때,
 * - 모든 정점(i,j)에 대해서 i에서 j로 가는 길이가 양수인 경로가 있는지 없는지 구하는 프로그램 작성
 *
 * # 입력
 * - 1행 : 정점의 개수 N
 * - N행 : 그래프의 인접 행렬 ( 1인 경우에 i에서 j로 가는 간선 존재, 0인 경우 존재 X)
 *
 * # 출력
 * - N개의 행에 걸쳐 인접행렬 형식으로 출력, 정점 i에서 j로 가는 길이가 양수인 경로가 있으면 1로 없으면 0으로 출력
 *
 * 💻 알고리즘 설계
 * - i -> j로 바로 갈 수 없어도, i -> k -> j로 갈 수 있다면 i -> j로 갈 수 있다.

 * ⏰ 시간복잡도
 * - O(N^3)
 * ================================================================
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        for(int i = 0; i < n; i++){
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(graph[i][k] == 1 && graph[k][j] ==1){
                        graph[i][j] = 1;
                    }
                }
            }
        }

        for(int[] g : graph){
            for(int i = 0; i < n; i++){
                System.out.print(g[i] + " ");
            }
            System.out.println();
        }
    }
}
