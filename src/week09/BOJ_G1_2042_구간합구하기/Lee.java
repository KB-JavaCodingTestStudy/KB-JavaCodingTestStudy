package algorithm.BOJ2042_구간합구하기;

import java.util.*;
import java.io.*;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 세그먼트 트리를 구성하고, 수의 변경 및 구간 합을 임의의 순서로 실행하여 구간합을 출력하는 문제.
 *
 * # 입력
 *  - line 1: n m k (n: 수의 개수, m: 수의 변경 횟수, k: 구간 합 횟수)
 *  - n lines: 한줄에 하나씩 n개의 수
 *  - m+k lines: a b c
 *
 * # 출력
 *  - 한 줄에 하나씩 구간합을 출력
 *
 * 💻 알고리즘 설계
 *  - 세그먼트 트리 알고리즘과 함께 설명하겠습니다.
 *
 * ================================================================
 */

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // size : n개의 데이터를 담을 수 있는 가장 작은 2의 제곱수
        int size = 1;
        while (size < n)
            size *= 2;

        // 세그먼트 트리 (배열형태) 생성
        int[] segment = new int[size * 2];

        // 리프 노드 채우기 (원본 배열의 원소들)
        for(int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());

            segment[size + i - 1] = num;
        }

        // 트리의 아래에서부터 자식 노드의 합계를 부모 노드에 저장한다.
        for(int i = size - 1; i > 0; i--) {
            segment[i] = segment[i * 2] + segment[i * 2 + 1];
        }

        // a b c를 입력받아 update 또는 aggregate를 수행한다.
        for(int i = 0; i < m+k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(segment, size, b, c);
            }
            else {
                int sum = aggregate(segment, size, b, c);
                bw.write(sum + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // i번째 원소를 x로 변경
    static void update(int[] segment, int size, int i, int x) {
        int curIdx = size + i - 1;

        segment[curIdx] = x;    // 리프 노드 갱신

        while(curIdx > 1) {   // 루트가 아니면
            curIdx /= 2;     // 부모 노드로 이동
            segment[curIdx] = segment[curIdx * 2] + segment[curIdx * 2 + 1];    // 합계를 다시 계산
        }
    }

    // 구간 [a, b] 원소들의 집계 (여기서는 합계)
    static int aggregate(int[] segment, int size, int a, int b) {
        int left = size + a - 1;
        int right = size + b - 1;
        int sum = 0;

        while (left <= right) {
            if (left % 2 == 1)              // left가 오른쪽 자식 노드이면,
                sum += segment[left++];     // 자신을 합계하고 +1 (자신이 왼쪽 노드가 되도록 이동한다.)

            if (right % 2 == 0)             // right가 왼쪽 자식 노드이면,
                sum += segment[right--];    // 자신을 합계하고 -1 (자신이 오른쪽 노드가 되도록 이동한다.)

            // 부모 노드로 이동 : left가 왼쪽 자식 노드이거나, right가 오른쪽 자식 노드이면 바로 집계하지 않아도 된다. 어차피 형제 노드와 함께 집계되기 때문이다.
            left /= 2;
            right /= 2;
        }

        return sum;
    }
}
