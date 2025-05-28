/**
- BFS를 활용해 한 칸씩 넓혀가며 탐색 → 각 칸의 **레벨(depth)을 count로 추적**
- 방문한 길은 `1`로 마킹하여 중복 탐색 방지
- 도착 지점에 **가장 먼저 도달한 순간의 count**를 반환함으로써 **최단 거리** 확보
*/

import java.util.*;
class Solution {
    static int[] dx =new int[]{0,1,0,-1};
    static int[] dy =new int[]{1,0,-1,0};

    public int solution(int[][] maps) {
        return bfs(maps);
    }
    public static int bfs(int[][] maps){    
        Queue<int []> que = new ArrayDeque<>();
        que.offer(new int[]{0,0});
        maps[0][0]= -1;
        int count =1;
        while(!que.isEmpty()){
            int len =que.size();
            count++;
            while(len -- >0){
            int [] cur = que.poll();        
            for(int d=0;d<4;d++){
                int nx = cur[0]+dx[d];
                int ny = cur[1]+dy[d];
                
                if(nx == maps.length-1 && ny == maps[0].length-1){
                    return count;
                }
                
                if(nx < 0 || ny< 0 || nx >=maps.length || ny>=maps[0].length){
                    continue;
                }
                
                if(maps[nx][ny]==1){
                    que.offer(new int[]{nx,ny});                    
                    maps[nx][ny]=-1;
                }
            }
            
            }
        }
        return -1;
    }
}
