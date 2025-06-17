package week10.combinations;

import java.util.ArrayList;
import java.util.List;

public class MJ {
    class Solution {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited;
        public void makeCombine(int s, int n, int k, List<Integer> list){
            if(list.size() == k){
                answer.add(new ArrayList<>(list));
                return;
            }
            for(int i=s;i<=n;i++){
                if(!visited[i]){
                    visited[i] = true;
                    list.add(i);
                    makeCombine(i+1, n, k, list);
                    list.remove(list.size()-1);
                    visited[i] = false;
                }
            }
        }
        public List<List<Integer>> combine(int n, int k) {
            visited = new boolean[n+1];
            makeCombine(1, n, k, new ArrayList<>());
            return answer;
        }
    }
}
