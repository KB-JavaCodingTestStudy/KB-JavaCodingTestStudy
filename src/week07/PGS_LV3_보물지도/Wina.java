package week07.PGS_LV3_보물지도;

import java.util.ArrayDeque;
import java.util.Deque;

class Wina {
	
	private static final int[] dr = {-1, 1, 0, 0};
	private static final int[] dc = {0, 0, -1, 1};
	private static final Deque<Node> dq = new ArrayDeque<>();
	static int WIDTH, HEIGHT;
	static int[][] maps;
	
	
	//	BFS
	static int bfs() {
		boolean[][][] visited = new boolean[HEIGHT + 1][WIDTH + 1][2];
		visited[1][1][0] = true;
		
		while (!dq.isEmpty()) {
			//	현재 노드 방문
			Node now = dq.remove();
			
			//	if 도착지 방문: return dist;
			if (now.r == HEIGHT && now.c == WIDTH) {
				return now.dist;
			}

// 다음 노드 방문
			for (int i = 0; i < 4; i++) {
				int nr = now.r + dr[i], nc = now.c + dc[i];
				if (nr > 0 && nr <= HEIGHT && nc > 0 && nc <= WIDTH && maps[nr][nc] == 0) {
					if (!visited[nr][nc][now.jumped]) {
						dq.offer(new Node(nr, nc, now.dist + 1, now.jumped));
						visited[nr][nc][now.jumped] = true;
					}
				}
			}
			if (now.jumped == 0) {
				for (int i = 0; i < 4; i++) {
					int nr = now.r + dr[i] * 2, nc = now.c + dc[i] * 2;
					if (nr > 0 && nr <= HEIGHT && nc > 0 && nc <= WIDTH && maps[nr][nc] == 0) {
						if (!visited[nr][nc][now.jumped + 1]) {
							dq.offer(new Node(nr, nc, now.dist + 1, now.jumped + 1));
							visited[nr][nc][now.jumped + 1] = true;
						}
					}
				}
			}
			
			
		}
		return -1;
	}
	
	public int solution(int n, int m, int[][] hole) {
//		초기값
		WIDTH = n;
		HEIGHT = m;

//		hole로 배열 구성
		maps = new int[HEIGHT + 1][WIDTH + 1];
		for (int[] h : hole) {
			maps[h[1]][h[0]] = 1;
		}

//		시작점 예약(0,0,dist,jumped)
		dq.add(new Node(1, 1, 0, 0));
		int answer = bfs();
		return answer;
	}
	
	static class Node {
		
		int r;
		int c;
		int dist;
		int jumped;
		
		public Node(int r, int c, int dist, int jumped) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.jumped = jumped;
		}
	}
	
}

