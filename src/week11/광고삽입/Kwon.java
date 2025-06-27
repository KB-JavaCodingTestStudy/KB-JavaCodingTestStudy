import java.util.*;
import java.io.*;

class Solution {

    // hh:mm:ss -> sec
    public int timeToSec(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");

        int hours = Integer.parseInt(st.nextToken());
        int minutes = Integer.parseInt(st.nextToken());
        int seconds = Integer.parseInt(st.nextToken());

        return hours * 3600 + minutes * 60 + seconds;
    }

    // sec -> hh:mm:ss
    public String secToTime(long sec) {
        long hours = sec / 3600;
        long minutes = sec % 3600 / 60;
        long seconds = sec % 60;

        String hh = String.format("%02d", hours);
        String mm = String.format("%02d", minutes);
        String ss = String.format("%02d", seconds);

        return hh + ":" + mm + ":" + ss;
    }

    public String solution(String play_time, String adv_time, String[] logs) {

        int play_sec = timeToSec(play_time);
        int adv_sec = timeToSec(adv_time);

        int[] all_times = new int[play_sec + 1];

        // (1) 재생 구간의 시작, 끝 부분에 차분값 기록
        for(String log : logs) {
            StringTokenizer st = new StringTokenizer(log, "-");
            int log_start_sec = timeToSec(st.nextToken());
            int log_end_sec = timeToSec(st.nextToken());

            all_times[log_start_sec]++;
            all_times[log_end_sec]--;
        }

        // (2) 누적합으로 각 초당 재생 횟수 계산 (차분값을 베이스로 일종의 적분 비슷한 짓을 함)
        for(int i = 1; i <= play_sec; i++) {
            all_times[i] += all_times[i - 1];
        }

        // (3) 슬라이딩 윈도우로 가장 많은 재생시간과 겹치는 광고 시작시간 구하기
        long overlap_times = 0;

        for(int i = 0; i < adv_sec; i++) {
            overlap_times += all_times[i];
        }

        long max_overlap_times = overlap_times;
        long max_overlap_start_sec = 0;

        for(int i = 0; i < play_sec - adv_sec; i++) {
            overlap_times -= all_times[i];
            overlap_times += all_times[i + adv_sec];

            if (overlap_times > max_overlap_times) {
                max_overlap_times = overlap_times;
                max_overlap_start_sec = i + 1;
            }
        }

        return secToTime(max_overlap_start_sec);

    }
}
