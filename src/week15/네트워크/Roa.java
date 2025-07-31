class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n]; // n개만큼 방문 배열 false로 초기화
        int cnt=0;
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(n, computers, visited, i);
                cnt++; // dfs 실행할 때마다 네트워크 개수 +1
            }
        }
        return cnt;
    }
    
    public void dfs(int n, int[][] computers, boolean[] visited, int node){
        visited[node]=true;
        for(int j=0; j<n; j++){
            if(node!=j && !visited[j] && computers[node][j]==1){ // 1. 자기 자신이 아니며 2. 방문하지 않았고 3. 연결되어있으면
                dfs(n, computers, visited, j); // dfs 실행
            }
        }
    }
}
