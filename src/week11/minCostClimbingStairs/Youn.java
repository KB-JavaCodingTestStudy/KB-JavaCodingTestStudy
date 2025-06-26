/** 문제 설명
- 계단 배열 `cost`이 주어짐.
- `0` 또는 `1`칸씩 올라갈 수 있음.
- 마지막 계단을 "밟지 않고도" 넘어가는 것이 가능.
- 도달하는 데 드는 최소 비용을 구하라.

접근 방식
- `p[i]`는 i번째 계단까지 도달하는 데 드는 최소 비용
- 끝에 도달하는 방법은 마지막 계단 또는 **마지막 전 계단**을 밟았을 때

👉 둘 중 더 적은 비용을 반환하면 됨

시간 복잡도: O(n)
  */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n =cost.length;
        int [] dp = new int[n+1];
        dp[0]=cost[0];
        dp[1]=cost[1];

        for(int i=2;i<=cost.length-1;i++){
            dp[i] = Math.min(dp[i-1], dp[i-2])+cost[i];
        }
        return Math.min(dp[n-1],dp[n-2]);
        
    }
}
