package week03.BOJ_S2_12891_DNA비밀번호;
/* ================================================================
 *
 * Author   : 김혜지
 * Date     : 2025년 04월 21일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - DNA 문자열 - {'A', 'C', 'G', 'T'}
 * - 임의의 DNA 문자열의 부분문자열을 뽑았을 때, 부분 문자열에서 등장하는 문자의 개수가 특정 개수 이상이여야 비밀번호로 사용 가능
 * - 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급
 *
 * # 입력
 * - 1행 : DNA 문자열의 길이 S, 부분 문자열의 길이 P
 * - 2행 : 임의의 DNA 문자열
 * - 3행 : {'A','C','G','T'}의 최소 개수
 *
 * # 출력
 * - 만들 수 있는 비밀번호의 종류의 수
 *
 * 💻 알고리즘 설계
 * 1. DNA 문자열의 길이와 부분 문자열의 길이 입력받기
 * 2. DAN 문자열 입력 받기
 * 3. A C G T 최소 개수 입력 받기
 * 4. 부분 문자열의 크기만큼 반복하여 각 문자의 개수 구하기 -> 초기 윈도우
 * 5. 각 문자의 개수가 최소 개수를 충족한다면 count에 +1
 * 6. 윈도우를 오른쪽으로 한 칸 이동하여 제외된 문자는 해당 개수에서 차감하고, 추가된 문자는 해당 개수에서 증가시키기
 *    -> ( DNA 문자열의 길이 만큼 반복 )
 * 7. 각 문자의 개수가 최소 개수를 충족한다면 count에 +1
 * 8. count 출력
 *
 * ⏰ 시간복잡도
 * - O(n)
 * -> n : DNA 문자열의 길이
 * ================================================================
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(token.nextToken());
        int p = Integer.parseInt(token.nextToken());

        String dna = br.readLine();

        StringTokenizer token2 = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(token2.nextToken());
        int c = Integer.parseInt(token2.nextToken());
        int g = Integer.parseInt(token2.nextToken());
        int t = Integer.parseInt(token2.nextToken());

        int count = 0;
        int ta = 0, tc = 0, tg = 0, tt = 0;

        // 초기 윈도우
        for ( int i = 0; i < p; i++){
            char ch = dna.charAt(i);
            if (ch =='A') ta++;
            else if(ch=='C') tc++;
            else if(ch=='G') tg++;
            else tt++;
        }
        if (ta >= a && tc >= c && tg >= g && tt >= t) count++;

        // 슬라이딩 윈도우 이동
        for ( int i = p; i < s; i++){
            char left = dna.charAt(i - p); // 2 - 2 = 0 / 3 - 2 = 1 /
            char right = dna.charAt(i); // 2 // 3

            if (left =='A') ta--;
            else if(left=='C') tc--;
            else if(left=='G') tg--;
            else tt--;

            if (right =='A') ta++;
            else if(right=='C') tc++;
            else if(right=='G') tg++;
            else tt++;

            if (ta >= a && tc >= c && tg >= g && tt >= t) count++;
        }
        System.out.println(count);
    }
}
