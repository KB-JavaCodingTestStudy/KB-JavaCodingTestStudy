package KB.week05;

/* ================================================================
 *
 * Problem  : PGS - 문자열 압축
 * Author   : 김로아
 * Date     : 2025-07-24
 *
 * ================================================================
 * 📌 문제 분석 요약
 * 문자열을 일정 단위로 잘라서 반복되는 부분을 압축
 * 예: "aabbaccc" → "2a2ba3c" → 길이 7
 * 
 * 가능한 모든 단위(1 ~ 문자열 길이의 절반)로 나눠 압축했을 때
 * 가장 짧은 문자열의 길이를 구하는 문제
 *
 * # 입력
 * 문자열 s (1 ≤ s.length() ≤ 1,000)
 *
 * # 출력
 * 압축해서 표현한 문자열 중 가장 짧은 길이
 *
 * 💻 알고리즘 설계
 * 1) 압축 단위를 1부터 s.length()/2까지 순회
 * 2) 단위 크기만큼 자른 문자열을 기준으로 반복 횟수 계산
 * 3) 반복되지 않으면 그대로 추가, 반복되면 숫자+문자 형식으로 압축
 * 4) 압축 결과 문자열 길이 갱신
 * 5) 모든 단위에 대해 최소 압축 길이 반환
 *
 * ⏰ 시간복잡도
 * - 최악의 경우 O(n^2) (문자열 길이 1,000일 때)
 *
 * ================================================================
 */

class Roa {
    public int solution(String s) {
        int answer = s.length(); // 압축이 안 될 경우 원래 길이

        // 압축 단위: 1 ~ s.length() / 2
        for (int len = 1; len <= s.length() / 2; len++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, len); // 처음 비교할 단위 문자열
            int count = 1;

            // len 간격으로 순회
            for (int i = len; i <= s.length(); i += len) {
                String current;
                // 범위 벗어나면 남은 부분 처리
                if (i + len > s.length()) {
                    current = s.substring(i);
                } else {
                    current = s.substring(i, i + len);
                }

                if (current.equals(prev)) {
                    count++; // 같은 문자열 반복 중
                } else {
                    // 압축 결과에 추가
                    if (count > 1) {
                        compressed.append(count).append(prev);
                    } else {
                        compressed.append(prev);
                    }
                    prev = current; // 현재 문자열로 갱신
                    count = 1;
                }
            }

            // 마지막 prev 처리
            if (count > 1) {
                compressed.append(count).append(prev);
            } else {
                compressed.append(prev);
            }

            // 최소 길이 갱신
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}
