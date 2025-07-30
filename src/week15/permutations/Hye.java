package week15.permutations;

/* ================================================================
 *
 * Problem  : permutations_
 * Date     : 2025년 07월 30일
 * 
 * ================================================================
 */

import java.util.ArrayList;
import java.util.List;

public class Hye {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            int n = nums.length;

            List<List<Integer>> result = new ArrayList<>(); // 결과
            List<Integer> path = new ArrayList<>(); // 현재까지의 경로
            boolean[] visited = new boolean[n]; // 방문 배열

            dfs(result, path, visited, nums); // 백트래킹

            return result; // 결과 반환

        }

        void dfs(List<List<Integer>> result, List<Integer> path, boolean[] visited, int[] nums){
            if(path.size() == nums.length){ // 모두 방문했을 때 결과 리스트에 저장
                result.add(new ArrayList<>(path));
                return;
            }

            for(int i = 0; i < nums.length; i++){
                if(visited[i]) continue; // 방문 안했을 경우 현재 경로에 추가
                visited[i] = true;
                path.add(nums[i]);

                dfs(result, path, visited, nums); // 재귀 호출

                path.remove(path.size() - 1); // 백트래킹
                visited[i] = false;
            }
        }
    }
}
