package week10.twosum;

/* ================================================================
 *
 * Problem  : two sum_Easy
 * Date     : 2025년 06월 16일
 * 
 * ================================================================
 */

import java.util.*;

public class Hye {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int n = nums.length;

            int[][] index = new int[n][2];

            for(int i = 0; i < n; i++){
                index[i] = new int[]{nums[i], i};
            }

            Arrays.sort(index, (a, b) -> a[0] - b[0]);

            int left = 0;
            int right = nums.length - 1;

            while(left < right){
                int sum = index[left][0] + index[right][0];
                if(sum == target){
                    break;
                }else if(sum > target){
                    right--;
                }else{
                    left++;
                }
            }

            return new int[]{index[left][1], index[right][1]};
        }
    }
}
