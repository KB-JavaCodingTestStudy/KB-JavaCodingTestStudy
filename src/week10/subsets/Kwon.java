class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> now = new ArrayList<>();
    //int[] visited;
    int n;

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        //visited = new int[n];
        dfs(0, nums);

        return answer;
    }

    void dfs (int idx, int[] nums) {
        answer.add(new ArrayList<>(now));

        for(int i=idx; i<n; i++) {
            //if(visited[i]==0) {
                //visited[i] = 1;
                now.add(nums[i]);
                dfs(i+1, nums);
                //visited[i] = 0;
                now.remove(now.size()-1);
            //}
        }
    }
}
