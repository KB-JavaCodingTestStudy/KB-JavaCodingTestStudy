package week04.PGS_Lv02_타겟넘버;

/* ================================================================
 *
 * Author   : 남민주
 *
 * ================================================================
 * 📌 문제 분석 요약 
 *
 * # 입력
 * - n개의 음이 아닌 정수(numbers)
 * - 타겟 넘버(target)
 *
 * # 출력
 * - 주어진 정수를 더하거나 빼서 타겟 넘버를 만드는 방법의 수(순서 배경 불가)
 *
 * 💻 알고리즘 설계
 * - 현재까지의 합, 안덱스 구조로 입력받는 Queue 생성
 * - 0, 0으로 초기화 값 넣기
 * - queue가 비어있지 않다면 아랴 반복
 *  1. 값 하나 queue에서 꺼내기
 *  2. 만약 마지막이고 값이 타겟 넘버와 같다면 answer+1
 *  3. 마지막 값이 아니라면
 *      3-1. 해당 값에서 다음 인덱스를 뺀 값 & 더한 값을 queue에 넣기
 *          (다음 번호로 이동하기 위해 인덱스 + 1)
 * - answer 출력
 *
 * ================================================================
 */

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

