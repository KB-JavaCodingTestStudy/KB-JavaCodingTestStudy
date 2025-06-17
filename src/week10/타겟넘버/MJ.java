package week10.타겟넘버;

public class MJ {
    class Solution {
        int answer = 0;
        public void backtraking(int[] numbers, int target, int n, int sum){
            if(n==numbers.length){
                if(sum==target){
                    answer++;
                }
                return;
            }
            backtraking(numbers, target, n+1, sum+numbers[n]);
            backtraking(numbers, target, n+1, sum-numbers[n]);
        }
        public int solution(int[] numbers, int target) {
            answer = 0;
            backtraking(numbers, target, 0, 0);
            return answer;
        }
    }
}
