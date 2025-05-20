package week06.BOJ_G3_2623_음악프로그램;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Wina {
	
	// 초기 설정
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	//	변수
	static List<List<Integer>> graph;
	static int[] indegree;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		indegree = new int[N + 1];

//		인접리스트 초기화
		for (int n = 0; n <= N; n++) {
			graph.add(new ArrayList<>());
		}

//		그래프 구성
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			for (int i = 1; i < cnt; i++) {
				int next = Integer.parseInt(st.nextToken());
				graph.get(prev).add(next);
				indegree[next]++;
				prev = next;
			}
		}

//		위상 정렬
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		for (int n = 1; n <= N; n++) {
			if (indegree[n] == 0) {
				queue.offer(n);
			}
		}
		while (!queue.isEmpty()) {
			int cur = queue.poll();
//				정렬 결과 리스트에 추가
			result.add(cur);
			bw.write(cur + "\n");
			for (int next : graph.get(cur)) {
//					진입 차수 감소
				indegree[next]--;
//					진입 차수가 0일 때 큐에 삽입
				if (indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
		
		if (result.size() != N) {
//			사이클 발생 시
			System.out.println(0);
		} else {
			bw.flush();
		}
		
		//	종료 설정
		br.close();
		bw.close();
		
	}
	
}
