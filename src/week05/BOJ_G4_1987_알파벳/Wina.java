package week05.BOJ_G4_1987_알파벳;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Wina {
	
	private static final int[] dr = new int[]{-1, 1, 0, 0};
	private static final int[] dc = new int[]{0, 0, -1, 1};
	private static final boolean[] visited = new boolean[26];
	// 초기 설정
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	private static int[][] alphabets;
	private static int R, C;
	private static int max = 0;
	
	public static void main(String[] args) throws IOException {
//		입력
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alphabets = new int[R][C];
		for (int r = 0; r < R; r++) {
			String line = br.readLine();
			for (int c = 0; c < C; c++) {
				alphabets[r][c] = line.charAt(c) - 65;
			}
		}

//		dfs
		dfs(0, 0, 1);
		
		System.out.println(max);
		//	종료 설정
		br.close();
	}
	
	static void dfs(int r, int c, int cnt) {

//		들어온 값 방문 처리 및 최대값 비교
		visited[alphabets[r][c]] = true;
		max = Math.max(max, cnt);
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
//			들어갈 수 있는 조건인지 확인
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[alphabets[nr][nc]]) {
				dfs(nr, nc, cnt + 1);
			}
		}
		//			백트래킹을 위해 false 처리
		visited[alphabets[r][c]] = false;
	}
}

