package week10.permutations;

import java.util.ArrayList;
import java.util.List;

public class MJ {
    class Solution {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited;
        //int
        public void makePermute(int max, int[] nums, List<Integer> list){
            if(list.size()==max){
                answer.add(new ArrayList<>(list));
                return;
            }
            for(int i=0;i<max;i++){
                if(!visited[i]){
                    visited[i] = true;
                    list.add(nums[i]);
                    makePermute(max, nums, list);
                    list.remove(list.size()-1);
                    visited[i] = false;
                }
            }

        }
        public List<List<Integer>> permute(int[] nums) {
            visited = new boolean[nums.length];
            makePermute(nums.length, nums, new ArrayList<>());
            return answer;
        }
    }
}
