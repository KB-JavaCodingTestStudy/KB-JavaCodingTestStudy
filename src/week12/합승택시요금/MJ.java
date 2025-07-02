package week12.합승택시요금;

import java.util.Arrays;

public class MJ {
    class Solution {
        public int solution(int n, int s, int a, int b, int[][] fares) {
            int answer = 200*100000;
            int[][] map = new int[n+1][n+1];

            for(int i=0;i<=n;i++){
                Arrays.fill(map[i], 200*100000);
                map[i][i]=0;
            }

            for(int[] fare:fares){
                map[fare[0]][fare[1]]=fare[2];
                map[fare[1]][fare[0]]=fare[2];
            }

            for(int m=1;m<=n;m++){
                for(int i=1;i<=n;i++){
                    for(int j=1;j<=n;j++){
                        map[i][j] = Math.min(map[i][j], map[i][m]+map[m][j]);
                    }
                }
            }

            for(int m=1;m<=n;m++){
                answer = Math.min(answer, map[s][m] + map[m][a] + map[m][b]);
            }
            return answer;
        }
    }
}
