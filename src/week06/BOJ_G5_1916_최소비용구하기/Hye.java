package week06.BOJ_G5_1916_최소비용구하기;

/* ================================================================
 *
 * Problem  : 최소 비용 구하기_G5
 * Author   : 김혜지
 * Date     : 2025년 05월 20일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - 가중치가 있는 방향 그래프
 * - 주어진 출발점에서 도착점까지 가는 데 드는 최소 비용 구하기
 *
 * # 입력
 * - 1행 : 도시의 개수 N ( 1 <= N <= 1000 )
 * - 2행 : 버스의 개수 M ( 1 <= M <= 100000 )
 * - M행 : 출발 도시 A, 도착 도시 B, 비용 C
 * - 마지막행 : 출발 도시, 도착 도시
 *
 * # 출력
 * - 출발 도시에서 도착 도시까지 가는데 드는 최소 비용 출력
 *
 * 💻 알고리즘 설계
 * 1. 도시의 개수 n과 버스의 개수 m 입력 받기
 * 2. m만큼 출발지와 도착지, 비용을 입력 받기
 * 3. BFS를 이용해 각 노드마다의 비용을 갱신하면서 탐색하기
 * 4. 도착지 노드에서의 비용 출력
 *
 * ⏰ 시간복잡도
 * - O(m log n)
 * -> 노드의 개수 : n, 간선의 개수 : m
 * ================================================================
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Node>> list = new ArrayList<>();
        for(int i = 0; i <= n; i ++){
            list.add(new ArrayList<>());
        }
        StringTokenizer st;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list.get(A).add(new Node(B,C));

        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.C - n2.C);
        queue.add(new Node(start, 0));

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int curB = cur.B;
            int curC = cur.C;

            if(dist[curB] < curC) continue;

            for(Node next: list.get(curB)){
                int nextB = next.B;
                int nextC = next.C + curC;
                if(nextC < dist[nextB]){
                    dist[nextB] = nextC;
                    queue.add(new Node(nextB, nextC));
                }

            }
        }

        System.out.println(dist[end]);

    }

    public static class Node {
        int B;
        int C;

        Node(int B, int C){
            this.B = B;
            this.C = C;
        }

    }
}