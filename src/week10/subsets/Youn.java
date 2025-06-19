class Solution {
    static List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    void backtrack(int[] nums, int start, List<Integer> ans){
        res.add(new ArrayList<>(ans));
        for(int i=start;i<nums.length;i++){
            ans.add(nums[i]);
            backtrack(nums, i+1,ans);
            ans.remove(ans.size()-1);
        }
    }
}
