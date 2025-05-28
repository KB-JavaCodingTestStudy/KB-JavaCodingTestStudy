import java.util.*;

class Solution {
    int[] dr = {0,0,1,-1};
    int[] dc = {1,-1,0,0};
    
    int maxRow, maxCol;
    
    boolean isValid(int r, int c) {
        return r >= 0 && r < maxRow && c >= 0 && c < maxCol;
    }
    
    int bfs(int[][] maps) {
        
        int[][] dist = new int[maxRow][maxCol];
        
        for(int i = 0; i < maxRow; i++) 
            for(int j = 0; j < maxCol; j++)
                dist[i][j] = 10000;
    
        dist[0][0] = 1;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            int curRow = cur[0];
            int curCol = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                
                if(isValid(nextRow, nextCol) && maps[nextRow][nextCol] == 1 && dist[nextRow][nextCol] == 10000) {
                    dist[nextRow][nextCol] = dist[curRow][curCol] + 1;
                    q.add(new int[] {nextRow, nextCol});
                }
            }
        }
        
        if (dist[maxRow - 1][maxCol - 1] == 10000)
            return -1;
        
        return dist[maxRow - 1][maxCol - 1];
    }
    
    public int solution(int[][] maps) {

        maxRow = maps.length;
        maxCol = maps[0].length;

        return bfs(maps);
    }
}
