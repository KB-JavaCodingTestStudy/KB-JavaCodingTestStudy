package week12.태어난김에세계일주1;

public class MJ {
    class Solution {
        int max = 0;
        boolean[] visited;
        public void dfs(int balance, int visit, int[][] countries){
            max = Math.max(max, visit);
            for(int n=0;n<countries.length;n++){
                if(balance>=countries[n][1] && !visited[n]){
                    visited[n]=true;
                    dfs( balance-countries[n][0],visit+1,countries);
                    visited[n]=false;
                }
            }
        }
        public int solution(int balance, int[][] countries) {
            max = 0;
            visited = new boolean[countries.length+1];
            dfs( balance, 0, countries);
            int answer = max;
            return answer;
        }
    }
}
