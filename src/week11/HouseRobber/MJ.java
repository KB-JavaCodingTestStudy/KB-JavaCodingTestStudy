package week11.HouseRobber;

public class MJ {
    class Solution {
        int[] DP;
        public int rob(int[] nums) {
            DP=new int[nums.length+1];

            if(nums.length==1){
                return nums[0];
            }
            if(nums.length==2){
                return Math.max(nums[0], nums[1]);
            }
            DP[0]=nums[0];
            DP[1]=nums[1];
            DP[2]=DP[0]+nums[2];

            for(int i=3;i<nums.length;i++){
                DP[i] = Math.max(DP[i-2], DP[i-3]) + nums[i];
            }

            return Math.max(DP[nums.length-2], DP[nums.length-1]);
        }
    }
}
