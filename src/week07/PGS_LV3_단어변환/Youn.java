/**
1	target이 words에 없으면 0 반환
2	BFS 초기화 (큐에 begin 추가, visited 설정)
3	큐에서 하나씩 꺼내면서 연결된 단어 탐색 (canChange)
4	연결된 단어를 방문하지 않았다면 큐에 추가
5	탐색 중 target 발견 시, 현재까지의 레벨 total 반환
6	끝까지 못 찾으면 0 반환

시간 복잡도 : O(N^2 * L)
- BFS 단계 수: 최대 N
- 한 단계당 후보 단어 비교: N
- 각 비교마다 한 글자 차이 비교: L
*/
import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        Set<String> word = new HashSet<>(Arrays.asList(words));
        Set<String> visited = new HashSet<>();
        
        if(!word.contains(target)) return 0;
        
        Queue<String> que = new ArrayDeque<>();
        que.add(begin);    
        visited.add(begin);
        
        int total =0;
        while(!que.isEmpty()){
            int len = que.size();
            total++;
            while(len -- >0){
                String cur = que.poll();   
                for(String compare: word){   
                    if(visited.contains(compare)) continue;
                    
                    if(canChange(cur, compare)){
                        if(compare.equals(target))  return total;
                        que.offer(compare);     
                        visited.add(compare);
                    }
                }
            }
        }
        
        return total;
    }
    static boolean canChange(String cur, String compare){
        int diff =0;
        for(int i=0;i<cur.length();i++){
            if(cur.charAt(i)!=compare.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }
}
