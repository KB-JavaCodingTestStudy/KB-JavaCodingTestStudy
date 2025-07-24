import java.util.*;

class Solution {
    
    List<List<Integer>> arr = new ArrayList<>();
    int answer;

    public int solution(int n, int[][] wires) {
        answer = n;
        for(int i=0; i<=n; i++) {
            arr.add(new ArrayList<>());
        }
        for(int i=0; i<wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        
        boolean[] visited = new boolean[n+1];
        dfs(visited, 1, n);
        
        return answer;
    }
    
    public int dfs(boolean[] visited, int cur, int n) {
        int count = 1;
        visited[cur] = true;
        
        for(int i:arr.get(cur)) {
            if(!visited[i]) {
                count += dfs(visited, i, n);
            }
        }
        answer = Math.min(answer, Math.abs(n-count*2));
        return count;
    }
}
