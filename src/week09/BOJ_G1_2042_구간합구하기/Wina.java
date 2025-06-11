package week09.BOJ_G1_2042_구간합구하기;


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

//	자료구조
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		final int K = Integer.parseInt(st.nextToken());
		final int k = (int) Math.ceil(Math.log(N) / Math.log(2));
		long[] nodes = new long[(int) Math.pow(2, k) * 2];
		//		리프노드
		int leafStart = 1 << k;
		for (int i = 0; i < N; i++) {
			nodes[leafStart + i] = Long.parseLong(br.readLine());
		}
//		배열 채우기
		for (int i = leafStart - 1; i > 0; i--) {
			nodes[i] = nodes[2 * i] + nodes[2 * i + 1];
		}
		
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			final int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
//			업데이트
			if (a == 1) {
				int idx = leafStart + b - 1;
				nodes[idx] = c;
				while (idx > 1) {
					idx /= 2;
					nodes[idx] = nodes[idx * 2] + nodes[idx * 2 + 1];
				}
			}
//			구간합 구하기
			else {
				long sum = 0;
				int startIdx = b + leafStart - 1;
				int endIdx = (int) c + leafStart - 1;
				while (startIdx <= endIdx) {
//					노드 선택
					if (startIdx % 2 == 1) {
						sum += nodes[startIdx];
					}
//					노드 선택
					if (endIdx % 2 == 0) {
						sum += nodes[endIdx];
					}
//					업데이트
					startIdx = (startIdx + 1) / 2;
					endIdx = (endIdx - 1) / 2;
				}
				bw.write(sum + "\n");
			}
		}
		
		//	종료 설정
		br.close();
		bw.flush();
		bw.close();
		
	}
	
}
