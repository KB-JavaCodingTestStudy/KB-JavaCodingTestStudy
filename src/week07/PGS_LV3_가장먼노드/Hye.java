package week07.PGS_LV3_가장먼노드;

/* ================================================================
 *
 * Problem  : 가장먼노드_Lv3
 * Date     : 2025년 05월 28일
 * 
 * ================================================================
 */

import java.util.*;

public class Hye {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] numbers = {
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}
        };
        System.out.println(s.solution(6, numbers));

    }
    public static class Solution {
        public int solution(int n, int[][] edge) {
            int answer = 0;

            Map<Integer, List<Integer>> graph = new HashMap<>();

            for(int i=1; i<=n; i++){
                graph.put(i, new ArrayList<>());
            }

            for(int[] eg : edge){
                int a = eg[0];
                int b = eg[1];

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            Set<Integer> visited = new HashSet<>();
            ArrayDeque<int[]> queue = new ArrayDeque<>();

            queue.add(new int[]{ 1, 0 });
            visited.add(1);

            int max = 0;
            while(!queue.isEmpty()){
                int[] cur = queue.remove();

                if(max < cur[1]){
                    max = cur[1];
                    answer = 1;
                }else if( max == cur[1]){
                    answer++;
                }

                for(int nextVertex : graph.get(cur[0])){
                    if(!visited.contains(nextVertex)){
                        visited.add(nextVertex);
                        queue.add(new int[]{nextVertex, cur[1] + 1});
                    }
                }
            }

            return answer;
        }
    }
}
