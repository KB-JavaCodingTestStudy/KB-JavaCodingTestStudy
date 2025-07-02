package week12.디스크컨트롤러;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MJ {
    class Solution {
        public int solution(int[][] jobs) {
            //index 추가 작업
            for(int i=0;i<jobs.length;i++){
                jobs[i] = new int[]{jobs[i][0], jobs[i][1], i};
                //들어온 시점, 걸리는 시간, index
            }

            //들어온 시점에 따라 정렬
            Arrays.sort(jobs, (a, b)->a[0]-b[0]);


            //우선순위에 따라 자동 정렬
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a,b)->{
                        if(a[1]!=b[1]){// 소요시간이 짧은 것
                            return a[1]-b[1];
                        }
                        if(a[0]!=b[0]){// 요청 시각이 빠른 것
                            return a[0]-b[0];
                        }
                        return a[2]-b[2];//작업의 번호가 작은 것
                    }
            );

            int time=0;//현재 시간
            int index=0;//다음 jobs
            int total=0;//대기 시간 합산
            int finish=0;//처리한 job 수

            while(finish<jobs.length){//아직 전부 처리하지 않은 경우
                while(index<jobs.length && jobs[index][0]<=time){//현재 시간 이전에 들어온 job을 대기 pq에 추가
                    pq.add(new int[]{jobs[index][0], jobs[index][1], index});
                    //소요시간, 요청시간, 작업 번호
                    index++;//다음 job 확인 고고(시간이 많이 지나면 여러개의 job이 들어와 있을 수 있다.)
                }

                if(!pq.isEmpty()){//대기 값이 있으면 실행
                    int[] cur = pq.remove();//우선순위대로 정렬되어 있는 job 꺼내기
                    time+=cur[1];//처리 시간만큼 증가
                    total+=time-cur[0];//완료 시간 - 들어온 시간
                    finish++; //처리완료, 처리한 수 증가
                }else{
                    //대기 값이 없으면 다음 job이 들어오는 시점으로 이동
                    time=jobs[index][0];
                }
            }

            return total/jobs.length;//평균 구하기
        }
    }
}
