package week11.minCostClimbingStairs;

/* ================================================================
 *
 * Problem  : Min Cost Climbing Stairs_
 * Date     : 2025년 06월 25일
 * 
 * ================================================================
 */

import java.util.HashMap;
import java.util.Map;

public class Hye {
    class Solution {
        Map<Integer, Integer> memo = new HashMap<>();

        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;

            return dfs(cost, n);


        }

        int dfs(int[] cost, int n ){
            if( n==0 || n == 1) return 0;

            if (memo.containsKey(n)) return memo.get(n);

            int next = Math.min(dfs(cost, n-1) + cost[n-1], dfs(cost, n-2) + cost[n-2]);
            memo.put(n, next);


            return next;
        }
    }

    // Memoization X -> 시간 초과
    // class Solution {
    //     public int minCostClimbingStairs(int[] cost) {
    //         int n = cost.length;
    
    //         return dfs(cost, n);
    //     }
    
    //     int dfs(int[] cost, int n){
    //         if(n==0 || n== 1) return 0;
    //         return Math.min(dfs(cost, n-1) + cost[n-1], dfs(cost, n-2) + cost[n-2]);
    //     }
    // }
}
