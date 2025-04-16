package week01.BOJ_B4_15552_빠른AB;

import java.io.*;

public class Wina {

  public static void main(String[] args) throws IOException {
    //설정
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
//            한 라인을 받아와서 공백을 기준으로 저장
      String[] line = br.readLine().split(" ");
      int a = Integer.parseInt(line[0]);
      int b = Integer.parseInt(line[1]);
      bw.write((a + b) + "\n");
    }

//최종 정리
    bw.flush();
    bw.close();
    br.close();
  }
}
