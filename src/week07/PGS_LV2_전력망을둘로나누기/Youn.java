/**
1단계	인접 리스트로 그래프 구성
2단계	모든 전선을 하나씩 끊어봄
3단계	끊은 상태에서 한 쪽 트리의 크기 DFS로 탐색
4단계	두 트리 크기의 차이 계산 → 최소값 갱신

전체 시간 복잡도 O(n²)
- 전선 수는 최대 `n-1`개 → **O(n)**개의 전선 중 하나씩 끊기
- 각 전선마다 `DFS` 탐색 → **O(n)**
*/

import java.util.*;
class Solution {
    static int count;
    static List<Integer>[] graph;
    public int solution(int n, int[][] wires) {
       graph = new List[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e: wires){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
            
        }
        
        int min =101;
          for(int[] e: wires){
            count =0;             
            dfs(e[0], e[1], new boolean[n+1]);
            min = Math.min(min, Math.abs(n-2*count));
        }
                
        
        return min;
    }
    
    public static void dfs(int cur, int notConnected, boolean[] visited){
        count++;
        visited[cur]=true;
        if(graph[cur]!=null){
            for(int v: graph[cur]){
                if(v==notConnected||visited[v]) continue;                                
                dfs(v, notConnected, visited);                  
            }
        }
        
    }
}
