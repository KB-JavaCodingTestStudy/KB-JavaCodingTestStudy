class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length+2];
        
        dp[0]=0;
        dp[1]=nums[0];
        dp[2]=nums[1];
        for(int i=3;i<=nums.length;i++){
            dp[i] = Math.max(dp[i-2], dp[i-3])+nums[i-1];
        }
        return Math.max(dp[nums.length],dp[nums.length-1]);
    }
}
