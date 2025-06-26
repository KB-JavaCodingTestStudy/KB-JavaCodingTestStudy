package week11.HouseRobber;

public class Wina {
	
	public int rob(int[] nums) {
		int len = nums.length;
		
		if (len == 1) {
			return nums[0];
		}
		int[] dp = new int[len];

//		초기조건 설정
		dp[0] = nums[0];
		if (len > 1) {
			dp[1] = Math.max(nums[0], nums[1]);
		}

//		반복문으로 dp 테이블 채우기
		if (len > 2) {
			for (int i = 2; i < len; i++) {
				dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
			}
			
		}

//		정답 리턴
		return Math.max(dp[len - 1], dp[len - 2]);
	}
}
