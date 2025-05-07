package week04.BOJ_B2_2864_5와6의차이;

/* ================================================================
 *
 * Problem  : 5와 6의 차이
 * Author   : 김혜지
 * Date     : 2025년 05월 07일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - 두 수 A와 B가 주어졌을 때, 두수의 합 중 최소값과 최대값 구하기
 * + 두 수에서 5를 6으로 볼 수도 있고, 6을 5로도 볼 수도 있음
 *
 * # 입력
 * - 두 정수 A와 B
 *
 * # 출력
 * - 최소값과 최대값
 *
 * 💻 알고리즘 설계
 * 1. 두 수를 입력받는다.
 * 2. 각 수에서 최소값의 경우('6'을 '5'로 봄)와 최대값의 경우('5'를 '6'으로 봄)를 구한다.
 * 3. 서로 최소값일 경우를 더하고, 최대값일 경우를 더하여 출력한다.
 *
 * ⏰ 시간복잡도
 * - O(1)
 * ================================================================
 */

import java.io.*;
import java.util.StringTokenizer;

public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int maxA = Integer.parseInt(a.replace('5', '6'));
        int minA = Integer.parseInt(a.replace('6', '5'));

        int maxB = Integer.parseInt(b.replace('5', '6'));
        int minB = Integer.parseInt(b.replace('6', '5'));

        bw.write((minA + minB) + " " + (maxA + maxB));
        bw.flush();
        bw.close();

        br.close();

    }
}