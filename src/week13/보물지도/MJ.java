package week13.보물지도;

import java.util.ArrayDeque;
import java.util.Deque;

// https://campus.programmers.co.kr/tryouts/178141/challenges

public class MJ {
    class Solution {
        //다음 x, y를 위한 가중치
        public static int[] dx = new int[]{0, 0, 1, -1};
        public static int[] dy = new int[]{1, -1, 0, 0};

        public int solution(int n, int m, int[][] hole) {
            //갈 수 없는 경우: -1
            int answer = -1;

            //지도(함정인 경우 -1로 변경 예정)
            int[][] grid = new int[n+1][m+1];
            //방문 여부(0: 신발 사용X, 1:신발 사용O)
            boolean[][][] visited = new boolean[n+1][m+1][2];

            //함정의 경우 해당 위치의 지도를 -1로
            for(int[] h:hole){
                grid[h[0]][h[1]] = -1;
            }

            //deque 생성
            Deque<int[]> deque = new ArrayDeque<>();

            //시작 지점 넣기
            deque.addLast(new int[]{1, 1, 0, 0});// x, y, degree, shoes
            visited[1][1][0] = true;//해당 위치 방문 여부 업데이트

            //이동할 수 있는 경우가 있는 경우
            while(!deque.isEmpty()){
                // 가장 앞의 값: 먼저 들어온 값 = 움직임이 적은 것
                int[] cur = deque.removeFirst();

                //보물이 있는 위치인 경우
                if(cur[0]==n && cur[1]==m){
                    //현재 움직인 거리를 답으로
                    answer = cur[2];
                    //종료
                    break;
                }

                //신발 사용 안하는 다음 이동 추가
                for(int i=0; i<4; i++){
                    //다음 위치 계산
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];

                    // 지도 밖의 위치는 방문 못하므로 생략
                    if(nx<1 || ny<1 || nx>n || ny>m){
                        continue;
                    }

                    //방문한 적이 없고, 함정이 아니면
                    if(!visited[nx][ny][cur[3]] && grid[nx][ny]!=-1){
                        //값 추가
                        deque.addLast(new int[]{nx, ny, cur[2]+1, cur[3]});
                        //visited 배열 업데이트(방문완료!)
                        visited[nx][ny][cur[3]] = true;
                    }

                }

                //신발 사용하는 다음 이동 추가
                for(int i=0; i<4; i++){
                    //다음 위치 계산
                    int nx = cur[0] + 2 * dx[i];
                    int ny = cur[1] + 2 * dy[i];

                    // 지도 밖의 위치는 방문 못하므로 생략
                    if(nx<1 || ny<1 || nx>n || ny>m){
                        continue;
                    }

                    //방문한 적이 없고, 신발 사용 안했고, 함정이 아니면
                    if(!visited[nx][ny][1] && cur[3]!=1 && grid[nx][ny]!=-1){
                        //값 추가
                        deque.addLast(new int[]{nx, ny, cur[2]+1, 1});
                        //visited 배열 업데이트(방문완료!)
                        visited[nx][ny][1] = true;
                    }

                }
            }
            //정답 반환
            return answer;
        }
    }
}
