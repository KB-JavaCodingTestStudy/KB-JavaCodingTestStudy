class Solution {
    static int[] dx ={0,1,0,-1};
    static int[] dy ={1,0,-1,0};
    static boolean [][] visited;
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    visited = new boolean[board.length][board[0].length];
                    visited[i][j]=true;
                    if(dfs(board, word, 1,i,j)) return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board, String word, int idx, int x, int y){                    
        if(idx == word.length()){
            return true;
        }

        for(int d=0;d<4;d++){
            int nx = x+dx[d];
            int ny = y+dy[d];

            if(nx<0 || ny<0 ||nx>=board.length|| ny>=board[0].length) continue;
            if(board[nx][ny]!=word.charAt(idx)) continue;

            if(!visited[nx][ny]){
                visited[nx][ny]=true;
                boolean res =dfs(board, word, idx+1, nx, ny);
                visited[nx][ny]=false;   
                if(res) return true;                    
            }
           
        }

        return false;
    }
}
