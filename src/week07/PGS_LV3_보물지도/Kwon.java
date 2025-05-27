import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] hole) {
        int answer = -1;
        int[][] arr = new int[n][m];
        for(int[] h : hole) {
            int a = h[0];
            int b = h[1];
            arr[a-1][b-1] = 1; //bomb
        }
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        Queue<int[]> q = new ArrayDeque<>();
        int[][][] visited = new int[n][m][2] ;
        
        q.add(new int[]{0,0,0,0});   //x,y,time,shoes
        visited[0][0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] now = q.remove();
            int x = now[0]; int y = now[1]; int t = now[2]; int s = now[3];
            
            if(x==n-1 && y==m-1) { //목적지에 도착하면
                return t;
            }
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny]!=1 && visited[nx][ny][s]==0) {
                    q.add(new int[]{nx, ny, t+1, s});
                    visited[nx][ny][s] = 1;
                }
            }
            if(s==0) {
                for(int i=0; i<4; i++) {
                    int nx = x + dx[i]*2;
                    int ny = y + dy[i]*2;
                    if(nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny]!=1 && visited[nx][ny][1]==0) {
                        q.add(new int[]{nx, ny, t+1, 1});
                        visited[nx][ny][1] = 1;
                    }
                }
            }
        }
            
        return answer;
    }
}
