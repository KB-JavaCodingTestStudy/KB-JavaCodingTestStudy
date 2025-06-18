
/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 알파벳이 하나씩 쓰인 m x n 크기의 grid가 있습니다.
 *  - 임의의 위치에서 시작하여, 중복된 칸을 두번이상 지나지 않고, word 문자열을 만들 수 있는 길을 찾아야 합니다. 
 *  - 그러한 길이 존재한다면 true, 없으면 false를 반환합니다.
 *  
 * # 입력
 *  - board: char[][]
 *  - word: String
 *
 * # 반환
 *  - true or false
 *
 * 💻 알고리즘 설계
 *  - 그리드의 모든 칸에서 출발하여 다음을 확인합니다.
 *  - 현재 확인할 word의 알파벳과 현재 칸이 다르면 종료합니다.
 *  - 같다면 상하좌우 칸으로 이동하면서 반복합니다. (visited 에도 기록) 
 *  - word의 길이만큼 전부 확인했으면 그 단어를 찾은 것이므로 true를 반환합니다.
 *  - 다 돌아도 안나오면 false를 반환합니다.
 *
 * ================================================================
 */

class Solution {

    int maxRow;
    int maxCol;

    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};

    boolean isValid(int r, int c) {
        return r >= 0 && r < maxRow && c >= 0 && c < maxCol;
    }

    public boolean exist(char[][] board, String word) {
        
        maxRow = board.length;
        maxCol = board[0].length;

        boolean[][] visited = new boolean[maxRow][maxCol];

        for(int r = 0; r < maxRow; r++) {
            for (int c = 0; c < maxCol; c++) {
                if(backtrack(board, word, visited, r, c, 0))
                    return true;
            }
        }

        return false;
    }

    public boolean backtrack(char[][] board, String word, boolean[][] visited, int r, int c, int i) {

        if (i < word.length() && board[r][c] != word.charAt(i))
            return false;

        if (i == word.length() - 1)
            return true;

        boolean isExist = false;

        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(!isValid(nr, nc) || visited[nr][nc]) continue;

            visited[r][c] = true;
            isExist = isExist || backtrack(board, word, visited, nr, nc, i+1);
            visited[r][c] = false;
        }

        return isExist;
    }
}
