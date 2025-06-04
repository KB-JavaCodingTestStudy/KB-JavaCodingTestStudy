import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 학생 
        M = Integer.parseInt(st.nextToken()); // 키 비교 

        adj = new boolean[N + 1][N + 1];

        // 키 비교 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int shorter = Integer.parseInt(st.nextToken());
            int taller = Integer.parseInt(st.nextToken());
            adj[shorter][taller] = true; // shorter < taller
        }

        // 플로이드 워셜 알고리즘으로 간접 비교 가능한 관계 갱신
        for (int k = 1; k <= N; k++) {       // 경유지
            for (int i = 1; i <= N; i++) {   // 출발지
                for (int j = 1; j <= N; j++) { // 도착지
                    if (adj[i][k] && adj[k][j]) {
                        adj[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;

        // 각 학생에 대해 비교 가능한 사람 수 확인
        for (int i = 1; i <= N; i++) {
            int count = 0;

            for (int j = 1; j <= N; j++) {
                if (i == j) continue;

                // i가 j보다 크거나 작으면 관계를 아는 것
                if (adj[i][j] || adj[j][i]) {
                    count++;
                }
            }

            if (count == N - 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
