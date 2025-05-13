package week05.BOJ_S1_1697_숨바꼭질;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Wina {
	
	// 초기 설정
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static boolean[] visited = new boolean[100001];
	
	static int bfs(int N, int K) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{N, 0});//		수빈이의 위치와 시간을 저장
//		큐가 빌 때까지 반복
		while (!queue.isEmpty()) {
			//		현재위치와 시간을 저장
			int[] cur = queue.poll();
			int idx = cur[0];
			int time = cur[1];
			
			//		현재위치가 동생의 위치와 같다면 시간을 반환
			if (idx == K) {
				return time;
			}

//		다음 위치를 저장
			int[] nextIdx = {idx - 1, idx + 1, idx * 2};

//		다음 위치가 범위 안에 있고 방문하지 않았다면 큐에 저장
			for (int next : nextIdx) {
				if (0 <= next && next <= 100000 && !visited[next]) {
					//		방문했음을 표시
					visited[next] = true;
					queue.offer(new int[]{next, time + 1});
				}
			}
			
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = bfs(N, K);
		System.out.println(cnt);
		
		//	종료 설정
		br.close();
	}
	
}
