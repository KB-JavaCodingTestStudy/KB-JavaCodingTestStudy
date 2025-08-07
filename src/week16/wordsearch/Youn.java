/**
접근 방식 
보드에서 word의 첫 글자와 일치하는 모든 칸에서 DFS를 시작한다.
visited 배열을 사용하여 중복 방문을 방지한다.
현재 위치에서 상하좌우 4방향을 탐색하며 다음 글자가 일치하면 재귀 호출한다.
한 경로가 실패하면 visited를 원래대로 돌려 백트래킹한다.
단어 전체를 찾으면 즉시 true 반환, 모든 시도 실패 시 false 반환한다.


시간 복잡도
전체 보드를 순회하며 DFS 시작 지점을 찾는다 → O(n * m)
각 DFS 호출은 최대 4 방향으로 분기된다.
단어 길이를 L이라 할 때, 한 경로의 최대 탐색 깊이는 L이다.
최악의 경우 시간 복잡도는 O(n * m * 3^L)
(처음 칸은 4방향 가능, 이후엔 되돌아가지 않으므로 3방향)
따라서 보드 크기와 단어 길이가 클 경우 성능 저하가 발생할 수 있다.

*/

class Solution {
    static int n;
    static int m;
    static boolean [][] visited;
    static boolean isWord;

    static int [] dx = new int[]{0,1,0,-1};
    static int [] dy = new int[]{1,0,-1,0};
    public boolean exist(char[][] board, String word) {    
        char start = word.charAt(0);
        n = board.length;
        m = board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==start){
                    visited = new boolean[n][m];
                    visited[i][j]=true;
                    boolean res = dfs(board, word,i,j,1);
                    if(res) return true;
                }

            }
        }
            return false;            
    }

    static boolean dfs(char [][] board,String word, int cx, int cy, int idx){
        if(idx== word.length()){
            return true;
        }
        for(int d=0;d<4;d++){
            int nx = cx+dx[d];
            int ny = cy+dy[d];

            if(nx < 0 || ny <0 || nx>=n || ny>=m) continue;
            if(board[nx][ny]!=word.charAt(idx)) continue;

            if(!visited[nx][ny]){
                    visited[nx][ny]=true;
                    boolean res = dfs(board, word, nx, ny, idx+1);
                    if(res) return true;
                    visited[nx][ny]=false;
            
            }
        }    
        return false;
    }   
}
