package week08.BOJ_G4_1197_최소스패닝트리;

/* ================================================================
 *
 * Problem  : 최소 스패닝 트리_G4
 * Author   : 김혜지
 * Date     : 2025년 06월 04일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - 그래프가 주어졌을 때, 최소 스패닝 트리를 구하는 프로그램을 작성해야 한다.
 *   최소 스패닝 트리는 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소입 트리를 말한다.
 *
 * # 입력
 * - 1행 : 정점의 개수 V, 간선의 개수 E
 * - E행 : 각 간선에 대한 정보를 나타내는 세 정보 A B C
 *         ( A 정점과 B 정점이 가중치 C인 간선으로 연결, C는 음수일 수도 있다. )
 *
 * # 출력
 * - 최소 스패닝 트리의 가중치 출력
 *
 * 💻 알고리즘 설계
 * 1. 가중치를 기준으로 정렬한다.
 * 2. 가중치가 낮은 간선부터 하나씩 확인하며 간선의 두 정점 u, v가 서로 다른 집합에 속해 있는지 확인한다.
 *    -> 다른 집합이면 같은 집합으로 합치고 해당 가중치를 결과에 더한다. (+ 선택된 간선 수 증가)
 * 3. 간선이 V-1개 선택되면 MST가 완성된다.
 * 4. 결과값을 출력한다.
 *
 * ⏰ 시간복잡도
 * - O(E log E)
 * ================================================================
 */

import java.io.*;
import java.util.*;

public class Hye {
    static int[] root;

    static int find(int x){
        if(root[x] != x) root[x] = find(root[x]);
        return root[x];
    }

    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB) root[rootB] = rootA;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<int[]> edges = new ArrayList<>();

        for(int i = 0; i < E; i++){
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edges.add(temp);
        }

        edges.sort((a,b) -> Integer.compare(a[2], b[2]));

        root = new int[V + 1];

        for(int i = 1; i <= V; i++) root[i] = i;

        int result = 0;
        int count = 0;

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if(find(u) != find(v)){
                union(u,v);
                result += w;
                count++;
                if(count == V - 1) break;
            }
        }

        System.out.println(result);

    }
}
