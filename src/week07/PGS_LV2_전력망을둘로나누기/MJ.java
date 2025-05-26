package week07.PGS_LV2_전력망을둘로나누기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MJ {
    class Solution {
        int[] child;
        boolean[] visited;
        Map<Integer, List<Integer>> map = new HashMap<>();
        public int getChildNum(int n){
            int count = 1;
            visited[n]=true;//자식 노드에서 다시 위로 올라오는 것 방지

            for(int c: map.getOrDefault(n, new ArrayList<>())){
                if(!visited[c]){ //이미 방문->위의 노드
                    count+=getChildNum(c);
                }
            }

            child[n] = count;
            return count;
        }

        public int solution(int n, int[][] wires) {
            int answer = n; //최대로 설정
            child = new int[n+1];
            visited = new boolean[n+1];

            for(int[] wire: wires){
                List<Integer> list = map.getOrDefault(wire[0], new ArrayList<>());
                list.add(wire[1]);
                map.put(wire[0], list);

                list = map.getOrDefault(wire[1], new ArrayList<>());
                list.add(wire[0]);
                map.put(wire[1], list);
            }
            getChildNum(1);

            for(int c: child){
                int target = Math.abs((n-c)-c);
                answer = Math.min(answer, target);
            }
            return answer;
        }
    }
}
