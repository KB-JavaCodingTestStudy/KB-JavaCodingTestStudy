class Word_Search {
    static int m, n;
    int[] dr = {-1, 1, 0, 0}; // 상하좌우 방향 이동 (행 변화)
    int[] dc = {0, 0, -1, 1}; // 상하좌우 방향 이동 (열 변화)

    public boolean exist(char[][] board, String word) {
        m = board.length; // 보드의 행 길이
        n = board[0].length; // 보드의 열 길이
        boolean[][] visited = new boolean[m][n];

        // 보드의 모든 칸을 시작점으로 시도해봄
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // (i,j)에서 DFS 시작. 만약 찾으면 true 리턴
                if (dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false; // 끝까지 못 찾았으면 false
    }

    public boolean dfs(char[][] board, String word, boolean[][] visited, int r, int c, int idx) {
        // 단어의 모든 글자를 다 찾은 경우
        if (idx == word.length()) return true;

        // 범위 벗어남 또는 이미 방문함 또는 현재 글자가 다름 → 실패
        if (r < 0 || r >= m || c < 0 || c >= n) return false;
        if (visited[r][c] || board[r][c] != word.charAt(idx)) return false;
        visited[r][c] = true;

        // 상하좌우 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            // 다음 칸에서 계속 단어 찾기
            if (dfs(board, word, visited, nr, nc, idx + 1)) return true;
        }
        visited[r][c] = false; // 백트래킹: 방문 해제 (다른 경로 위해 복원)
        return false; // 4방향 다 해도 못 찾으면 false
    }
}
