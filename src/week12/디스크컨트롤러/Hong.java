import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] != b[1]) return a[1] - b[1]; // 소요시간 우선
                return a[0] - b[0];                   // 요청시간 우선
            }
        );
        
        int time = 0; //지금 시간
        int idx = 0;    // 인덱스
        int total = 0;  // 총 반환 시간
        int completed = 0; // 작업 완료 한 수
        
        while (completed < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(jobs[idx]);
                idx++;
            }
            
            if(pq.isEmpty()) {
                time = jobs[idx][0];
            }else{
                int[] cur = pq.poll();
                time += cur[1];
                total += time - cur[0];
                completed++;
            }
        }
        
        return total / jobs.length;
        
    }
}
