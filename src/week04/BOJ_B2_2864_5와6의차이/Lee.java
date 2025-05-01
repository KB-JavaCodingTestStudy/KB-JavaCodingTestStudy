package study.week04.BOJ_B2_2864_5와6의차이;

import java.util.*;
import java.io.*;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 05월 01일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 두 정수가 주어진다. 여기서 5를 6으로, 6을 5로 바꿀 수 있다.
 *  - 5,6을 규칙에 따라 바꾸어 두 수의 합이 가장 작게 되도록, 또 합이 가장 크게 되도록 하여 각각 출력한다.
 *
 *  # 입력
 *  - A B (두 정수)
 *
 *  # 출력
 *  - min max (두 정수에서 5와 6만 바꿔서 더했을 때 나올 수 있는 최소값과 최대값)
 *
 * 💻 알고리즘 설계
 * - 수를 문자열로 입력받는다.
 * - 문자열의 replace를 이용하여 6을 전부 5로 바꾼뒤, 정수로 바꾸어 합한다. 이것이 최소값이 된다.
 * - 5를 전부 6으로 바꾼뒤, 정수로 바꾸어 합한다. 이것이 최대값이 된다.
 *
 * ================================================================
 */

public class Lee {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int min = 0;
        int max = 0;

        min += Integer.parseInt(a.replace("6", "5"));
        min += Integer.parseInt(b.replace("6", "5"));

        max += Integer.parseInt(a.replace("5", "6"));
        max += Integer.parseInt(b.replace("5", "6"));

        bw.write(min + " " + max);

        bw.flush();

        br.close();
        bw.close();
    }
}
