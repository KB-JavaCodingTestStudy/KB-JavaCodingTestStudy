
/* ================================================================
 *
 * Author   : 안홍영
 * Date     : 2025년 04월 23일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - DNA 문자열 - {'A', 'C', 'G', 'T'}
 * - 임의의 문자열에서 부분문자열을 뽑았을 때 {'A', 'C', 'G', 'T'}에 해당하는 문자 개수가 특정 개수 이상이여야 비밀번호로 사용 가능
 *
 * # 입력
 * - 1행 : 문자열의 길이 S, 비번에 사용될 문자열 길이 P
 * - 2행 : S 길이 만큼의 문자열
 * - 3행 : DNA 비번이 될 수 있는 {'A','C','G','T'}의 최소 개수
 *
 * # 출력
 * - 만들 수 있는 비밀번호의 종류의 수
 *
 * 💻 알고리즘 설계
 * 1. 입력 받기!
 * 2. P(부분문자열) 크기만큼 배열을 방문하여 DNA 비번이 될 수 있는지 check (슬라이딩 윈도우)
 * 3. 비번이 될 수 있는 DNA 문자열이면 result++
 *
 * ⏰ 시간복잡도
 * - O(n)
 * -> n : 문자열의 길이
 * ================================================================
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hong {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String AllDNA = br.readLine();

        st = new StringTokenizer(br.readLine());
        int minA = Integer.parseInt(st.nextToken());
        int minC = Integer.parseInt(st.nextToken());
        int minG = Integer.parseInt(st.nextToken());
        int minT = Integer.parseInt(st.nextToken());

        int countA = 0, countC = 0, countG = 0, countT = 0;
        int result = 0;

        for (int i = 0; i < P; i++) {
            char c = AllDNA.charAt(i);
            if (c == 'A') countA++;
            else if (c == 'C') countC++;
            else if (c == 'G') countG++;
            else if (c == 'T') countT++;
        }

        if (countA >= minA && countC >= minC && countG >= minG && countT >= minT) result++;

        for (int i = P; i < S; i++) {
            char out = AllDNA.charAt(i - P);
            char in = AllDNA.charAt(i);

            if (out == 'A') countA--;
            else if (out == 'C') countC--;
            else if (out == 'G') countG--;
            else if (out == 'T') countT--;

            if (in == 'A') countA++;
            else if (in == 'C') countC++;
            else if (in == 'G') countG++;
            else if (in == 'T') countT++;

            if (countA >= minA && countC >= minC && countG >= minG && countT >= minT) result++;
        }

        System.out.println(result);
    }
}


/*
    코드가 반복 되는거 같아 줄여보자 해서 줄인 반복문.....
    for (int i = 0; i < S; i++) {
        char in = AllDNA.charAt(i);
        if (in == 'A') countA++;
        else if (in == 'C') countC++;
        else if (in == 'G') countG++;
        else if (in == 'T') countT++;

        if (i >= P) {
            char out = AllDNA.charAt(i - P);
            if (out == 'A') countA--;
            else if (out == 'C') countC--;
            else if (out == 'G') countG--;
            else if (out == 'T') countT--;
        }

        if (countA >= minA && countC >= minC && countG >= minG && countT >= minT) result++;
 */

