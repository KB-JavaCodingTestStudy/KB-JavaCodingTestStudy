package week01.BOJ_B2_10809_알파벳찾기;

import java.util.Scanner;

public class Wina {

  public static void main(String[] args) {
//        입력
    String s = new Scanner(System.in).next();

//        초기화
    int[] arr = new int[26];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = -1;
    }

//        반복문을 통해서 인덱스 계산
    for (int idx = 0; idx < s.length(); idx++) {
      char c = s.charAt(idx);
//            처음 등장할 때
      if (arr[c - 'a'] == -1) {
        arr[c - 'a'] = idx;
      }
    }

//        출력
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
