package week12.HouseRobber;

public class MJ {
    class Solution {
        public int rob(int[] nums) {
            int[] dp = new int[nums.length+1];

            if(nums.length==1){
                return nums[0];
            }
            if(nums.length==2){
                return Math.max(nums[0], nums[1]);
            }
            dp[0]=nums[0];
            dp[1]=nums[1];
            dp[2] = Math.max(nums[0]+nums[2], nums[1]);

            for(int i=3;i<nums.length;i++){
                dp[i] = Math.max(nums[i]+dp[i-3], nums[i]+dp[i-2]);
            }

            // for(int i=0;i<nums.length;i++){
            //     System.out.println(dp[i]);
            // }
            return Math.max(dp[nums.length-1], dp[nums.length-2]);
        }
    }
}
