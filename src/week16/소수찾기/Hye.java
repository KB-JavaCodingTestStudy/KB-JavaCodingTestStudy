package week16.소수찾기;

/* ================================================================
 *
 * Problem  : 소수찾기_
 * Date     : 2025년 08월 04일
 * 
 * ================================================================
 */

import java.util.HashSet;
import java.util.Set;

public class Hye {
    class Solution {
        public int solution(String numbers) {
            Set<Integer> result = new HashSet<>(); // 집합 ( 중복 허용 X )
            boolean[] visited = new boolean[numbers.length()];

            dfs(numbers, "", result, visited); // DFS - 숫자 조합
            return result.size(); // 소수의 개수 반환
        }

        // DFS로 숫자 조합을 만들고, 소수일 경우 집합에 저장
        void dfs(String numbers, String path, Set<Integer> result, boolean[] visited){
            if(!path.isEmpty()){
                int temp = Integer.parseInt(path);
                if(isPrime(temp)){ // 현재 조합이 소수라면 result에 추가
                    result.add(temp);
                }
            }

            for(int i = 0; i <  numbers.length(); i++){
                if(!visited[i]){ // 사용하지 않은 숫자라면
                    visited[i] = true; // 숫자 i 사용
                    dfs(numbers, path + numbers.charAt(i), result, visited); // dfs 재귀 호출
                    visited[i] = false; // 숫자 i 미사용 - 백트래킹
                }
            }
        }

        // 소수 판별
        boolean isPrime(int num){
            if(num < 2) return false; // 0과 1은 소수 X
            for(int i = 2; i <= Math.sqrt(num); i++){
                if(num % i == 0) return false; // 약수가 존재하면 소수 X
            }
            return true; // 중간에 return false 되지 않으면 소수
        }
    }
}
