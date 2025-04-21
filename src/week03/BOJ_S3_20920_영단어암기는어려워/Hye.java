package week03.BOJ_S3_20920_영단어암기는어려워;
/* ================================================================
 *
 * Problem  : 영단어 암기는 괴로워_S3
 * Author   : 김혜지
 * Date     : 2025년 04월 21일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - 영어단어장 => 길이가 M 이상인 단어만
 * -> 자주 나오는 단어일수록 앞에 배치
 * -> 해당 단어의 길이가 길수록 앞에 배치
 * -> 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치
 *
 * # 입력
 * - 1행 : 단어의 개수 N, 단어의 최소 길이 M
 * - 2행~ : N개의 단어 입력 ( 알파벳 소문자 & M <= 10 )
 *
 * # 출력
 * - 단어장 단어 출력
 *
 * 💻 알고리즘 설계
 * 1. 단어의 개수 N과 단어의 최소 길이 M 입력 받기
 * 2. 단어 입력 받기 - 단어의 길이가 M 이상인 경우만 HashMap에 추가하기
 * 3. 단어 정렬하기
 * 4. 단어장 단어 출력하기
 *
 * ⏰ 시간복잡도
 * - O(N log N)
 * ================================================================
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hash = new HashMap<>();

        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            if( temp.length() < M) continue;
            hash.put(temp, hash.getOrDefault(temp, 0) + 1);
        }


        List<String> list = new ArrayList<>(hash.keySet());

        Collections.sort(list, (o1, o2) -> {
            if (Integer.compare(hash.get(o1), hash.get(o2)) != 0) {
                return Integer.compare(hash.get(o2), hash.get(o1));
            }

            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }

            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str + '\n');
        }
        System.out.println(sb);

    }
}