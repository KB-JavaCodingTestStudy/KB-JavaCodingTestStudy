import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
방향 그래프에서 각 정점에서 다른 모든 정점으로 도달 가능한지 여부(경로 존재 여부)를 구하는 문제
플로이드-워셜 알고리즘을 사용해 모든 정점 쌍에 대해 경로가 존재하는지를 계산
map[i][j]는 i에서 j로 가는 경로가 있으면 1, 없으면 0으로 표현된다.

- 인접 행렬 map을 입력받아 경로 정보를 저장
- 플로이드-워셜 알고리즘을 사용해 map[i][j] = 1인지 여부를 중간 노드 k를 통해 갱신
- 즉, i → k → j 경로가 존재하면 i → j도 도달 가능하므로 1로 표시한다.
- 최종적으로 각 정점 쌍 간 경로 존재 여부를 출력한다.
 */
public class N_11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int [][] map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int j=0;
            while (st.hasMoreTokens()){
                map[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0; k < n; k++){
            for (int i=0; i < n; i++){
                for (int j=0; j < n; j++){
                    if(map[i][j]==1 || (map[i][k]==1 && map[k][j]==1)){
                        map[i][j] = 1;
                    }
                }
            }
        }
        StringBuilder sb= new StringBuilder();
        for(int[] row: map){
            for(int val: row){
                sb.append(val+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
