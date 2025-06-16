package week10.타겟넘버;

/* ================================================================
 *
 * Problem  : 타겟넘버
 * Date     : 2025년 06월 16일
 *
 * ================================================================
 */

public class Hye {
    class Solution {
        int count;
        public int solution(int[] numbers, int target) {
            count = 0;

            dfs(numbers, target, 0, numbers.length, 0);

            return count;
        }

        void dfs(int[] numbers, int target, int depth, int n, int sum){
            if(depth == n){
                if(sum == target){
                    count++;
                }
                return;
            }

            dfs(numbers, target, depth+1, n, sum + numbers[depth]);
            dfs(numbers, target, depth+1, n, sum - numbers[depth]);
        }
    }
}
