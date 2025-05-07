package week04.BOJ_S3_2606_바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Wina {
	
	// 초기 설정
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static boolean[] visited;
	public static List<List<Integer>> graph;
	
	public static void main(String[] args) throws IOException {
//		입력
		int n = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());

//		방문 배열 초기화
		visited = new boolean[n + 1];

//		인접리스트 생성
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
//			무방향 그래프이기에 서로 연결
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		
		bfs(1);
		int cnt = 0;
		for (boolean b : visited) {
			if (b) {
				cnt++;
			}
		}

//		시작노드는 빼줘야 함
		System.out.println(cnt - 1);
		
		//	종료 설정
		br.close();
	}
	
	public static void bfs(int node) {
//		BFS에 사용할 큐 선언
		Queue<Integer> queue = new LinkedList<>();

//		시작 노드 방문 처리 및 큐에 삽입
		visited[node] = true;
		queue.offer(node);

//		큐가 빌 때까지 반복
		while (!queue.isEmpty()) {
//			현재 노드 큐에서 꺼내기
			int cur = queue.poll();

//			현재 노드에 인접한 노드들을 순회
			for (int next : graph.get(cur)) {
//				아직 방문하지 않은 노드라면
				if (!visited[next]) {
//					방문 처리 후 큐에 삽입
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
	}
	
}
