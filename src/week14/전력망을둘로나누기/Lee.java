import java.util.*;
import java.io.*;

class Solution {
    
    public int[] sub_size;     // sub_size[i] : i번 노드를 루트로 삼는 서브트리의 크기
    public boolean[] visited;  // 방문 여부
    
    public int countSubNodes(List<Integer>[] tree, int k) {
        
        int count = 1;
        
        for(int next : tree[k]) {
            
            if (!visited[next]) {
                
                visited[next] = true;
                
                count += countSubNodes(tree, next);
            }
        }
        
        sub_size[k] = count;
        
        return count;
    }
    
    public int solution(int n, int[][] wires) {

        List<Integer>[] tree = new ArrayList[n+1];
        
        for(int i = 1; i <= n; i++)
            tree[i] = new ArrayList<>();
        
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            tree[a].add(b);
            tree[b].add(a);
        }
        
        sub_size = new int[n+1];
        visited = new boolean[n+1];
        
        countSubNodes(tree, 1);
        
        int min_diff = n;
        
        for(int i = 1; i <= n; i++) {
            int diff = Math.abs(n - sub_size[i] * 2);
            
            min_diff = Math.min(min_diff, diff);
        }
        
        return min_diff;
    }
}
