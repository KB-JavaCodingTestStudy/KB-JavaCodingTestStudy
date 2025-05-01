package study.week04.PGS_Lv02_타겟넘버;

import java.util.*;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 05월 01일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - 음이 아닌 정수의 배열 numbers 와 타겟넘버 target 이 주어진다.
 * - numbers의 각 수들은 각각 더하거나 뺄 수 있다. 이들의 합과 차로 target을 만들 수 있는 경우의 수를 출력한다.
 *
 * # 입력
 * - numbers : 음이 아닌 정수 배열
 * - target : 타겟넘버 (numbers의 각 수들을 더하거나 빼서 만들어야 한다.)
 *
 * # 출력
 * - 타겟넘버를 만들 수 있는 방법의 수
 *
 * 💻 알고리즘 설계
 * - 그래프는 없지만 dfs로 풀 수 있는 문제이다.
 * - numbers의 맨 앞의 원소부터 차례로 꺼내서 더하거나 뺀다. (더하거나 빼서 만들어지는 수가 새로운 노드가 된다.)
 * - numbers의 맨 끝까지 도달했을 때 더하거나 빼서 만들어진 수가 target과 같다면 카운트 한다 (return 1)
 * 
 * - dfs 이므로 solution 자체를 재귀로 돌려 해결한다.
 * - 0부터 더하거나 빼는것이 아닌, 반대로 target에서 빼거나 더한다. (어차피 양쪽 모두 진행하므로 순서는 상관없다.) 
 *   이렇게 하면 재귀할 때 따로 인자를 하나 더 전달할 필요가 사라진다.
 * - numbers는 그냥 넘기는 것이 아닌, 맨 앞의 원소만 제거한 새로운 서브 배열을 만들어 다음 재귀함수에 넘긴다.
 *
 * ================================================================
 */

public class Lee {
    public int solution(int[] numbers, int target) {

        if(numbers.length == 0) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }

        int[] next_numbers = Arrays.copyOfRange(numbers, 1, numbers.length);    // 0번 인덱스를 제외한 sub array 생성

        return solution(next_numbers, target - numbers[0]) + solution(next_numbers, target + numbers[0]);
    }
}
