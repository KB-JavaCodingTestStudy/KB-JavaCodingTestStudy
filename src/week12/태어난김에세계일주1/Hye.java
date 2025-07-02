package week12.태어난김에세계일주1;

public class Hye {
    class Solution {
        int max;
        public int solution(int balance, int[][] countries) {
            max = 0;

            boolean[] visited = new boolean[countries.length];
            dfs(balance, countries, visited, 0);
            return max;
        }

        void dfs(int balance, int[][] countries, boolean[] visited, int count){
            if(balance < 0){
                return;
            }

            for(int i = 0; i < countries.length; i++){
                if(!visited[i] && balance >= countries[i][1]){
                    visited[i] = true;
                    dfs(balance-countries[i][0], countries, visited, count + 1);
                    visited[i] = false;
                }
            }
            max = Math.max(max, count);
            return;
        }
    }
}
