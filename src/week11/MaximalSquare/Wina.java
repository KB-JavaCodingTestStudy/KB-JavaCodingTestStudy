package week11.MaximalSquare;

public class Wina {
	
	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

//	  변수의미 정의
		int[][] dp = new int[m][n]; //각 칸에서의 최대 정사각형 한 변의 길이
		int max = 0; //정사각형 최대 변 길이 저장

//		초기조건 설정
//		반복문을 통해 dp 테이블 채우기
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					if (i == 0 || j == 0) {
						dp[i][j] = 1;
					} else {
						// ← 정사각형 구성 조건
						dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					}
					// 최대값 갱신
					max = Math.max(max, dp[i][j]);
				}
			}
		}

//		정답 리턴
		return max * max;
	}
}
