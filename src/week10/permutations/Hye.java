package week10.permutations;

/* ================================================================
 *
 * Problem  : permutations_Medium
 * Date     : 2025년 06월 16일
 * 
 * ================================================================
 */

import java.util.*;

public class Hye {

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            int n = nums.length;

            List<List<Integer>> result = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            boolean[] visited = new boolean[n];

            dfs(result, path, visited, nums);

            return result;

        }

        void dfs(List<List<Integer>> result, List<Integer> path, boolean[] visited, int[] nums){
            if(path.size() == nums.length){
                result.add(new ArrayList<>(path));
                return;
            }

            for(int i = 0; i < nums.length; i++){
                if(visited[i]) continue;
                visited[i] = true;
                path.add(nums[i]);

                dfs(result, path, visited, nums);

                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}
