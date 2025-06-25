package week11.climbingStairs;

/* ================================================================
 *
 * Problem  : ClimbingStairs_
 * Date     : 2025년 06월 25일
 * 
 * ================================================================
 */

import java.util.HashMap;
import java.util.Map;

public class Hye {
    class Solution {
        public Map<Integer, Integer> map = new HashMap<>();

        public int climbStairs(int n) {
            return dfs(n);
        }

        public int dfs(int s){
            if(s==0) return 1;
            else if(s<0) return 0;
            if(map.containsKey(s)) return map.get(s);

            int temp = dfs(s-1) + dfs(s-2);
            map.put(s, temp);
            return temp;
        }
    }

    // dfs(5)
    // ├── dfs(4)
    // │   ├── dfs(3)
    // │   │   ├── dfs(2)
    // │   │   │   ├── dfs(1)
    // │   │   │   │   ├── dfs(0) → 1
    // │   │   │   │   └── dfs(-1) → 0
    // │   │   │   └── dfs(0) → 1
    // │   │   └── dfs(1)
    // │   │       ├── dfs(0) → 1
    // │   │       └── dfs(-1) → 0
    // │   └── dfs(2) → 메모된 값 사용
    // ├── dfs(3) → 메모된 값 사용
    
    
    
    //              dfs(5)
    //            /       \
    //        dfs(4)       dfs(3)
    //        /   \         /   \
    //    dfs(3) dfs(2)  dfs(2) dfs(1)
    //   ..  ..  ..  ..  ..  ..  ..  ..  
}
