package week05.PGS_LV2_구명보트;

import java.util.Arrays;
/* ================================================================
 *
 * Author   : 남민주
 *
 * ================================================================
 * 📌 문제 분석 요약
 *
 * # 입력
 * - 사람들 몸무게
 * - 보트 무게 제한
 *
 * # 출력
 * - 구명보트 개수(최소)
 *
 * # 참고사항
 *  - 보트 최대 인원: 2인
 * 💻 알고리즘 설계
 * - 몸무게를 오름차순으로 정렬
 * - start, end index를 지정
 * - start<=end 이면 아직 남은 사람이 존재하므로 아래 반복
 *      1. start 번째 사람과 end 번째 사람을 더했을 때 제한 무게보다 작으면
 *           - 2명 태우기 가능
 *           => start+1 & end-1
 *      2. 크면
 *          - 무거운 사람만 타고 가기(가벼운 사람은 그 다음 무거운 사람이랑은 같이 탈 수도 있으니까!)
 *           => end-1
 *      3. 두 경우 모두 필요한 보트 수가 늘어난 것이므로 answer+1
 * - answer 출력
 *
 * ================================================================
 */
public class MJ {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int start = 0;
        int end = people.length-1;

        while(start<=end){
            if(people[start]+people[end]<=limit){
                start++;
            }
            end--;
            answer++;
        }
        return answer;
    }
}
