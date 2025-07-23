/**

접근 방식
- 문자열을 1부터 s.length()/2까지의 단위로 잘라가며 압축 시도
- 동일한 문자열이 연속되면 "개수 + 문자열" 형식으로 압축 (1개면 개수X)
- 각 압축된 문자열 길이를 비교해 최소값 저장
- 최종적으로 가장 짧은 압축 결과 길이를 반환
- 예외 처리 없이 모든 경우를 브루트포스로 탐색함


시간 복잡도
- 바깥 반복문은 최대 s.length()/2번 반복 (O(N))
- 각 반복에서 문자열을 len 단위로 순회하며 압축 진행 (O(N))
=> 전체 시간 복잡도는 O(N^2)
최악의 경우 N ≤ 1000일 때도 성공

*/

import java.util.*;

class Solution {
    public int solution(String s) {
        int min = s.length();
        for(int size=1;size<=s.length()/2;size++){
            min = Math.min(min, pressString(s, size));
        }
        return min;
    }
    static int pressString(String s, int len){
        StringBuilder sb = new StringBuilder();
        int count =0;
        String start ="";
        for(int i=0;i<s.length();i+=len){        
            String cur = s.substring(i, Math.min(i+len, s.length()));
            if(start.equals(cur)){
                count++;
            }
            else{
                if(count >1) sb.append(count);
                sb.append(start);
                start = cur;
                count=1;                
            }
        }
        if(count >1) sb.append(count);
        sb.append(start);
        
        return sb.length();
    }
}
