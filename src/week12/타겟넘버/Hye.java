package week12.타겟넘버;

public class Hye {
    class Solution {
        int count = 0;
        public int solution(int[] numbers, int target) {

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

            return;
        }
    }
}
