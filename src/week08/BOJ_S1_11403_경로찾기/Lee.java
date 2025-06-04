import java.util.*;
import java.io.*;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 유향 그래프가 주어진다. 특정 노드에서 다른 노드로 이동 가능한 경로가 존재하는지 찾아야 한다.
 *  - 길이가 양수인 경로 조건 : 간선을 거치지 않고 자기 자신으로 향하는 경우를 배제하는 조건이다. 최소한 사이클을 거쳐서 다른 노드를 지나 되돌아 와야 한다.
 *
 * # 입력
 *  - line 1: n
 *  - line 2~n+1: 그래프의 인접 행렬. i번째 줄의 j번째 숫자가 1인 경우에는 i에서 j로 가는 간선이 존재한다는 뜻이고, 0인 경우는 없다는 뜻이다. i번째 줄의 i번째 숫자는 항상 0이다.
 *
 * # 출력
 *  - 총 N개의 줄에 걸쳐서 문제의 정답을 인접행렬 형식으로 출력한다. 정점 i에서 j로 가는 길이가 양수인 경로가 있으면 i번째 줄의 j번째 숫자를 1로, 없으면 0으로 출력해야 한다.
 *
 * 💻 알고리즘 설계
 *  - 플로이드 워셜을 통해 각 노드 사이의 거리를 계산하지만 조금 다르다.
 *  - 0은 길이 없다는 뜻이므로 사실상 INF 이다. 따라서 0 + ? 는 0으로 생각해야 한다.
 *  - 또한 1은 단순히 길이 존재한다는 뜻으로 거리 자체는 중요하지 않다. 따라서 1 + 1은 1로 생각해야 한다.
 *  - 즉, 1 + 1 일 때만 1로 갱신하고 나머지는 그대로 두면 된다.
 *
 * ================================================================
 */

public class Lee {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];

        for(int i = 0; i < n; i++){
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[i] = line;
        }

        for(int m = 0; m < n; m++) {
            for(int s = 0; s < n; s++) {
                for(int e = 0; e < n; e++) {
                    if (graph[s][m] + graph[m][e] == 2)
                        graph[s][e] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                bw.write(graph[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();

        bw.close();
        br.close();
    }
}
