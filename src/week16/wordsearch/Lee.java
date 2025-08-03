import java.util.*;

class Solution {

    int maxRow, maxCol;

    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};

    char[][] board;
    String word;

    // 배열 범위를 벗어나는지 검사하는 메소드
    boolean isValid(int r, int c) {
        return r >= 0 && r < maxRow && c >= 0 && c < maxCol;
    }

    public boolean exist(char[][] board, String word) {

        // 확인, 참조 용도로만 사용하기에 전역 변수로 복사 (편하게 쓰기 위해서)
        this.board = board;
        this.word = word;
        
        maxRow = board.length;
        maxCol = board[0].length;

        boolean[][] visited = new boolean[maxRow][maxCol];

        // board의 모든 칸에서 출발하여 완전탐색을 각각 실행해본다. 
        for(int r = 0; r < maxRow; r++) {
            for (int c = 0; c < maxCol; c++) {
                if (dfs(visited, r, c, 0))
                    return true;
            }
        }

        return false;
    }

    public boolean dfs(boolean[][] visited, int r, int c, int i) {

        // 현재 board의 문자가 word의 i번째와 다르면 종료 (false)
        if (this.board[r][c] != this.word.charAt(i))
            return false;

        // 첫번째 if문에 걸리지 않고 word와 동일한 길이까지 탐색했다면, word와 같은 단어!
        if (i == this.word.length() - 1)
            return true;

        boolean isExist = false;

        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // board 범위 밖이거나 이미 갔던 곳이라면 continue
            if (!isValid(nr, nc) || visited[nr][nc])
                continue;
                
            // 현재 칸을 방문 처리
            visited[r][c] = true;

            // 백트레킹 도중 하나라도 true가 나오면 isExist는 true가 된다.
            isExist = isExist || dfs(visited, nr, nc, i+1);

            // 현재 칸의 방문 여부를 다시 되돌림
            visited[r][c] = false;
        }

        return isExist;
    }
}
