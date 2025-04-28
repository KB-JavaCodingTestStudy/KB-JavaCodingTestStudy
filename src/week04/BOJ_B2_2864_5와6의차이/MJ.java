package week04.BOJ_S2_2864_5와6의차이;

import java.io.*;

public class MJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String string = br.readLine();
        String[] strings = string.split(" ");

        int min = Integer.parseInt(strings[0].replace("6" ,"5"))
        + Integer.parseInt(strings[1].replace("6" ,"5"));
        int max =  Integer.parseInt(strings[0].replace("5" ,"6"))
        + Integer.parseInt(strings[1].replace("5" ,"6"));

        bw.write(min + " " + max);          
        bw.flush();

    }
}
