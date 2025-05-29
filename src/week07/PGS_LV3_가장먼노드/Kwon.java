import java.util.*;
      // 1번 노드에서 가장 멀리 떨어진 노드의 갯수 구하기
      //(노드번호, 경로 거리) 함께 관리
      //visited에 거리를 저장
      //Queue<int[]> queue 
      //map 사용

      //가장 먼 거리 계산
      //경로 거리 == 가장 먼 거리인 노드 수 카운트
      //그래프를 돌면서 노드,거리 해시맵에 저장? => 맵을 사용하지 않고 visited 배열에 1이나 true 대신 거리를 저장 가능
class Solution {
    public int solution(int n, int[][] edge) {
        int[] visited = new int[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        int answer = 0;
        
        List<List<Integer>> arr = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            arr.add(i,new ArrayList<>());
        }
        for(int i=0; i<edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        
        q.add(1);
        visited[1] = 0;
        int maxLen = 0;
        
        while(!q.isEmpty()) {
            int now = q.remove();
            int len = visited[now];
            maxLen = Math.max(maxLen, len);
            
            for(int i : arr.get(now)) {
                if(visited[i]==0) {
                    q.add(i);
                    visited[i] = len+1;
                }
            }
        }
        
        for(int i=2; i<=n; i++) {
            System.out.println(visited[i]);
            if(visited[i]==maxLen) {
                answer++;
            }
        }
        
        return answer;
    }
}
