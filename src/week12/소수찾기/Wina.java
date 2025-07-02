package week12.소수찾기;


import java.util.HashSet;
import java.util.Set;

class Wina {
	
	static int[] NUMS;
	static Set<Integer> primeSet;
	
	static void recursion(int now, int depth, int size, boolean[] visited) {
//		반드시 실행
		if (depth == size) {
			//		탈출조건
			if (isPrime(now)) {
				primeSet.add(now);
			}
		}

//		재귀호출
		for (int i = 0; i < NUMS.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				recursion(now * 10 + NUMS[i], depth + 1, size, visited);
				//		백트래킹
				visited[i] = false;
			}
		}
	}
	
	static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i <= Math.pow(num, 0.5); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public int solution(String numbers) {
//		초기화
		NUMS = new int[numbers.length()];
		primeSet = new HashSet<>();
		for (int i = 0; i < numbers.length(); i++) {
			NUMS[i] = numbers.charAt(i) - '0';
		}
		
		boolean[] visited = new boolean[NUMS.length];
//		재귀 호출
		for (int i = 1; i <= NUMS.length; i++) {
			recursion(0, 0, i, visited);
		}
		
		return primeSet.size();
	}
}