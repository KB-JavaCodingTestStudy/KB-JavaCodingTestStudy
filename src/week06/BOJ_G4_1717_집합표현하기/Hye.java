package week06.BOJ_G4_1717_집합표현하기;

/* ================================================================
 *
 * Problem  : 집합의 표현_G5
 * Author   : 김혜지
 * Date     : 2025년 05월 20일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - n+1개의 집합 ({0} ~ {n} )
 * - 해당 집합에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지 확인하는 연산 수행
 * - 집합을 표현하는 프로그램 작성
 *
 * # 입력
 * - 1행 : n, m | m : 입력으로 주어지는 연산의 개수
 * - m행 : 연산
 *         -> 합집합 : 0 a b - a가 포함되어 있는 집합과 b가 포함되어 있는 집합을 합함
 *         -> 포함 여부 : 1 a b - a와 b가 같은 집합에 포함되어 있는지
 *
 * # 출력
 * - 1로 시작하는 입력에 대해 a와 b가 같은 집합에 포함되어 있느면 YES, 그렇지 않다면 NO를 출력
 *
 * 💻 알고리즘 설계
 * 1. n과 m 입력 받기
 * 2. 연산 ( f, a, b ) 입력 받기
 * 3. 만약 f가 0이면 합집합(union), 1이면 포함 여부(find) 출력하기
 *    -> union : 만약 a와 b의 루트노드가 다르다면 b의 루트노드를 a의 루트 노드로 설정
 *    -> find : 만약 인덱스와 배열 root의 해당 인덱스의 값이 다르다면 해당 인덱스의 노드는 루트가 아님을 의미
 *              재귀적으로 find를 호출하여 최상위 루트 노드를 반환
 *    -> 만약 a와 b의 루트 노드가 같다면 "YES" 출력, 다르다면 "NO" 출력
 *
 * ⏰ 시간복잡도
 * - O(m * ɑ(n))
 * -> m : 연산의 개수
 * -> n + 1 : 집합의 개수
 * -> ɑ(n) : find()는 일반적으로 O(log n) -> 경로 압축 : O(ɑ(n))
 *
 * ++ 추가 ++
 * - rank : 병합 시 트리의 균형을 맞추기 위한 기준 ( 트리의 최대 높이 상한 )
 *
 * ================================================================
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hye {
    static int[] root ;
    static int[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        root = new int[n+1];
        rank = new int[n+1];
        for(int i=0; i<=n; i++){
            root[i] = i;
            rank[i] = i;
        }

        for(int i =0; i <m; i++){
            st = new StringTokenizer(br.readLine());

            int f = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(f == 0){
                union(a,b);
            }else{
                if(find(a) == find(b)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }


    }

    static int find(int x){
        if(root[x] != x){
            root[x] = find(root[x]);
        }
        return root[x];
    }

    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if( rootA == rootB) return;

        if(rank[rootA] < rank[rootB]){
            root[rootA] = rootB;
        }else if(rank[rootA] > rank[rootB]){
            root[rootB] = rootA;
        }else{
            root[rootB] = rootA;
            rank[rootA]++;
        }
    }
}
