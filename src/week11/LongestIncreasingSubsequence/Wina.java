package week11.LongestIncreasingSubsequence;

public class Wina {
	
	public int lengthOfLIS(int[] nums) {
		int len = nums.length;
//		변수의미정하기
//		현재 위치까지 증가 갯수
		int[] dp = new int[len];

//		초기조건 설정
		for (int i = 0; i < len; i++) {
			dp[i] = 1;
		}

//		반복문으로 dp 테이블 채우기
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

//		정답 리턴
		int ans = 0;
		for (int num : dp) {
			ans = Math.max(num, ans);
		}
		return ans;
	}
}
