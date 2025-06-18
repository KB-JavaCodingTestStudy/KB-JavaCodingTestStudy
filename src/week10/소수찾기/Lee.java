
/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 숫자로만 이루어진 문자열 numbers가 주어집니다. 
 *  - numbers 의 숫자들만을 사용해서 수를 만들 수 있습니다.
 *  - 이렇게 만들 수 있는 수들 중에서 소수가 몇개나 되는지 세어야 합니다.
 *  
 * # 입력
 *  - numbers: String
 *
 * # 반환
 *  - 소수의 개수
 *
 * 💻 알고리즘 설계
 *  - 순열 (permutations)를 응용해서 주어진 숫자들로 만들 수 있는 모든 수를 찾습니다.
 *  - 그리고 그들 각각에 대해 소수 판별을 실시합니다.
 *  - 주의할 점은 일반적인 순열과 달리, 주어진 숫자를 모두 사용하지 않은 수도 모두 판별해야 합니다.
 *  - numbers 안에 같은 숫자가 여러개 들어있는 경우, 11 처럼 같은 수가 여러번 나올 수 있고, 0이 들어있는 경우 '011' 과 '11' 등 실제로는 같은 수가 다른 경우로 나올 수 있습니다.
 *  - 따라서 이런 중복 방지를 위해 HashSet에 int형으로 형변환하여 저장한 뒤, 마지막에 그 안의 수를 세는 식으로 진행합니다.
 *
 * ================================================================
 */

import java.util.*;
import java.io.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        dfs("", new boolean[numbers.length()], numbers);
        
        return set.size();
    }
    
    public void dfs(String cur, boolean[] isUsed, String numbers) {
        
        if (cur.length() > 0 && isPrime(Integer.parseInt(cur))) {
            set.add(Integer.parseInt(cur));
        }
            
        
        if (cur.length() == isUsed.length)
            return;
        
        for(int i = 0; i < isUsed.length; i++) {
            
            if (isUsed[i]) continue;
            
            isUsed[i] = true;
            
            String next = cur + numbers.charAt(i);
            dfs(next, isUsed, numbers);
            
            isUsed[i] = false;
        }
        
        return;
    }
    
    boolean isPrime(int n) {
        
        if (n <= 1)
            return false;
        
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        
        return true;
    }
}
