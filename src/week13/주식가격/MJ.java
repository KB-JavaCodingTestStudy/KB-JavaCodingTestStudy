package week13.주식가격;

import java.util.ArrayDeque;
import java.util.Deque;

public class MJ {
    class Solution {
        public int[] solution(int[] prices) {
            int n = prices.length;
            //기간만큼의 배열로 생성
            int[] answer = new int[n];

            //값을 추가할 Deque 자료 구조
            Deque<int[]> deque = new ArrayDeque<>();

            // prices를 처음부터
            for(int i=0;i<n;i++){
                //만약 deque가 존재하고 이전값이 지금보다 큰 경우(=떨어진 경우)
                while(!deque.isEmpty() && deque.getLast()[0]>prices[i]){
                    //해당 값 제거 = 이미 떨어진 값이므로
                    int tmp = deque.removeLast()[1];
                    //현재 값에서 해당 일자를 뺀 값으로 업데이트
                    // 즉, 해당 일자부터 지금까지 일 수
                    //-> 그 전에 겁사했을 때는 걸리지 않음 = 떨어지지 않았음
                    answer[tmp] = i-tmp;
                }
                //해당 값 추가
                deque.addLast(new int[]{prices[i], i});

            }

            //끝날 때까지 떨어지지 않는 경우는 deque에 남아 있음
            //즉, 끝날 때 날짜에서 해당 일자를 빼면 떨어지지 않은 일 수가 됨
            while(!deque.isEmpty()){
                //해당 일자 제거 및 반환
                int tmp = deque.removeLast()[1];
                //해당 일자를 총 기간에서 제거
                //여기서 일자는 0-index이므로 실제 길이-1
                answer[tmp] = n-tmp-1;
            }

            return answer;
        }
    }
}
