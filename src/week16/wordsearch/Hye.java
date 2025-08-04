package week16.wordsearch;

/* ================================================================
 *
 * Problem  : WordSearch_
 * Date     : 2025년 08월 04일
 * 
 * ================================================================
 */
public class Hye {
    class Solution {
        // 상하좌우 이동
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        public boolean exist(char[][] board, String word) {
            int n = board.length;
            int m = board[0].length;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(board[i][j] == word.charAt(0)){ // board의 글자와 단어의 첫 글자 일치
                        boolean[][] visited = new boolean[n][m];
                        visited[i][j] = true; // board[i][j] 방문
                        if(dfs(board, word, visited, 0, i, j)){ // DFS 탐색
                            return true; // 단어를 찾으면 true 반환
                        };
                    }
                }
            }
            return false; // 단어를 못찾으면 false 반환
        }

        boolean dfs(char[][] board, String word, boolean[][] visited, int depth, int cx, int cy){
            if(depth == word.length()-1){ // 단어의 마지막 문자까지 방문
                return true; // true 반환
            }

            int n = board.length;
            int m = board[0].length;

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위를 벗어남 OR 이미 방문 OR 다음 글자 불일치 -> continue
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(word.charAt(depth+1) != board[nx][ny]) continue;

                visited[nx][ny] = true; // 다음 글자 방문
                if(dfs(board, word, visited, depth + 1, nx, ny)){
                    return true; // 중간에 단어를 찾으면 true 반환
                };
                visited[nx][ny] = false; // 방문 취소 - 백트래킹
            }

            return false; // 탐색 실패 -> false 반환
        }
    }
}
