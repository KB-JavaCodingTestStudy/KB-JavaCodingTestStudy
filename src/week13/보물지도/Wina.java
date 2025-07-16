package week13.보물지도;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	
	final int[] dr = {-1, 1, 0, 0};
	final int[] dc = {0, 0, -1, 1};
	
	public int solution(int n, int m, int[][] hole) {
//         초기화
		int W = n;
		int H = m;
		Deque<Node> dq = new ArrayDeque<>();
		boolean[][][] visited = new boolean[H][W][2];
		int[][] map = new int[H][W];

//         hole->map
		for (int[] h : hole) {
			int r = h[1] - 1;
			int c = h[0] - 1;
			map[r][c] = 1;
		}

//         초기값
		dq.add(new Node(0, 0, 0, 0));
		visited[0][0][0] = true;

//         완전탐색
		while (!dq.isEmpty()) {
//         - 현재 노드 빼기
			Node cur = dq.remove();

//         - 종료 조건
			if (cur.r == H - 1 && cur.c == W - 1) {
				return cur.dist;
			}

//         - 다음 노드 탐색
			for (int i = 0; i < 4; i++) {
//         -- 한칸만 이동
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

//         -- 방문한적 없고, 범위가 올바르고, 함정이 없는지 확인
				if (nr >= 0 && nr < H && nc >= 0 && nc < W && !visited[nr][nc][cur.jumped]
						    && map[nr][nc] == 0) {
					dq.add(new Node(nr, nc, cur.dist + 1, cur.jumped));
					visited[nr][nc][cur.jumped] = true;
				}

//         -- 두칸 이동
				nr = cur.r + dr[i] * 2;
				nc = cur.c + dc[i] * 2;

//         -- 방문한적 없고, 범위가 올바르고, 함정이 없는지 확인, 신발사용한적 없는지 확인
				if (nr >= 0 && nr < H && nc >= 0 && nc < W && !visited[nr][nc][cur.jumped]
						    && map[nr][nc] == 0 && cur.jumped == 0) {
					dq.add(new Node(nr, nc, cur.dist + 1, 1));
					visited[nr][nc][1] = true;
				}
			}
		}
		return -1;
	}
	
	
	class Node {
		
		int r, c, dist, jumped;
		
		Node(int r, int c, int dist, int jumped) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.jumped = jumped;
		}
	}
}