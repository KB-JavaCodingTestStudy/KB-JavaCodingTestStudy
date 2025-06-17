package week10.태어난김에세계일주1;

public class MJ {
    class Solution {
        int max = 0;
        boolean[] visited;
        public void aroundTheWorld(int balance, int[][] countries, int count){
            max = Math.max(max, count);

            for(int i=0;i<countries.length;i++){
                int[] country = countries[i];
                if(!visited[i]&& balance>=country[1]){
                    visited[i]=true;
                    aroundTheWorld(balance-country[0], countries, count+1);
                    visited[i]=false;
                }
            }
        }
        public int solution(int balance, int[][] countries) {
            max = 0;
            visited = new boolean[countries.length];

            aroundTheWorld(balance, countries, 0);

            return max;
        }
    }
}
