import java.util.*;
import java.io.*;

class Solution {
    
    public int[] sub_size;     // sub_size[i] : i번 노드를 루트로 삼는 서브트리의 크기
    public boolean[] visited;  // 방문 여부
    
    public int countSubNodes(List<Integer>[] tree, int k) {
        
        int count = 1;    // 자기 자신 1개 
        
        for(int next : tree[k]) {
            
            if (!visited[next]) {
                
                visited[next] = true;    // 방문 여부를 전역 변수에 기록
                
                count += countSubNodes(tree, next);    // 자식 노드의 서브트리 크기 (개수)
            }
        }
        
        sub_size[k] = count;    // k번 노드의 서브트리 크기를 전역 변수에 기록
        
        return count;
    }
    
    public int solution(int n, int[][] wires) {

        List<Integer>[] tree = new ArrayList[n+1];
        
        for(int i = 1; i <= n; i++)
            tree[i] = new ArrayList<>();
        
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            // 부모 자식 관계를 정확히 알 수 없으므로, 양방향으로 기록한다.
            tree[a].add(b);
            tree[b].add(a);
        }

        // 노드 번호 1~n 까지 사용 (0번은 버려짐)
        sub_size = new int[n+1];
        visited = new boolean[n+1];

        // 1번 노드를 루트로 잡고 각 노드의 모든 서브트리의 크기를 구한다.
        countSubNodes(tree, 1);
        
        int min_diff = n;
        
        for(int i = 1; i <= n; i++) {
            int diff = Math.abs(n - sub_size[i] * 2);    // 서브트리 크기를 기반으로 양쪽 트리의 크기 차이를 구한다.
            
            min_diff = Math.min(min_diff, diff);    // 가장 작은 차이로 갱신해 나간다.
        }
        
        return min_diff;
    }
}
