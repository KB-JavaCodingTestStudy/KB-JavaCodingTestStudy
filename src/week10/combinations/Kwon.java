
class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> now = new ArrayList<>();
    int[] visited;
    public List<List<Integer>> combine(int n, int k) {
        visited = new int[n+1];

        dfs(1,n,k);
        return answer;
    }
    void dfs(int idx, int n, int k) {
        if(now.size() == k) {
            answer.add(new ArrayList<>(now));
            return ;
        }

        for(int i=idx; i<n+1; i++) {
            if(visited[i]==0) {
                visited[i] = 1;
                now.add(i);
                dfs(i+1, n, k);
                visited[i] = 0;
                now.remove(now.size()-1);
            }
        }

    }
}
