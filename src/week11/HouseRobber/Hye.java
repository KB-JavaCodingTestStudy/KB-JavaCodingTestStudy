package week11.HouseRobber;

/* ================================================================
 *
 * Problem  : HouseRobber_
 * Date     : 2025년 06월 25일
 * 
 * ================================================================
 */

import java.util.HashMap;
import java.util.Map;

public class Hye {
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            if (n == 1) return nums[0];

            Map<Integer, Integer> memo = new HashMap<>();
            memo.put(0, nums[0]);
            memo.put(1, Math.max(nums[0], nums[1]));

            for(int i = 2; i < n; i++){
                int p = memo.get(i-2) + nums[i];
                int s = memo.get(i-1);
                memo.put(i, Math.max(p, s));
            }
            return memo.get(n-1);
        }
    }
}
