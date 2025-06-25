package week11.UniquePaths;

/* ================================================================
 *
 * Problem  : 광고삽입_Medium
 * Author   : 김혜지
 * Date     : 2025년 06월 25일
 * 
 * ================================================================
 * 📌 문제 분석 요약
 * - m x n 격자에서 좌측 상단 (0,0)에서 우측 하단 (m-1,n-1)까지 이동하는 경로의 개수를 구하는 문제
 * - 한 번에 오른쪽 또는 아래쪽으로만 이동 가능
 * - 장애물 없음, 단순한 조합 경로 계산 문제
 *
 * # 입력
 * - m: 세로 칸 수 (1 ≤ m ≤ 100)
 * - n: 가로 칸 수 (1 ≤ n ≤ 100)
 *
 * # 출력
 * - 오른쪽 아래까지 이동할 수 있는 유일한 경로의 수
 *
 * 💻 알고리즘 설계
 * - dp[i][j] = (i,j)까지 올 수 있는 경로의 수
 * - 첫 행과 첫 열은 모두 1로 초기화
 * - 점화식: dp[i][j] = dp[i-1][j] + dp[i][j-1] // 왼쪽에서 오는 경로 수(dp[i][j-1]) + 위에서 오는 경로 수(dp[i-1][j]) 의 합
 *
 * ⏰ 시간복잡도
 * - O(MN)
 * ================================================================
 */

import java.util.Arrays;

public class Hye {
    // DP - 2차원 배열
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] memo = new int[m][n];

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(i==0 || j == 0){
                        memo[i][j] = 1;
                        continue;
                    }

                    memo[i][j] = memo[i][j-1] + memo[i-1][j];

                }
            }

            for(int i = 0; i < m; i++){
                System.out.println(Arrays.toString(memo[i]));
            }
            return memo[m-1][n-1];
        }
    }

    // DP - 1차원 배열
    class Solution2 {
        public int uniquePaths(int m, int n) {
            int[] memo = new int[n];

            Arrays.fill(memo, 1);

            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                    memo[j] = memo[j-1] + memo[j]; // memo[j-1]: 현재 행에서 전 열(왼쪽 칸)의 경로 수
                                                   // memo[j]: 이전 행에서 같은 열(위쪽 칸)의 경로 수
                }
            }

            return memo[n-1];
        }
    }
}
