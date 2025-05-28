/**
- 신고 정보 파싱 및 중복 제거 = O(r), r: reported.len
    - `Map<String, Set<String>> map`: key = 신고자 ID, value = 신고한 ID 목록 (중복 제거 위해 `Set` 사용)
    - `report` 배열을 순회하면서, 신고자를 key로, 피신고자를 set에 저장한다.
- 각 사용자별 신고당한 횟수 계산 및 정지자 목록 추출: O(n * m)
    - 모든 유저 `id_list`를 순회하며, **자신이 얼마나 많은 사람에게 신고당했는지** 계산한다.
    - 신고당한 횟수가 `k` 이상이면 정지(`blocked`) 목록에 추가한다.
- 각 사용자별로 받은 메일 수 계산 O(n)
    - `id_list`를 다시 순회하며,
    - 각 사용자가 신고한 사람들 중 정지된 사람만 카운트해 결과 배열에 저장.
*/

import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> map = new HashMap<>();
        for(String blocked: report){
            String id = blocked.split(" ")[0];
            String block = blocked.split(" ")[1];
            map.putIfAbsent(id, new HashSet<>());
            map.get(id).add(block);              
        }    
        Set<String> blocked = new HashSet<>();
        for(String id: id_list){
            int count =0;
            for(String key: map.keySet()){
                if(map.get(key).contains(id)) count++;                
                if(count >= k) {
                    blocked.add(id);
                    break;
                }
            }
        }
        
        int [] result =new int[id_list.length];
        for(int i=0;i<id_list.length;i++){
            if(map.get(id_list[i])==null){
                result[i]= 0; continue;
            }
            
            long count = map.get(id_list[i]).stream()
                .filter(blocked::contains)
                .count();          
            result[i]=(int) count;
        }
                
        return result;
    }
}
