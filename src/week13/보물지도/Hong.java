import java.util.*;

/**
 * [문제 요약]
 * n×m 격자에서 (1,1)에서 (n,m)까지 이동할 때, 각 칸에 구멍(hole)이 있어 밟으면 안됨
 * 이동 방식은
 *  1) 상하좌우 한 칸 이동 (언제나 가능)
 *  2) 상하좌우 두 칸 점프 이동 (한 번만 사용 가능)
 * 를 사용하여 최단 이동 횟수(dist)를 구하는 문제
 *
 * [풀이 요약]
 * - BFS를 사용해 (x, y, jumpUsed) 3차원 상태 공간을 탐색함
 *   visited[x][y][jumpUsed]로 같은 상태 재방문을 방지
 * - 일반 이동(4방향)과 점프 이동(4방향)을 각각 큐에 넣으며, 레벨 단위로 거리를 1씩 증가
 * - 목적지에 처음 도달했을 때의 dist를 반환
 *
 * [시간 복잡도]
 * - 상태 수: n * m * 2         (점프 사용 전/후)
 * - 각 상태에서 최대 8번의 이웃 상태 검사
 * → O(n * m * 2 * 8) ≃ O(n * m)
 */

class Solution {
    public int solution(int n, int m, int[][] hole) {
        // 구멍(이동 불가) 표시
        boolean[][] trap = new boolean[n+1][m+1];
        for (int[] h : hole) {
            trap[h[0]][h[1]] = true;
        }
        
        // visited[x][y][jumpUsed] = true면 이미 방문
        boolean[][][] visited = new boolean[n+1][m+1][2];
        Queue<int[]> queue = new ArrayDeque<>();
        
        // 델타 배열: 일반 이동(1칸) / 점프 이동(2칸)
        int[][] dx1 = { {1,0}, {0,1}, {-1,0}, {0,-1} };
        int[][] dx2 = { {2,0}, {0,2}, {-2,0}, {0,-2} };
        
        // 시작점: (1,1), jumpUsed=0, dist=0
        visited[1][1][0] = true;
        queue.add(new int[]{1, 1, 0, 0});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int x = cur[0], y = cur[1], jump = cur[2], dist = cur[3];
            
            // 목적지 도착 시점에 dist 반환
            if (x == n && y == m) {
                return dist;
            }
            
            // 1) 일반 이동 (항상 가능)
            for (int i = 0; i < 4; i++) {
                int nx = x + dx1[i][0], ny = y + dx1[i][1];
                if (nx >= 1 && nx <= n && ny >= 1 && ny <= m
                    && !visited[nx][ny][jump] && !trap[nx][ny]) {
                    visited[nx][ny][jump] = true;
                    queue.add(new int[]{nx, ny, jump, dist + 1});
                }
            }
