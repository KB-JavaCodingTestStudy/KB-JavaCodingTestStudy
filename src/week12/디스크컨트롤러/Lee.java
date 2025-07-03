
import java.util.*;
import java.io.*;


class Solution {
    public int solution(int[][] jobs) {
    
        // 작업을 요청 시간이 빠른 순으로 정렬
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
        
        int curTime = 0;    // 현재 시각
        int completed = 0;  // 처리된 작업의 수
        int nextIndex = 0;  // 다음에 큐에 넣을 작업 번호 (인덱스)
        int total = jobs.length;    // 총 작업의 수
        int totalResponseTime = 0;  // 총 응답 시간 (합계)
         
        Queue<Work> pq = new PriorityQueue<>();
        
        while(completed < total) {
            
            // 당장 처리할 작업이 없으면 다음 작업의 요청 시각까지 시간을 스킵한다.
            if (pq.isEmpty()) {
                curTime = jobs[nextIndex][0];
            }
            
            // 현재 시각을 기준으로, 요청이 들어온 작업들을 전부 큐에 담는다.
            while(nextIndex < total && jobs[nextIndex][0] <= curTime) {
                pq.add(new Work(nextIndex, jobs[nextIndex][0], jobs[nextIndex][1]));
                nextIndex++;
            }
            
            // 큐에서 작업을 하나 꺼내 처리한다.
            Work work = pq.poll();
            
            curTime += work.processTime;    // 처리 시간만큼 현재 시간이 지난다.
            System.out.println(curTime);
            totalResponseTime += (curTime - work.requestTime);  // 응답시간 누적 (응답시간 : 현재시간 - 요청시간)
            completed++;    // 처리된 작업의 수 + 1
        }
        
        return totalResponseTime / total;
        
    }
    
    class Work implements Comparable<Work> {
        public int num;
        public int requestTime;
        public int processTime;
        
        public Work(int num, int requestTime, int processTime) {
            this.num = num;
            this.requestTime = requestTime;
            this.processTime = processTime;
        }
        
        @Override
        public int compareTo(Work other) {
            if (this.processTime == other.processTime) {
                if (this.requestTime == other.requestTime)
                    return this.num - other.num;
                
                return this.requestTime - other.requestTime;
            }
            
            return this.processTime - other.processTime;
        }
    }
    
    
    
}
