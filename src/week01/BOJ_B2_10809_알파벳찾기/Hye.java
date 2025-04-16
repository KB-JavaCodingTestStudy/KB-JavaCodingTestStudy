package week01.BOJ_B2_10809_알파벳찾기;

import java.io.*;
import java.util.Arrays;

public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] alpha = new String[26];
        Arrays.fill(alpha, "-1");

        String[] temp = br.readLine().split("");

        for (int i = 0; i < temp.length; i++) {
            String t = alpha[temp[i].charAt(0) - 'a'];
            if(t.equals("-1")){
                alpha[temp[i].charAt(0) - 'a'] = String.valueOf(i);

            }
        }

        bw.write(String.join(" ", alpha));
        bw.flush();
        bw.close();
        br.close();
    }
}
