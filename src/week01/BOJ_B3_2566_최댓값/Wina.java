package week01.BOJ_B3_2566_최댓값;

import java.io.*;

public class Wina {

  public static void main(String[] args) throws IOException {
//        설정
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int maxNum = 0, r = 0, c = 0;
//        입력
    for (int i = 0; i < 9; i++) {
      String[] line = br.readLine().split(" ");
      for (int j = 0; j < 9; j++) {
        int num = Integer.parseInt(line[j]);
//            매 숫자마다 최댓값인지 확인
        if (num > maxNum) {
          r = i;
          c = j;
          maxNum = num;
        }
      }
    }
    bw.write(maxNum + "\n");
    bw.write((r + 1) + " " + (c + 1));

//        종료 처리
    bw.flush();
    br.close();
    br.close();
  }
}
