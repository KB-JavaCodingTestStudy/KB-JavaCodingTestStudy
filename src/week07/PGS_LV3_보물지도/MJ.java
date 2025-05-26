package week07.PGS_LV3_보물지도;

import java.util.ArrayDeque;
import java.util.Deque;

public class MJ {
    class Solution {
        public static final int[] dx = {0, 0, -1, 1};
        public static final int[] dy = {1, -1, 0, 0};

        public int solution(int n, int m, int[][] hole) {
            int answer = -1;
            int[][] grid = new int[n+1][m+1];
            boolean[][][] visited = new boolean[n+1][m+1][2];
            //n,m,사용 여부(0: 사용X, 1:사용O)
            for(int[] h: hole){
                grid[h[0]][h[1]] = -1;
            }

            Deque<int[]> deque = new ArrayDeque<>();
            deque.addLast(new int[]{1, 1, 0, 0});
            //n,m,depth,신발 사용 여부
            visited[1][1][0] = true;

            while(!deque.isEmpty()){
                int[] cur = deque.removeFirst();

                if(cur[0]==n && cur[1]==m){
                    answer = cur[2];
                    break;
                }

                for(int i=0; i<4; i++){
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];

                    if(nx<1 || ny<1 || nx>n || ny>m){
                        continue;
                    }

                    //신발 사용X
                    //1일 수도 있음 cur[3]으로 설정하기! 0으로 한정하여 생각하면 안 됨
                    if(grid[nx][ny]!=-1 && !visited[nx][ny][cur[3]]){
                        deque.addLast(new int[]{nx, ny, cur[2]+1, cur[3]});
                        //n,m,depth,신발 사용 여부
                        visited[nx][ny][cur[3]] = true;
                    }

                    nx = cur[0] + 2 * dx[i];
                    ny = cur[1] + 2 * dy[i];

                    if(nx<1 || ny<1 || nx>n || ny>m){
                        continue;
                    }
                    //신발 사용X
                    if(grid[nx][ny]!=-1 && !visited[nx][ny][cur[3]] && cur[3] == 0){
                        deque.addLast(new int[]{nx, ny, cur[2]+1, 1});
                        //n,m,depth,신발 사용 여부
                        visited[nx][ny][1] = true;
                    }

                }
            }

            return answer;
        }
    }
}
