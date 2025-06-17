package week10.combinations;

import java.util.ArrayList;
import java.util.List;

class Wina {
	
	static List<List<Integer>> ans;
	static int N, K;
	
	static void recursion(int start, List<Integer> current) {
//	반드시 실행
//		탈출 조건
		if (current.size() == K) {
			ans.add(new ArrayList<>(current));
			return;
		}

//		탈출 안 했을 때 로직
		for (int i = start; i <= N; i++) {
			current.add(i);
//			재귀
			recursion(i + 1, current);
//			백트래킹
			current.remove(current.size() - 1);
		}
	}
	
	public List<List<Integer>> combine(int n, int k) {
//		초기화
		N = n;
		K = k;
		ans = new ArrayList<>();
		List<Integer> current = new ArrayList<>();

//		함수 실행
		recursion(1, current);
		return ans;
	}
}
