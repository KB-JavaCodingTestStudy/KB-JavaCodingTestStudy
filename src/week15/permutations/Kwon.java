//순열 만들기 문제
class Solution {
    int[] visited;
    List<List<Integer>> answer = new ArrayList<>();  //2차원리스트 정답 배열
    List<Integer> now = new ArrayList<>();
    int n;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        visited = new int[n];  //방문 체크 배열 선언
        dfs(nums);

        return answer;
    }

    public void dfs(int[] nums)  {
      
      //길이를 충족하면 정답 배열에 넣기
        if(now.size() == n) {
          
            //깊은 복사해야됨 주의
            answer.add(new ArrayList<>(now));
            return ;
        }

        for(int i=0; i<n; i++) {
            if(visited[i]==0) {
                visited[i] = 1;  //방문체크
                now.add(nums[i]);
                dfs(nums);  //재귀 돌기
                visited[i]=0;  //방문 해제
                now.remove(now.size()-1);
            }
        }

    }
}
