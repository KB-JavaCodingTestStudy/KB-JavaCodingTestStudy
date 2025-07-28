/**

풀이 시간: 12min

접근 방식
- visited: 이전 네트워크에 속한 노드
- 모든 노드를 탐색하면서 네트워크 확장
- 방문한 노드가 없을 때까지 함수 호출, 호출한 수 = 네트워크 수

시간 복잡도
예상: O(N)
실제: O(N²) 

입력: 컴퓨터 수 n
computers는 n x n 크기의 인접 행렬

외부 for문은 n번 순회하며, 방문하지 않은 노드를 기준으로 BFS 호출
BFS 내에서는 해당 노드의 연결 여부를 computers[cur][i]로 확인하며 n번 반복
모든 노드는 한 번만 방문되므로, BFS 탐색 총 비용은 인접 행렬 기준으로 O(N²) 
*/

import java.util.*;
class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                findNetwork(computers, i);        
                answer++;        
            }
                
        }
        return answer;
    }
    
    static void findNetwork(int[][] computers, int x){
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(x);
        visited[x]=true;
        
        while(!que.isEmpty()){
            int cur =que.poll();
            for(int i=0;i<computers[cur].length;i++){
                if(i==cur) continue;
                if(computers[cur][i]==1 && !visited[i]){
                    visited[i]=true;
                    que.offer(i);
                }
            }
        }
    }
    
}
