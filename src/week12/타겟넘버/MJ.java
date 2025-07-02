package week12.타겟넘버;

public class MJ {
    class Solution {
        int answer = 0;
        public void dfs(int i, int target, int[] numbers, int now){
            if(i==numbers.length && now==target){
                answer++;
                return;
            }
            if(i<=numbers.length-1){
                dfs(i+1, target, numbers, now+numbers[i]);
                dfs(i+1, target, numbers, now-numbers[i]);
            }
        }
        public int solution(int[] numbers, int target) {
            dfs(0, target, numbers,  0);
            return answer;
        }
    }
}
