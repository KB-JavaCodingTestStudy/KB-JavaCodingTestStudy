package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 문제 설명
음의 가중치 간선이 있는 그래프에서 1번 정점 기준 최단 거리를 구하는 문제
모든 간선을 n-1번 반복해서 완화(relax)하며, 이후 한 번 더 검사하여 음의 사이클 존재 여부를 판단한다.
최단 경로가 없으면 -1을 출력하고, 있다면 각 노드까지의 최소 비용을 출력한다.

입력으로 주어진 정점 수 `n`과 간선 수 `m`을 받아 인접 리스트를 구성한다.
`result` 배열을 사용해 1번 노드로부터의 최단 거리를 저장 및 n-1`번 모든 간선을 순회하며 거리 갱신을 수행한다.
거리 배열이 `Integer.MAX_VALUE`인 경우는 도달할 수 없는 노드로 간주한다.
`hasCycle` 함수로 한 번 더 간선을 확인해 음수 사이클이 존재하는지 검사한다.
음수 사이클이 있다면 `-1`을 출력하고, 없으면 최단 거리를 출력한다.
 */


public class N_11657 {
    static List<Node>[] list;
    static int[] result;

    static class Node {
        int val;
        int weight;

        public Node(int next, int weight) {
            this.val = next;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new List[n + 1];
        result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[1] = 0;

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
        }

        int start = 1;
        Queue<Node> que = new ArrayDeque<>();
        que.addAll(list[start]);
        for (int i = 0; i < n - 1; i++) {
            for (int v = 1; v <= n; v++) {
                for (Node next : list[v]) {
                    if (result[v] != Integer.MAX_VALUE && result[next.val] > result[v] + next.weight) {
                        result[next.val] = result[v] + next.weight;
                    }
                }
            }
        }

        boolean hasCycle = hasCycle(n);
        if(hasCycle) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=n;i++) {
            if(result[i] == Integer.MAX_VALUE) {
                sb.append(-1+"\n");
            }else{
                sb.append(result[i]+"\n");
            }
        }
        System.out.println(sb);
    }
    public static boolean hasCycle(int n) {
        for(int i=0;i<1;i++){
            for(int v=1;v<=n;v++){
                for(Node next : list[v]){
                    if(result[v]!=Integer.MAX_VALUE && result[next.val] > result[v] + next.weight) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
