class Solution {
    public int rob(int[] nums) {
        //도둑의 집 털기
        //두 집을 연속해서 털면 경찰 출동
        //주의할 점 : index out of bound 인덱스 범위 주의

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if(n>=2) {
            dp[1] = Math.max(nums[0], nums[1]);
            for(int i=2; i<n; i++) {
                dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
            }
        }
        return dp[n-1];
    }
}
