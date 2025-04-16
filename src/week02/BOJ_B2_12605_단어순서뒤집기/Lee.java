package week02.BOJ_B2_12605_단어순서뒤집기;

import java.util.*;
import java.io.*;

public class Lee{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> words = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()) {
                words.push(st.nextToken());
            }

            bw.write("Case #" + (i+1) + ":");

            while(!words.isEmpty()) {
                bw.write(" " + words.pop());
            }
            bw.write("\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}