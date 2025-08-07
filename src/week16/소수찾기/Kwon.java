import java.util.*;

class Solution {
    int n;
    int[] num;
    int[] visited;
    List<Integer> now = new ArrayList<>();
  
    //중복 방지를 위해 최종 결과물 저장에 set을 사용
    Set<Integer> set = new HashSet<>();
    
    
    public int solution(String numbers) {
        //numbers 사이즈
        n = numbers.length();
        
        //숫자(값) 배열
        num = new int[n]; 
        
        //방문 체크할 배열
        visited = new int[n];
        
        for(int i=0; i<n; i++) {
            int a = numbers.charAt(i) - '0';
            num[i] = a;
        }
        dfs();
        
        return set.size();
    }
    
    //dfs로 완전 탐색 돌기
    public void dfs() {
        sosu(now);
        
        for(int i=0; i<n; i++) {
            if(visited[i]==0) {
                now.add(num[i]);
                visited[i] = 1;
                //재귀
                dfs();
                //백트래킹 사용 취소 처리
                visited[i] = 0;
                now.remove(now.size()-1);
            }
        }
        
    }
    
    public void sosu(List<Integer> now) {
        int n = now.size();
        if(n==0) return;
        
        //리스트에 순서대로 저장되어있는 현재 값을 int로 바꾸기
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++) {
            sb.append(now.get(i));
        }
        int a = Integer.parseInt(sb.toString());
        
        if(a<=1) return;
        
        for(int i=2; i<a; i++) {
            //a가 소수가 아닌경우
            if(a%i==0) return;
        }
        set.add(a);
        
    }
}
