package week10.subsets;

/* ================================================================
 *
 * Problem  : subsets_Medium
 * Date     : 2025년 06월 16일
 * 
 * ================================================================
 */

import java.util.ArrayList;
import java.util.List;

public class Hye {
    class Solution {
        int n;
        public List<List<Integer>> subsets(int[] nums) {
            n = nums.length;
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> path = new ArrayList<>();

            dfs(result, path, 0, nums);

            return result;
        }

        void dfs(List<List<Integer>> result, List<Integer> path, int start, int[] nums){
            result.add(new ArrayList<>(path));

            for(int i = start; i < n; i++){
                path.add(nums[i]);

                dfs(result, path, i+1, nums);

                path.remove(path.size() -1);
            }
        }
    }
}
