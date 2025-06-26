class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxCount = 0;

        for(int i = 0; i < nums.length; i++) {
            
            int cnt = 0;

            for(int j = 0; j < i; j++) {
                if(nums[j] >= nums[i]) continue;

                cnt = Math.max(cnt, dp[j]);
            }

            dp[i] = cnt + 1;
            maxCount = Math.max(maxCount, dp[i]);
        }

        for(int i : dp)
            System.out.print(i + " ");

        return maxCount;
    }
}
