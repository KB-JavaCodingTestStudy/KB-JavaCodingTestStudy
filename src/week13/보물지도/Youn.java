import java.util.*;

class Solution {
    static boolean[][][] visited;
    static class Point{
        int x, y, jumped, dist;
        public Point(int x, int y, int jumped, int dist){
            this.x=x;
            this.y=y;
            this.jumped=jumped;
            this.dist=dist;
        }
    }
    public int solution(int n, int m, int[][] hole) {
        visited = new boolean[n+1][m+1][2];
        Set<String> holes = new HashSet<>();
        for(int[] h: hole){
            holes.add(h[0]+" "+h[1]);
        }
        
        return bfs(n,m,holes);
        
    }
    
    static int bfs(int n, int m, Set<String> holes){
        int [] dx = new int[]{0,1,0,-1};
        int [] dy = new int[]{1,0,-1,0};
        
        Queue<Point> que = new ArrayDeque<>();
        que.offer(new Point(1,1,0,0));  // x, y, jumped, dist
        visited[1][1][0] = true;
        
        while(!que.isEmpty()){
            Point cur = que.poll();
            if(cur.x == n && cur.y == m){return cur.dist;}
            for(int d=0;d<4;d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
                
                if(!holes.contains(nx+" "+ny)&& !visited[nx][ny][cur.jumped]){
                    visited[nx][ny][cur.jumped]=true;
                    que.offer(new Point(nx, ny, cur.jumped,cur.dist+1));
                }                
            }
            
            // 이전에 신발 사용한 적이 없는 경우
            if(cur.jumped == 0){
                for(int d=0;d<4;d++){
                int nx = cur.x + dx[d]*2;
                int ny = cur.y + dy[d]*2;
                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
                if(!holes.contains(nx+" "+ny) &&!visited[nx][ny][1]){
                    visited[nx][ny][1]=true;
                    que.offer(new Point(nx, ny, 1,cur.dist+1));
                }
            }
            }
        }
        
        return -1;
    }
}
