package week11.climbingStairs;

public class MJ {
    class Solution {
        int[] DP;
        public int climbStairs(int n) {
            DP = new int[n+1];

            DP[0]=1;
            DP[1]=1;

            for(int i=2;i<=n;i++){
                DP[i]=DP[i-1]+DP[i-2];
            }
            return DP[n];
        }
    }
}
