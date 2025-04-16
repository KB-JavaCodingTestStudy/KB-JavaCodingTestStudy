package week01.BOJ_B3_10818_최소최대;

import java.util.Arrays;
import java.util.Scanner;

public class Wina {

  public static void main(String[] args) {
    //        입력
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

//        알고리즘
    Arrays.sort(arr);
    int min = arr[0];
    int max = arr[n - 1];

//        출력
    System.out.println(min + " " + max);
  }
}
