import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 

        int[][] graph = new int[n + 1][n + 1];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1; 
        }


        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (graph[i][k] == 1) { 
                    for (int j = 1; j <= n; j++) {
                        if (graph[k][j] == 1) {
                            graph[i][j] = 1;
                        }
                    }
                }
            }
        }

        int result = 0;

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (graph[i][j] == 1 || graph[j][i] == 1) {
                    count++;
                }
            }
            if (count == n - 1) {
                result++;
            }
        }

        System.out.println(result);
    }
}
