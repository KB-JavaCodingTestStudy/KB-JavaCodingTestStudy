import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {

        int n = id_list.length;
        
        // 유저 id와 번호를 매칭하는 해시맵
        Map<String, Integer> id_map = new HashMap<>();
        for(int i = 0; i < n; i++)
            id_map.put(id_list[i], i);
        
        // report_log[i] : i번 유저가 신고한 사람들을 모은 Set
        Set<Integer>[] report_log = new HashSet[n];
        for(int i = 0; i < n; i++)
            report_log[i] = new HashSet<>();
        
        for(int i = 0; i < reports.length; i++) {
            String[] report = reports[i].split(" ");
            
            int reporter = id_map.get(report[0]);
            int reported = id_map.get(report[1]);
            
            report_log[reporter].add(reported);
        }
        
        // reported_cnt[i] : i번 유저가 신고당한 횟수
        int[] reported_cnt = new int[n];
        
        for(int i = 0; i < n; i++) {
            for(int reported : report_log[i]) 
                reported_cnt[reported]++;
        }
        
        // result_cnt[i] : i번 사람이 받은 결과 메일의 수
        int[] result_cnt = new int[n];
        
        for(int i = 0; i < n; i++) {
            for(int reported : report_log[i]) {
                if(reported_cnt[reported] >= k)
                    result_cnt[i]++;                
            }
        }
        
        return result_cnt;
        
    }
}
