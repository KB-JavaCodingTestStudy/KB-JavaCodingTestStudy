package week08.BOJ_S1_11403_경로찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Wina {
	
	// 초기 설정
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		final int INF = Integer.MAX_VALUE;
//		입력 받기
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];

//		그래프의 인접행렬 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		플로이드 워셜로 경로 업데이트
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (graph[i][k] == 1 && graph[k][j] == 1) {
						graph[i][j] = 1;
					}
				}
			}
		}

//		출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.write(graph[i][j] + " ");
			}
			bw.newLine();
		}
		
		//	종료 설정
		bw.flush();
		br.close();
		bw.close();
	}
}
