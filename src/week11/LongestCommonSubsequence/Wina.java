package week11.LongestCommonSubsequence;

public class Wina {
	
	public int longestCommonSubsequence(String text1, String text2) {
//		변수 정의
		int len1 = text1.length();
		int len2 = text2.length();
		int[][] dp = new int[len1 + 1][len2 + 1]; //문자열의 앞에서부터 i글자, j글자까지 비교하면서 LCS 길이를 누적

//		초기조건 설정
		for (int i = 0; i < len1; i++) {
			dp[i][0] = 0;
		}
		for (int j = 0; j < len2; j++) {
			dp[0][j] = 0;
		}

//		반복문으로 dp 테이블 채우기
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
//		정답 리턴
		return dp[len1][len2];
	}
}
