package week06.BOJ_G4_1717_집합_표현하기;

import java.io.*;
import java.util.Arrays;

/* ================================================================
 *
 * Author : 남민주
 * Link : https://www.acmicpc.net/problem/1717
 * ================================================================
 * 📌 문제 분석 요약
 *
 * # 입력
 * -  초기 집합 수(0~n)
 *  - 연산의 개수
 *  - 연산
 *      - 합 집합: 0 a b
 *      - 같은 집합 여부: 1 a b
 *
 * # 출력
 * - 같은 잡합 여부 연산의 결과
 *      - 같은 집합: YES
 *      - 다른 집합: NO
 *
 * 💻 알고리즘 설계
 * - union 함수
 *      - 루트를 찾아 루트를 대표값을 하나로 통일하여 합치기
 * - findRoot 함수
 *      - 해당 인덱스와 대표값이 같을 때까지 재귀하여 같은 값을 대표값으로 하여 모든 재귀된 인덱스를 해당 값으로 업데이트
 *          - 경로 압축
 *  -  isSameSet 함수
 *      - findRoot한 두 값을 비교하여 대표값이 같은 지 여부 반환
 *  - 0인 경우 union을 이용하여 두 집합을 합치기
 *  - 1인 경우 isSameSet을 이용하여 같은 집합(대표값)인지 여부 출력
 * ================================================================
 */
public class MJ {
    public static int[] nums;

    public static void union(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);
        if (rootA != rootB) {
            nums[rootB] = rootA;
        }
    }
    public static int findRoot(int a) {
        if (nums[a] != a) {
            nums[a] = findRoot(nums[a]); // 경로 압축
        }
        return nums[a];
    }

    public static boolean isSameSet(int a, int b) {
        return findRoot(a) == findRoot(b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        nums = new int[input[0]+1];

        for(int i = 0; i <= input[0]; i++) {
            nums[i] =i;
        }

        for(int i = 0; i < input[1]; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(tmp[0]==0){
                   union(tmp[1], tmp[2]);
            } else if(tmp[0]==1){
                if(isSameSet(tmp[1], tmp[2])){
                    bw.write("YES\n");
                }else{
                    bw.write("NO\n");
                }
            }
        }
        bw.flush();
        bw.close();

    }
}