import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static char[] signs;
    static boolean[] visited = new boolean[10];
    static List<String> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        signs = new char[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            signs[i] = st.nextToken().charAt(0);
        }

        dfs(0, "");
        Collections.sort(results);
        System.out.println(results.get(results.size() - 1)); // 최대
        System.out.println(results.get(0));                  // 최소
    }

    static void dfs(int depth, String num) {
        if (depth == k + 1) {
            results.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                if (depth == 0 || isValid(num.charAt(depth - 1) - '0', i, signs[depth - 1])) {
                    visited[i] = true;
                    dfs(depth + 1, num + i);
                    visited[i] = false;
                }
            }
        }
    }

    static boolean isValid(int a, int b, char sign) {
        if (sign == '<') return a < b;
        if (sign == '>') return a > b;
        return false;
    }
}


