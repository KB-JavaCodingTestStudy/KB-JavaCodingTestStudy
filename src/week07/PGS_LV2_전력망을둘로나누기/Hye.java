package week07.PGS_LV2_전력망을둘로나누기;

/* ================================================================
 *
 * Problem  : 전력망을둘로나누기_Lv2
 * Date     : 2025년 05월 28일
 * 
 * ================================================================
 */

import java.util.*;

public class Hye {

    class Solution {
        public int solution(int n, int[][] wires) {
            Map<Integer, List<Integer>> maps = new HashMap<>();


            int min = Integer.MAX_VALUE;

            for(int[] wire : wires){
                int a = wire[0];
                int b = wire[1];

                maps.computeIfAbsent(a, k-> new ArrayList<>()).add(b);
                maps.computeIfAbsent(b, k-> new ArrayList<>()).add(a);
            }

            for(int[] cut : wires){
                Set<Integer> visited_left = new HashSet<>();
                Set<Integer> visited_right = new HashSet<>();

                dfs(cut[0], visited_left, cut, maps);
                dfs(cut[1], visited_right, cut, maps);

                if(min > Math.abs(visited_left.size() - visited_right.size())){
                    min = Math.abs(visited_left.size() - visited_right.size());
                }


            }

            return min;
        }

        private void dfs(int cur, Set<Integer> visited, int[] cut, Map<Integer, List<Integer>> maps){
            visited.add(cur);
            for(int next : maps.get(cur)){
                if ((cur == cut[0] && next == cut[1]) || (cur == cut[1] && next == cut[0])) continue;
                if(!visited.contains(next)){
                    dfs(next, visited, cut, maps);
                }

            }
        }
    }
}
