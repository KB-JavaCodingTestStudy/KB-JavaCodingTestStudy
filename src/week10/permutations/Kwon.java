class Solution {
    int[] visited;
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> now = new ArrayList<>();
    int n;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        visited = new int[n];
        dfs(nums);

        return answer;
    }

    public void dfs(int[] nums)  {
        if(now.size() == n) {
            answer.add(new ArrayList<>(now));
            return ;
        }

        for(int i=0; i<n; i++) {
            if(visited[i]==0) {
                visited[i] = 1;
                now.add(nums[i]);
                dfs(nums);
                visited[i]=0;
                now.remove(now.size()-1);
            }
        }

    }
}
