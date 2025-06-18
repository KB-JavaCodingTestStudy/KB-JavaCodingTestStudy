
/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  -  
 *  - 
 *  - 
 *  
 * # 입력
 *  - 
 *
 * # 반환
 *  - 
 *
 * 💻 알고리즘 설계
 *  - 
 *  - 
 *  - 
 *  - 
 *  - 
 *
 * ================================================================
 */

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] numbers, int target) {
        
        int count = dfs(numbers, 0, target, 0);
        
        return count;
    }
    
    public int dfs(int[] numbers, int depth, int target, int sum) {
        if(depth == numbers.length) {
            if (sum == target)
                return 1;
            
            return 0;
        }
        
        int count = 0;
        
        count += dfs(numbers, depth + 1, target, sum + numbers[depth]);
        count += dfs(numbers, depth + 1, target, sum - numbers[depth]);
        
        return count;
    }
}
