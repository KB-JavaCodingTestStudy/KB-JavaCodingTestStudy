package week11.광고삽입;

public class MJ {
    class Solution {
        public int[] splitStart2EndTime(String str){
            int[] result = new int[2];
            String[] times = str.split("-");
            result[0] = Str2Time(times[0]);
            result[1] = Str2Time(times[1]);
            return result;
        }

        public int Str2Time(String time){
            String[] s = time.split(":");
            int hour = Integer.parseInt(s[0]);
            int minute = Integer.parseInt(s[1]);
            int second = Integer.parseInt(s[2]);
            return hour * 3600 + minute * 60 + second;
        }

        public String intToStr(int s) {
            int hour = s / 3600;
            s %= 3600;
            int minute = s / 60;
            int second = s % 60;

            return String.format("%02d:%02d:%02d", hour, minute, second);
        }

        public String solution(String play_time, String adv_time, String[] logs) {
            int play = Str2Time(play_time);
            int adv = Str2Time(adv_time);
            long[] dp = new long[play + 1];

            for (String log : logs) {
                int[] se = splitStart2EndTime(log);
                dp[se[0]]++;
                dp[se[1]]--;
            }

            // 1초 단위 시청자 수 누적
            for (int i = 1; i <= play; i++) {
                dp[i] += dp[i - 1];
            }

            // 누적 시청 시간 계산
            for (int i = 1; i <= play; i++) {
                dp[i] += dp[i - 1];
            }

            long maxTime = dp[adv - 1];
            int startTime = 0;

            for (int i = 1; i + adv <= play; i++) {
                long curr = dp[i + adv - 1] - dp[i - 1];
                if (curr > maxTime) {
                    maxTime = curr;
                    startTime = i;
                }
            }

            return intToStr(startTime);
        }
    }
}
