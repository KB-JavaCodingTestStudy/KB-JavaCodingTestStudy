import java.util.*;

class Solution {
    public int solution(String s) {
        int len = s.length();
        int shortest = len;
        
        // l : 단위 길이 (1 ~ 전체 길이 절반 이하)
        for(int l = 1; l <= len / 2; l++) {
            
            String zipStr = "";        // 압축 문자열
            String prev = "";          // 이전 단위 문자열 (처음에는 없음)
            
            int cnt = 0;
            
            for (int i = 0; i < len; i += l) {
                String unit = s.substring(i, Math.min(i+l, len)); // l개 단위로 자른 문자열
                
                // 현재 단위 문자열이 이전 단위 문자열과 같다면 
                if(unit.equals(prev)) {
                    cnt++;    // 카운트 증가
                }
                // 다르다면
                else {
                    if(cnt > 1)  // 카운트가 1보다 큰 경우에만 압축 문자열에 추가
                        zipStr += String.valueOf(cnt);
                    
                    zipStr += prev;  // 압축 문자열에 단위 문자열 추가
                    
                    prev = unit;  // 이전 단위 문자열을 현재 단위 문자열로 갱신 (달라졌으므로)
                    cnt = 1;  // 카운트 초기화
                }
            }
            
            if(cnt > 1)
                zipStr += String.valueOf(cnt);
                    
            zipStr += prev;

            // 가장 짧은 압축 문자열 길이 갱신
            if (zipStr.length() < shortest)
                shortest = zipStr.length();
        }
        
        return shortest;
    }
}
