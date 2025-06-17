package week10.twosum;

class Wina {
	
	static int[] ans;
	
	static void recursion(int[] nums, int target, int startIdx, int endIdx) {
//		반드시 실행
		if (startIdx >= nums.length - 1 || endIdx >= nums.length) {
			return;
		}
		
		int sum = nums[startIdx] + nums[endIdx];
//		탈출 조건
		if (sum == target) {
			ans = new int[]{startIdx, endIdx};
			return;
		}

//		탈출 안 했을 때 실행 로직
//		재귀 로직
		if (endIdx < nums.length - 1) {
			recursion(nums, target, startIdx, endIdx + 1);
		} else {
			recursion(nums, target, startIdx + 1, startIdx + 2);
		}
	}
	
	public int[] twoSum(int[] nums, int target) {
		ans = new int[2];
		recursion(nums, target, 0, 1);
		return ans;
	}
}
