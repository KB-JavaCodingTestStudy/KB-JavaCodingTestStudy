package week09.BOJ_G3_11437_LCA;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Wina {
	
	// 초기 설정
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	//	자료구조
	static Map<Integer, Node> tree;
	static int[] parent;
	static int[] depth;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
//		노드의 개수
		final int N = Integer.parseInt(br.readLine());
		tree = new HashMap<>();

//		초기화
		for (int i = 0; i <= N; i++) {
			tree.put(i, new Node(i));
		}
		parent = new int[N + 1];
		depth = new int[N + 1];
		visited = new boolean[N + 1];

//		트리 구성
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
//			연결
			tree.get(p).children.add(tree.get(c));
			tree.get(c).children.add(tree.get(p));
		}

//		초기값
//		깊이 저장
		dfs(tree.get(1), 0);

//		공통 조상을 알고 싶은 쌍의 개수
		final int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			System.out.println(lca(n1, n2));
		}
		
		//	종료 설정
		br.close();
	}
	
	static int lca(int n1, int n2) {
//		깊이를 둘이 맞춰줌
		while (depth[n1] > depth[n2]) {
			n1 = parent[n1];
		}
		while (depth[n2] > depth[n1]) {
			n2 = parent[n2];
		}

//		조상이 같아질 때까지 이동
		while (n1 != n2) {
			n1 = parent[n1];
			n2 = parent[n2];
		}
		return n1;
	}
	
	static void dfs(Node node, int d) {
		visited[node.data] = true;
		depth[node.data] = d;
		for (Node c : node.children) {
			if (!visited[c.data]) {
				parent[c.data] = node.data;
				dfs(c, d + 1);
			}
		}
	}
	
	static class Node {
		
		int data;
		Set<Node> children = new HashSet<>();
		
		public Node(int data) {
			this.data = data;
		}
	}
}
