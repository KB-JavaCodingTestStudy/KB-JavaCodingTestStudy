package week11.coinChange;

import java.util.Arrays;

public class Wina {
	
	public int coinChange(int[] coins, int amount) {
//	 문제를 정의하고 변수 의미 정하기
		int[] dp = new int[amount + 1];

//		점화식 세우기
//		초기조건 설정
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;

//		반복문으로 dp 테이블 채우기
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i - coin >= 0) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}
//		정답 리턴
		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}
}
