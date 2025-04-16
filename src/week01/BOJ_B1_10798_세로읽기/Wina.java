package week01.BOJ_B1_10798_세로읽기;

import java.io.IOException;
import java.util.Scanner;

public class Wina {

  public static void main(String[] args) throws IOException {
//        입력
    Scanner sc = new Scanner(System.in);
    char[][] matrix = new char[5][15];
    for (int i = 0; i < 5; i++) {
      String line = sc.next();
      for (int j = 0; j < line.length(); j++) {
        matrix[i][j] = line.charAt(j);
      }
    }

//        출력
    for (int j = 0; j < 15; j++) {
      for (int i = 0; i < 5; i++) {
//                비어있는 문자인지 확인
        if (matrix[i][j] != '\0') {
          System.out.print(matrix[i][j]);
        }
      }
    }
  }
}
