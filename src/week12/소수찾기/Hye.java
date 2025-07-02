package week12.소수찾기;

import java.util.HashSet;
import java.util.Set;

public class Hye {
    class Solution {
        Set<Integer> duple;
        public int solution(String numbers) {
            int n = numbers.length();

            duple = new HashSet<>();

            boolean[] visited = new boolean[n];
            dfs(numbers, "", n, visited);

            return duple.size();
        }

        void dfs(String numbers, String path, int n, boolean[] visited){
            if(!path.isEmpty()){
                isPrime(path);
            }

            for(int i = 0; i < n; i++){
                if(!visited[i]){
                    visited[i] = true;
                    dfs(numbers, path + numbers.charAt(i), n, visited);
                    visited[i] = false;
                }
            }
            return;
        }

        boolean isPrime(String now){
            int check = Integer.parseInt(now);
            if( check < 2) return false;
            for(int i = 2; i <= Math.sqrt(check); i++){
                if(check % i == 0){
                    return false;
                }
            }

            duple.add(check);

            return true;
        }
    }
}
