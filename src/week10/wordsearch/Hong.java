class Solution {
    int[] dx = { -1, 1, 0, 0 }; 
    int[] dy = { 0, 0, -1, 1 };
    int n, m;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0)) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int idx) {
        if (idx == word.length()) return true;

        // 범위 체크 및 현재 글자 확인
        if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] != word.charAt(idx)) return false;

        // 방문 표시
        char temp = board[i][j];
        board[i][j] = '*';

        // 4방향 탐색
        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            if (dfs(board, nx, ny, word, idx + 1)) return true;
        }

        // 백트래킹
        board[i][j] = temp;

        return false;
    }
}
