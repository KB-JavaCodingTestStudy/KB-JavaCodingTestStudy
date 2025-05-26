package week07.PGS_LV1_신고결과받기;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MJ {
    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];

            Map<String, Set<String>> notice = new HashMap<>();
            Map<String, Integer> send = new HashMap<>();

            for(String pair :report){
                String[] tf = pair.split(" ");
                //신고당한 사람->신고한 사람 리스트
                Set<String> list = notice.getOrDefault(tf[1], new HashSet<String>());
                list.add(tf[0]);
                notice.put(tf[1], list);
            }
            for(String id :id_list){
                if(notice.getOrDefault(id, new HashSet<String>()).size() >= k){
                    for(String person: notice.getOrDefault(id, new HashSet<String>())){
                        send.put(person, send.getOrDefault(person, 0)+1);
                    }
                }
            }
            for(int i=0;i<id_list.length;i++){
                answer[i] = send.getOrDefault(id_list[i], 0);
            }
            return answer;
        }
    }
}
