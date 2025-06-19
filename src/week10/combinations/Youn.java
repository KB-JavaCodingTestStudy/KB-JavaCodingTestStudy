class Solution {
    static List<List<Integer>> res;
    static int len;
    static int count;
    public List<List<Integer>> combine(int n, int k) {
        res= new ArrayList<>();
        len = n;
        count =k;
        combinations(new ArrayList<>(), 1,0);
        return res;
    }
    public void combinations(List<Integer> ans, int start, int idx){
        if(ans.size() == count){
            res.add(new ArrayList<>(ans));            
            return;
        }
        for(int i=start;i<=len;i++){
            ans.add(i);

            combinations(ans, i+1, idx+1);
            ans.remove(ans.size()-1);
        }
    }
}
