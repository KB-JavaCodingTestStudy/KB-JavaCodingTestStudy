package week10.소수찾기;

/* ================================================================
 *
 * Problem  : 소수 찾기
 * Date     : 2025년 06월 16일
 * 
 * ================================================================
 */

import java.util.*;

public class Hye {

    class Solution {
        public int solution(String numbers) {
            String[] nums = numbers.split("");
            int n = nums.length;

            Set<Integer> result = new HashSet<>();
            boolean[] visited = new boolean[n];

            dfs(nums, "", visited, result);

            return result.size();
        }

        void dfs(String[] nums, String current, boolean[] visited, Set<Integer> result) {
            if (!current.isEmpty()) {
                int temp = Integer.parseInt(current);
                if (isPrime(temp)) {
                    result.add(temp);
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) continue;

                visited[i] = true;
                dfs(nums, current + nums[i], visited, result);
                visited[i] = false;
            }
        }

        boolean isPrime(int num) {
            if (num < 2) return false;

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }

}
