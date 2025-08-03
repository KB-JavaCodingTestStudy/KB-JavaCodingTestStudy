package week16.wordsearch;

public class MJ {
    class Solution {
        //상하좌우로 이동 가능
        public int[] dx = {1, -1, 0, 0};
        public int[] dy = {0, 0, 1, -1};
        //방문여부 확인 배열
        public boolean[][] visited;

        //탐색을 하는 메소드
        //현재 확인하고자 하는 위치(단어에서), 압력값(board, word), 현재 위치(board 에서) x & y
        public boolean dfs(int index, char[][] board, String word, int x, int y){
            //마지막 위치이면 가능한 경우
            if(index == word.length()-1){
                return true;
            }
            //상하좌우 이동!
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                //불가능한 경우는 패스
                if(nx<0 || ny<0 || nx>=board.length || ny>=board[0].length){
                    continue;
                }

                //방문한적이 없고 다음 글자가 board의 다음 위치와 같으면
                if(!visited[nx][ny] && word.charAt(index+1) == board[nx][ny]){
                    //방문했어요!
                    visited[nx][ny] = true;
                    //다음 값 확인하러 가자!!
                    if(dfs(index+1, board, word, nx, ny)) {
                        //돌고 가능하면 true 반환되게
                        return true;
                    }
                    //방문여부 풀고 다음 체크하자!
                    visited[nx][ny] = false;
                }
            }
            //불가능하면 false!
            return false;
        }

        public boolean exist(char[][] board, String word) {
            //visited 초기화(board와 같은 크기로)
            visited = new boolean[board.length][board[0].length];
            
            //모든 board를 돌며 
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    //처음 글자와 같은 지 체크하고 같으면 dfs 하도록
                    if(word.charAt(0)==board[i][j]){
                        //방문했어요!
                        visited[i][j] = true;
                        //dfs 에서 있으면
                        if(dfs(0, board, word, i, j)){
                            //true 반환
                            return true;
                        }
                        //떠날게요!
                        visited[i][j] = false;
                    }
                }
            }
            //위에서 true 반환을 안함 = 가능한 경우가 없음
            return false;
        }
    }
}
