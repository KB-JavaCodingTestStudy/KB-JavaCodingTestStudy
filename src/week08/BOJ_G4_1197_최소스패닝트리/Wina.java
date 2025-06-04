package week08.BOJ_G4_1197_최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Wina {
	
	// 초기 설정
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
//		입력 받기
		st = new StringTokenizer(br.readLine());
		final int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		final int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); // 시작 정점
			int to = Integer.parseInt(st.nextToken()); // 도착 정점
			int weight = Integer.parseInt(st.nextToken()); // 간선의 가중치
			edges.add(new Edge(from, to, weight));
		}

//		부모 배열 초기화
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

//		간선 정렬
		Collections.sort(edges);
		
		int totalCost = 0; // 최소 스패닝 트리의 총 비용
		for (Edge e : edges) {
			if (union(e.from, e.to)) {
				totalCost += e.weight; // 간선을 선택한 경우 비용 추가
			}
		}

//		출력
		System.out.println(totalCost); // 최소 스패닝 트리의 총 비용 출력
		
		//	종료 설정
		br.close();
	}
	
	static int find(int n) {
		if (n != parent[n]) {
			parent[n] = find(parent[n]); // 경로 압축
		}
		return parent[n];
	}
	
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA == rootB) {
			return false; // 이미 같은 집합에 속함
		}
		parent[rootB] = rootA; // rootB를 rootA의 자식으로 설정
		return true;
	}
	
	static class Edge implements Comparable<Edge> {
		
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
}

