
/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 주어진 수들을 덧셈, 뺄셈을 통하여 target 으로 만들 수 있는지 확인합니다.
 *  - 덧셈, 뺄셈의 위치가 다르면 서로 다른 방법으로 간주하여, target으로 만들 수 있는 방법의 수를 구합니다.
 *  
 * # 입력
 *  - numbers: int[]
 *  - target: int
 *
 * # 반환
 *  - target을 만들 수 있는 방법의 수
 *
 * 💻 알고리즘 설계
 *  - 주어진 수를 차례대로 더하거나 뺀 값을 이진트리 처럼 생각하여 가지를 뻗어 나갑니다. 
 *  - 맨 마지막 수 까지 모두 더하거나 빼면서 이진트리를 완성한다고 생각하고 그 리프 노드의 값을 모두 확인하여 target이 되는 것의 수만 카운팅합니다.
 *  - 실제로는 이 과정을 dfs (백트레킹) 형식으로 재귀적으로 확인합니다. 
 *
 * ================================================================
 */

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] numbers, int target) {
        
        return dfs(numbers, 0, target, 0);
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
