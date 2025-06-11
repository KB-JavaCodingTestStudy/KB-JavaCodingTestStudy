import java.io.*;
import java.util.*;

public class Main {
    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) line = br.readLine();
        StringTokenizer st = new StringTokenizer(line.trim());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            while (line != null && line.trim().isEmpty()) line = br.readLine();
            arr[i] = Long.parseLong(line.trim());
        }

        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int size = 1 << (h + 1);
        tree = new long[size];

        init(1, 0, N - 1);

        int total = M + K;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < total; i++) {
            line = br.readLine();
            while (line != null && line.trim().isEmpty()) line = br.readLine();
            st = new StringTokenizer(line.trim());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(1, 0, N - 1, b - 1, c);
            } else if (a == 2) {
                sb.append(query(1, 0, N - 1, b - 1, (int)c - 1)).append('\n');
            }
        }

        System.out.print(sb);
    }

    static long init(int node, int start, int end) {
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
    }

    static long query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return 0;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right)
             + query(node * 2 + 1, mid + 1, end, left, right);
    }

    static void update(int node, int start, int end, int index, long value) {
        if (index < start || index > end) return;

        if (start == end) {
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, index, value);
        update(node * 2 + 1, mid + 1, end, index, value);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}
