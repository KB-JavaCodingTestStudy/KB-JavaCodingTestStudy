package week12.합승택시요금;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Hye {
    // 다익스트라
    class Solution {
        public int solution(int n, int s, int a, int b, int[][] fares) {
            int answer = 0;

            int[][] cost = new int[n+1][n+1];
            for(int[] fare : fares){
                cost[fare[0]][fare[1]] = fare[2];
                cost[fare[1]][fare[0]] = fare[2];
            }

            int[][] dist = new int[3][n+1];
            for(int[] d : dist){
                Arrays.fill(d, Integer.MAX_VALUE);
            }

            Queue<int[]> queue = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
            final int[] start = {s,a,b};

            for(int j = 0; j < 3; j++){
                int[] d = dist[j];
                queue.add(new int[]{start[j], 0});
                d[start[j]] = 0;
                while(!queue.isEmpty()){
                    int[] cur = queue.remove();

                    for(int i = 1; i <= n; i++){
                        if(cost[cur[0]][i] == 0) continue;
                        if(d[i] > cur[1] + cost[cur[0]][i]){
                            d[i] = cur[1] + cost[cur[0]][i];
                            queue.add(new int[]{i, cur[1] + cost[cur[0]][i]});
                        }
                    }
                }
            }
            int minC = Integer.MAX_VALUE;
            for(int i = 1; i <= n; i++){
                int sum = dist[0][i] + dist[1][i] + dist[2][i];
                minC = Math.min(minC, sum);
            }

            return minC;
        }
    }

    // 플로이드워셜
    class Solution2 {
        public int solution(int n, int s, int a, int b, int[][] fares) {
            int[][] map = new int[n+1][n+1];

            for(int i = 1; i <= n; i++){
                Arrays.fill(map[i], 200 * 100000);
                map[i][i] = 0;
            }


            for(int[] fare : fares){
                map[fare[0]][fare[1]] = fare[2];

                map[fare[1]][fare[0]] = fare[2];
            }


            for(int k = 1; k <= n; k++){
                for(int i = 1; i <= n; i++){
                    for(int j = 1; j <= n; j++){
                        if(map[i][j] > map[i][k] + map[k][j]){
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }

            int answer = map[s][a] + map[s][b];

            for(int i = 1; i <= n; i++){
                answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
            }

            return answer;
        }
    }
}
