class Solution {
    private int maxCountries;

    public int solution(int balance, int[][] countries) {
        maxCountries = 0;
        boolean[] visited = new boolean[countries.length];
        dfs(balance, 0, countries, visited);
        return maxCountries;
    }

    private void dfs(int balance, int count, int[][] countries, boolean[] visited) {
        maxCountries = Math.max(maxCountries, count);

        for (int i = 0; i < countries.length; i++) {
            int cost = countries[i][0];
            int minBalance = countries[i][1];

            if (!visited[i] && balance >= minBalance) {
                visited[i] = true;
                dfs(balance - cost, count + 1, countries, visited);
                visited[i] = false;
            }
        }
    }
}
