/*
  1. 맵의 각 지점에 대한 최단 거리를 2차원 배열에 저장한다. 단, 신발 사용 횟수에 따라 차원을 하나 더 추가하여 신발을 k번 사용했을 때 해당 지점까지의 최단 거리를 표시하도록 3차원 배열을 구성한다. 
  2. 그냥 1칸 이동했을 때와 신발을 사용하여 2칸 이동했을 때 총 8칸에 대해 bfs를 진행한다. 어느 한 지점으로부터 이동 가능한 칸이 8개인 그래프인 셈이다. 
  3. 다만 신발을 사용해 2칸 이동할 때는 위치 뿐만 아니라 3번째 차원도 함께 이동해야 한다. 이는 신발을 n번 사용한 차원임을 나타낸다.
  4. 마지막 n-1, m-1 지점에서 신발을 몇번 사용하여 최소로 도달했는지는 모른다. 이 중 최소값을 리턴한다.  
*/

import java.util.*;
import java.io.*;

class Solution {
    
    int[] dr = {1,-1,0,0};
    int[] dc = {0,0,1,-1};
    
    int n, m;
    
    boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
    
    public int solution(int n, int m, int[][] holes) {
        this.n = n;
        this.m = m;
        
        int[][][] dist = new int[n][m][2];
        
        // 모든 거리를 MAX값으로 초기화
        for(int r = 0; r < n; r++)
            for(int c = 0; c < m; c++)
                for(int k = 0; k < 2; k++)
                    dist[r][c][k] = Integer.MAX_VALUE;

        // 시작점인 0,0 지점만 거리 0으로 초기화
        dist[0][0][0] = 0;
        dist[0][0][1] = 0;
        
        // 함정은 -1 로 저장
        for(int[] hole : holes) {
            int r = hole[0] - 1;
            int c = hole[1] - 1;
            
            dist[r][c][0] = -1;
            dist[r][c][1] = -1;
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,0});
        
        // bfs
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            int r = cur[0];
            int c = cur[1];
            int k = cur[2];
            
            // 1칸 걸어서 이동
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (isValid(nr, nc) && dist[nr][nc][k] == Integer.MAX_VALUE) {
                    dist[nr][nc][k] = dist[r][c][k] + 1;
                    q.add(new int[] {nr, nc, k});
                }
            }
            
            // 신발을 사용했을 경우 건너뜀
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
        
        if(dist[n-1][m-1][0] == Integer.MAX_VALUE && dist[n-1][m-1][1] == Integer.MAX_VALUE)
            return -1;
        
        return Math.min(dist[n-1][m-1][0], dist[n-1][m-1][1]);

        
    }
}
