package week10.소수찾기;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Wina {
	
	static Set<Integer> sosu;
	static int answer;
	static String numbersN;
	
	static void recursion(boolean[] visited, List<Character> current, int r) {
//		반드시 해야하는 것
//		탈출조건
		if (current.size() == r) {
			StringBuilder sb = new StringBuilder();
			for (char ch : current) {
				sb.append(ch);
			}
			int num = Integer.parseInt(sb.toString());
			if (isSosu(num)) {
				sosu.add(num);
			}
			return;
		}

//		탈출 조건 안 했을 때 실행 로직
		for (int i = 0; i < numbersN.length(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				current.add(numbersN.charAt(i));
//		재귀호출
				recursion(visited, current, r);
//		백트래킹
				visited[i] = false;
				current.remove(current.size() - 1);
			}
		}
	}
	
	static boolean isSosu(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public int solution(String numbers) {
//		초기화
		answer = 0;
		numbersN = numbers;
		sosu = new HashSet<>();
		boolean[] visited = new boolean[numbers.length()];
		List<Character> current = new ArrayList<>();

//		함수 호출
		for (int r = 1; r <= numbers.length(); r++) {
			recursion(visited, current, r);
		}
		
		return sosu.size();
	}
}

