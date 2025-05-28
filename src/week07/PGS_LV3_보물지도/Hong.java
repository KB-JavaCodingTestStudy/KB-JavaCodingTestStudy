import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] hole) {
        boolean[][] trap = new boolean[n+1][m+1];
        for(int[] h : hole){
            trap[h[0]][h[1]] = true;
        }
        
        boolean[][][] visited = new boolean[n+1][m+1][2];
        Queue<int[]> queue = new ArrayDeque<>();
        
        int[][] dx1 = { {1,0}, {0,1}, {-1,0}, {0,-1} };
        int[][] dx2 = { {2,0}, {0,2}, {-2,0}, {0,-2} };
        
        queue.add(new int[]{1, 1, 0, 0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.remove();
            int x = cur[0], y = cur[1], jump=cur[2], dist=cur[3];
            
            if(x == n && y == m){
                return dist;
            }
            
            
            for(int i=0; i<4; i++){
                int nx = x + dx1[i][0], ny = y + dx1[i][1];
                
                if(nx >= 1 && nx <= n && ny >=1 && ny <= m && !visited[nx][ny][jump] && !trap[nx][ny]){
                    visited[nx][ny][jump] = true;
                    queue.add(new int[]{nx, ny, jump, dist+1});
                }
            }
            
            if(jump == 0){
                for(int i=0; i<4; i++){
                    int nx = x + dx2[i][0], ny = y + dx2[i][1];

                    if(nx >= 1 && nx <= n && ny >=1 && ny <= m && !visited[nx][ny][1] && !trap[nx][ny]){
                        visited[nx][ny][1] = true;
                        queue.add(new int[]{nx, ny, 1, dist+1});
                    }
                }
            }
            
        }
        return -1;
        
    }
}
