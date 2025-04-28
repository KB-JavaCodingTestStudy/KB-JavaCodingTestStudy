package week04.BOJ_S2_2864_5와6의차이;

/* ================================================================
 *
 * Author   : 남민주
 *
 * ================================================================
 * 📌 문제 분석 요약 
 *
 * # 입력
 * - 두 정수
 *
 * # 출력
 * - 5와 6을 혼동할 때 두 수의 합 중 최솟값&최댓값
 *
 * 💻 알고리즘 설계
 * - 두 수 입력 받기
 * - 최솟값 구하기(5<6)
 *  - 입력받은 수 중 6이 존재하면 모두 5로 변경
 *  - 두 수 더 해서 출력
 * - 최댓값 구하기(6>5)
 *  - 입력받은 수 중 5가 존재하면 모두 6으로 변경
 *  - 두 수 더 해서 출력
 *
 * ================================================================
 */

import java.io.*;

public class MJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String string = br.readLine();
        String[] strings = string.split(" ");

        int min = Integer.parseInt(strings[0].replace("6" ,"5"))
        + Integer.parseInt(strings[1].replace("6" ,"5"));
        int max =  Integer.parseInt(strings[0].replace("5" ,"6"))
        + Integer.parseInt(strings[1].replace("5" ,"6"));

        bw.write(min + " " + max);          
        bw.flush();

    }
}
