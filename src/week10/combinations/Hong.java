class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();

        backtrack(answer, new ArrayList<>(), 1, n, k);
        return answer;
    }
    void backtrack(List<List<Integer>> answer, List<Integer> cur, int start, int n, int k){
        if(cur.size() == k){
            answer.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start; i <= n; i++){
            cur.add(i);
            backtrack(answer, cur, i+1, n, k);
            cur.remove(cur.size()-1);
        }
    }
}
