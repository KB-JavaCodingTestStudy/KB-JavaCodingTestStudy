import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static char[] ops;
    static boolean[] visited = new boolean[10];
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        ops = new char[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            ops[i] = st.nextToken().charAt(0);
        }

        dfs(0, "");

        Collections.sort(result);
        System.out.println(result.get(result.size() - 1));   // 최대값
        System.out.println(result.get(0));                   // 최소값
    }

    static void dfs(int depth, String num) {
        if (depth == k + 1) {
            result.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                if (depth == 0 || check(num.charAt(depth - 1) - '0', i, ops[depth - 1])) {
                    visited[i] = true;
                    dfs(depth + 1, num + i);
                    visited[i] = false; // 백트래킹
                }
            }
        }
    }

    static boolean check(int a, int b, char op) {
        if (op == '<') return a < b;
        if (op == '>') return a > b;
        return false;
    }
}
