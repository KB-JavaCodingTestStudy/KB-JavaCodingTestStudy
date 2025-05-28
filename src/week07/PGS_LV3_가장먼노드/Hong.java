

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }


        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int[] dist = new int[n + 1]; 
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[1] = true;
        dist[1] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    queue.offer(next);
                }
            }
        }

        int maxDist = 0;
        for (int d : dist) {
            maxDist = Math.max(maxDist, d);
        }

        int count = 0;
        for (int d : dist) {
            if (d == maxDist) count++;
        }

        return count;
    }
}
