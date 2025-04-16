package week01.BOJ_B2_2908_상수;

import java.io.*;
import java.util.StringTokenizer;

public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String a = st.nextToken();
        String b = st.nextToken();

        String ra =  "" + a.charAt(2) + a.charAt(1) + a.charAt(0);
        String rb = "" + b.charAt(2) + b.charAt(1) + b.charAt(0);

        if(Integer.parseInt(ra)>Integer.parseInt(rb)){
            bw.write(ra);
        }else{
            bw.write(rb);
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
