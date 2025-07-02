package week12.합승택시요금;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
