package week07.PGS_LV3_단어변환;
/* ================================================================
 *
 * Problem  : 단어 변환
 * Author   : 최승아
 * Date     : 2025-05-28
 *
 * ================================================================
 * 📌 문제 분석 요약
 * 첫 단어부터 타겟단어까지 words에 있는 글자들을 한글자씩만 바꿔가면서 target에 도달할 수 있는가?
 * 도달할 수 있다면 몇번째만에 도달했는지 횟수를 리턴해라
 *
 *
 * 💻 알고리즘 설계
 * 각 words에서 한글자씩 다르고, words에 포함돼있는 단어를 인접리스트로 그래프를 만든다.
 * begin에서 시작해서 target까지 도달할 때까지 완전탐색을 한다.
 * 도달했다면 그 길이를 리턴한다.
 *
 *
 *
 * ⏰ 시간복잡도
 *
 * ================================================================
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Wina {
	
	public int solution(String begin, String target, String[] words) {
		Deque<String[]> dq = new ArrayDeque<>();
		Set<String> visited = new HashSet<>();
		
		dq.add(new String[]{begin, 0 + ""});
		visited.add(begin);
		
		while (!dq.isEmpty()) {
			String[] cur = dq.remove();
			String word = cur[0];
			int dist = Integer.parseInt(cur[1]);

//			종료 조건
			if (word.equals(target)) {
				return dist;
			}

//			다음 단어를 탐색
			for (String next : words) {
//				한글자씩 바꾸면서
				for (int i = 0; i < words[0].length(); i++) {
//					조건에 만족하는 것을 다음 노드로 설정
					String nextWord = word.substring(0, i) + next.charAt(i) + word.substring(i + 1);
					if (!visited.contains(nextWord) && nextWord.equals(next)) {
						dq.add(new String[]{nextWord, dist + 1 + ""});
						visited.add(nextWord);
					}
				}
			}
		}
		return 0;
	}
}
