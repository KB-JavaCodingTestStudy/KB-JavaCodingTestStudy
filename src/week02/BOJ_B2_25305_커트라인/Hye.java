package week02.BOJ_B2_25305_커트라인;

/* ================================================================
 *
 * Author   : 김혜지
 * Date     : 2025년 04월 17일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - N명의 학생들 중 점수가 가장 높은 K명 수상 - 상을 받는 점수 커트라인 구하기
 *
 * # 입력
 * - 1행 : 응시자의 수 N과 상을 받는 사람의 수 k 입력받기
 * - 2행 : 각 학생의 점수 x (공백을 기준으로 문자열로 입력)
 *
 * # 출력
 * - 상을 받는 커트라인 출력
 *
 * 💻 알고리즘 설계
 * 1. N과 k를 입력받는다.
 * 2. 각 학생의 점수 x를 입력받은 후 리스트로 변환한다.
 * 3. 리스트를 내림차순으로 정렬한 후 `k-1` 인덱스의 값을 구해 출력한다.
 *
 * ⏰ 시간복잡도
 * - O(n log n)
 * -> for : O(n)
 * -> sort : O(n log n)
 *
 * ================================================================
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        String[] ns = br.readLine().split(" ");

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < ns.length; i++){
            list.add(Integer.parseInt(ns[i]));
        }

        list.sort((a, b) -> b - a);

        System.out.println(list.get(k-1));
    }
}

