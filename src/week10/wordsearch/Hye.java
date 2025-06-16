package week10.wordsearch;

/* ================================================================
 *
 * Problem  : wordsearch_Medium
 * Date     : 2025년 06월 16일
 * 
 * ================================================================
 */

public class Hye {
    class Solution {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        public boolean exist(char[][] board, String word) {
            int n = board.length;
            int m = board[0].length;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(board[i][j] == word.charAt(0)){
                        boolean[][] visited = new boolean[n][m];
                        visited[i][j] = true;
                        if(dfs(board, word, visited, 0, i, j)){
                            return true;
                        };
                    }
                }
            }
            return false;
        }

        boolean dfs(char[][] board, String word, boolean[][] visited, int depth, int cx, int cy){
            if(depth == word.length()-1){
                return true;
            }

            int n = board.length;
            int m = board[0].length;

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(word.charAt(depth+1) != board[nx][ny]) continue;

                visited[nx][ny] = true;
                if(dfs(board, word, visited, depth + 1, nx, ny)){
                    return true;
                };
                visited[nx][ny] = false;
            }

            return false;
        }
    }
}
