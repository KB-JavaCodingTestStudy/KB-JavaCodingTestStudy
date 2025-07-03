package week12.합승택시요금;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/* ================================================================
 *
 * Problem  : 합승택시요금
 * Subject  : 다익스트라
 * Date     : 2025-07-02
 * ================================================================
 * 📌 문제 분석 요약
 * 어떠한 지점에서 흩어지는 것이 가장 적은 비용을 들이는지 구하는 문제→s,a,b부터 각각의 위치까지 최단경로를 구한 후 한 지점에서의 값을 모두 구하면서 최소값을 반환한다.
 * 일반적인 힙 완전탐색과 동일!
 * 어떻게 문제를 이해하는지가 중요한 문제
 *
 * 💻 알고리즘 설계
 * 1. 초기화
2. fares→graph
3. 다익스트라
    1. 초기화
    2. 초기값
    3. bfs
        1. 이미 방문했다면 skip
        2. 방문표시
        3. 이어져 있는 곳을 돌면서 업데이트해야 한다면
        4. 업데이트(우선순위 큐에 추가)
 *
 * ⏰ 시간복잡도
 *
 * ================================================================
 */

class Wina {
	
	static List<List<Edge>> graph;
	static int N;
	
	static int[] dijkstra(int start) {
//		초기화
		Queue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		int[] cost = new int[N + 1];
		Arrays.fill(cost, Integer.MAX_VALUE);

//		초기값
		cost[start] = 0;
		pq.add(new Node(start, 0));

//		bfs
		while (!pq.isEmpty()) {
			Node now = pq.remove();
			if (visited[now.value]) {
				continue;
			}
			visited[now.value] = true;
			
			for (Edge next : graph.get(now.value)) {
				if (cost[next.node] > cost[now.value] + next.weight) {
					cost[next.node] = cost[now.value] + next.weight;
					pq.add(new Node(next.node, cost[next.node]));
				}
			}
		}
		return cost;
	}
	
	public int solution(int n, int s, int a, int b, int[][] fares) {
//		초기화
		int answer = Integer.MAX_VALUE;
		N = n;
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
//		fares->graph
		for (int[] fare : fares) {
			int from = fare[0];
			int to = fare[1];
			int weight = fare[2];
			graph.get(from).add(new Edge(to, weight));
			graph.get(to).add(new Edge(from, weight));
		}
//		다익스트라
		int[] S = dijkstra(s);
		int[] A = dijkstra(a);
		int[] B = dijkstra(b);
//		최소값 찾기
		for (int i = 1; i <= n; i++) {
			answer = Math.min(answer, S[i] + A[i] + B[i]);
		}
		return answer;
	}
	
	static class Edge {
		
		int node, weight;
		
		public Edge(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}
	
	static class Node implements Comparable<Node> {
		
		int value, dist;
		
		public Node(int value, int dist) {
			this.value = value;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
}
