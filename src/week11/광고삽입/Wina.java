package week11.광고삽입;

import java.util.StringTokenizer;

class Wina {
	
	public static int StringToSec(String time) {
		StringTokenizer st = new StringTokenizer(time, ":");
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		return hour * 3600 + minute * 60 + second;
	}
	
	public static String SecToString(int time) {
		int hour = time / 3600;
		time %= 3600;
		int minute = time / 60;
		int second = time % 60;
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
	
	public String solution(String play_time, String adv_time, String[] logs) {
//		변수 의미 정의
		int playSec = StringToSec(play_time);
		int advSec = StringToSec(adv_time);
		
		long[] view = new long[playSec + 2]; //t초에 시청 중인 사람 수
		long[] dp = new long[playSec + 2]; //t초까지의 전체 누적 시간
//		초기 설정: 각 로그마다 시청/종료 시간 처리
		for (String log : logs) {
			StringTokenizer st = new StringTokenizer(log, "-");
			int startLog = StringToSec(st.nextToken());
			int endLog = StringToSec(st.nextToken());
			view[startLog] += 1;
			view[endLog] -= 1;
		}
//		누적합
		for (int i = 1; i <= playSec; i++) {
			view[i] += view[i - 1];
		}

//		반복문으로 dp테이블 채우기
		dp[0] = view[0];
		for (int i = 1; i <= playSec; i++) {
			dp[i] = dp[i - 1] + view[i];
		}

//		정답리턴
		long maxView = dp[advSec - 1];
		int startTime = 0;
		for (int i = advSec; i <= playSec; i++) {
			long total = dp[i] - dp[i - advSec];
			if (total > maxView) {
				maxView = total;
				startTime = i - advSec + 1;
			}
		}
		return SecToString(startTime);
	}
}