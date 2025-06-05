package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
떤 학생 A가 B보다 키가 작고, B가 C보다 작다면 A < C라는 관계도 성립
전체 학생 수 N명 중, 자신의 키 순서를 정확히 알 수 있는 학생의 수를 구하기

- 입력으로 학생들의 키 비교 결과를 받아 인접 행렬 arr에 저장
- 플로이드-워셜 알고리즘을 통해 간접적인 키 비교 관계도 전이 (i < k and k < j ⇒ i < j).
- 각 학생에 대해 자신보다 키가 큰 학생 수와 작은 학생 수를 합산하여 총 n-1이면 순위를 확정
- 이러한 학생의 수를 total에 누적하여 출력

 시간복잡도
입력 처리: O(M)
플로이드-워셜: O(N³)
순위 판단 반복: O(N²)
총 시간복잡도: O(N³)
→ N ≤ 500 이므로 약 1억 2천만 번 연산으로, Java 기준 시간 제한 2초 내 통과 가능
 */

public class N_2458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int m  = Integer.parseInt(st.nextToken());
        int [][] arr = new int[n+1][n+1];
        while (m -- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b]=1;
        }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(arr[i][j]==1 || arr[i][k]+arr[k][j]==2){
                        arr[i][j]=1;
                    }
                }
            }
        }
        int total =0;
        for(int i=1; i<=n; i++){
            int count =0;
            for(int j=1; j<=n; j++){
                if(arr[i][j]==1){count++; }
                if(arr[j][i]==1){ count++; }
            }
            if(count == n-1){
                total++;
            }
        }
        System.out.println(total);
    }
}
