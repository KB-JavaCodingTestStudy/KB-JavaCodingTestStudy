package week12.디스크컨트롤러;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Wina {
	
	static Queue<Node> pq;
	
	public int solution(int[][] jobs) {
//		초기화
		Arrays.sort(jobs, Comparator.comparingInt(a -> a[0])); //도착순으로 정렬
		pq = new PriorityQueue<>();
		int time = 0; //현재 시각
		int idx = 0; //jobs 배열 인덱스
		int total = 0; //대기시간 총합
		int cnt = 0; //처리한 작업 수
		
		while (cnt < jobs.length) {
//		초기값
//			현재 시각에 도착한 모든 작업을 pq에 추가
			while (idx < jobs.length && jobs[idx][0] <= time) {
				pq.add(new Node(jobs[idx][0], jobs[idx][1]));
				idx++;
			}
			
			if (pq.isEmpty()) {
//				현재 시각에 처리할 작업이 없으면 다음 작업 시작 시각으로 이동
				time = jobs[idx][0];
				continue;
			}
			
			//		다익스트라
			Node now = pq.remove();
			time += now.dist;
			total += time - now.value; //요청~완료시간
			cnt++;
		}

//		평균 소요 시간 계산
		return total / jobs.length;
	}
	
	static class Node implements Comparable<Node> {
		
		int value, dist;
		
		public Node(int value, int dist) {
			this.value = value;
			this.dist = dist;
		}
		
		//		지연시간이 짧은 작업부터 처리
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
}
