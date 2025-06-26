package KB.week08;

/* ================================================================
 *
 * Problem  : LeetCode - Climbing Stairs
 * Author   : 김로아
 * Date     : 2025-06-20
 *
 * ================================================================
 * 📌 문제 분석 요약
 * n개의 계단이 있고 한 번에 1개 혹은 2개씩 오를 수 있을 때, 꼭대기로 갈 수 있는 방법은 몇개?
 *
 * # 입력
 * 계단 개수 n개
 *
 * # 출력
 * 꼭대기까지 가는 방법의 수
 *
 * 💻 알고리즘 설계
 * DP 이용 (재귀로만 하면 시간 초과가 난다.)
 * 1) 해쉬맵으로 memo 만들고 n=1, n=2 경우 저장
 * 2) 3부터 n까지 반복문 돌며 각 경우마다 이전 값들을 더해서 memo에 저장
 * 3) n일 경우의 값 반환
 *
 * ⏰ 시간복잡도
 * O(n)
 * ================================================================
 */

import java.util.HashMap;
import java.util.Map;

class Roa {
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        memo.put(2, 2);

        for (int i = 3; i <= n; i++) {
            memo.put(i, memo.get(i - 1) + memo.get(i - 2));
        }
        return memo.get(n);
    }
}
