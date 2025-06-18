import java.util.*;

class Solution {
    int answer;
    int[] visited;
    int n;

    public int solution(int balance, int[][] countries) {
        answer = 0;
        n = countries.length;
        visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (balance >= countries[i][1]) {
                visited[i] = 1; // 방문 체크
                dfs(i, balance, 1, countries);
                visited[i] = 0; // 백트래킹
            }
            if (answer == n) return answer; // 조기 종료
        }
        return answer;
    }

    void dfs(int idx, int b, int c, int[][] countries) {
        answer = Math.max(answer, c);
        b -= countries[idx][0];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && countries[i][1] <= b) {
                visited[i] = 1;
                dfs(i, b, c + 1, countries);
                visited[i] = 0;
            }
        }
    }
    
}
