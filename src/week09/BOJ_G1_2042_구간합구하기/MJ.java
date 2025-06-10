package week09.BOJ_G1_2042_구간합구하기;

import java.io.*;
import java.util.StringTokenizer;

public class MJ {
    static long[] tree;
    static long[] arr;

    // 세그먼트 트리 구축
    public static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(2 * node, start, mid);
            build(2 * node + 1, mid + 1, end);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    // 특정 위치 값 갱신
    public static void update(int node, int start, int end, int index, long newValue) {
        if (index < start || index > end) return;

        if (start == end) {
            arr[index] = newValue;
            tree[node] = newValue;
            return;
        }

        int mid = (start + end) / 2;
        update(2 * node, start, mid, index, newValue);
        update(2 * node + 1, mid + 1, end, index, newValue);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    // 구간 합 쿼리
    public static long query(int node, int start, int end, int left, long right) {
        if (right < start || end < left) return 0;//범위에서 벗어나는 값
        if (left <= start && end <= right) return tree[node];//left와 right 사이 값

        // 애매한 값은 더 작은 범위의 합을 확인
        int mid = (start + end) / 2;
        return query(2 * node, start, mid, left, right) + query(2 * node + 1, mid + 1, end, left, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n];
        tree = new long[n * 4];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        build(1, 0, n - 1);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(1, 0, n - 1, b - 1, c);  // 인덱스 0 기반
            } else if (a == 2) {
                long result = query(1, 0, n - 1, b - 1,  c - 1);
                bw.write(result + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
