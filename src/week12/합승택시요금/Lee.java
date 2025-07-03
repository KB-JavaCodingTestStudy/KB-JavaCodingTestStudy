
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        final int inf = n * 100000 + 1;
        
        int[][] min_fares = new int[n+1][n+1];
        
        for(int i = 0; i < n+1; i++)
            for(int j = 0; j < n+1; j++)
                min_fares[i][j] = inf;
        
        for(int i = 0; i < n+1; i++)
            min_fares[i][i] = 0;
        
        for(int[] fare : fares) {
            min_fares[fare[0]][fare[1]] = fare[2];
            min_fares[fare[1]][fare[0]] = fare[2];
        }
        
        for(int k = 1; k <= n; k++) {
            for (int r = 1; r <= n; r++) {
                for (int c = 1; c <= n; c++) {
                    if (min_fares[r][k] + min_fares[k][c] < min_fares[r][c])
                        min_fares[r][c] = min_fares[r][k] + min_fares[k][c];
                }
            }
        }
        
        int min_fare = inf;
        
        for(int k = 1; k <= n; k++) {
            
            int fare = min_fares[s][k] + min_fares[k][a] + min_fares[k][b];
            
            if (fare < min_fare)
                min_fare = fare;
        }
        
        return min_fare;
    }
}
