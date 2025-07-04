package week11.MaximalSquare;

/* ================================================================
 *
 * Problem  : MaximalSquare_
 * Date     : 2025년 06월 25일
 * 
 * ================================================================
 */

public class Hye {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int r = matrix.length;
            int c = matrix[0].length;

            int[][] dp = new int[r+1][c+1];

            int max = 0;

            for(int i = 1; i <= r; i++){
                for(int j = 1; j<= c; j++){
                    if(matrix[i-1][j-1] == '1'){
                        dp[i][j] = Math.min(
                                Math.min(dp[i-1][j], dp[i][j-1]),
                                dp[i-1][j-1]
                        ) + 1;
                    }

                    max = Math.max(max, dp[i][j]);
                }
            }

            return max * max;

        }
    }
}
