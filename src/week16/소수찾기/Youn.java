/**
접근 방식
1. 숫자 문자열에서 각 자리의 숫자를 조합하여 모든 순열 숫자를 만든다.
2. 각 숫자는 makeNums 재귀 함수로 DFS 탐색하며 조합된다.
3. 이미 확인한 숫자는 Set<Integer> prev를 통해 중복 체크하여 건너뛴다.
4. 만들어진 수가 소수인지 isPrime() 함수로 판별한다.
5. 중복되지 않고 소수라면 total++ 하여 최종 개수를 센다.

시간 복잡도 분석
1. numbers.length() = n일 때, 만들 수 있는 숫자 조합은 최대 n!개
2. 각 숫자는 최대 길이 n까지의 순열로 구성되며, 중복 숫자는 Set으로 제거
3. 매 숫자마다 isPrime()이 실행되며, 최대 수는 9999999 이하 → 약 O(√k)
4. 따라서 최악의 경우는 O(n! * √k)
n ≤ 7 이므로 현실적으로는 빠르게 실행됨 (DFS + 백트래킹으로 완전탐색)

참고 사항
"011" → 만들 수 있는 수: 0, 1, 10, 11, 101, 110 등
소수인 숫자만 카운트되며, 중복 제거 덕분에 11 등은 한 번만 센다.
0으로 시작하는 숫자도 정상적으로 처리됨.
*/


import java.util.*;
class Solution {
    static int total;
    static boolean[] visited;
    static Set<Integer> prev;
    public int solution(String numbers) {
        total = 0;
        visited = new boolean[numbers.length()];
        prev = new HashSet<>();
        makeNums(numbers, 0);
        return total;
    }
    static void makeNums(String numbers, int num){        
        if(isPrime(num) && !prev.contains(num)){
        prev.add(num);
          total++;  
        } 
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i]=true;            
                makeNums(numbers, (num*10)+(numbers.charAt(i)-'0'));
                visited[i]=false;
            }
        }
    }
    static boolean isPrime(int num){
        if(num == 0 || num ==1) return false;
        
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num %i == 0)return false;
        }
        return true;
    }
}
