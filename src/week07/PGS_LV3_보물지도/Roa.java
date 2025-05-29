package KB.week05;

/* ================================================================
 *
 * Problem  : PGS - 보물지도
 * Author   : 김로아
 * Date     : 2025-05-27
 *
 * ================================================================
 * 📌 문제 분석 요약
 * 1) 크기: 세로 m, 가로 n 크기의 보물 지도
 * 2) 출발점 (1,1)에서 도착점 (m,n)까지 이동해야 함
 * 3) 상/하/좌/우 한 칸 이동 시 시간 +1, 함정은 이동 불가
 * 4) '신비한 신발' 사용 시 한 번만 두 칸 이동 가능, 함정도 넘을 수 있음, 시간은 동일하게 +1
 * 5) 목적지까지의 최소 시간을 구해야 함
 *
 * # 입력
 * - int m: 세로 길이 (행)
 * - int n: 가로 길이 (열)
 * - int[][] hole: 함정의 좌표 목록
 *
 * # 출력
 * - 출발점 (1,1) → 도착점 (m,n)까지 이동하는 데 걸리는 최소 시간
 * - 도달할 수 없다면 -1 반환
 *
 * 💻 알고리즘 설계
 * 1) BFS로 최단 거리 탐색
 *    → 상태 정보: [행, 열, 신발 사용 여부, 시간]
 * 2) visited[r][c][usedShoes] 배열로 상태 방문 여부 체크
 * 3) 함정 여부는 isHole[r][c]로 관리
 * 4) 일반 이동(상하좌우): 방문하지 않았고 함정이 아니면 큐에 삽입
 * 5) 신발 점프(2칸 이동): 신발을 사용하지 않았고, 목적지가 유효하며, 방문하지 않았으면 큐에 삽입
 * 6) 도착점에 도달 시 현재 시간 반환
 * 7) 큐를 모두 탐색해도 도착 못 하면 -1 반환
 *
 * ⏰ 시간복잡도
 *  O(m * n * 2): 위치 (r,c)마다 신발 사용 여부 2가지 상태
 *
 * ================================================================
 */

import java.util.ArrayDeque;
import java.util.Queue;

class Roa {
    // 상, 하, 좌, 우
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    // 행 : m, 열 : n -> solution 안에 변수 순서 바꿈
    public int solution(int m, int n, int[][] hole) {
        Queue<int[]> q = new ArrayDeque<>(); // [r, c, usedShoes, time]
        boolean[][][] visited = new boolean[m + 1][n + 1][2]; // [r][c][usedShoes]
        boolean[][] isHole = new boolean[m + 1][n + 1]; // 함정 여부

        // 함정 위치 표시
        for (int[] h : hole) {
            isHole[h[0]][h[1]] = true;
        }

        // 시작 위치 큐 삽입
        q.add(new int[]{1, 1, 0, 0});
        visited[1][1][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.remove();
            int r = cur[0];
            int c = cur[1];
            int usedShoes = cur[2];
            int time = cur[3];

            // 도착 지점 도달
            if (r == m && c == n) return time;

            // 일반 이동
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (0 < nr && nr <= m && 0 < nc && nc <= n &&
                        !visited[nr][nc][usedShoes] && !isHole[nr][nc]) {
                    visited[nr][nc][usedShoes] = true;
                    q.add(new int[]{nr, nc, usedShoes, time + 1});
                }
            }

            // 점프 이동 (신발 한 번만 사용 가능)
            if (usedShoes == 0) {
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i] * 2;
                    int nc = c + dc[i] * 2;

                    if (0 < nr && nr <= m && 0 < nc && nc <= n &&
                            !visited[nr][nc][1] && !isHole[nr][nc]) {
                        visited[nr][nc][1] = true;
                        q.add(new int[]{nr, nc, 1, time + 1});
                    }
                }
            }
        }

        // 도착 불가능
        return -1;
    }
}
