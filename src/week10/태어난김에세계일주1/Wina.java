package week10.태어난김에세계일주1;

/* ================================================================
 *
 * Problem  : 태어난김에 세계일주
 * Author   : 최승아
 * Date     : 2025-06-17
 *
 * ================================================================
 * 📌 문제 분석 요약
 *
 * # 입력
 * balance: 통장 잔고
 * countries: 각 나라별 [여행경비,입국필요잔고]
 *
 * # 출력
 * 나라 방문 최대 횟수
 *
 * 💻 알고리즘 설계
 * countries를 전역으로 사용하기 위해서 새로운 변수를 선언해서 복사 후에 필요잔고를 기준으로 내림차순 정렬
 * 한번 방문한 나라는 다시 방문하지 않기 위해 visited 방문 배열 생성
 * 재귀 함수 호출
 * - cnt와 answer 중 큰 값으로 업데이트 해서 나라 방문 최대 횟수 결정
 * - countries 순회
 * -- 방문하지 않았고, 현재 잔고가 입국비용보다 많이 있다면
 * --- 방문 표시
 * --- 재귀함수를 호출한다(방문했기 때문에 나라+1, 잔고-여행비용, 방문배열)
 * --- 다른 재귀함수를 위해 백트래킹(방문 철회)
 *
 * ⏰ 시간복잡도
 * O(2^n): 7개의 나라라고 한정지었기 때문에 문제 없음
 * ================================================================
 */

import java.util.Arrays;

class Wina {
	
	static int answer;
	static int[][] countriesN;
	static boolean[] visited;
	
	static void recursion(int cnt, int balance, boolean[] visited) {
//	반드시 실행
		answer = Math.max(answer, cnt);

//		탈출 안 했을 때 로직
		for (int i = countriesN.length - 1; i >= 0; i--) {
			int cost = countriesN[i][0];
			int entrance = countriesN[i][1];
			
			if (!visited[i] && balance >= entrance) {
				visited[i] = true;
				//		재귀
				recursion(cnt + 1, balance - cost, visited);
				//		백트래킹
				visited[i] = false;
			}
		}
	}
	
	
	public int solution(int balance, int[][] countries) {
//		초기화
		answer = -1;
		countriesN = countries;
		visited = new boolean[countriesN.length];

//		필요잔고를 기준으로 내림차순 정렬
		Arrays.sort(countriesN, (a, b) -> Integer.compare(b[1], a[1]));
		
		recursion(0, balance, visited);
		return answer;
	}
}