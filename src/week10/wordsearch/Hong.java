
/* ================================================================
 *
 * Problem  : LeetCode - Word Search
 * Author   : 안홍영
 * Date     : 2025-06-18
 *
 * ================================================================
 * 📌 문제 분석 요약
 * 2차원 board[n][m]에서 주어진 word가 글자들이 상하좌우로 인접하게 연결되어 이루어져 있으면 true 없으면 false
 * 같은 셀을 중복 사용 X
 *
 * # 입력
 * - char[][] board : 대소문자 알파벳으로 이루어진 2차원 배열 (최대 6x6 크기)
 * - String word : 찾고자 하는 단어 (최대 15자)
 *
 *
 * 💻 알고리즘 과정
 * board 전체를 순회하면서, word[0]과 일치하는 셀을 찾음 
 * 해당 셀에서 DFS 시작
 * 인덱스가 word.length()와 같으면 true 반환 (모든 문자 찾음)
 * 현재 위치가 board 범위를 벗어나면 false
 * 현재 위치의 문자가 word[idx]와 다르면 false
 * 방문 처리를 위해 해당 셀을 임시로 다른 문자로 바꿔줌
 * 상하좌우 방향으로 탐색
 * 실패한 경우 원래 문자로 복구 (백트래킹)
 *
 * ⏰ 시간복잡도
 * - 최악의 경우 O(M * N * 4^L)
 *   (M*N: 시작 좌표 수, L: 단어 길이, 각 위치에서 최대 4방향 탐색)
 *
 * ================================================================
 */

class Solution {
    int[] dx = { -1, 1, 0, 0 }; 
    int[] dy = { 0, 0, -1, 1 };
    int n, m;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;

        // word[0]과 일치하는놈 찾기
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
