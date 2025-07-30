package week15.permutations;

import java.util.ArrayList;
import java.util.List;

public class MJ {
    class Solution {
        //총 숫자 개수
        public int n;
        //방문여부 저장 배열
        public boolean[] visited;
        //answer(정답 저장할 변수값)
        List<List<Integer>> list = new ArrayList<>();

        //permutation을 생성하는 메소드(지금까지 선택한 개수, 현재까지 추가되어 있는 list, 숫자 배열)
        public void dfs(int index, List<Integer> per, int[] nums){
            //선택된 개수가 총 숫자 개수와 같으면
            //모두 선택된 것이므로 정답에 현재 값(per)을 추가
            if(index == n){
                list.add(per);
            }
            //아니라면 모든 숫자 배열에 대하여
            for(int i=0;i<n;i++){
                //방문한 적 없으면
                if(!visited[i]){
                    //방문했어요!
                    visited[i] = true;
                    //해당 값 추가
                    per.add(nums[i]);
                    //재귀! (값 추가되었으므로 1 증가, 값 추가된 배열 전달, 숫자 배열 전달~)
                    dfs(index+1, new ArrayList<>(per), nums);
                    //값 제거(다음으로!)
                    per.remove(per.size()-1);
                    //제거했으므로 방문안했어요로 변경
                    visited[i] = false;
                }
            }
        }
        public List<List<Integer>> permute(int[] nums) {
            //전역 변수 값들을 입력 값의 개수로 초기화
            n = nums.length;
            visited = new boolean[n];
            //permutation을 생성하는 메소드 돌아갑니다~
                //현재 0개 추가되어있으므로 0
                //아무것도 없는 배열로 시작
                //숫자 배열 전달
            dfs(0, new ArrayList<>(), nums);
            //결과 반환!
            return list;
        }
    }
}
