package week10.subsets;

import java.util.ArrayList;
import java.util.List;

/* ================================================================
 *
 * Author   : 남민주
 *
 * ================================================================
 * 📌 문제 분석 요약
 *
 * # 입력
 * -  nums
 *      - 정수 집합
 *
 * # 출력
 * - SubSet
 *      - 부분 집합 (공집합 표현)
 *
 * 💻 알고리즘 설계
 * -  추가 여부를 나타낼 visited 배열(boolean) 생성
 *  - 반활할 결과 이중 리스트 answer 생성 (전역 변수)
 * - 부분 집합을 만드는 makeSubsets 함수 생성
 *      - 해당 집합을 포함
 *          - 처음에 추가하여 생성되는 모든 집합(+공집합) 리스트를 결과 리스트에 추가
 *      - start 부터 nums 길이만큼 반복문 실행
 *          - start가 필요한 이유: 재귀를 돌 때 자신의 다음 값들만 돌아야 중복 집합이 생성되지 않는다.
 *      - 추가되지 않은 값에 대하여
 *          - 추가 여부(visited)를 true로 변경
 *          - 재귀 실행(이전 값을 수행하면 순서가 변경된 배열이 중복 추가되므로 start값을 +1하여 업데이트)
 *      - list 에서 해당 메소드에서 추가한 값 제거
 *      - 추가 여부(visited)를 false로 변경 (값을 제거하였으므로)
 *  - 결과 이중 리스트를 반환한다.
 * ================================================================
 */
public class MJ {
    class Solution {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited;
        public void makeSubsets(int start, int[] nums, List<Integer> list){
            answer.add(new ArrayList<>(list));
            for(int i=start;i<nums.length;i++){
                if(!visited[i]){
                    visited[i]=true;
                    list.add(nums[i]);
                    makeSubsets(i+1, nums, list);
                    list.remove(list.size()-1);
                    visited[i]=false;
                }
            }
        }
        public List<List<Integer>> subsets(int[] nums) {
            visited = new boolean[nums.length];
            makeSubsets(0, nums, new ArrayList<>());
            return answer;
        }
    }
}
