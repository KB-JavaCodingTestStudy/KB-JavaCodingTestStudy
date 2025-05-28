package week07.PGS_LV3_가장먼노드;

/* ================================================================
 *
 * Problem  : 가장 먼 노드
 * Author   : 최승아
 * Date     : 2025-05-28
 *
 * ================================================================
 * 📌 문제 분석 요약
 * n개의 노드가 있는 그래프가 있다. 1번 노드에서 가장 먼 노드의 갯수를 구해라.
 *
 * 💻 알고리즘 설계
 * edge를 이용해서 그래프를 생성한다.
 * 그래프를 bfs를 이용해서 최단경로를 구하고, 해당 거리를 n개의 배열에 저장한다.
 * 배열에서 가장 큰 값을 구한 후, 해당 배열에서 최대값의 개수를 구한다.
 *
 *
 * ⏰ 시간복잡도
 *
 * ================================================================
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Wina {
	
	static int[] distList;
	static int max = Integer.MIN_VALUE;
	
	public int solution(int n, int[][] edge) {
		int answer = 0;

//		인접 리스트 생성
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < edge.length; i++) {
			int to = edge[i][0];
			int from = edge[i][1];
			graph.get(to).add(from);
			graph.get(from).add(to);
		}
		
		distList = new int[n + 1];
		Arrays.fill(distList, -1);
		
		Deque<Integer> dq = new ArrayDeque<>();
		boolean[] visited = new boolean[n + 1];
//		초기값
		dq.add(1);
		visited[1] = true;
		distList[1] = 0;

//		완전탐색하면서 최단거리 저장
		while (!dq.isEmpty()) {
			int cur = dq.remove();
			
			for (int next : graph.get(cur)) {
				if (!visited[next]) {
					dq.add(next);
					visited[next] = true;
					distList[next] = distList[cur] + 1;

//					최고 길이 저장
					max = Math.max(max, distList[next]);
				}
			}
		}

//		배열에서 max의 값 개수 구하기
		for (int i = 1; i <= n; i++) {
			if (max == distList[i]) {
				answer++;
			}
		}
		return answer;
	}
}
