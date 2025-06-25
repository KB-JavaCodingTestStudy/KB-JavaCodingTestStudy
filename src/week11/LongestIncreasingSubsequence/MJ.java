package week11.LongestIncreasingSubsequence;

public class MJ {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] DP= new int[nums.length];
            int Max=1;

            DP[0]=1;
            for(int i=1;i<nums.length;i++){
                for(int j=i-1;j>=0;j--){
                    if(nums[j]<nums[i]){
                        DP[i]=Math.max(DP[i], DP[j]);
                    }
                }
                DP[i]++;
                Max=Math.max(Max, DP[i]);
            }

            // for(int d:DP){
            //     System.out.print(d+" ");
            // }
            return Max;
        }
    }
}
