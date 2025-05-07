package week04.PGS_Lv02_타겟넘버;

/* ================================================================
 *
 * Problem  : 타겟넘버_Lv2
 * Author   : 김혜지
 * Date     : 2025년 05월 07일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - n개의 음이 아닌 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버 만들기
 *
 * # 입력
 * - 사용할 수 있는 숫자가 담긴 배열 numbers
 * - 타겟 넘버 target
 *
 * # 출력
 * - 타겟 넘버를 만드는 방법의 수
 *
 * 💻 알고리즘 설계
 * 1. DFS 사용하여 모든 경우의 수 계산하기 - 트리 구조
 *
 * ⏰ 시간복잡도
 * - O(2^n)
 * ================================================================
 */
public class Hye {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] numbers = {4, 1, 2, 1};
        System.out.println(s.solution(numbers, 4));

    }

    static class Solution {
        int answer = 0;
        public int solution(int[] numbers, int target) {
            dfs(0, numbers, target, 0);
            return answer;
        }

        private void dfs(int depth, int[] numbers, int target, int result){
            if(depth == numbers.length){
                if(result== target){
                    answer++;
                }
                return;
            }
            dfs(depth+1, numbers, target, result + numbers[depth]);
            dfs(depth+1, numbers, target, result - numbers[depth]);
        }
    }

}
