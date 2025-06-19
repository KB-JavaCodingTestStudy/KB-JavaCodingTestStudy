class Solution {
    static List<List<Integer>> res;
    static boolean [] visited;
    public List<List<Integer>> permute(int[] nums) {
         res = new ArrayList<>();
         visited = new boolean[nums.length];
         dfs(nums, new int[nums.length], 0);

         return res;


    }
    static void dfs(int[] nums, int [] ans, int idx){
        if(idx == nums.length){
            res.add(new ArrayList<>());
            for(int v: ans){
                res.get(res.size()-1).add(v);
            }
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                ans[idx] = nums[i];
                dfs(nums, ans, idx+1);
                visited[i]=false;
            }
        }
    }

}
