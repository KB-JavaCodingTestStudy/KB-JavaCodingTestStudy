package pgs.lv2.p문자열압축;

class Solution {
	
	public int solution(String s) {
		int answer = s.length();
		
		for (int i = 1; i <= s.length() / 2; i++) {
			StringBuilder sb = new StringBuilder(); //압축 결과 저장
			String tmp = s.substring(0, i);
			int cnt = 1; //문자열 반복 수 저장
			
			for (int j = i; j < s.length(); j += i) {
				String now;
//				잘라낼 수 있는 범위인지 체크
				if (j + i <= s.length()) {
					now = s.substring(j, j + i);
				} else {
					now = s.substring(j);
				}

//				이전 문자열과 같으면 cnt++
				if (tmp.equals(now)) {
					cnt++;
				} else {
					if (cnt > 1) {
						sb.append(cnt);
					}
					sb.append(tmp);
//					새롭게 기준 생성
					tmp = now;
					cnt = 1;
				}
			}

//			마지막 문자열 처리
			if (cnt > 1) {
				sb.append(cnt);
			}
			sb.append(tmp);

//			최솟값 계산
			answer = Math.min(answer, sb.length());
		}
		
		return answer;
	}
}