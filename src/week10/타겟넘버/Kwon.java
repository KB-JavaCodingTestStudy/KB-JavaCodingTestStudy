import java.util.*;

class Solution {
    int answer=0;
    int n;
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        dfs(0,0,0, target, numbers);
        dfs(0,1,0,target, numbers);
        return answer;
    }
    
    void dfs(int total, int bu, int i, int target, int[] numbers) {
        if(bu==0) {
            total += (-1*numbers[i]);
        } else {
            total += (1*numbers[i]);
        }
        
        if(i==n-1) {
            if(total == target)
                answer++;
        } else  {
            dfs(total, 0, i+1, target, numbers);
            dfs(total, 1, i+1, target, numbers);
        }
        
    }
}
