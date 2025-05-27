import java.util.*;

class Solution {
    List<List<Integer>> arr = new ArrayList<>();
    boolean[] visited;
    int answer;
    public int solution(int n, int[][] wires) {
        for(int i=0; i<=n; i++) {
            arr.add(new ArrayList<>());
        }
        
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        
        visited = new boolean[n+1];
        
        answer = n;
        dfs(1,n);
        return answer;
    }
    public int dfs(int cur, int n) {
        int count = 1;    //count는 자신을 포함한 하위 노드 갯수의 합
        visited[cur] = true;
        
        for(int i : arr.get(cur)) {
            if(!visited[i]) {
                count += dfs(i, n);
            }
        }
        answer = Math.min(answer, Math.abs(n-count*2));
        
        return count;
    }
}
