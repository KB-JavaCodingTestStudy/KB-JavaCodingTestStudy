package week03.BOJ_G3_10986_나머지합;

/* ================================================================
 *
 * Problem  : 나머지 합 구하기
 * Author   : 최승아
 * Date     : 2025-04-23
 *
 * ================================================================
 * 📌 문제 분석 요약
 * 수 N개가 주어졌을 때 합이 M이 되는 구간합의 개수를 반환해라
 *
 * # 입력
 * N: 전체 수의 수
 * M: 찾고자 하는 합
 * nums: 수 배열
 *
 * # 출력
 * 조건을 만족한 구간합의 갯수
 *
 * 💻 알고리즘 설계
 * 1. 합배열을 만든다
 * 2. 이중포문을 돌리면서 구간합%M==0이 되는지 확인한다
 *
 * 시간초과: 두 누적합이 M으로 나눈 나머지가 같다면, 그 사이의 구간합은 M으로 나누어 떨어진다
 *           S[j] % M == S[i] % M이면 (j > i), S[j] - S[i]는 M으로 나누어떨어진다
 * 1. 누적합을 구하면서 매 순간 mod에 누적합%M의 값을 저장한다
 * 2. 같은 나머지를 가진 누적합의 쌍의 개수만큼 정답에 더한다
 * 3. 누적합이 처음부터 M으로 나누어떨어지는 경우는 직접 카운트한다.
 *
 *
 * ⏰ 시간복잡도
 * O(N)
 * ================================================================
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_10986_나머지합구하기 {
	
	// 초기 설정
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
//		입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		long[] sums = new long[N];
		long[] mod = new long[M]; //나머지 카운팅 배열
		long cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			nums[n] = Integer.parseInt(st.nextToken());
//			누적합 구하기
			if (n == 0) {
				sums[n] = nums[n];
			} else {
				sums[n] = sums[n - 1] + nums[n];
			}

//			오버플로우 때문에 음수가 나오는 경우를 방지
			int num = (int) ((sums[n] % M + M) % M);
			if (num == 0) {
				cnt++; //처음부터 i까지 나눠떨어지는 경우
			}
//			같은 나머지의 수인 것들의 갯수를 저장
			mod[num]++;
		}

//같은 나머지의 조합 개수
		for (int i = 0; i < M; i++) {
//			쌍이 존재할 때
			if (mod[i] > 1) {
//				2개를 뽑았을 때 나오는 조합의 수
				cnt += (mod[i] * (mod[i] - 1)) / 2;
			}
		}
		
		System.out.println(cnt);
		//	종료 설정
		br.close();
	}
}
