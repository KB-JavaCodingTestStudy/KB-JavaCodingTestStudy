package week11.minCostClimbingStairs;

public class MJ {
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int[] DP = new int[cost.length+1];
            DP[0] = cost[0];
            DP[1] = cost[1];

            for(int i=2;i<cost.length;i++){
                DP[i] = Math.min(DP[i-1], DP[i-2]) + cost[i];
            }
            DP[cost.length] = Math.min(DP[cost.length-1], DP[cost.length-2]);
            return DP[cost.length];
        }
    }
}
