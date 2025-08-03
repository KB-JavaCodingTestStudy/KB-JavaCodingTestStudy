import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    // 소수 판별 함수
    public boolean isPrime(int n) {
        if (n <= 1)
            return false;
        
        for(int d = 2; d <= Math.sqrt(n); d++) {
            if (n % d == 0)
                return false;
        }
        
        return true;
    }
    
    /** 완전 탐색 dfs 
     * cur : numbers의 숫자를 이어붙인 문자열
     * isUsed : visited 와 동일. 현재 탐색 분기에서 사용된 숫자인지 판별 
     * numbers : 처음 주어지는 숫자로 이루어진 문자열
     */
    public void dfs(String cur, boolean[] isUsed, String numbers) {
        
        // 현재까지 이어붙인 문자열 (숫자 형태)이 소수인지 판별하여 hashset에 추가 
        if (cur.length() > 0 && isPrime(Integer.parseInt(cur))) {
            set.add(Integer.parseInt(cur));
        }
        
        // 모든 숫자를 사용했다면 (= 길이가 numbers와 같아졌다면) 종료
        if (cur.length() == numbers.length())
            return;
        
        // 일단 numbers의 모든 숫자를 살펴본다.
        for (int i = 0; i < numbers.length(); i++) {
            
            // 사용된 숫자라면 건너뜀
            if (isUsed[i]) continue;
            
            // 아니라면 사용한다는 표시를 해주고
            isUsed[i] = true;
            
            // numbers 에서 해당 숫자를 꺼내 이어붙인다.
            String next = cur + numbers.charAt(i);
            
            // 재귀 호출을 통해 백트레킹 형식으로 탐색한다.
            dfs(next, isUsed, numbers);
            
            // 백트레킹 후, 사용했다는 표시를 지운다.
            isUsed[i] = false;
        }
        
        return;
    }
    
    public int solution(String numbers) {
        
        boolean[] isUsed = new boolean[numbers.length()];
        
        // 백트레킹으로 가능한 숫자 조합을 모두 탐색하고 그 중 소수만을 hashset에 담는다.
        dfs("", isUsed, numbers);
        
        // hashset에 담긴 숫자들의 개수를 세어 return 한다.
        return set.size();
    }
}
