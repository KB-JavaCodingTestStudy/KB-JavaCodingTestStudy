package week06.BOJ_G5_1916_최소비용구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Wina {
	
	private static final int INF = Integer.MAX_VALUE;
	// 초기 설정
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	//	변수
	private static int N, M;
	private static int A, B;
	private static List<List<Node>> list;
	private static int[] dist;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

//		인접리스트 생성
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		dist = new int[N + 1];
//		무한대로 초기화
		Arrays.fill(dist, INF);

//		입력값으로 인접리스트 만들기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.get(from).add(new Node(to, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

//		다익스트라 알고리즘 실행
		dijkstra(A);
		
		System.out.println(dist[B]);
		//	종료 설정
		br.close();
	}
	
	public static void dijkstra(int start) {
		Queue<Node> queue = new LinkedList<>();
//		시작값 설정
		dist[start] = 0;
		queue.offer(new Node(start, 0));

//		큐가 빌 때까지 반복(모든 노드를 방문할 때까지)
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int current = cur.to;
			int cost = cur.weight;

//			비교하지 않아도 될 때
			if (dist[current] < cost) {
				continue;
			}

//			현재 노드에서 갈 수 있는 모든 인접 노드 탐색
			for (Node next : list.get(current)) {
//				더 짧은 경로를 발견한 경우
				if (dist[next.to] > cost + next.weight) {
					dist[next.to] = cost + next.weight;
					queue.offer(new Node(next.to, dist[next.to]));
				}
			}
		}
	}
	
	//	간선을 표현하는 클래스
	static class Node implements Comparable<Node> {
		
		int to; //도착 정점
		int weight; //가중치
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		//		정렬
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;  //최소 힙
		}
	}
	
}

