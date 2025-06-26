package week11.minCostClimbingStairs;

public class Wina {
	
	public int minCostClimbingStairs(int[] cost) {
//	문서를 정의하고, 변수 의미 정하기
//		점화식 세우기
		int[] dp = new int[cost.length + 1];

//		초기조건 설정
		dp[0] = 0;
		dp[1] = 0;

//		반복문으로 dp 테이블 채우기
		for (int i = 2; i <= cost.length; i++) {
			dp[i] = Math.min(dp[i - 1] + cost[i - 1],
					dp[i - 2] + cost[i - 2]); //i-1에서 올라온것과 i-2에서 올라온 것 비교
		}
//		정답 리턴
		return dp[cost.length];
	}
}
