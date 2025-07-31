import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int cnt = 0;                         // 네트워크 개수 카운트 변수
        boolean[] visited = new boolean[n];  // 방문 처리 배열
        
        for(int cur = 0; cur < n; cur++) {
            if(!visited[cur]) {    // 방문한 적이 없는 곳이면
                bfs(computers, visited, cur);  // 해당 지점을 기준으로 bfs로 연결된 모든 지점을 탐색하고 방문 처리한다.
                cnt++;            // 네트워크 개수 +1
            }
        }
        
        return cnt;
    }

    // bfs 처리 함수
    public void bfs(int[][] computers, boolean[] visited, int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(startVertex);  // 큐에 시작 정점을 담는다.
        visited[startVertex] = true;  // 시작 정점을 방문 처리한다.
        
        while(!queue.isEmpty()) {  // 큐가 빌 때 까지
            int curVertex = queue.remove();  // 큐에서 정점을 하나 꺼낸다.
            
            for(int neighbor = 0; neighbor < computers.length; neighbor++) {
                if(!visited[neighbor] && computers[curVertex][neighbor] == 1) {  // 현재 정점으로 부터 이웃한 정점에 방문한 적이 없으면
                    queue.add(neighbor);  // 그 이웃 정점을 큐에 담고
                    visited[neighbor] = true;  // 방문 처리한다.
                }
            }
        }
    }
}
