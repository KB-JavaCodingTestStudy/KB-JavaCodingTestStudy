import java.util.*;

class Solution {
    int n;
    int[] num;
    int[] visited;
    List<Integer> now = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        n = numbers.length();
        num = new int[n];
        visited = new int[n];
        
        for(int i=0; i<n; i++) {
            int a = numbers.charAt(i) - '0' ;
            num[i] = a;
        }
        
        dfs();
        return set.size();
    }
    
    public void dfs() {
        sosu(now);
        
        for(int i=0; i<n; i++) {
            if(visited[i]==0) {
                now.add(num[i]);
                visited[i] = 1;
                dfs();
                visited[i] = 0;
                now.remove(now.size()-1);
            }
        }
    }
    
    public void sosu(List<Integer> now) {
        int n = now.size();
        if(n==0) return;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(now.get(i));
        }
        int a = Integer.parseInt(sb.toString());
        
        if(a<=1) return;
        
        for(int i=2; i<a; i++) {
            if(a % i == 0) return;
        }
        set.add(a);
        
    }
}


