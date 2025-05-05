package week04.BOJ_B2_2864_5와6의차이;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* ================================================================
 *
 * Problem  : 5와 6의 차이
 * Author   : 최승아
 * Date     : 2025-05-06
 *
 * ================================================================
 * 📌 문제 분석 요약
 *임의의 두 숫자가 주어진다. 5,6의 숫자 중에서 둘 중에 무엇이 진짜 수인지 판단할 수 없다.
 * 그래서 두 수가 가질 수 있는 합의 최소값과 최대값을 구한다.
 *
 * # 입력
 * 임의의 두수가 주어진다.
 *
 * # 출력
 * 가질 수 있는 최소값과 최대값을 공백을 기준으로 출력한다.
 *
 * 💻 알고리즘 설계
 * 최소값은 모든 5,6 값이 5일 때이다.
 * 최대값은 모든 5,6 값이 6일 때이다.
 * 문자열로 받았기에 replaceAll을 사용해서 각각의 숫자를 변경한다.
 * 정수로 바꾼 후 최소값과 최대값을 구한다.
 *
 * ⏰ 시간복잡도
 * O(1)
 *
 * ================================================================
 */

public class Wina {
	
	// 초기 설정
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
//		입력
		st = new StringTokenizer(br.readLine());
		String A = (st.nextToken());
		String B = (st.nextToken());
//		모두 5일 때와 6일 때를 각각 저장한다.
		int[] arrA = new int[2];
		int[] arrB = new int[2];
		arrA[0] = Integer.parseInt(A.replaceAll("6", "5"));
		arrA[1] = Integer.parseInt(A.replaceAll("5", "6"));
		arrB[0] = Integer.parseInt(B.replaceAll("6", "5"));
		arrB[1] = Integer.parseInt(B.replaceAll("5", "6"));
		
		int min = arrA[0] + arrB[0];
		int max = arrA[1] + arrB[1];
		System.out.println(min + " " + max);
		
		//	종료 설정
		br.close();
	}
}

