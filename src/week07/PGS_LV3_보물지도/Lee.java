import java.util.*;
import java.io.*;

class Solution {
    
    int[] dr = {0,0,1,-1};
    int[] dc = {1,-1,0,0};
    
    int mr, mc;
    
    boolean isValid(int r, int c) {
        return r >= 0 && r < mr && c >= 0 && c < mc;
    }
    
    public int solution(int n, int m, int[][] holes) {

        /// input ///
        
        mr = n;
        mc = m;
        
        int[][][] dist = new int[mr][mc][2];
        
        for(int r = 0; r < mr; r++)
            for(int c = 0; c < mc; c++)
                for(int k = 0; k < 2; k++)
                    dist[r][c][k] = Integer.MAX_VALUE;
        
        dist[0][0][0] = 0;
        dist[0][0][1] = 0;
        
        for(int[] hole : holes) {
            int r = hole[0] - 1;
            int c = hole[1] - 1;
            
            dist[r][c][0] = -1;
            dist[r][c][1] = -1;
        }
        
        /// imple ///
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            int r = cur[0];
            int c = cur[1];
            int k = cur[2];
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (isValid(nr, nc) && dist[nr][nc][k] == Integer.MAX_VALUE) {
                    dist[nr][nc][k] = dist[r][c][k] + 1;
                    q.add(new int[] {nr, nc, k});
                }
            }
            
            if (k == 1) continue;
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i] * 2;
                int nc = c + dc[i] * 2;

                if (isValid(nr, nc) && dist[nr][nc][k+1] == Integer.MAX_VALUE) {
                    dist[nr][nc][k+1] = dist[r][c][k] + 1;
                    q.add(new int[] {nr, nc, k+1});
                }
            }
        }
        
        /// result ///
        
        if(dist[n-1][m-1][1] != Integer.MAX_VALUE)
            return dist[n-1][m-1][1];
        
        if(dist[n-1][m-1][0] != Integer.MAX_VALUE)
            return dist[n-1][m-1][0];
        
        return -1;
    }
}
