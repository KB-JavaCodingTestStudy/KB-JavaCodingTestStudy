package week01.BOJ_B3_2566_최댓값;

import java.io.*;
import java.util.StringTokenizer;

public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[9][9];
        int max = Integer.MIN_VALUE;
        int x = -1;
        int y = -1;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(arr[i][j] > max){
                    max = arr[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        bw.write(String.valueOf(max) + '\n');
        bw.write(String.valueOf(x+1) + " " + String.valueOf(y+1) + '\n');

        bw.flush();
        br.close();
        bw.close();
    }
}
