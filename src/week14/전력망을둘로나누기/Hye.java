package week14.전력망을둘로나누기;

/* ================================================================
 *
 * Problem  : 전력망을 둘로 나누기_
 * Author   : 김혜지
 * Date     : 2025년 07월 23일
 *
 * ================================================================
 */

import java.util.*;

public class Hye {
    class Solution {
        public int solution(int n, int[][] wires) {
            int min = Integer.MAX_VALUE;
            Map<Integer, List<Integer>> tree = new HashMap<>();

            for(int[] wire : wires){ // 간선 정보로 트리 구성 (양방향)
                int a = wire[0];
                int b = wire[1];

                tree.putIfAbsent(a, new ArrayList<>());
                tree.putIfAbsent(b, new ArrayList<>());

                tree.get(a).add(b);
                tree.get(b).add(a);
            }

            for(int[] wire : wires){ // 간선 wire를 끊었다고 가정
                Set<Integer> visited1 = new HashSet<>();
                Set<Integer> visited2 = new HashSet<>();

                dfs(wire[0], wire, visited1, tree);
                dfs(wire[1], wire, visited2, tree);

                // 두 전력망이 가지고 있는 송전탑 개수의 최소 차이(절대값)
                int temp = Math.abs(visited1.size() - visited2.size());
                if(temp < min){
                    min=temp;
                }
            }

            return min;

        }

        void dfs(int curVertex, int[] cut, Set<Integer> visited,  Map<Integer, List<Integer>>tree ){
            visited.add(curVertex); // 현재 노드 방문

            for(int nextVertex : tree.get(curVertex)){
                // 만약 현재 노드와 다음 노드가 끊은 간선으로 이어져있다면 방문 X
                if((curVertex == cut[0] && nextVertex == cut[1]) ||
                        (curVertex == cut[1] && nextVertex == cut[0])){
                    continue;
                }

                // 다음 노드를 아직 방문하지 않았다면 재귀 호출
                if(!visited.contains(nextVertex)){
                    dfs(nextVertex, cut, visited, tree);
                }

            }
        }
    }
}
