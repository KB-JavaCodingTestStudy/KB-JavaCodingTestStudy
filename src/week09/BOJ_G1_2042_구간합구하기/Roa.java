package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* ================================================================
 *
 * Problem  : BOJ 2042 - 구간 합 구하기
 * Author   : 김로아
 * Date     : 2025-06-12
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - 수의 변경과 구간 합 계산이 반복적으로 주어지는 문제
 * - 단순 반복문 O(N) 접근은 시간 초과 발생
 * - 세그먼트 트리 사용 시 갱신/질의 모두 O(log N) 가능
 *
 * # 입력
 * - 첫 줄: N(수 개수), M(업데이트 횟수), K(구간합 질의 횟수)
 * - 다음 N줄: 수열 A₁, A₂, ..., Aₙ
 * - 이후 M+K줄: 아래 두 종류의 쿼리
 *   1. 1 a b → a번째 수를 b로 바꿈 (update)
 *   2. 2 a b → a~b 구간의 합 출력 (query)
 *
 * # 출력
 * - 각 구간합 질의에 대해 한 줄씩 출력
 *
 * 💻 알고리즘 설계
 * - 세그먼트 트리 생성 (크기: 4 * N)
 * - 재귀 기반의 세그먼트 트리 구현
 *
 * ⏰ 시간복잡도
 * - 초기 트리 구성: O(N)
 * - 각 쿼리/업데이트: O(log N)
 * - 총 시간: O((M + K) × log N)
 *
 * ================================================================
 */

public class Roa {
    static int N, M, K;
    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수의 개수
        M = Integer.parseInt(st.nextToken()); // 업데이트 횟수
        K = Integer.parseInt(st.nextToken()); // 구간합 질의 횟수

        arr = new long[N];
        tree = new long[N * 4]; // 세그먼트 트리는 4배 크기 할당

        // 수열 입력
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // 세그먼트 트리 초기화
        init(1, 0, N - 1);

        // 쿼리 처리
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()) - 1;
            long b = Long.parseLong(st.nextToken());

            if (cmd == 1) {
                // 값 변경 (1-based -> 0-based)
                update(1, 0, N - 1, a, b);
            } else {
                // 구간 합 질의
                int bIdx = (int) b - 1;
                System.out.println(query(1, 0, N - 1, a, bIdx));
            }
        }
    }

    // 세그먼트 트리 초기화
    static long init(int node, int start, int end) {
        if (start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;
        return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
    }

    // 구간 합 쿼리
    static long query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return 0; // 완전히 벗어남
        if (left <= start && end <= right) return tree[node]; // 완전히 포함

        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right)
             + query(node * 2 + 1, mid + 1, end, left, right);
    }

    // 값 업데이트
    static void update(int node, int start, int end, int idx, long newValue) {
        if (idx < start || idx > end) return;

        if (start == end) {
            tree[node] = newValue;
