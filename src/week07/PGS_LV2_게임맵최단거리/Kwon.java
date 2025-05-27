import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        
        //bfs로 최단거리 구하기
        q.add(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.remove();
            int x = now[0], y=now[1], road = now[2];
            if(x==n-1 && y==m-1) {
                return road;
            }
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m &&maps[nx][ny]==1 && !visited[nx][ny]) {
                    q.add(new int[] {nx,ny,road+1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return answer;
    }
}
