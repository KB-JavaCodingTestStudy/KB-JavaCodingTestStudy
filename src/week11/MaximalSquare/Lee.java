class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = Math.min(n, m);

        int[][][] dp = new int[l][n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dp[0][i][j] = matrix[i][j] - '0';
            }
        }

        int k = 0;
        for(; k < l - 1; k++) {

            boolean end = true;

            for(int i = 0; i < n - k - 1; i++) {
                for(int j = 0; j < m - k - 1; j++) {

                    int sum = 0;

                    for(int a = 0; a < 2; a++) {
                        for (int b = 0; b < 2; b++) {
                            sum += dp[k][i+a][j+b];
                        }
                    }

                    if(sum == 4) {
                        dp[k+1][i][j] = 1;
                        end = false;
                    }
                }
            }

            if(end)
                break;
        }

        if (k != 0)
            return (k+1) * (k+1);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (dp[0][i][j] == 1)
                    return 1;
            }
        }

        return 0;
    }
}
