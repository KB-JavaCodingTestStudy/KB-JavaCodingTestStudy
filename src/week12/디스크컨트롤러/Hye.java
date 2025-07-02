package week12.디스크컨트롤러;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Hye {

    class Solution {
        public int solution(int[][] jobs) {

            Arrays.sort(jobs, (q1, q2)-> q1[0] - q2[0]);
            Queue<int[]> queue = new PriorityQueue<>((q1, q2)-> q1[1] - q2[1]);
            int comple = 0;
            int current = 0;
            int total = 0;
            int idx = 0;

            while(comple < jobs.length){
                while(idx < jobs.length && jobs[idx][0] <= current){
                    queue.offer(jobs[idx]);
                    idx++;
                }

                if(!queue.isEmpty()){
                    int[] cur = queue.poll();

                    current += cur[1];

                    total += current - cur[0];

                    comple++;

                }else{
                    current = jobs[idx][0];
                }
            }
            return total/jobs.length;
        }
    }
}
