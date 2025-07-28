/**

풀이 시간: 6min
접근 방식
- visited 배열을 선언하여 이전에 사용한 숫자인지 check
- list를 이용해 만들어지는 숫자 list 저장
- nums를 끝까지 순회하면서, 현재 list의 길이가 nums의 개수와 같다면 res에 삽입

시간 복잡도 
예상: O(N²)
실제: O(N * N!)

입력 배열 길이를 n이라 할 때,순열 개수는 n! (팩토리얼) 입니다.

DFS 탐색 과정에서 깊이 n까지 내려가며, 
각 단계에서 최대 n개의 분기(branch)가 발생하지만 방문한 원소는 다시 방문하지 않으므로, 실제 탐색 경로 수는 n!에 해당합니다.

각 완성된 순열을 res에 추가할 때 new ArrayList<>(list)를 통해 리스트 복사가 일어나는데, 복사 비용은 O(n)입니다.
따라서 전체 시간 복잡도는: O(n⋅n!)  => 모든 순열(n!) 생성 × 순열 복사(n) 비용
*/

class Solution {
    static boolean[] visited;
    static List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        res =new ArrayList<>();

        dfs(nums, new ArrayList<>());

        return res;
        
    }
    public void dfs(int[] nums, List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                list.add(nums[i]);
                dfs(nums, list);
                list.remove(list.size()-1);
                visited[i]=false;
            }
        }

    }

}
