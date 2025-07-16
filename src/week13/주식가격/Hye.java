package week13.주식가격;

/* ================================================================
 *
 * Problem  : [PGS] 42584_주식가격
 * Author   : 김혜지
 * Date     : 2025년 07월 10일
 * 
 * ================================================================
 * 📌 문제 분석 요약
 * - 초 단위로 기록된 주식가격이 담긴 배열이 주어질 때,
 *   가격이 떨어지지 않은 기간이 몇 초인지 구하는 함수 완성
 *
 * # 입력
 * - 초 단위로 기록된 주식가격이 담긴 배열 prices
 *
 * # 출력
 * - 가격이 떨어지지 않은 기간이 몇 초인지에 대한 배열
 *
 * 💻 알고리즘 설계
 * 1. 스택에는 아직 가격이 떨어지지 않은 가격의 인덱스를 저장한다.
 * 2. 현재 시점 i의 가격이 스택 맨 위 인덱스 j의 가격보다 낮으면, j의 하락 시점이 i
 *     → answer[j] = i - j & j를 스택에서 제거한다.
 * 3. 남은 인덱스는 가격이 떨어지지 않은 경우이므로 N - j - 1
 *
 * ⏰ 시간복잡도
 * - O(N)
 * ================================================================
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Hye {
    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            Deque<Integer> stack = new ArrayDeque<>();

            for(int i = 0; i < prices.length; i++){
                while(!stack.isEmpty()){
                    int j = stack.peek();
                    if(prices[j] > prices[i]){
                        // 현재 시점 i의 가격이 스택 맨 위 인덱스 j의 가격보다 낮으면, j의 하락 시점이 i
                        answer[j] = i - j;
                        stack.pop();
                    }else break;
                }

                stack.push(i); // 현재 시점 인덱스 i 저장
            }

            while(!stack.isEmpty()){
                // 남은 인덱스는 가격이 떨어지지 않은 경우이므로 N - j - 1
                int j = stack.pop();
                answer[j] = prices.length - j - 1;
            }
            return answer;
        }
    }
}
