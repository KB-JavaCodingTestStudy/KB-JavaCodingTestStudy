package week11.MaximalSquare;

public class MJ {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int Max = 0;
            int x = matrix.length;
            int y = matrix[0].length;
            int[][] DP = new int[x][y];

            for(int i=0; i<x; i++){
                if(matrix[i][0]=='0'){
                    continue;
                }
                DP[i][0] = 1;
                Max=1;
            }

            for(int i=0; i<y; i++){
                if(matrix[0][i]=='0'){
                    continue;
                }
                DP[0][i] = 1;
                Max=1;
            }

            for(int i=1; i<x; i++){
                next:
                for(int j=1; j<y; j++){
                    if(matrix[i][j]=='0'){
                        continue;
                    }

                    for(int n=0; n<=DP[i-1][j-1]; n++){
                        if(
                                matrix[i][j-n] != '1' ||
                                        matrix[i-n][j] != '1'
                        ){
                            Max=Math.max(Max, DP[i][j]);
                            continue next;
                        }
                        DP[i][j]++;
                    }
                    Max=Math.max(Max, DP[i][j]);
                }
            }

            return Max*Max;
        }
    }
}
