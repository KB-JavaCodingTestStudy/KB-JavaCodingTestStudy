import java.io.*;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 05월 20일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - n+1개의 집합에 각각 0부터 n까지의 수가 하나씩 들어있다. ( {0}, {1}, ... , {n} )
 *  - 0 a b 는 a가 든 집합과 b가 든 집합을 합집합 연산한다.
 *  - 1 a b 는 a와 b가 같은 집합에 있으면 YES를, 아니라면 NO를 출력한다.
 *
 * # 입력
 *  - line 1: n m (n: 집합 번호 최대값, m: 이후 나올 연산의 개수)
 *  - line 2~m+1: m줄에 걸쳐 op a b (op: 0 또는 1 / n, m: 0~n 사이의 수)
 *
 * # 출력
 *  - 1 a b 가 나올 때 마다, YES 또는 NO를 한줄에 하나씩 출력한다.
 *
 * 💻 알고리즘 설계
 *  - 유니온 파인드 문제의 전형으로, 0 a b가 나오면 union(a, b)를 하고 1 a b가 나오면 find(a)와 find(b)를 비교하여 YES 또는 NO를 출력한다.
 *
 * ================================================================
 */


public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        parent = new int[n+1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for(; m > 0; m--) {
            input = br.readLine().split(" ");

            int op = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            if(op == 0) {
                union(a, b);
            }
            else if(op == 1) {
                if(find(a) == find(b)) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void union(int a, int b) {
        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    public static int find(int n) {
        if (parent[n] != n)
            parent[n] = find(parent[n]);

        return parent[n];
    }
}
