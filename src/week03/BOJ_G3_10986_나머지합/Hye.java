package week03.BOJ_G3_10986_나머지합;

import java.io.*;
import java.util.StringTokenizer;

/* ================================================================
 *
 * Problem  : 나머지 합_G3
 * Author   : 김혜지
 * Date     : 2025년 04월 22일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - 수 N개가 주어지며, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하기
 *
 * # 입력
 * - 1행 : N과 M 입력 받기
 * - 2행 : N개의 수 입력 받기
 *
 * # 출력
 * - 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수 출력
 *
 * 💻 알고리즘 설계
 * 1. N과 M 입력 받기
 * 2. N개의 수 입력 받기
 * 3. 구간합을 구한 뒤 그 합을 M으로 나눈 나머지를 prefix에 저장
 *    -> prefix[i] % M == prefix[j] % M : i+1부터 j까지의 합이 M의 배수
 *       ! prefix[j] - prefix[i] : i+1부터 j까지의 합
 *       ! (prefix[j] - prefix[i]) % M == 0
 *       ! 즉, prefix[i] % M == prefix[j] % M
 * 4. 이전에 같은 나머지를 가진 prefix[i]가 몇 번 나타났는지 기록
 * 5. count[temp]만큼 현재 구간과 M으로 나누어떨어지는 구간이 존재하기 때문에 result에 더함
 * 6. count[temp]에 1를 더함 - 현재 구간 추가
 *
 * ⏰ 시간복잡도
 * - O(N)
 * ================================================================
 */
public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] prefix = new long[N+1];
        long[] count = new long[M];

        long result = 0;

        st = new StringTokenizer(br.readLine());

        for(int i=  1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            prefix[i] = (prefix[i-1] + num) % M;
        }

        count[0] = 1;

        for(int i = 1; i <= N; i++){
            int temp = (int) prefix[i];
            result += count[temp];
            count[temp]++;
        }

        bw.write(result + "\n");
        bw.flush();

        br.close();
        bw.close();

    }
}