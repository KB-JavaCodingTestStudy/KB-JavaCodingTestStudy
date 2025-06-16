package week10.태어난김에세계일주1;

/* ================================================================
 *
 * Problem  : 태어난김에 세계일주1
 * Date     : 2025년 06월 16일
 * 
 * ================================================================
 */
public class Hye {
    class Solution {
        int max;

        public int solution(int balance, int[][] countries) {
            max = 0;

            boolean[] visited = new boolean[countries.length];
            dfs(visited, balance, countries, 0);

            return max;
        }

        void dfs(boolean[] visited, int balance, int[][] countries, int count){
            max = Math.max(max, count);

            for(int i = 0; i < countries.length; i++){
                if (visited[i]) continue;
                if(balance < countries[i][1]) continue;

                visited[i] = true;

                dfs(visited, balance - countries[i][0], countries, count + 1);

                visited[i] = false;

            }
        }
    }
}
