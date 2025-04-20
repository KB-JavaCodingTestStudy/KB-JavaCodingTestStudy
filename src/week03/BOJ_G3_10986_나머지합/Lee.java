package week03.BOJ_G3_10986_나머지합;

import java.util.*;
import java.io.*;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 04월 20일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 주어진 수열에서 구간 합이 m의 배수가 되는 구간의 개수 세기
 *
 *  # 입력
 *  - 첫째 줄 : n m        // n : 수열의 크기 (수의 개수), m : 나누는 수
 *  - 둘째 줄 : n개의 수    // 수열
 *
 *  # 출력
 *  -
 *
 * 💻 알고리즘 설계
 *
 * - 방법 1.
 * 1) 수를 저장할 때 처음부터 m으로 나눈 나머지로 저장
 * 2) 누적합 배열을 만든 후 (O(n) 시간), 모든 구간의 구간 합을 계산하여 m으로 나눠 비교한다. (O(n^2) 시간)
 * 3) 당연히 시간 초과...
 *
 * - 방법 2.
 * 1) 누적 합을 m으로 나눈 나머지를 저장한다.
 * 2) (m으로 나눈) 나머지가 같은 두 누적 합의 차는 나머지가 0이 된다.
 * 3) 따라서 나머지가 같은 누적 합 쌍의 수를 센다.
 *
 * 📢 주의 사항
 *
 * - counts 배열에 들어오는 입력은 int 범위를 벗어나지 않는다.
 *   cnt에 들어오는 계산 결과도 int 범위를 벗어나지 않는다.
 *   단, cnt += counts[i] * (counts[i] - 1) / 2; 에서
 *   counts[i] * (counts[i] - 1) 부분이 잠시 int 범위를 초과하여 오버플로우 될 수 있다.
 *   따라서 long 으로 형변환 하여 이를 방지한다. / 2 까지 마친 결과는 int 형 범위 안이므로 그대로 넣어도 된다.
 *
 * ================================================================
 */

public class Lee {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int sum = 0;  // 누적합 임시저장 변수
        int[] counts = new int[m];  // counts[i] : 나머지가 i인 누적합의 개수

        counts[0] = 1;  // 아무것도 더하지 않은 누적합 1가지 경우 추가

        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(st.nextToken());
            sum %= m;

            counts[sum]++;
        }

        int cnt = 0;

        for(int i = 0; i < m; i++) {
            if(counts[i] == 0)
                continue;

            cnt += (long)counts[i] * (counts[i] - 1) / 2;   // counts[i] 에서 2개를 뽑는 combinations 공식
        }

        bw.write(cnt + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

}
