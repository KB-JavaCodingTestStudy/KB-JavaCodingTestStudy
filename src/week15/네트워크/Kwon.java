import java.util.*;

//총 몇개의 네트워크가 존재하는 지 파악하는 문제

class Solution {
    public static int[] visited;
    Queue<Integer> q = new ArrayDeque<>();
    int answer = 0;
    
    public int solution(int n, int[][] computers) {
        visited = new int[n];
        
        for(int i=0; i<n; i++) {
            if(visited[i] != 1) {
                bfs(n, computers, i);
            }
        }
        
        return answer;
    }

    //bfs로 로직 구현
    public void bfs(int n, int[][] computers, int start) {

        //시작노드 방문 처리 후 큐에 삽입
        visited[start] = 1;
        q.add(start);

        //큐가 빌때까지 -> 연결되어있는 노드를 모두 방문할 때까지
        while(!q.isEmpty()) {
            int curr = q.remove();

            
            for(int i=0; i<n; i++) {
                if(computers[curr][i]==1 && visited[i]!=1) {   //노드가 방문전이고 1이면
                    q.add(i);
                    visited[i] = 1;
                }
            }
        }
        answer ++;
    }
}
