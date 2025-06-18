class Solution {
    int maxCount = 0;

    public int solution(int balance, int[][] countries) {
        boolean[] visited = new boolean[countries.length];
        dfs(balance, countries, visited, 0);
        return maxCount;
    }

    private void dfs(int balance, int[][] countries, boolean[] visited, int count) {
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < countries.length; i++) {
            if (!visited[i]) {
                int cost = countries[i][0];     
                int required = countries[i][1];
              
                if (balance >= required) {  
                    visited[i] = true;
                    dfs(balance - cost, countries, visited, count + 1);
                    visited[i] = false;   
                }
            }
        }
    }
}
