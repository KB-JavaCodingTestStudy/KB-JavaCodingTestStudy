package week02.BOJ_B2_12605_단어순서뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Wina {

  public static void main(String[] args) throws IOException {
//        입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

//        반복문 돌면서 배열을 반대로 꺼내면서 출력
    for (int n = 0; n < N; n++) {
      String[] line = br.readLine().split(" ");
      System.out.printf("Case #%d:", n + 1);
      for (int i = line.length - 1; i >= 0; i--) {
        System.out.printf(" %s", line[i]);
      }
      System.out.println();
    }

    br.close();
  }

}
