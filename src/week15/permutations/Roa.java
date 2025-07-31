class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length]; // 백트래킹을 위한 방문 배열
        List<List<Integer>> ans = new ArrayList<>(); // 정답 배열
        dfs(nums, new ArrayList<>(), visited, ans);
        return ans;
    }

    public void dfs(int[] nums, List<Integer> path, boolean[] visited, List<List<Integer>> ans){
        if(nums.length==path.size()){ // 한바퀴 돌면 한 케이스 종료
            ans.add(new ArrayList<>(path)); // 한 케이스 정답에 추가
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!visited[i]){
                List<Integer> newPath = new ArrayList<>(path);
                visited[i]=true; // 방문 처리
                newPath.add(nums[i]); // 현재 배열에 추가
                dfs(nums, newPath, visited, ans); 
                visited[i]=false; // 방문 취소 처리 (백트래킹)
                newPath.remove(newPath.size()-1); // 방문 취소 처리 (백트래킹)
            }
        }

    }
}
