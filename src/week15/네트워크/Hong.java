/**
 * [프로그래머스] 네트워크 (DFS/BFS 유형)
 * 
 * 문제 설명
 * - 컴퓨터들 사이의 연결 정보를 보고, 독립된 네트워크(덩어리)의 개수를 구하는 문제
 *  
 *
 * 접근 방식
 * - 그래프 탐색(DFS or BFS)로 방문 체크하며 연결된 컴퓨터들 덩어리 개수 세기
 * - 방문하지 않은 컴퓨터 발견하면 탐색 시작 = 새로운 네트워크 발견
 *
 * 시간 복잡도
 * - O(N^2) (최악의 경우 모든 컴퓨터 쌍을 한 번씩 탐색)
 *   (n: 컴퓨터 개수)
 *
 * 풀이 방식
 * 1. visited 배열로 각 컴퓨터 방문 여부 체크
 * 2. for문으로 모든 컴퓨터 돌면서, 방문 안 했으면 DFS/BFS로 연결된 모든 노드 방문
 * 3. DFS 시작 횟수가 곧 네트워크 개수
 */

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n]; 
        int answer = 0; 
        
        // 모든 컴퓨터 한 번씩 순회
        for (int i = 0; i < n; i++) {
            // 아직 방문 안 한 컴퓨터라면 새로운 네트워크 발견
            if (!visited[i]) {
                dfs(computers, visited, i, n);
                answer++; // DFS 한 번 들어갈 때마다 네트워크 +1
            }
        }
        return answer;
    }
    
    // 깊이 우선 탐색(DFS)
    private void dfs(int[][] computers, boolean[] visited, int cur, int n) {
        visited[cur] = true; 
        // 현재 컴퓨터와 연결된 모든 컴퓨터 탐색
        for (int j = 0; j < n; j++) {
            // 자기 자신이 아니고, 연결되어 있고, 아직 방문 전이면
            if (cur != j && computers[cur][j] == 1 && !visited[j]) {
                dfs(computers, visited, j, n); // 연결된 컴퓨터도 재귀로 탐색
            }
        }
    }
}
