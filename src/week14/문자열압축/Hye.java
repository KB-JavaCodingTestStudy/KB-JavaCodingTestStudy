package week14.문자열압축;

/* ================================================================
 *
 * Problem  : 문자열 압축_
 * Author   : 김혜지
 * Date     : 2025년 07월 23일
 *
 * ================================================================
 */

import java.util.ArrayList;
import java.util.List;

public class Hye {
    class Solution {
        public int solution(String s) {
            int min = Integer.MAX_VALUE; // 최소 길이

            if(s.length() == 1){ // 문자열 길이가 1이면 압축해도 1
                return 1;
            }

            for(int i = 1; i <= s.length()/2; i++){ // i개 단위로 문자열을 잘라 list에 저장
                List<String> list = new ArrayList<>();

                for(int j = 0; j < s.length(); j+=i){ // 자르는 단위만큼 건너뛰기
                    String temp = null;
                    if(s.length() <= j + i){ // // 범위를 벗어나는 경우 나머지 문자열을 끝까지 저장
                        temp = s.substring(j);
                    }else{
                        temp = s.substring(j, j + i);
                    }
                    list.add(temp);
                }

                int count = 1; // 반복 횟수
                String result = ""; // 압축 문자열
                for(int p = 0; p < list.size()-1; p++){
                    String now = list.get(p);
                    String next = list.get(p+1);

                    if(now.equals(next)){ // 현재 문자열과 다음 문자열이 같으면 count++
                        count++;
                    }else{ // 같지 않으면 지금까지의 결과를 압축해서 추가
                        if(count == 1){
                            result += "" + now;
                        }else{
                            result += "" + count + now;
                        }
                        count = 1; // count 초기화
                    }
                }

                // 마지막 문자열 계산
                if(count == 1){
                    result += "" + list.get(list.size()-1);
                }else{
                    result += "" + count + list.get(list.size()-1);
                }

                // 압축 문자열의 최소 길이 저장
                if(min > result.length()){
                    min = result.length();
                }
            }

            return min; // 최소 길이 반환
        }
    }
}
