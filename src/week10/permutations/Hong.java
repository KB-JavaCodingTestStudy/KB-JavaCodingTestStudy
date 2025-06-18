class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(nums, visited, answer, new ArrayList<>());
        return answer;
    }

    void backtrack(int[] nums, boolean[] visited, List<List<Integer>> answer, List<Integer> cur){
        if(cur.size() == nums.length){
            answer.add(new ArrayList<>(cur));
            return;
        }
          for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                cur.add(nums[i]);
                backtrack(nums, visited, answer, cur);
                cur.remove(cur.size()-1);
                visited[i] = false;
            }
        }
    }
}
