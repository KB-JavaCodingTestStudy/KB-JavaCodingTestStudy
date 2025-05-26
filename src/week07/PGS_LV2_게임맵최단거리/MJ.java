package week07.PGS_LV2_게임맵최단거리;

import java.util.ArrayDeque;
import java.util.Deque;

public class MJ {
    class Solution {
        public static final int[] dx = {0, 0, -1, 1};
        public static final int[] dy = {-1, 1, 0, 0};

        public int solution(int[][] maps) {
            int answer = -1;
            boolean[][] visited = new boolean[maps.length][maps[0].length];
            Deque<int[]> deque = new ArrayDeque<>();

            deque.addLast(new int[]{0, 0, 1});
            visited[0][0] =true;

            while(!deque.isEmpty()){
                int[] cur = deque.removeFirst();
                if(cur[0] == maps.length-1 && cur[1] == maps[0].length-1){
                    answer = cur[2];
                    break;
                }
                for(int i=0;i<4;i++){
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if(nx<0 || ny<0 || nx>=maps.length || ny>=maps[0].length){
                        continue;
                    }
                    if(!visited[nx][ny] && maps[nx][ny]==1){
                        deque.addLast(new int[]{nx, ny, cur[2]+1});
                        visited[nx][ny] = true;
                    }
                }
            }
            return answer;
        }
    }
}
