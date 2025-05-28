package week07.PGS_LV2_전화번호목록;



/* ================================================================
 *
 * Problem  : 전화번호 목록
 * Author   : 최승아
 * Date     : 2025-05-28
 *
 * ================================================================
 * 📌 문제 분석 요약
 * phonebook의 휴대전화번호가 다른 휴대전화번호의 접두어인 경우가 있다면 false를 리턴하라
 *
 * 💻 알고리즘 설계
 * phone_book 리스트를 해시셋에 저장한다.
 * 현재 전화번호를 한글자씩 늘려가면서 다른 것의 전화번호와 일치하다면 그 전화번호는 이미 전화번호부에 있는 것이기 때문에 return 한다.
 *
 * ⏰ 시간복잡도
 *
 * ================================================================
 */

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Wina {
	
	static Set<String> phoneSet;
	
	public boolean solution(String[] phone_book) {
		phoneSet = new HashSet<>();
		Collections.addAll(phoneSet, phone_book);

//		전화번호부를 돈다
		for (String phone : phone_book) {
//			현재 전화번호를 한글자씩 늘리면서 다른 전화번호부에 일치하는 것이 있는지 확인한다.
			for (int i = 1; i < phone.length(); i++) {
				String prefix = phone.substring(0, i);
				if (phoneSet.contains(prefix)) {
					return false;
				}
			}
		}
		
		return true;
	}
}
