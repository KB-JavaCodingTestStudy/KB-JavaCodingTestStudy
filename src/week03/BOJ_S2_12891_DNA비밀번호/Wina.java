package week03.BOJ_S2_12891_DNA비밀번호;
/* ================================================================
 *
 * Problem  : DNA 비밀번호
 * Author   : 최승아
 * Date     : 2025-04-22
 *
 * ================================================================
 * 📌 문제 분석 요약
 * DNA 문자열에 ACGT로만 이루어진 부분 문자열이 있는가?
 * 민호가 설정해둔 알파벳 최소횟수의 조건을 만족하는 것만 횟수에 포함시킨다.
 *
 * # 입력
 * S: DNA 문자열 길이
 * P: 부분 문자열 길이
 * DNA 문자열
 * 각 알파벳의 최소 횟수
 *
 * # 출력
 * 만들 수 있는 비밀번호의 경우의 수
 *
 * 💻 알고리즘 설계
 * 1. 모두 입력을 받는다.
 * 2. 슬라이딩 윈도우를 통해서 하나씩 움직이면서 조건에 부합하는지 확인한다.
 * 3. 조건에 부합한다면 cnt+1
 *
 *
 * ⏰ 시간복잡도
 *
 * ================================================================
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_12891_DNA비밀번호 {
	
	public static void main(String[] args) throws IOException {
//    입력 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		char[] dnas = br.readLine().toCharArray(); // 문자열 한 줄 → 문자 배열
		
		int[] acgt = new int[4]; // A, C, G, T 순서
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			acgt[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] myAcgt = {0, 0, 0, 0};
		int cnt = 0;
//		초기 슬라이딩 윈도우 구성
		for (int i = 0; i < P; i++) {
			char alpha = dnas[i];
			add(myAcgt, alpha);
		}
		
		//			acgt 조건을 모두 맞췄는지 확인
		if (check(myAcgt, acgt)) {
			cnt++;
		}

//		슬라이딩 윈도우
		for (int i = P; i < S; i++) {
			// 들어오는 문자
			add(myAcgt, dnas[i]);
			// 빠지는 문자
			minus(myAcgt, dnas[i - P]);
			//			acgt 조건을 모두 맞췄는지 확인
			if (check(myAcgt, acgt)) {
				cnt++;
			}
		}
		System.out.println(cnt);

//    종료 설정
		br.close();
	}
	
	static void add(int[] myAcgt, char c) {
		switch (c) {
			case 'A':
				myAcgt[0]++;
				break;
			case 'C':
				myAcgt[1]++;
				break;
			case 'G':
				myAcgt[2]++;
				break;
			case 'T':
				myAcgt[3]++;
				break;
		}
	}
	
	static void minus(int[] myAcgt, char c) {
		switch (c) {
			case 'A':
				myAcgt[0]--;
				break;
			case 'C':
				myAcgt[1]--;
				break;
			case 'G':
				myAcgt[2]--;
				break;
			case 'T':
				myAcgt[3]--;
				break;
		}
	}
	
	static boolean check(int[] myAcgt, int[] acgt) {
		for (int i = 0; i < 4; i++) {
			if (myAcgt[i] < acgt[i]) {
				return false;
			}
		}
		return true;
	}
	
	
}
