import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSeconds = timeToSeconds(play_time);
        int advSeconds = timeToSeconds(adv_time);
        long[] total = new long[playSeconds + 2];

        // 시청 구간 누적
        for (String log : logs) {
            String[] split = log.split("-");
            int start = timeToSeconds(split[0]);
            int end = timeToSeconds(split[1]);
            total[start] += 1;
            total[end] -= 1;
        }

        // 누적 재생자 수 계산 (prefix sum 1단계)
        for (int i = 1; i <= playSeconds; i++) {
            total[i] += total[i - 1];
        }

        // 누적 재생 시간 계산 (prefix sum 2단계)
        for (int i = 1; i <= playSeconds; i++) {
            total[i] += total[i - 1];
        }

        // 슬라이딩 윈도우로 광고시간만큼 구간합 최대 찾기
        long maxTime = total[advSeconds - 1];
        int startTime = 0;
        for (int i = advSeconds; i <= playSeconds; i++) {
            long current = total[i] - total[i - advSeconds];
            if (current > maxTime) {
                maxTime = current;
                startTime = i - advSeconds + 1;
            }
        }

        return secondsToTime(startTime);
    }

    private int timeToSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 3600
             + Integer.parseInt(parts[1]) * 60
             + Integer.parseInt(parts[2]);
    }

    private String secondsToTime(int seconds) {
        int h = seconds / 3600;
        seconds %= 3600;
        int m = seconds / 60;
        seconds %= 60;
        return String.format("%02d:%02d:%02d", h, m, seconds);
    }
}
