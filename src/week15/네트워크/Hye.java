package week15.네트워크;

/* ================================================================
 *
 * Problem  : 네트워크_
 * Date     : 2025년 07월 30일
 *
 * ================================================================
 */

import java.util.*;

public class Hye {
    class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0; // 네트워크 개수

            Map<Integer, List<Integer>> adjList = new HashMap<>(); // 인접리스트

            for (int i = 0; i < n; i++) {
                adjList.put(i, new ArrayList<>());
                for (int j = 0; j < n; j++) {
                    if (i != j && computers[i][j] == 1) { // 현재 노드가 아니면서 연결되어 있으면 인접 리스트에 추가
                        adjList.get(i).add(j);
                    }
                }
            }

            Set<Integer> visited = new HashSet<>(); // 방문 집합

            for(int i =0; i< n; i++){
                if(!visited.contains(i)){ // 아직 방문하지 않은 노드가 있다면 기존 네트워크에 포함 X
                    dfs(adjList, visited, i); // 새로운 네트워크 탐색
                    answer++; // 네트워크 개수 증가
                }
            }

            return answer; // 네트워크 개수 반환
        }

        public void dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int curVertex){
            visited.add(curVertex); // 현재 노드 방문

            for(int nextVertex : graph.get(curVertex)){ // 다음 노드 탐색
                if(!visited.contains(nextVertex)){ // 아직 방문하지 않은 노드일 경우
                    dfs(graph, visited, nextVertex); // 재귀 호출
                }
            }
        }
    }
}
