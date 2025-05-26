import java.util.*;
import java.io.*;

class Solution {
    
    int[] node_num;     // i번 노드를 루트로 삼는 서브트리의 크기를 저장
    boolean[] visited;  // 방문 여부
    
    public int solution(int n, int[][] wires) {
        
        /// 매개값으로 그래프 구성 ///
        
        List<Integer>[] tree = new ArrayList[n+1];
        
        for(int i = 0; i < n+1; i++)
            tree[i] = new ArrayList<>();
        
        for(int[] wire : wires) {
            
            int a = wire[0];
            int b = wire[1];
            
            tree[a].add(b);
            tree[b].add(a);
        }
        
        /// 각 서브트리의 크기 계산 ///
        
        node_num = new int[n+1];
        visited = new boolean[n+1];
        
        countNodes(tree, 1);
        
        /// 최솟값 (송전탑 개수 차이) 구하기 ///
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i <= n; i++) {
            
            int diff = Math.abs(n - node_num[i] * 2);
            
            min = Math.min(min, diff);
        }
        
        return min;
    }
    
    // 각 서브트리의 크기를 구하는 함수 (전역변수 node_num에 저장한다.)
    int countNodes(List<Integer>[] tree, int i) {
        
        int count = 1;
        
        for(int next : tree[i]) {
            
            if (!visited[next]) {
                
                visited[next] = true;
                
                count += countNodes(tree, next);
            }
        }
        
        node_num[i] = count;
        
        return count;
    }
}
