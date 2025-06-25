import java.util.*;

class Solution {
    int[] dp;

    public int climbStairs(int n) {
        dp = new int[n+1];

        dp[1] = 1;
        if(n>=2) dp[2] = 2;

        if(n>=3) {
            for(int i=3; i<=n; i++) {
                dp[i] = dp2(i-1) + dp2(i-2);
            }
        }

        return dp[n];
    }

    public int dp2(int n) {
        return dp[n];
    }
}
