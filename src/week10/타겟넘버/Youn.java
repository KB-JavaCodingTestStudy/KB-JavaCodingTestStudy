//시간 복잡도:  O(2ⁿ)
import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers,0,target,0);
    }
    public int dfs(int [] numbers, int idx, int target, int sum){
        if(idx == numbers.length){
            if(target == sum) return 1;
            return 0;
        }
           
        return dfs(numbers, idx+1, target, sum+numbers[idx])
           +dfs(numbers, idx+1, target, sum-numbers[idx]);
    }
}


//DFS + Memoization : O(n × 2t) (t는 최대 sum 범위)
import java.util.*;

class Solution {
    static Map<String, Integer> map;
    public int solution(int[] numbers, int target) {
        map = new HashMap<>();
        return dfs(numbers, 0,target);
    }
    
    public static int dfs(int[] number, int idx, int target){
        String key = idx+","+target;
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        if(idx == number.length){
            return target==0?1:0;
        }
        
        int res =dfs(number, idx+1, target-number[idx])+
            dfs(number, idx+1, target+number[idx]);
        
        map.put(key, res);
        return res;
    }
}
