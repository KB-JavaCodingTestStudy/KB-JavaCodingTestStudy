import java.io.*;
import java.util.*;

public class Main {
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st2.nextToken());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            if (k == 0){
                union(a, b);
            } else if (k == 1) {
                sb.append(yesNo(a, b)).append("\n");
            }
        }
        System.out.println(sb);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    static int find(int x){
        if (parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    static String yesNo(int a, int b){
        a = find(a);
        b = find(b);
        return (a == b) ? "YES" : "NO";
    }
}










