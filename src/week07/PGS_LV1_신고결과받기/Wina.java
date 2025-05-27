package week07.PGS_LV1_신고결과받기;

/* ================================================================
 *
 * Problem  : 신고 결과 받기
 * Author   : 최승아
 * Date     : 2025-05-26
 *
 * ================================================================
 * 📌 문제 분석 요약
 * 유저는 여러명의 다른 유저를 신고할 수 있다. 하지만 한 유저가 신고하는 여러번의 신고는 모두 1회로 판단한다.
 * k번 이상 신고된 유저를 신고한 유저에게 처리 결과 메일을 발송한다.
 * 처리 결과 메일을 몇번 받게 되는지, id_list의 순서에 맞게 반환한다.
 *
 * 💻 알고리즘 설계
 * id_list와 연계되는 HashMap을 작성한다. 추후 결과 리스트를 반환하기 위함
 * report 배열의 동일값을 제거하기 위해 Map으로 전환한다.
 * space를 기준으로 {신고받은 사람:[신고한 사람]} 형태의 HashMap을 작성한다.
 * report를 모두 돌았을 때 k보다 신고 받은 사람이 있을 때 신고한 사람에게 결과 메일을 보내기 위해 각 result에 +1을 해준다.
 *
 *
 * ⏰ 시간복잡도
 *
 * ================================================================
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Wina {
	
	static Map<String, Integer> mailCnt;
	static Map<String, Set<String>> getReported;
	static Set<String> reportSet;
	
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		getReported = new HashMap<>();
		mailCnt = new HashMap<>();

//		map 초기화
		for (String id : id_list) {
			getReported.put(id, new HashSet<>());
			mailCnt.put(id, 0);
		}

//		피신고자를 신고한 배열 저장
		for (String reportCase : report) {
			StringTokenizer st = new StringTokenizer(reportCase);
			String reporter = st.nextToken();
			String reported = st.nextToken();
//			추가, Set이기 때문에 중복값은 저장되지 않음
			getReported.get(reported).add(reporter);
		}

//		k를 넘었을 때 처리 결과 추가
		for (String id : id_list) {
			Set<String> reporters = getReported.get(id);
			if (reporters.size() >= k) {
				for (String str : reporters) {
					mailCnt.put(str, mailCnt.get(str) + 1);
				}
			}
		}

//		순서 맞춰서 저장
		for (int i = 0; i < id_list.length; i++) {
			answer[i] = mailCnt.get(id_list[i]);
		}
		
		return answer;
	}
}
