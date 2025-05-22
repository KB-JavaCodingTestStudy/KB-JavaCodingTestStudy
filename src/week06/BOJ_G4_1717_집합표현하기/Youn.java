import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제 설명
n개의 원소(1~n)를 각각 집합으로 초기화한 후, 두 집합을 합치거나 두 원소가 같은 집합인지 확인하는 연산을 수행

풀이 방식
Union-Find (Disjoint Set Union, DSU) 알고리즘 사용
find(x): x의 루트 노드를 찾고 경로 압축
union(x, y): 루트끼리 연결 (rank 기준 병합)

자료 구조
arr[]: 각 노드의 부모를 저장하는 배열
rank[]: 트리의 높이를 기반으로 병합 최적화

시간 복잡도
find, union: O(α(n)) ≈ O(1)
전체 쿼리 처리: O(m α(n))

기타
출력은 StringBuilder 사용으로 I/O 성능 향상
arr[a] = find(arr[a])를 통해 경로 압축 최적화 적용
 */

public class N_1717 {
    static int [] arr;
    static int [] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int m  = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        rank = new int[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = i;
            rank[i] = 0;
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(op==0){ union(a,b); }
            else{
                String res = connected(a,b)? "YES" : "NO";
                sb.append(res + "\n");
            }
        }
        System.out.print(sb.toString());
    }
    public static void union(int a, int b) {
        int rootX =find(a);
        int rootY=find(b);
        if(rootX==rootY) return;

        if(rank[rootX] < rank[rootY]){
            arr[rootX] = rootY;
        }else if (rank[rootY] < rank[rootX]){
            arr[rootY] = rootX;
        }else{
            arr[rootY] = rootX;
            rank[rootX]++;
        }
    }
    public static int find(int a) {
        if(arr[a] != a) {
            arr[a] = find(arr[a]);
        }
        return arr[a];
    }

    public static boolean connected(int a, int b) {
        return find(a)==find(b);
    }
}
