class Solution {
    //word를 전역으로 사용하기 위한 변수
    String word2 = "";
    //상하좌우 확인
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int[][] visited;
    int wordLength;
    int m,n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        word2 = word;
        visited = new int[m][n];
        wordLength = word.length();

      //전체 칸을 돌면서, 첫글자가 동일하면 dfs 시작
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(i, j, 1, board)) return true;
                }
            }
        }
        return false;
        
    }

    public boolean dfs(int i, int j, int idx, char[][] board) {
        //단어 길이만큼 충족햇으면 반환
        if(idx == wordLength) {
            return true ;
        }

        visited[i][j] = 1;

      //상,하,좌,우 중 다음값으로 동일한 값이 있으면 실행
        for(int k=0; k<4; k++) {
            int ni = dx[k] + i;
            int nj = dy[k] + j;
            if(ni>=0 && ni<m && nj>=0 && nj<n && visited[ni][nj]==0 && board[ni][nj] == word2.charAt(idx)) {
                if(dfs(ni, nj, idx+1,board)) return true;
                visited[ni][nj] = 0;
            }
        }
        visited[i][j] = 0;
        return false;
    }
}
