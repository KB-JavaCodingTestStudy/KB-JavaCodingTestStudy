/**
 * [프로그래머스/LeetCode] 순열(Permutations)
 * 
 * 문제 설명
 * - 서로 다른 정수를 원소로 갖는 배열 nums가 주어질 때,
 *   모든 가능한 순열을 구해서 2차원 리스트로 리턴하시오!
 *   (순서는 상관없음)
 *
 * 접근 방식
 * - 백트래킹(Backtracking) 재귀 탐색으로 모든 경우의 수(순열) 탐색!
 * - 이미 사용한 숫자는 visited 배열로 체크해서 중복 방지!
 *
 * 시간 복잡도
 * - O(N!) (N = nums.length)
 *   (순열은 경우의 수가 n!임! n=6이면 720가지임)
 *
 * 풀이 방식
 * 1. visited 배열로 숫자 사용여부 체크
 * 2. cur 리스트에 순서대로 숫자 넣기
 * 3. cur 길이가 nums 길이랑 같으면 answer에 추가
 * 4. 탐색 끝나면 cur에서 숫자 빼고, visited도 false로 롤백 (백트래킹의 핵심!!)
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> answer = new ArrayList<>();
        // 재귀로 순열 만들어 넣기
        backtrack(nums, visited, answer, new ArrayList<>());
        return answer;
    }

    // 백트래킹 함수! cur은 현재까지 만든 순열, answer에 정답 누적
    void backtrack(int[] nums, boolean[] visited, List<List<Integer>> answer, List<Integer> cur){
        if(cur.size() == nums.length){
            answer.add(new ArrayList<>(cur));
            return;
        }
        // 모든 인덱스 i에 대해서 아직 안 썼으면 골라서 넣고 재귀
        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){ // 아직 사용 안 한 숫자면
                visited[i] = true; // 사용 표시
                cur.add(nums[i]);  // 현재 순열에 숫자 추가
                backtrack(nums, visited, answer, cur);
                cur.remove(cur.size()-1); // 되돌리기(Backtracking) 마지막 원소 삭제
                visited[i] = false; 
            }
        }
    }
}
