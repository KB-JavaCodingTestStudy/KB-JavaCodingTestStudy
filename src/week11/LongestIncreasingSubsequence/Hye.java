package week11.LongestIncreasingSubsequence;

/* ================================================================
 *
 * Problem  : Longest Increasing Subsequence_
 * Date     : 2025년 06월 25일
 * 
 * ================================================================
 */

import java.util.Arrays;

public class Hye {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int max = 1;

            int n = nums.length;

            int[] dp = new int[n];
            Arrays.fill(dp, 1);

            if(n == 0){
                return 0;
            }

            for(int i = 1; i < n; i++){
                for(int j = 0; j < i; j++){
                    if(nums[i] > nums[j]){
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }

            return max;

        }
    }
}
