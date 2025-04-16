package week02.BOJ_B2_17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Wina {

  public static void main(String[] args) throws IOException {
//    초기 설정
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//    입력
    int N = Integer.parseInt(br.readLine());
    int[] height = new int[N];

    for (int i = 0; i < N; i++) {
      height[i] = Integer.parseInt(br.readLine());
    }

    int max = 0;     // 지금까지 본 가장 높은 막대기
    int count = 0;   // 보이는 막대기 수

    for (int i = N - 1; i >= 0; i--) {
//      현재까지 본 막대기보다 높은 것이 있다면
      if (height[i] > max) {
        count++;
        max = height[i];
      }
    }

    System.out.println(count);

//    종료 설정
    br.close();
  }
}
