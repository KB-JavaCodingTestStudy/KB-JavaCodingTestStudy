package week01.BOJ_B2_8958_OX퀴즈;

import java.util.Scanner;

public class Wina {

  public static void main(String[] args) {
//        입력
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();

//        알고리즘
    Integer[] ans = new Integer[tc];
    for (int t = 0; t < tc; t++) {
      String str = sc.next();
      int cnt = 0;
      int score = 0;

//            각 라인 순회
      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == 'O') {
          cnt++;
          score += cnt;
        } else {
          cnt = 0; //초기화
        }
      }
      ans[t] = score;
    }

//출력
    for (int i = 0; i < tc; i++) {
      System.out.println(ans[i]);
    }
  }
}
