package week12.태어난김에세계일주1;


class Wina {
	
	static int[][] COUNTRIES;
	static int answer;
	
	static void recursion(int cnt, boolean[] visited, int balance) {
//		반드시 실행
		answer = Math.max(answer, cnt);

//		탈출 안 할시 실행하는 조건
		for (int i = 0; i < COUNTRIES.length; i++) {
			int cost = COUNTRIES[i][0];
			int entrance = COUNTRIES[i][1];
			
			if (!visited[i] && balance >= entrance) {
				visited[i] = true;
				//		재귀 호출
				recursion(cnt + 1, visited, balance - cost);
				//		백트래킹
				visited[i] = false;
			}
		}
	}
	
	public int solution(int balance, int[][] countries) {
		answer = -1;
		COUNTRIES = countries;
		boolean[] visited = new boolean[countries.length];
		recursion(0, visited, balance);
		return answer;
	}
}