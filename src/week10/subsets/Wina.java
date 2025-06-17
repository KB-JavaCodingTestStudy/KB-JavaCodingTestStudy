package week10.subsets;

import java.util.ArrayList;
import java.util.List;

class Wina {
	
	static List<List<Integer>> ans;
	static int len;
	static int[] newNums;
	
	static void recursion(int r, List<Integer> current, int start) {
//		반드시 실행
//		탈출 조건
		if (current.size() == r) {
			ans.add(new ArrayList<>(current));
			return;
		}
//		탈출 안 했을 때 로직
		for (int i = start; i < len; i++) {
			current.add(newNums[i]);
//		재귀
			recursion(r, current, i + 1);
//		백트래킹
			current.remove(current.size() - 1);
		}
	}
	
	public List<List<Integer>> subsets(int[] nums) {
//		초기화
		ans = new ArrayList<>();
		len = nums.length;
		newNums = nums;
		List<Integer> current = new ArrayList<>();

//		함수 실행
		for (int r = 0; r <= len; r++) {
			recursion(r, current, 0);
		}
		
		return ans;
	}
}
