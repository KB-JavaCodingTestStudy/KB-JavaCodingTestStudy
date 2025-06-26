import java.util.*;

class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        

        if(n>=3) {
            dp[2] = Math.min(dp[1], dp[0]) + cost[2];
            for(int i=3; i<n; i++) {
                dp[i] = dp2(i) + cost[i];
            }
        }

        return Math.min(dp[n-1], dp[n-2]);

    }

    int dp2(int n) {
        return Math.min(dp[n-1], dp[n-2]);
    }
}
