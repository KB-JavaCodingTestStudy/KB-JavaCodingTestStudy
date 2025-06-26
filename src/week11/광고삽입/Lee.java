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

        for(String log : logs) {
            StringTokenizer st = new StringTokenizer(log, "-");
            int log_start_sec = timeToSec(st.nextToken());
            int log_end_sec = timeToSec(st.nextToken());

            all_times[log_start_sec]++;
            all_times[log_end_sec]--;
        }

        for(int i = 1; i <= play_sec; i++) {
            all_times[i] += all_times[i - 1];
        }


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
