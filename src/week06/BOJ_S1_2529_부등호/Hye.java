package week06.BOJ_S1_2529_부등호;

/* ================================================================
 *
 * Problem  : 부등호_S1
 * Author   : 김혜지
 * Date     : 2025년 05월 20일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - 부등호 기호 '<'와 '>'가 k개 나열된 순서열 A
 * - 부등호 기호 앞 뒤에 서로 다른 한 자릿수 숫자(0~9)를 넣어 모든 부등호 관계 만족시키기
 * - 부등호 기호를 제거한 뒤, 숫자를 모두 붙인 수를 주어진 부동호 관계를 만족시키는 정수라고 함 ( 하나 이상 존재 )
 * -> k개의 부등호 순서를 만족하는 (k+1)자리의 정수 중에서 최댓값과 최솟값 찾기
 *
 * # 입력
 * - 1행 : 부등호 문자의 개수를 나타내는 정수 k
 * - 2행 : k개의 부등호 기호가 하나의 공백을 두고 한 줄에 모두 제시 ( 2 <= k <= 9 )
 *
 * # 출력
 * - 부등호 관계를 만족하는 k+1 자리의 최대, 최소 정수 ( 첫 자리가 0인 경우도 정수에 포함 )
 *
 * 💻 알고리즘 설계
 * 1. 정수 k 입력
 * 2. k개의 부등호 기호를 하나의 공백을 두고 한 줄로 입력
 * 3. DFS - 백트래킹을 사용하여 조건에 맞는 조합 탐색
 * 4. 조건에 맞는 (k+1)개의 숫자를 완성한 경우
 *    -> 해당 숫자가 기존 min 보다 작으면 min 업데이트
 *    -> 해당 숫자가 기존 max 보다 크면 max 업데이트
 * 5. max 값과 min 값 출력
 *
 * ⏰ 시간복잡도
 * -
 * ================================================================
 */

import java.util.*;
import java.io.*;

public class Hye {
    static String min,  max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        char[] A = new char[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            A[i] = st.nextToken().charAt(0);
        }

        min = null;
        max = null;

        boolean[] visited = new boolean[10]; // 0 ~ 9
        int[] result = new int[k+1];

        dfs(0,k,A,visited,result);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth, int k, char[] A, boolean[] visited, int[] result){

        if(depth == k + 1){
            StringBuilder sb = new StringBuilder();
            for(int n : result){
                sb.append(n);
            }
            String num = sb.toString();

            if(min == null || num.compareTo(min) < 0) min = num;
            if(max == null || num.compareTo(max) > 0) max = num;

            return;

        }
        for(int i=0; i <= 9; i++){
            if(!visited[i]){
                if(depth ==0 || (A[depth-1] == '<' && result[depth -1] < i) || (A[depth-1] == '>' && result[depth-1] > i)){
                    visited[i] = true;
                    result[depth] = i;
                    dfs(depth+1, k, A, visited, result);
                    visited[i] = false;
                }
            }
        }
    }
}
