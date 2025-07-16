package week13.보물지도;

/* ================================================================
 * Problem  : 보물지도
 * Author   : 김혜지
 * Date     : 2025년 07월 16일
 * ================================================================
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class Hye {
    class Solution {

        int[] dx = {0,0,1,-1,0,0,2,-2};
        int[] dy = {1,-1,0,0,2,-2,0,0};
        // index 0 ~ 3 : 점프 X
        // index 4 ~ 7 : 점프 O

        public int solution(int n, int m, int[][] hole) {
            // 시작 1,1 | 도착 n,m
            boolean[][][] visited = new boolean[n+1][m+1][2]; // 점프 여부 나누어 방문 표시
            int[][] map = new int[n+1][m+1];

            for(int[] h : hole){
                map[h[0]][h[1]] = 1; // map에 구멍위치 표시하기
            }

            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{1,1,0,0});   // x, y, dist, jump
            visited[1][1][0] = true; // 1,1 방문표시

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int cx = cur[0];
                int cy = cur[1];
                int cd = cur[2];
                int cj = cur[3];

                if(cx == n && cy == m){
                    // n,m 도착하면 거리 return
                    return cd;
                }

                int maxI = (cj==1) ? 4 : 8; // 점프한 경우 최대 인덱스 - 4, 안한 경우 최대 인덱스 - 8

                for(int i = 0; i < maxI; i++){
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    int nj = cj == 1 ? 1 : i / 4; // 이미 점프한 경우 nj = 1, 아닌 경우 이후 점프 여부 - i / 4

                    if(nx >= 1 && nx <= n && ny >= 1 && ny <= m && !visited[nx][ny][nj] && map[nx][ny] == 0){
                        // 아직 방문 X && 구멍이 아닌 경우
                        queue.offer(new int[]{nx, ny, cd + 1, nj});
                        visited[nx][ny][nj] = true;
                    }
                }
            }
            // 도착 못한 경우
            return -1;
        }
    }
}
