package week07.PGS_LV1_신고결과받기;

/* ================================================================
 *
 * Problem  : 신고 결과 받기_Lv1
 * Author   : 김혜지
 * Date     : 2025년 05월 27일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * @ 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템
 * - 각 유저는 한 번에 한 명의 유저 신고 ( 횟수 제한 X )
 * -> !!! 동일한 유저에 대한 신고 횟수는 1회로 처리
 *
 * - k번 이상 신고된 유저는 게시판 이용 정지 -> 해당 유저를 신고한 모든 유저에게 정지 사실 메일 발송
 * -> !!! 여러 번 신고해도 해당 유저에 대한 메일은 한 번만 수신
 *
 * -> 각 유저가 받은 메일 개수 구하기
 *
 * # 입력
 * - 이용자 목록 : id_list, 신고 목록 : report, 정지 기준 : k
 *
 * # 출력
 * - id_list에 담긴 id 순서대로 각 유저가 받은 메일 수
 *
 * 💻 알고리즘 설계
 * 1. id_list의 인덱스를 유저를 키로 하여 Map에 저장한다.
 * 2. 신고 목록 - 피신고자를 키로 하여 신고자를 집합으로 저장한다. ( 중복 신고 제거 )
 * 3. 신고 횟수 구하기 - 만약 집합의 크기가 정지 기준 신고 횟수보다 크다면 해당 피신고자는 정지된다.
 *    -> 해당 신고자 집합에서 유저 정보를 키로 하여 Map에서 인덱스를 찾고, 결과 배열에서 해당 인덱스의 값을 증가시킨다.
 * 4. 결과 배열을 반환한다.
 *
 * ⏰ 시간복잡도
 * - O(NM)
 * -> N : id_list 크기
 * -> M : report 크기
 *
 * ================================================================
 */

import java.util.*;

public class Hye {

    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {

            Map<String, Integer> index = new HashMap<>();
            for (int i = 0; i < id_list.length; i++) {
                index.put(id_list[i], i);
            }

            int[] answer = new int[id_list.length];

            Map<String, Set<String>> map = new HashMap<>();

            for(String s : report){
                String[] temp = s.split(" ");
                String a = temp[0];
                String b = temp[1];

                map.putIfAbsent(b, new HashSet<>());

                map.get(b).add(a);
            }

            for(String key : map.keySet()){
                Set<String> temp = map.get(key);
                if(temp.size() >= k){
                    for(String user : temp){
                        answer[index.get(user)]++;
                    }
                }
            }

            return answer;
        }
    }
}
