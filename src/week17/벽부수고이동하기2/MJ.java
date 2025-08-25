package week17.벽부수고이동하기2;
//  Link: https://www.acmicpc.net/problem/14442

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
방문 여부 잊지 말기
가능한 범위 체크 필수
* */

public class MJ {
    //상하좌우 이동
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    //방문여부 배열
    public static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //결과값 (방문 불가시 -1)
        int result = -1;

        String input = br.readLine();
        String[] inputArray = input.split(" ");
        // 목적지 (n, m)
        int n = Integer.parseInt(inputArray[0]);
        int m = Integer.parseInt(inputArray[1]);

        //부술 수 있는 벽의 개수
        int k = Integer.parseInt(inputArray[2]);

        int[][] matrix = new int[n][m];
        visited = new boolean[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = line;
        }

        Deque<int[]> deque = new ArrayDeque<>();
        //초기값
        deque.addLast(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;
        // 위치 n,m ,  이동거리, 파괴한 벽의 수

        while (!deque.isEmpty()) {
            int[] cur = deque.removeFirst();
            // 목적지 도착시
            if (cur[0] == n - 1 && cur[1] == m - 1) {
                // 현재까지 이동한 값 결과에 저장
                result = cur[2];
                //종료(현재가 최적의 결과)
                break;
            }
            //상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                //이동 불가능하면 패스
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                //벽이 없고 방문한 적이 없으면
                if (matrix[nx][ny] == 0 && !visited[nx][ny][cur[3]]) {
                    //이동하고 이동거리+1
                    deque.addLast(new int[]{nx, ny, cur[2] + 1, cur[3]});
                    //방문 여부 업데이트
                    visited[nx][ny][cur[3]] = true;
                }
                //벽이 있으면 벽 부술 수 있는지 확인 & 방문 여부 확인
                else if (matrix[nx][ny] == 1 && cur[3] < k && !visited[nx][ny][cur[3] + 1]) {
                    //이동하고 이동거리+1 & 벽 부순 회수 증가
                    deque.addLast(new int[]{nx, ny, cur[2] + 1, cur[3] + 1});
                    //방문 여부 업데이트
                    visited[nx][ny][cur[3] + 1] = true;
                }
            }
        }
        //결과 출력
        bw.write(result + "");
        bw.flush();
    }
}
