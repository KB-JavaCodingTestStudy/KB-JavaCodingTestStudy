package week02.BOJ_B2_25305_커트라인;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Wina {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    // 점수 배열 입력
    int[] scores = new int[N];
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      scores[i] = Integer.parseInt(st2.nextToken());
    }

    br.close();
    // 점수 내림차순 정렬
    Arrays.sort(scores); // 오름차순 정렬
    int result = scores[N - k]; // k번째 큰 수

    System.out.println(result);
  }

}
