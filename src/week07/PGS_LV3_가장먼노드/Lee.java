import java.util.*;

class Solution {
    public int solution(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] shortest = new int[n+1];
        for(int i = 0; i < n+1; i++)
            shortest[i] = n;
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(1);
        shortest[1] = 0;
        int long_shortest = 0;
        
        while(!queue.isEmpty()) {
            int cur = queue.remove();
            
            for(int next : graph.get(cur)) {
                if(shortest[next] == n) {
                    shortest[next] = shortest[cur] + 1;
                    long_shortest = shortest[cur] + 1;
                    queue.add(next);
                }
            }
        }
        
        int cnt = 0;
        
        for(int len : shortest) {
            if (len == long_shortest)
                cnt++;
        }
        
        return cnt;
    }
}
