package week11.UniquePaths;

public class Wina {
	
	public int uniquePaths(int m, int n) {
//		변수의미 설정
//		각 위치에서 올 수 있는 경우의 수
		int[][] dp = new int[m][n];

//		초기조건 설정
		dp[0][0] = 0;
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}

//		반복문으로 dp 테이블 채우기
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

//		정답 리턴
		return dp[m - 1][n - 1];
	}
}