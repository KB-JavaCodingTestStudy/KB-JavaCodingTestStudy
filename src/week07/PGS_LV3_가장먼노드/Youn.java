/**
인접리스트를 Map 자료구조를 사용하여 저장. →  O(E) (E: 간선 수)
1번에서 가장 먼 노드이니 BFS를 사용하여, 이동한 간선 수에 해당하는 방문 노드를 구한다.
즉, 현재 이동한 간선 수를 저장하는 `count` 변수를 이용하여 푼다.
전체 노드 수에서 방문할 노드 수를 감해가는데, 
*전체 노드가 0이 되면 해당 노드들이 가장 먼 노드들이다.*
*/

import java.util.*;
class Solution {
    static Set<Integer> notVisited;
    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        notVisited = new HashSet<>();
        
        for(int [] connect: edge){
            int a = connect[0];
            int b = connect[1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            
            graph.get(a).add(b);
            graph.get(b).add(a);
            notVisited.add(a);
            notVisited.add(b);
        }
        int total = notVisited.size();
        
        return bfs(1,graph, total);
    }
    
    public static int bfs(int start, Map<Integer, List<Integer>> g, int total){
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        notVisited.remove(start);
        while(!que.isEmpty()){
            int len = que.size();
            total -=len; // 전체 노드 - 현재 간선에서 방문할 노드 개수
            if(total==0){return len;}
            
            for(int i=0;i<len;i++){
                int next= que.poll();
                for(int v: g.get(next)){
                    if(notVisited.contains(v)){
                        notVisited.remove(v);
                        que.add(v);
                    }
                }
            }
            
        }
        return 0;
    }
}
