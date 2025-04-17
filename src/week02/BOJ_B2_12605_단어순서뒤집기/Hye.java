package week02.BOJ_B2_12605_단어순서뒤집기;
/* ================================================================
 *
 * Author   : 김혜지
 * Date     : 2025년 04월 17일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - 단어들을 반대 순서로 뒤집기
 *
 * # 입력
 * - 첫 행 : 전체 케이스의 개수 N
 * - N 행 : 스페이스로 띄어진 단어들 ( 문자열 )
 *
 * # 출력
 * - 각 케이스에 대해 "Case #x: "를 출력한 후 이어 단어들을 반대 순서로 출력
 *
 * 💻 알고리즘 설계
 * 1. 전체 케이스의 개수를 입력받는다 ( N )
 * 2. 입력받은 문자열을 공백(스페이스)를 기준으로 나누어 단어 리스트를 만든다.
 * 3. 스택에 단어를 순서대로 집어 넣는다.
 * 4. 스택이 다 비워질 때까지 값을 꺼내 출력한다.
 * ================================================================
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<String>[] stack = new Stack[n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            stack[i] = new Stack<>();

            for (int j = 0; j < s.length; j++) {
                stack[i].push(s[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Case #" + (i + 1) + ":");
            while(!stack[i].isEmpty()){
                System.out.print(" " + stack[i].pop());
            }
            System.out.println();
        }
    }
}

/* ================================================================
 * ⏰ 시간복잡도
 * - O(NW)
 * -> N : 문장의 개수
 * -> W : 각 문장의 단어 수
 * ================================================================
 */