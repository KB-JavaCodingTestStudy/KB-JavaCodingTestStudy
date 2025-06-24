class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] matrix2 = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j]=='0') {
                    matrix2[i][j] = 0;
                } else {
                    matrix2[i][j] = 1;
                }
            }
        }


        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix2[i][j]==1) {
                    matrix2[i][j] = Math.min(Math.min(matrix2[i-1][j], matrix2[i][j-1]),matrix2[i-1][j-1])+1;
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<m; i++) {
            if(matrix2[i][0]==1) {
                answer = 1;
            }
        }
        for(int i=0; i<n; i++) {
            if(matrix2[0][i]==1) {
                answer = 1;
            }
        }
        
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                answer = Math.max(answer, matrix2[i][j]);
            }
        }

        return answer*answer;

        
    }
}
