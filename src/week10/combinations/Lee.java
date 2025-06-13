
/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - n, k가 주어집니다.
 *  - 1 부터 n까지의 자연수 중에서 k개를 순서에 상관없이 선택하여 만들 수 있는 모든 조합을 구합니다.
 *
 * # 입력
 *  - n: 사용할 수 있는 자연수의 최대값 
 *  - k: 조합을 위해 선택할 수의 개수
 *
 * # 반환
 *  - 1~n 까지 자연수 중 k개를 선택해 만들 수 있는 모든 조합 (List형) 을 담은 List를 return
 *
 * 💻 알고리즘 설계
 *  - 빈 리스트에서 출발하여, 백트래킹을 통해 조건에 알맞은 원소를 차례로 골라 리스트에 추가합니다. 
 *  - 해당 리스트의 길이가 k가 되면 그 리스트는 k개의 수를 선택했다는 뜻이므로 정답 리스트에 담기게 됩니다. 
 *  - 중복된 조합을 피하기 위해, 작은 수 부터 차례대로 선택하게 합니다. 즉 largest를 사용하여 현재 리스트에 있는 수 보다 작은 수는 담을 수 없도록 합니다.
 *  - 이렇게 하면 a < b < c 일때 [a, b, c] 는 조합되지만, [b, a, c], [c, a, b] 등은 조합되지 않아 자연스럽게 중복을 피할 수 있습니다. 
 *
 * ================================================================
 */


class Solution {

    public List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        
        backtrack(new ArrayList<>(), 0, n, k);

        return answer;
    }

    public void backtrack(List<Integer> cur, int largest, int n, int k) {

        if(cur.size() == k) {
            answer.add(cur);
            return;
        }

        for(int i = largest + 1; i <= n; i++) {
            List<Integer> next = new ArrayList<>(cur);
            next.add(i);
            backtrack(next, i, n, k);
        }
    }
}
