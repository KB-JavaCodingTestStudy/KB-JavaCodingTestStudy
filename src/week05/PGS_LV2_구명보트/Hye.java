package week05.PGS_LV2_구명보트;

/* ================================================================
 *
 * Problem  : 구명보트_Lv2
 * Author   : 김혜지
 * Date     : 2025년 05월 12일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - 무인도에 갇힌 사람들을 구명보트를 이용해서 구출
 * -> 한 번에 최대 2명씩 & 무게제한 : 최대한 적게 사용하여 모든 사람 구출
 *
 * # 입력
 * - 사람들의 몸무게를 담은 배열 people, 구명보트의 무게 제한 limit
 *
 * # 출력
 * - 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값
 *
 * 💻 알고리즘 설계
 * 1. 사람들의 몸무게를 담은 배열 people - 오름차순 정렬
 * 2. 투포인터 사용
 * -> 가벼운 사람 무게와 무거운 사람 무게의 합이 limit보다 클 경우 무거운 사람 먼저 구출 ( right-- & answer++ )
 * -> 가벼운 사람 무게와 무거운 사람 무게의 합이 limit보다 작거나 같으면 두 명 모두 구출 ( left++ & right-- & answer++ )
 * 3. answer 출력
 *
 * ⏰ 시간복잡도
 * - O(N log N)
 * -> 정렬 : O(N log N)
 * -> 투 포인터 : O(N)
 * ================================================================
 */

import java.util.Arrays;

public class Hye {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(new int[]{70,50,80,50}, 100);
        System.out.println(answer);
    }

    public static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;

            Arrays.sort(people);

            int left = 0;
            int right = people.length - 1;

            while(true){
                if(left > right){
                    break;
                }

                if(people[right] + people[left] > limit){
                    right--;
                    answer++;
                }else{
                    right--;
                    left++;
                    answer++;
                }
            }
            return answer;
        }
    }
}
