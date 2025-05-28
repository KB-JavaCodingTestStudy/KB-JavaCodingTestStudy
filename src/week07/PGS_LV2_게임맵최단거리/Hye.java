package week07.PGS_LV2_게임맵최단거리;

/* ================================================================
 *
 * Problem  : 게임 맵 최단거리_Lv2
 * Date     : 2025년 05월 28일
 * 
 * ================================================================
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class Hye {

    class Solution {
        static int[] dx = { 0,0,1,-1};
        static int[] dy = {1,-1,0,0};
        static boolean[][] visited;

        public int solution(int[][] maps) {
            int n = maps.length;
            int m = maps[0].length;

            visited = new boolean[n][m];

            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{0,0,1});
            visited[0][0] = true;


            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int cx = cur[0], cy = cur[1], dist = cur[2];

                if(cx == n - 1 && cy == m - 1){
                    return dist;
                }

                for(int i=0; i<4; i++){
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1){
                        if(!visited[nx][ny]){
                            queue.offer(new int[]{nx, ny, dist + 1});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }

            return -1;
        }
    }
}
