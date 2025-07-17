import java.util.*;

class Solution {
    /**
     * [문제 요약]
     * prices 배열이 주어질 때, 각 시점의 가격이 떨어지지 않은 기간(초)을 구해 배열로 반환
     *
     * 예: prices = [1, 2, 3, 2, 3]
     *     answer = [4, 3, 1, 1, 0]
     *
     * [풀이 요약]
     * 스택에 “가격이 떨어지지 않은 인덱스”를 저장하며,
     * 새로운 시점 i의 가격이 스택 최상단 인덱스의 가격보다 낮으면
     * 그 인덱스가 가격이 떨어진 시점이 i임을 알 수 있음
     * 꺼낸 인덱스에 대해 (i – idx) 만큼 answer[idx]를 채우고,
     * 스택에 현재 i를 추가
     * 마지막에 스택에 남은 인덱스들은 끝까지 가격이 떨어지지 않은 것이므로
     * (n – idx – 1)초 동안 유지된 것으로 답을 채움
     *
     * [시간 복잡도]
     * 모든 인덱스를 스택에 한 번 넣고 최대 한 번 꺼내므로 O(n)
     */
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 현재 가격이 스택 최상단의 가격보다 낮다면,
            // 그 시점이 가격이 떨어진 시점임
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            // 현재 인덱스를 스택에 쌓음
            stack.push(i);
        }

        // 스택에 남은 인덱스는 끝까지 가격이 떨어지지 않은 경우
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = (n - 1) - idx;
        }

        return answer;
    }
}
