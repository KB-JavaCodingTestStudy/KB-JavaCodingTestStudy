package week10.permutations;

import java.util.ArrayList;
import java.util.List;

class Wina {
	
	static List<List<Integer>> ans;
	static int[] newNums;
	
	static void recursion(boolean[] visited, List<Integer> current) {
//	  반드시 실행
//		탈출조건
		if (current.size() == newNums.length) {
			ans.add(new ArrayList<>(current));
			return;
		}

//		탈출 안 했을 때 실행 로직
		for (int i = 0; i < newNums.length; i++) {
			if (!visited[i]) { //아직 방문하지 않은 숫자
				visited[i] = true;
				current.add(newNums[i]);

//		재귀 호출
				recursion(visited, current);

//				백트래킹
				visited[i] = false;
				current.remove(current.size() - 1);
			}
		}
	}
	
	public List<List<Integer>> permute(int[] nums) {
//		초기화
		newNums = nums;
		ans = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		List<Integer> current = new ArrayList<>();
//		순열 계산
		recursion(visited, current);
		return ans;
	}
}
