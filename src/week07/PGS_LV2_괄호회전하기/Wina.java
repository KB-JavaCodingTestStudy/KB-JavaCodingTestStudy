package week07.PGS_LV2_괄호회전하기;

/* ================================================================
 *
 * Problem  : 괄호 회전하기
 * Author   : 최승아
 * Date     : 2025-05-27
 *
 * ================================================================
 * 📌 문제 분석 요약
 * (), [], {}의 괄호가 있을 때 이것들이 올바른 괄호인지 확인한다.
 * ([])의 형태는 허용하지만, ([)]의 형태는 허용하지 않는다.
 * 괄호를 만들 수 없다면 0을 리턴한다.
 *
 * 💻 알고리즘 설계
 * String의 길이만큼 회전한다.
 * 회전하면서 올바른 괄호인지 확인한다.
 * 올바른 괄호라면 +1를 한다.
 *
 * 올바른 괄호 탐색법:
 * - 개괄호는해당 괄호 크기의 이름으로 스택에 넣는다.
 * - 닫는 개괄호일 때는 스택의 top이 해당 괄호와 일치한지 확인한다.
 * - 스택이 비어있다면 바로 반환이다.
 * - 모든 반복문을 돌았는데, 스택이 비어있다면 올바른 괄호가 아니다
 * - 모든 조건을 만족했을 때 올바른 괄호이다.
 *
 *
 * ==============================================================
 */

import java.util.ArrayDeque;
import java.util.Deque;

class Wina {
	
	static Deque<String> dq;
	
	static boolean isRight(String str) {
//		스택으로 사용
		dq = new ArrayDeque<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
//			개괄호는 넣기
			if (ch == '(') {
				dq.add("Small");
			} else if (ch == '{') {
				dq.add("Medium");
			} else if (ch == '[') {
				dq.add("Large");
			}

//			닫는괄호일 때 판단
			if (ch == ')') {
				if (!isMatch("Small")) {
					return false;
				}
			} else if (ch == '}') {
				if (!isMatch("Medium")) {
					return false;
				}
			} else if (ch == ']') {
				if (!isMatch("Large")) {
					return false;
				}
			}
		}
		
		return dq.isEmpty();
	}
	
	static boolean isMatch(String size) {
		if (dq.isEmpty()) {
			return false;
		}
		String top = dq.removeLast();
//		짝 맞는지 비교
		return size.equals(top);
	}
	
	public int solution(String s) {
		int cnt = 0;
		int len = s.length();
		
		for (int i = 0; i < len; i++) {
//			괄호 회전
			String str = s.substring(i) + s.substring(0, i);
			if (isRight(str)) {
				cnt++;
			}
		}
		
		return cnt;
	}
}
