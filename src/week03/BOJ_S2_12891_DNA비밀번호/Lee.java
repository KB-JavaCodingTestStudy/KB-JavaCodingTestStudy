package week03.BOJ_S2_12891_DNA비밀번호;

import java.util.*;
import java.io.*;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 04월 20일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 길이 n짜리 문자열이 주어진다.
 *  -  A C G T 의 개수가 필요로 하는 최소 개수를 만족하는 길이 m짜리 부분 문자열의 수를 카운팅한다.
 *
 *
 *  # 입력
 *  - 첫째 줄 : n m
 *  - 둘째 줄 : ACGT로 이루어진 문자열
 *  - 셋째 줄 : 필요로 하는 A C G T 의 개수 (최소값)
 *
 *  # 출력
 *  - A C G T의 필요개수를 만족하는 길이 m짜리 부분 문자열의 수
 *
 * 💻 알고리즘 설계
 *  - 슬라이딩 윈도우 기법을 이용하여 각 부분 문자열의 A, C, G, T 개수를 세고 조건에 맞는지 확인한다.
 *  - 조건에 맞는 부분 문자열의 개수를 카운팅한다.
 *
 *
 * ================================================================
 */

public class Lee {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 1번째 줄 입력
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 2번재 줄 입력
        String DNA = br.readLine();

        // 3번째 줄 입력
        st = new StringTokenizer(br.readLine());
        int needs[] = new int[4];
        for(int i = 0; i < 4; i++) {
            needs[i] = Integer.parseInt(st.nextToken());
        }

        /* 알고리즘 파트 */

        Map<Character, Integer> map = new HashMap<>();  // 각 문자를 인덱스로 바꾸는 해시맵
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        int counts[] = new int[4];  // 부분 문자열에 담긴 ACGT 문자의 수를 카운팅하는 배열

        // 최초의 문자열에 있는 ACGT 개수 카운팅
        for(int i = 0; i < m; i++) {
            counts[map.get(DNA.charAt(i))]++;   // 각 문자 (ACGT)를 추출 -> 인덱스 (0123) 으로 변환 -> 해당 인덱스를 카운팅
        }

        int cnt = 0;

        cnt++;  // 일단 조건에 맞다고 치고,
        for(int i = 0; i < 4; i++) {
            if(counts[i] < needs[i]) {
                cnt--;  // 아니면 다시 빼면 되지 뭐...
                break;
            }
        }

        for(int i = 0; i < n - m; i++) {
            counts[map.get(DNA.charAt(i))]--;
            counts[map.get(DNA.charAt(i+m))]++;

            cnt++;
            for(int j = 0; j < 4; j++) {
                if(counts[j] < needs[j]) {
                    cnt--;
                    break;
                }
            }
        }

        bw.write(cnt + "\n");

        bw.flush();

        bw.close();
        br.close();
    }
}