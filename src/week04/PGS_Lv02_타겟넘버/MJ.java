package week04.PGS_Lv02_타겟넘버;

import java.util.*;

public class MJ {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); 

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int sum = current[0];
            int idx = current[1];
            
            if (idx == numbers.length) {
                if (sum == target) {
                    answer++;
                }
            } else {
                queue.offer(new int[]{sum + numbers[idx], idx + 1});
                queue.offer(new int[]{sum - numbers[idx], idx + 1});
            }
        }
        
        return answer;
    }
}


// public class MJ {
//     public int solution(int[] numbers, int target) {
//         int answer = 0;
        
//         Map<Integer, Integer> map = new HashMap<>();
//         map.put(numbers[0], map.getOrDefault(numbers[0], 0) + 1);
//         map.put(-numbers[0], map.getOrDefault(-numbers[0], 0) + 1);
        
//         for (int i = 1; i < numbers.length; i++) {
//             Map<Integer, Integer> newMap = new HashMap<>();
//             for (int k : map.keySet()) {
//                 int cnt = map.get(k);
//                 newMap.put(k + numbers[i], newMap.getOrDefault(k + numbers[i], 0) + cnt);
//                 newMap.put(k - numbers[i], newMap.getOrDefault(k - numbers[i], 0) + cnt);
//             }
//             map = newMap;
//         }
        
//         answer = map.getOrDefault(target, 0);
//         return answer;
//     }
// }

