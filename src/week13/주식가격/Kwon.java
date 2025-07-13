//문제도 짧고 만만하게 보았으나 큰코다침
//한번에 안풀림 샤갈...
//노씨 수업 때는 스택으로 풀었으나 그때 적은 설명 다시 봐도 이해 안됨
//큐로 푸는게 훨씬 쉬운 듯

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        
        //큐에 전체 값 삽입
        for(int i=0; i<n; i++) {
            q.add(prices[i]);
        }
        
        //answer에 값 넣기 위한 인덱스 체크용
        int idx = 0;
        
        while(!q.isEmpty()) {
            int now = q.remove();
            int time = 0;
            
            for(int a : q) {
                if(a >= now) time++;
                else {
                    time++; 
                    break;
                }
            }
            
            answer[idx] = time;
            idx++;
        }
        return answer;
    }
}
