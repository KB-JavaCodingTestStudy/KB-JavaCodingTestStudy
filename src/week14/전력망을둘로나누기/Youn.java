/**

접근 방식
1. 주어진 전선을 하나씩 끊어보며 각 경우마다 두 전력망의 노드 개수 차이를 계산
2. 전선을 끊는 것은 BFS 탐색 시 해당 간선을 무시하는 방식으로 구현.
3. 끊은 전선을 기준으로 한 쪽 전력망의 노드 수 count
4. 전체 노드 수 n에서 이 수를 빼고 차이의 절댓값을 구해 최소값을 갱신
5. 모든 전선을 검사한 후, 최소 차이를 반환


시간 복잡도
전선 수: wires.length == n - 1 (트리 구조)
각 전선을 끊고 BFS → O(n)
총 n - 1개의 전선 검사 → O(n * n)
최종 시간 복잡도: O(n^2)
*/

import java.util.*;
class Solution {
    static List<List<Integer>> list;
    
    public int solution(int n, int[][] wires) {
        list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        
        for(int [] wire: wires){
            int a = wire[0];
            int b = wire[1];
            
            list.get(a).add(b);
            list.get(b).add(a);                        
        }
        int min = n;
        for(int [] wire: wires){
            int a = wire[0];
            int b = wire[1];
            min = Math.min(countAbs(a,b,n), min);
        }
        return min;
    }
    
    static int countAbs(int a, int b, int n){
        Queue<Integer> que = new ArrayDeque<>();
        boolean [] visited = new boolean[n+1];
        que.offer(a);
        visited[a] = true;
        
        int count =0;
        while(!que.isEmpty()){
            int cur = que.poll();
            count++;
            
            for(int nei: list.get(cur)){
                if(cur==a && nei==b || visited[nei]) continue;
                else{
                    visited[nei] = true;
                    que.offer(nei);
                }
                
                
            }
        }
        
        return Math.abs(n-2*count);
    }
}
