package pgs.lv2.p전력망을둘로나누기;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
	
	public int solution(int n, int[][] wires) {
//         초기화
		int answer = n + 1;
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

//         wires->graph
		for (int[] wire : wires) {
			int to = wire[0];
			int from = wire[1];
			graph.get(to).add(from);
			graph.get(from).add(to);
		}

//         wires만큼 돌기
		for (int[] wire : wires) {
//         - 연결 끊기
			int to = wire[0];
			int from = wire[1];
			graph.get(to).remove(Integer.valueOf(from));
			graph.get(from).add(Integer.valueOf(to));
//         - 초기화
			Deque<Integer> dq = new ArrayDeque<>();
			boolean[] visited = new boolean[n + 1];
			int cnt = 0;

//         - 초기값
			dq.add(to);
			visited[to] = true;

//         - 완전탐색
			while (!dq.isEmpty()) {
				int cur = dq.remove();
				cnt++;
				for (int next : graph.get(cur)) {
					if (!visited[next]) {
						dq.add(next);
						visited[next] = true;
					}
				}
			}

//         - 최솟값 업데이트
			answer = Math.min(answer, Math.abs(n - cnt * 2));

//         - 연결 붙이기
			graph.get(to).add(from);
			graph.get(from).add(to);
		}
		return answer;
	}
}