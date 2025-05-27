package week07.PGS_LV2_게임맵최단거리;

/* ================================================================
 *
 * Problem  : 게임맵 최단거리
 * Author   : 최승아
 * Date     : 2025-05-27
 *
 * ================================================================
 * 📌 문제 분석 요약
 * 1,1에서 출발해서 n,m에 도달할 수 있는 최단거리 cnt를 구해라
 * 만약 갈 수 없다면 -1을 리턴해라
 * 상하좌우로만 움직일 수 있다.
 *
 * 💻 알고리즘 설계
 * 최단 거리이기 때문에 BFS를 사용해서 풀이한다.
 *
 *
 * ================================================================
 */

import java.util.ArrayDeque;
import java.util.Deque;

class Wina {
	
	//	상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	//	변수 설정
	static Deque<State> dq; //int에 들어갈 값: cr,cc,dist
	static boolean[][] visited;
	
	public int solution(int[][] maps) {
		final int N = maps.length;
		final int M = maps[0].length;

//		초기화
		visited = new boolean[N][M];
		dq = new ArrayDeque<>();

//		시작점과 종점이 0이면 문제를 풀이할 수 없음
		if (maps[0][0] == 0 || maps[N - 1][M - 1] == 0) {
			return -1;
		}

//		초기값
		dq.add(new State(0, 0, 1));
		visited[0][0] = true;
		
		while (!dq.isEmpty()) {
			State cur = dq.remove();

//			종료 조건
			if (cur.r == N - 1 && cur.c == M - 1) {
				return cur.dist;
			}

//			최단거리 탐색
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && maps[nr][nc] == 1) {
					dq.add(new State(nr, nc, cur.dist + 1));
					visited[nr][nc] = true;
				}
			}
		}
		
		return -1;
	}
	
	class State {
		
		private final int r;
		private final int c;
		private final int dist;
		
		public State(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
}
