
/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 주어진 리스트의 수들을 모두 사용해서 재배열하여 만들 수 있는 모든 순열을 구합니다. 
 *  
 * # 입력
 *  - 배열 하나 (띡)
 *
 * # 반환
 *  - ㅈㄱㄴ
 *
 * 💻 알고리즘 설계
 *  - 빈 리스트를 준비합니다.
 *  - 각 단계마다, 이전 단계의 리스트에서 사용되지 않은 수를 뒤에 차례로 추가한 새로운 리스트를 생성합니다.
 *  - 이 과정에서 백트레킹을 활용합니다. 수가 사용됐는지 여부를 visited와 유사하게 기록합니다.
 *  - 백트레킹으로 되돌아올때는 다시 이 사용 여부를 해제합니다. 
 *  - 리스트의 size가 처음 주어진 리스트와 같다면 이를 정답 리스트에 추가합니다. 
 *
 * ================================================================
 */

import java.util.*;
import java.io.*;

class Solution {

    public List<List<Integer>> answer;

    public List<List<Integer>> permute(int[] nums) {
        
        boolean[] isUsed = new boolean[nums.length];
        answer = new ArrayList<>();

        dfs(new ArrayList<>(), isUsed, nums);

        return answer;
    }

    public void dfs(List<Integer> cur, boolean[] isUsed, int[] nums) {
        if(cur.size() == nums.length) {
            answer.add(new ArrayList<>(cur));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(isUsed[i]) continue;

            isUsed[i] = true;

            List<Integer> next = new ArrayList<>(cur);
            next.add(nums[i]);
            dfs(next, isUsed, nums);
            
            isUsed[i] = false;
        }
    }
}
