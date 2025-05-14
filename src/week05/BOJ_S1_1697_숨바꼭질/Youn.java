import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
문제 설명
수빈이는 위치N에서 시작해 걷기(±1) 또는 순간이동(×2)으로 이동할 수 있습니다.
동생은 위치 K에 있으며, 수빈이가 동생을 찾는 데 걸리는 최소 시간(초)을 구해야 합니다.
각 이동은 1초가 걸리며, 0≤N,K≤100,000입니다.

 시간 복잡도: O(N)

 풀이
 현재 위치 기준 -1, +1, *2 위치로 이동 가능
 BFS를 순회하면서 동생의 위치와 같게 되는 지점이 가장 최단 거리
 동생의 위치는 최대 1,000,000이므로 1,000,001 보다 큰 위치까지 가지 않아도 됨

 우리가 임의의 위치 X에 있다고 할 때:
 X > K일 경우, 반드시 뒤로 돌아가야 함 → 시간 낭비
 따라서 X가 커질수록 K로 오기 위한 시간도 같이 증가

 이때, X = K + (K - N) 이상인 경우
 출발점 N에서 X까지 가는 시간 ≥ (K - N) + (X - K)
 다시 X에서 K까지 오는 데 (X - K) 시간 필요
 총 시간 ≥ (K - N) + 2 × (X - K)

 즉, X가 K보다 커질수록 시간 증가량은 2배 이상씩 늘어남
 → BFS는 그런 경로를 이미 그 전에 더 짧은 거리로 도달했음
*/
public class N_1697 { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        if (start == goal) {
            System.out.println(0);
            return;
        }
        System.out.println(bfs(start, goal));
    }

    public static int bfs(int start, int goal) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        int[] move = {1, -1, 2};
        queue.add(start);
        visited.add(start);
        int count = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            count++;
            while (len-- > 0) {
                int curr = queue.poll();
                for (int d = 0; d < move.length; d++) {
                    int next;
                    if (d == 2) {
                        next = curr * move[d];
                    } else next = curr + move[d];

                    if (next == goal) {
                        return count;
                    }
                    if (next < 0 || next>100001|| visited.contains(next)) {
                        continue;
                    }
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return count;
    }
}
