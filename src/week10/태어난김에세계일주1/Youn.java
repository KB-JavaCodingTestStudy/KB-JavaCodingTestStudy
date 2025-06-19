import java.util.*;
class Solution {
    static int max;
    static boolean[] visited;
    public int solution(int balance, int[][] countries) {
        max = Integer.MIN_VALUE;
        visited = new boolean[countries.length];
        recur(balance, countries, 0);
        
        return max;
    }
    public static void recur(int balance, int[][] countries, int count){
        if(balance <= 0){
            return;}

        for(int i=0;i<countries.length;i++){
            if(balance >= countries[i][1] && !visited[i]){
                visited[i]=true;            
                recur(balance - countries[i][0], countries, count+1);
                                    
                visited[i]=false;
            }            
        }
        max = Math.max(max, count);                            
    }
}
