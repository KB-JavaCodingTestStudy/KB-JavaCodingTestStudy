package week09.BOJ_S4_14425_문자열집합;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MJ{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<String, Boolean> map = new HashMap<String, Boolean>();

        for (int i = 0; i < nm[0]; i++) {
            String str =  br.readLine();
            map.put(str, true);
        }

        for (int i = 0; i < nm[1]; i++) {
            String str =  br.readLine();
            if(map.containsKey(str)){
                count++;
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }
}
