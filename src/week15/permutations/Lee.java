import java.util.*;

class Solution {

    public List<List<Integer>> answer;

    public List<List<Integer>> permute(int[] nums) {
        
        boolean[] isUsed = new boolean[nums.length];
        answer = new ArrayList<>();

        dfs(new ArrayList<>(), isUsed, nums);

        return answer;
    }

    public void dfs(List<Integer> cur, boolean[] isUsed, int[] nums) {
        if(cur.size() == nums.length) {          // nums를 모두 사용하여 그 개수와 같으면 
            answer.add(new ArrayList<>(cur));    // 정답 배열에 추가
            return;
        }

        for(int i = 0; i < nums.length; i++) {   // 일단 주어진 모든 숫자를 확인
            if(isUsed[i]) continue;              // 이미 사용된 숫자라면 건너뛴다

            isUsed[i] = true;                    // 사용한 것으로 간주하고 백트레킹 처리
          
            List<Integer> next = new ArrayList<>(cur);  // cur의 복사본 next를 만들고 
            next.add(nums[i]);                          // next에 사용되지 않은 숫자를 추가
            dfs(next, isUsed, nums);                    // 백트레킹
            
            isUsed[i] = false;                  // 다시 사용하지 않은 것으로 처리한다. (백트레킹 이므로)
        }
    }
}
