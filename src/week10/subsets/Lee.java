
/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 주어진 배열의 모든 원소를 사용하여 만들 수 있는 순열을 전부 구하는 문제입니다. 
 *  
 * # 입력
 *  - 임의 개수의 수가 들어있는 배열 하나
 *
 * # 반환
 *  - 입력 배열의 모든 원소를 사용하여 만들 수 있는 순열 (List형) 을 모두 모은 List를 return 
 *
 * 💻 알고리즘 설계
 *  - 빈 리스트를 준비합니다. 
 *  - 원본 배열의 원소를 차례로 순회하면서 다음을 수행합니다.
 *  - 각 순회마다, 현재 존재하는 모든 리스트에 순회중인 원소를 추가한 리스트를 새로 추가합니다. 
 *  - 순회를 마치고 해당 리스트를 모두 모으면 정답이 됩니다. 
 *
 * ================================================================
 */

import java.util.*;
import java.io.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Queue<List<Integer>> q = new LinkedList<>();

        q.add(new ArrayList<Integer>());

        for(int i = 0; i < nums.length; i++) {
            Queue<List<Integer>> tmpQ = new LinkedList<>();

            while(!q.isEmpty()) {
                List<Integer> subset = q.poll();

                List<Integer> copy1 = new ArrayList<>(subset);
                List<Integer> copy2 = new ArrayList<>(subset);
                copy2.add(nums[i]);

                tmpQ.add(copy1);
                tmpQ.add(copy2);
            }

            while(!tmpQ.isEmpty()) {
                q.add(tmpQ.poll());
            }
        }

        List<List<Integer>> subsets = new ArrayList<>();

        while(!q.isEmpty()) {
            subsets.add(q.poll());
        }

        return subsets;
    }
}
