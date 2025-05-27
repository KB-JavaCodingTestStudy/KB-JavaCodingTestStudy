import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> report2 = new HashSet<>();
        for(int i=0; i<report.length; i++) {
            report2.add(report[i]);
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<id_list.length; i++) {
            map.put(id_list[i],i);
        }
        int[] answer = new int[id_list.length];

        
        HashMap<String, List<String>> total = new HashMap<>();
        for(String strr : report2) {
            String[] str = strr.split(" ");
            String from = str[0];
            String to = str[1];
            if(total.containsKey(to)) {
                List<String> now = total.get(to);
                now.add(from);
                total.put(to,now);
                
            } else {
                List<String> now = new ArrayList<>();
                now.add(from);
                total.put(to,now);
            }
            
        }
        
        for(String name : total.keySet()) {
            List<String> who = total.get(name);
            if(who.size()>=k) {
                for(int j=0; j<who.size(); j++) {
                    int idx = map.get(who.get(j));
                    answer[idx]++;
                }
            }
        }
        
        
        return answer;
    }
}
