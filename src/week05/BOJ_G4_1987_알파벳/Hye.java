package week05.BOJ_G4_1987_알파벳;

/* ================================================================
 *
 * Problem  : 알파벳_G4
 * Author   : 김혜지
 * Date     : 2025년 05월 12일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - 세로 R칸, 가로 C칸으로 된 표 모양의 보드
 * - 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸(1행 1열)에는 말이 놓여있다.
 * - 말은 상하좌우로 인접한 네 칸 중 한 칸으로 이동, 같은 알파벳이 적힌 칸을 두 번 지날 수는 없다.
 * - 좌측 상단에서 시작하여, 말이 최대한 몇 칸을 지날 수 있는지 구하기 ( 지나는 칸은 좌측 상단의 칸도 포함 )
 *
 * # 입력
 * - 1행 : R C ( 1 <= R, C <= 20 )
 * - 2행~ : C개의 대문자 알파벳
 *
 * # 출력
 * - 말이 지날 수 있는 최대의 칸 수
 *
 * 💻 알고리즘 설계
 * 1. R과 C 입력 받기
 * 2. 입력된 알파벳을 배열로 변환
 * 3. 백트래킹을 사용하여 각 위치에서 상하좌우로 가는 모든 경우의 수 확인 - max 값 갱신
 * 4. max 값 출력
 *
 * ⏰ 시간복잡도
 * - O(4^L)
 * -> 4 : 상하좌우 방향
 * -> L - 알파벳 수 ( 최대 26 )
 * ================================================================
 */

import java.io.*;
import java.util.*;

public class Hye {

    static int max = 0;
    static int[] dx = { 0, 0, -1, 1};
    static int[] dy = { 1, -1, 0, 0};
    static int r = 0;
    static int c = 0;
    static char[][] grid;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        grid = new char[r][c];

        for(int i = 0; i < r; i++){
            grid[i] = br.readLine().toCharArray();
        }

        Set<Character> visited = new HashSet<>();
        visited.add(grid[0][0]);
        back(0,0,visited, 1);

        System.out.println(max);

    }

    public static void back(int x, int y, Set<Character> visited, int count){
        max = Math.max(max, count);

        for(int i = 0; i < 4; i ++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && nx < r && ny >= 0 && ny < c){
                char nextCh = grid[nx][ny];
                if(!visited.contains(nextCh)){
                    visited.add(nextCh);
                    back(nx, ny, visited, count+1);
                    visited.remove(nextCh);
                }
            }
        }
    }
}

/* BFS - 메모리 초과 => 비트마스크 사용?
public class b_1987 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] grid = new char[r][c];

        for(int i = 0; i < r; i++){
            grid[i] = br.readLine().toCharArray();
        }

        int[] dx = { 0, 0, -1, 1};
        int[] dy = { 1, -1, 0, 0};
        int max = 0;

        Queue<State> queue = new LinkedList<>();
        Set<Character> ch = new HashSet<>();
        ch.add(grid[0][0]);

        queue.offer(new State(0,0, ch));

        Map<State, Boolean> visited = new HashMap<>();
        visited.put(new State(0,0,ch), true);

        while(!queue.isEmpty()){
            State cur = queue.poll();
            max = Math.max(max, cur.visited.size());


            for(int i=0; i < 4; i++){
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if(nextX >= 0 && nextX < r && nextY >= 0 && nextY < c){
                    char nextCh = grid[nextX][nextY];

                    if(!cur.visited.contains(nextCh)){
                        Set<Character> newSet = new HashSet<>(cur.visited);
                        newSet.add(nextCh);

                        State newState = new State(nextX, nextY, newSet);

                        if(!visited.containsKey(newState)){
                            visited.put(newState, true);
                            queue.offer(newState);
                        }
                    }
                }
            }
        }

        System.out.println(max);

    }

    public static class State {
        int x, y;
        Set<Character> visited;

        public State(int x, int y, Set<Character> visited){
            this.x = x;
            this.y = y;
            this.visited = new HashSet<>(visited);
        }

        @Override
        public boolean equals(Object obj){
            if(this == obj) return true;
            if(obj == null || getClass() != obj.getClass()) return false;
            State other = (State) obj;

            return this.x == other.x && this.y == other.y && this.visited.equals(other.visited);
        }

        @Override
        public int hashCode(){
            return Objects.hash(x,y,visited);
        }
    }
}
*/