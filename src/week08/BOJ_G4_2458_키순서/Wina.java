package week08.BOJ_G4_2458_키순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Wina {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 비교 횟수
		
		int[][] graph = new int[N + 1][N + 1];
		
		// 입력 받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1; // a < b
		}
		
		// 플로이드-워셜
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (graph[i][k] == 1 && graph[k][j] == 1) {
						graph[i][j] = 1;
					}
				}
			}
		}
		
		// 키 순서를 정확히 알 수 있는 학생 수 구하기
		int result = 0;
		for (int i = 1; i <= N; i++) {
			int count = 0;
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					continue;
				}
				if (graph[i][j] == 1 || graph[j][i] == 1) {
					count++;
				}
			}
			if (count == N - 1) {
				result++;
			}
		}
		
		System.out.println(result);
		br.close();
	}
}
