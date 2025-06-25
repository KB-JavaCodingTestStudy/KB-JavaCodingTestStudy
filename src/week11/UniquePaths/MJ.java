package week11.UniquePaths;

public class MJ {
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] DP = new int[m+1][n+1];

            DP[0][1] = 1;

            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    DP[i][j] = DP[i-1][j] + DP[i][j-1];
                }
            }

            return DP[m][n];
        }
    }
}
