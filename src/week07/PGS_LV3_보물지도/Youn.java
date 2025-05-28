/**
신발의 사용 여부를 쭉 가지고 가야한다. 
왜? 한 번 쓰면 끝이니까 이전에 썼는지 확인 해야 함

함정의 위치를 갖고 있는 `boolean` 타입의 trap 배열을 선언 & 초기화
- 이전에 신발을 사용한 경우 = 상, 하, 좌, 우
- 신발을 아직 사용하지 않은 경우 = 상, 하, 좌, 우 + 신발 사용 이동 (4칸)

만일 이전에 신발을 사용했다면 앞으로도 쭉 신발을 사용해야 한다.
그러면 다음 위치는 신발을 쓴 경우, 사용하지 않은 경우 두 가지 상태이다.
이 상태를 가지고 방문 여부를 구분해야 한다.

💡bfs는 모든 간선의 이동 비용이 동일할 때, 최단 거리를 보장한다.

- 걷기와 점프가 모두 `1`의 비용을 가짐
- 같은 좌표를 신발 사용 유무에 따른 방문 여부를 구분함

해당 접근은 위의 조건을 만족한다.
∴ bfs 탐색 중 목표 지점에 도착하게 되면 목표 지점의 dist는 최단 거리를 만족함
*/

import java.util.*;
class Solution {
    static Set<String> visited;
    static Set<String> holes;
    public int solution(int n, int m, int[][] hole) {
        visited= new HashSet<>();
        holes = new HashSet<>();
        for(int[] h: hole){
            holes.add(h[0]+" "+h[1]);
        }    
        return bfs(n,m);
    }
    static int bfs(int n, int m){
        int [] dx ={0,1,0,-1,0,2,0,-2};
        int [] dy ={1,0,-1,0,2,0,-2,0}; //0~3 신발x, 4~ 신발
        
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{1,1,0,0});  //x, y, dist, shoe
        visited.add(1+" "+1+" "+0);
        
        while(!que.isEmpty()){
            int len = que.size();        
            while(len-- > 0){
                int[] cur =que.poll();
                for(int d=0;(cur[3]==0? d<8:d<4);d++){
                    int nx = cur[0]+dx[d];
                    int ny = cur[1]+dy[d];
                    int isShoe = cur[3];
                    if(d>=4) isShoe=1;
                    
                    if(nx<=0 || ny<=0 || nx>n || ny>m) continue;
                    if(nx == n && ny==m){
                        return cur[2]+1;
                    }
                    if(!visited.contains(nx+" "+ny+" "+isShoe)){
                        if(!holes.contains(nx+" "+ny)){
                            que.offer(new int[]{nx, ny, (cur[2]+1), isShoe});                       
                            visited.add(nx+" "+ny+" "+isShoe);
                        }    
                    }                                                       
                }                
            }          
        }
        return -1;
    }
}
