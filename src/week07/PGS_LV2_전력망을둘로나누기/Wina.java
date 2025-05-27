package week07.PGS_LV2_전력망을둘로나누기;

/* ================================================================
 *
 * Problem  : 전력망을 둘로 나누기
 * Author   : 최승아
 * Date     : 2025-05-27
 *
 * ================================================================
 * 📌 문제 분석 요약
 * 하나의 네트워크로 이루어진 노드가 있다.
 * 노드 중 한 군데를 잘랐을 때, 두개의 네트워크가 가장 비슷한 크기가 되게 하고자 한다.
 * 그 비슷한 크기의 차를 절대값으로 반환하라.
 *
 * 💻 알고리즘 설계
 * 입력을 ArrayList로 변환해서 하나의 네트워크 형성
 * ArrayList를 돌면서 한개의 노드를 끊는다
 * 두개의 네트워크 중 한개를 택해서 크기를 구한다.
 * 차이를 구한 후, 최솟값을 저장한다.
 * ============================================================
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Wina {
	
	private static boolean[] visited;
	private static List<List<Integer>> graph;
	private static int size;
	
	static int bfs(int idx) {
		int cnt = 0;
//		초기값 설정
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[size];
		queue.offer(idx);
		visited[idx] = true;

//		큐가 빌 때까지 반복
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			cnt++;

//		현재 노드에 인접한 노드들을 순회
			for (int next : graph.get(cur)) {
//				아직 방문하지 않은 노드라면
				if (!visited[next]) {
//					방문 처리 후 큐에 삽입
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
		return cnt;
	}
	
	public int solution(int n, int[][] wires) {
		size = n + 1;
		graph = new ArrayList<>();
//		그래프를 인접리스트로 생성
		for (int i = 0; i < size; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < wires.length; i++) {
			int from = wires[i][0];
			int to = wires[i][1];
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		
		int min = Integer.MAX_VALUE;

//		간선을 하나씩 끊고, 두 네트워크의 크기를 DFS로 계산
		for (int[] wire : wires) {
			int a = wire[0];
			int b = wire[1];
//			두개의 네트워크로 분리
			graph.get(a).remove(Integer.valueOf(b));
			graph.get(b).remove(Integer.valueOf(a));
//			각 네트워크의 크기 계산
			int cntA = bfs(a);
			int cntB = n - cntA;
			int cnt = Math.abs(cntA - cntB);
//			작은 값으로 업데이트
			min = Math.min(min, cnt);
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		return min;
	}
}