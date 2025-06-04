package week08.BOJ_G4_11657_타임머신;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Wina {
	
	// 초기 설정
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
//		입력 받기
		int N, M;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시의 개수
		M = Integer.parseInt(st.nextToken()); // 버스의 개수
		
		List<Edge> edges = new ArrayList<>();
		long[] dist = new long[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); // 출발 도시
			int to = Integer.parseInt(st.nextToken()); // 도착 도시
			int weight = Integer.parseInt(st.nextToken()); // 소요 시간
			
			edges.add(new Edge(from, to, weight));
		}

//		벨만 포드 알고리즘
		dist[1] = 0;
		
		for (int i = 0; i < N - 1; i++) {
			for (Edge edge : edges) {
				if (dist[edge.from] != Integer.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.weight) {
//					업데이트 수행
					dist[edge.to] = dist[edge.from] + edge.weight;
				}
			}
		}
		
		int isCycle = 0;
		for (Edge edge : edges) {
			if (dist[edge.from] != Integer.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.weight) {
//				음수 사이클이 존재하는 경우
				isCycle = 1;
				break;
			}
		}
		
		if (isCycle == 1) {
			bw.write("-1\n");
		} else {
			for (int i = 2; i <= N; i++) {
				if (dist[i] == Integer.MAX_VALUE) {
					bw.write("-1\n");
				} else {
					bw.write(dist[i] + "\n");
				}
			}
		}
		
		//	종료 설정
		bw.flush();
		br.close();
		bw.close();
	}
	
	static class Edge {
		
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
}
