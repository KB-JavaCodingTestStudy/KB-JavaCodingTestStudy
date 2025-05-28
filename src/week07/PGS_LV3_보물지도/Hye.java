package week07.PGS_LV3_보물지도;

/* ================================================================
 *
 * Problem  : 보물지도_Lv3
 * Date     : 2025년 05월 28일
 * 
 * ================================================================
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class Hye {
    class Solution {
        int[] dx = { 0,  0, 1, -1, 0,  0, 2, -2};
        int[] dy = { 1, -1, 0,  0, 2, -2, 0,  0};

        public int solution(int n, int m, int[][] hole) {
            int answer = -1;

            int[][] map = new int[n][m];
            for(int[] h : hole){
                map[h[0]-1][h[1]-1] = 1; // hole
            }

            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{0,0,0,0}); // x, y, jump, dist
            boolean[][][] visited = new boolean[n][m][2];
            visited[0][0][0] = true;

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int curX = cur[0];
                int curY = cur[1];
                int jump = cur[2];
                int dist = cur[3];

                if(curX == n-1 && curY == m-1){
                    answer = dist;
                    break;
                }

                int max = jump == 1 ? 4 : 8;

                for(int i = 0; i < max; i++){
                    int nextX = curX + dx[i];
                    int nextY = curY + dy[i];
                    int nextJ = jump == 1 ? 1 : i / 4;

                    if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m){
                        if(map[nextX][nextY] != 1 && !visited[nextX][nextY][nextJ]){
                            visited[nextX][nextY][nextJ] = true;
                            queue.offer(new int[]{nextX, nextY, nextJ, dist+1});
                        }
                    }
                }
            }

            return answer;
        }
    }
}
