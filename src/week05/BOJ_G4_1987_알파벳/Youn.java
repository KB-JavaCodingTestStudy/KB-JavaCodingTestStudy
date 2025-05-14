import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제 설명:
- R행 C열 보드의 각 칸에는 대문자 알파벳(A~Z)이 하나씩 적혀 있다.
- 말은 좌측 상단(0,0)에서 시작하여 상하좌우 인접한 칸으로 이동할 수 있다.
- 단, 지금까지 지나온 경로에 포함된 알파벳이 있는 칸은 다시 방문할 수 없다.
- 말이 지날 수 있는 최대 칸 수를 구하는 문제 (시작 칸도 포함).

제한 사항:
- 1 ≤ R, C ≤ 20
- 보드의 각 칸에는 대문자 알파벳(A~Z) 중 하나가 적혀 있음

접근 방식:
- DFS + 백트래킹 사용
- 알파벳 방문 여부를 boolean[26] 배열(visited)로 관리
- 방문한 알파벳은 true로 표시하고, 재귀 호출 후 false로 되돌려 백트래킹
- 이동할 수 있는 모든 방향으로 탐색하며 최대 칸 수 갱신

시간 복잡도:
- 최대 26개의 알파벳만 사용할 수 있으므로 DFS 완전탐색 가능
- 시간 복잡도는 O(4^K), K ≤ 26
*/


public class N_1987 {
    public static final int [] dx = {-1, 0, 1, 0};
    public static final int [] dy = {0, -1, 0, 1};
    public static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        max = 1;
        char [][] map = new char[n][m];
        for(int i = 0; i < n; i++){
           map[i]= br.readLine().toCharArray();
        }
        boolean [] visited = new boolean[26];
        visited[map[0][0]-'A'] = true;
        dfs(map,0,0,visited, 1);
        System.out.println(max);

    }
    public static void dfs(char[][] map, int x, int y, boolean [] visited, int count) {
        for(int i = 0; i < dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >=map.length || ny <0 || ny >= map[0].length){
                continue;
            }
            if(!visited[map[nx][ny]-'A']){
                visited[map[nx][ny]-'A'] = true;
                dfs(map, nx, ny, visited,count+1);
                visited[map[nx][ny]-'A'] = false;
            }
        }
        max = Math.max(max, count);
    }
}
