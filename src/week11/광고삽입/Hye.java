package week11.광고삽입;

/* ================================================================
 *
 * Problem  : 광고삽입_
 * Date     : 2025년 06월 25일
 * 
 * ================================================================
 */

import java.util.*;

public class Hye {

    class Solution {
        public String solution(String play_time, String adv_time, String[] logs) {

            int playT = timeToInt(play_time);
            int advT = timeToInt(adv_time);


            long[] count = new long[playT + 1];

            for (String log : logs) {
                String[] ls = log.split("-");
                int startTime = timeToInt(ls[0]);
                int endTime = timeToInt(ls[1]);

                count[startTime]++;
                count[endTime]--;
            }

            for (int i = 1; i <= playT; i++) {
                count[i] += count[i - 1];
            }

            for (int i = 1; i <= playT; i++) {
                count[i] += count[i - 1];
            }

            long maxT = 0;
            int startT = 0;

            maxT = count[advT - 1];

            for (int st = 1; st <= playT - advT; st++) {
                int et = st + advT;

                long ct = count[et - 1] - count[st - 1];

                if (ct > maxT) {
                    maxT = ct;
                    startT = st;
                }
            }

            return timeToStr(startT);
        }

        public int timeToInt(String time) {
            String[] parts = time.split(":");
            return Integer.parseInt(parts[0]) * 3600 + Integer.parseInt(parts[1]) * 60 + Integer.parseInt(parts[2]);
        }


        public String timeToStr(int seconds) {
            return String.format("%02d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, seconds % 60);
        }
    }
}
