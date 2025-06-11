package week09.BOJ_G1_2042_구간합구하기;

/* ================================================================
 *
 * Problem  : 구간 합 구하기_G1
 * Author   : 김혜지
 * Date     : 2025년 06월 11일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - N개의 수가 주어진다. 그런데 중간에 수의 변경이 빈번히 일어나고
 *   그 중간에 어떤 부분의 합을 구하려 한다.
 *
 * # 입력
 * - 1행 : 수의 개수 N과 M, K ( M : 수의 변경이 일어나는 횟수, K : 구간의 합을 구하는 횟수 )
 * - N행 : N개의 수
 * - ~행 : 세 개의 정수 a b c
 *         + a가 1인 경우 b번째 수를 c로 변경
 *         + a가 2인 경우 b번째 수부터 c번째 수까지의 합을 구하여 출력
 *
 * # 출력
 * - 구간의 합 출력
 *
 * ⏰ 시간복잡도
 * - O(N+(M+K)⋅logN)
 * ================================================================
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hye {
    static long[] arr, tree;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        // 세그먼트 트리 초기화
        tree = new long[N * 4];
        init(1,1,N);

        for(int i = 0; i < M + K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a==1){
                // b번째 수를 c로 바꿈
                long diff = c - arr[b];
                arr[b] = c;
                update(1,1,N,b,diff);
            }else if(a==2){
                System.out.println(sum(1,1,N,b,(int)c));
            }
        }
    }

    static long init(int node, int start, int end){
        if(start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid+1, end);
    }

    static void update(int node, int start, int end, int idx, long diff){
        if(idx < start || idx > end) return;
        tree[node] += diff;
        if(start==end) return;
        int mid = (start+end) /2;
        update(node * 2, start, mid, idx, diff);
        update(node * 2 + 1, mid + 1, end, idx, diff);
    }

    static long sum(int node, int start, int end, int left, int right){
        if(right < start || end < left) return 0;
        if(left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid +1, end, left, right );
    }

}
