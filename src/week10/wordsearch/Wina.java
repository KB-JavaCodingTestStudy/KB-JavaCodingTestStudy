package week10.wordsearch;


class Wina {
	
	//	상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, M;
	static String wordN;
	static boolean complete;
	static char[][] boardN;
	
	static void recursion(int r, int c, boolean[][] visited, int idx) {
//		반드시 실행
//		탈출조건
		if (idx == wordN.length() - 1) {
			complete = true;
		}
		
		if (complete) {
			return;
		}

//		탈출하지 않았을 때 로직
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]
					    && boardN[nr][nc] == wordN.charAt(idx + 1)) { //다음 문자가 타겟단어와 동일할 때
				visited[nr][nc] = true;
//		재귀
				recursion(nr, nc, visited, idx + 1);
//		백트래킹
				visited[nr][nc] = false;
			}
		}
	}
	
	public boolean exist(char[][] board, String word) {
//		초기화
		boardN = board;
		N = boardN.length;
		M = boardN[0].length;
		wordN = word;
		complete = false;

//		모든 좌표에서 시작
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (boardN[i][j] == word.charAt(0)) {
					//		사전준비
					boolean[][] visited = new boolean[N][M];
					visited[i][j] = true;
					recursion(i, j, visited, 0);
				}
			}
		}
		return complete;
	}
}
