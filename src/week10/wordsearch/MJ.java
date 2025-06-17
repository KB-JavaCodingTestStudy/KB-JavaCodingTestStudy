package week10.wordsearch;

public class MJ {
    class Solution {
        boolean answer = false;
        public int[] dx = {0, 0, 1, -1};
        public int[] dy = {1, -1, 0, 0};
        public void backtraking(char[][] board, String word, int n, int[] xy){
            if(n==word.length()){
                answer=true;
                return;
            }
            char w = word.charAt(n);
            for(int i=0;i<4;i++){
                int nx = xy[0]+dx[i];
                int ny = xy[1]+dy[i];
                if(nx<0 || ny<0 || nx>=board.length||ny>=board[0].length){
                    continue;
                }
                char c = board[nx][ny];
                if(c==w){
                    board[nx][ny]='.';
                    backtraking(board, word, n+1, new int[]{nx, ny});
                    board[nx][ny]=c;
                }
            }
        }
        public void findWord(char[][] board, String word){
            char w = word.charAt(0);
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[i].length;j++){
                    char c = board[i][j];
                    if(w==c){
                        board[i][j]='.';
                        backtraking(board, word, 1, new int[]{i, j});
                        board[i][j]=c;
                    }
                }
            }


        }
        public boolean exist(char[][] board, String word) {
            findWord(board, word);
            return answer;
        }
    }
}
