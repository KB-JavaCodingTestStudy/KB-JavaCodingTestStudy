import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];

        //입력 간선 저장, 방향이 있는 그래프임에 주의
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if(input[j].charAt(0) == '1')
                    graph[i][j] = 1;
            }
        }

        //플로이드 워셜 탐색, k를 통해서 도달 가능한지 체크
        for(int k=0; k<n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(graph[i][k] == 1 && graph[k][j]==1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        //출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }


    }
}
