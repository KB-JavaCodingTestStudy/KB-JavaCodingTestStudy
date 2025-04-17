package week02.BOJ_B2_17608_막대기;

/* ================================================================
 *
 * Author   : 김혜지
 * Date     : 2025년 04월 17일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - 막대기를 일렬로 세운 후, 오른쪽에서 보이는 막대기의 개수 구하기
 *   ( 높이가 더 높은 것이 보이게 되며, 높이가 같은 경우 보이지 않음 )
 *
 * # 입력
 * - 첫번째 줄 : 막대기의 개수를 나타내는 정수 N
 * - N 줄 : 막대기의 높이를 나타내는 정수 h
 *
 * # 출력
 * - 오른쪽에서 N개의 막대기를 보았을 때, 보이는 막대의 개수 출력
 *
 * 💻 알고리즘 설계
 * 1. 막대기의 개수를 입력 받는다.
 * 2. 스택에 막대기의 높이를 넣는다.
 * 3. 스택의 값을 꺼내 MAX 값으로 지정한다. ( LIFO : Last-in First-out )
 * 4. 나머지 값들을 차례대로 꺼내면서 MAX 값보다 큰 개수를 센다.
 *    ( 꺼내진 값이 MAX 값보다 크다면 개수에 포함하고 그 값을 MAX로 지정 )
 * 5. 개수를 출력한다.
 * ================================================================
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Hye {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        for (int i = 0; i < number; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        int max = stack.pop();
        int count = 1;
        for (int i = 0; i < number-1; i++) {
            int next_right = stack.pop();
            if (max < next_right) {
                max = next_right;
                count++;
            }
        }
        System.out.println(String.valueOf(count));
    }
}

/* ================================================================
 * ⏰ 시간복잡도
 * - O(N)
 * ================================================================
 */

