package week14.문자열압축;

public class MJ {
    class Solution {
        public int solution(String s) {
            //가장 작은 길이를 저장할 변수
            // 최대 길이(주어진 문자열의 길이)로 초기화
            int minLen = s.length();

            // 자를 단위: 1 ~ 주어진 문자열/ 2(그 이상이 되면 같은 쌍이 여러개일 수 없으므로)
            for (int i = 1; i <= s.length() / 2; i++) {
                StringBuilder compressed = new StringBuilder();
                String prev = s.substring(0, i);
                int count = 1;

                // size 단위로 문자열 자르기
                for (int j = i; j <= s.length(); j += i) {
                    // 다음 조각 추출 (범위 초과 방지)
                    String current = j + i <= s.length() ? s.substring(j, j + i) : s.substring(j);

                    //반복되는 값이 있으면
                    if (prev.equals(current)) {
                        //개수 증가
                        count++;
                    } else {
                        // 반복 끝났을 때 압축 문자열 추가
                        //반복되면 볓개인지 표시해야 하므로
                        if (count > 1) {
                            compressed.append(count);
                        }
                        compressed.append(prev);
                        // 비교 대상 갱신
                        prev = current;
                        //다시 1로 초기화
                        count = 1;
                    }
                }

                // 마지막 처리
                if (count > 1) compressed.append(count);
                compressed.append(prev);

                // 원래 값과 현재값을 비교하여 최소 길이로 업데이트
                minLen = Math.min(minLen, compressed.length());
            }

            //결과 반환
            return minLen;
        }
    }

}
