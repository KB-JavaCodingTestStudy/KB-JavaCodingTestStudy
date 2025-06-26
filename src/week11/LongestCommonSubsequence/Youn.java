class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int [][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){   
            char t1 = text1.charAt(i-1);
            for(int j=1;j<=m;j++){
                char t2 = text2.charAt(j-1);
                dp[i][j]=(t1==t2)
                ?dp[i-1][j-1]+1
                :Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}
