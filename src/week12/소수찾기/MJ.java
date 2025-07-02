package week12.소수찾기;

import java.util.HashSet;
import java.util.Set;

public class MJ {
//    ❤️❤️
    class Solution {
        boolean[] visited;
        Set<Integer> set = new HashSet<>();
        public void dfs(String numbers, String making){
            if(making.length() != 0){
                set.add(Integer.parseInt(making));
            }

            for(int i=0;i<numbers.length();i++){
                if(!visited[i]){
                    visited[i]=true;
                    dfs(numbers, making+numbers.charAt(i));
                    visited[i]=false;
                }
            }
        }

        public boolean isPrime(int n){
            if(n<=1){
                return false;
            }
            for(int i=2;i*i<=n;i++){
                if(n%i==0){
                    return false;
                }
            }
            return true;
        }
        public int solution(String numbers) {
            int answer = 0;
            visited= new boolean[numbers.length()];
            String first = "";
            dfs(numbers,  first);
            for(int i:set){
                if(isPrime(i)){
                    answer++;
                }
                System.out.println(i);
            }

            return answer;
        }
    }
}
