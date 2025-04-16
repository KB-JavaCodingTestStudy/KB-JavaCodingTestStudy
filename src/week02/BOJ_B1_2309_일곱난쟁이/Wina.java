package week02.BOJ_B1_2309_일곱난쟁이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Wina {


  public static void main(String[] args) throws IOException {
//    초기설정
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//    입력
    int[] height = new int[9];
    int total = 0;
    for (int i = 0; i < 9; i++) {
      height[i] = Integer.parseInt(br.readLine());
      total += height[i];
    }

    for (int i = 0; i < 8; i++) { //난쟁이1
      for (int j = i + 1; j < 9; j++) { //난쟁이2
//        난쟁이 7명이 조건에 부합하는지 확인
        if (total - height[i] - height[j] == 100) {
          int[] result = new int[7];
          int idx = 0;

          for (int k = 0; k < 9; k++) {
            if (k != i && k != j) {
              result[idx++] = height[k];
            }
          }

          Arrays.sort(result);

          for (int h : result) {
            System.out.println(h);
          }

//          하나만 찾으면 됨
          return;
        }
      }
    }
//    종료 설정
    br.close();
  }
}
