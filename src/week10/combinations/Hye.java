package week10.combinations;

/* ================================================================
 *
 * Problem  : combinations_Medium
 * Author   : 김혜지
 * Date     : 2025년 06월 16일
 * 
 * ================================================================
 * 📌 문제 분석 요약
 * - 1부터 n까지 자연수 중에서 서로 다른 k개의 숫자를 선택하는 모든 조합(combination)을 구하는 문제.
 * - 조합은 순서와 상관없이 선택된 숫자들의 집합이므로, 동일한 숫자 조합은 한 번만 포함되어야 함.
 *
 * # 입력
 * - 정수 n (1 ≤ n ≤ 20): 조합의 범위를 나타냄 (1부터 n까지)
 * - 정수 k (1 ≤ k ≤ n): 조합에 포함될 숫자의 개수
 *
 * # 출력
 * - 가능한 모든 k개의 조합을 리스트 형태로 반환
 *
 * 💻 알고리즘 설계
 * - 백트래킹(재귀 탐색) 방식으로 조합 생성:
 *   > 현재 조합(combination)을 저장하는 리스트를 유지하며 재귀 탐색
 *   > 시작 인덱스부터 n까지 순차적으로 숫자를 선택하면서 조합을 구성
 *   > 조합의 길이가 k가 되면 결과 리스트에 추가
 *   > 선택한 숫자는 재사용하지 않으며, 다음 재귀 호출에서는 현재 숫자보다 큰 값부터 선택
 *
 * ⏰ 시간복잡도
 * - O(C(n, k) * k)
 *   > C(n, k) - 가능한 조합의 수
 *   > k - 각 조합을 복사 및 저장하는 데 드는 시간
 * ================================================================
 */

import java.util.*;

public class Hye {

    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> path = new ArrayList<>();

            dfs(result, path, 1, n, k);

            return result;

        }

        void dfs(List<List<Integer>> result, List<Integer> path, int start, int n, int k){
            if(path.size() == k){
                result.add(new ArrayList<>(path));
                return;
            }

            for(int i = start; i <= n; i++){
                path.add(i);
                dfs(result, path, i+1, n, k);
                path.remove(path.size() - 1);
            }
        }
    }
}
