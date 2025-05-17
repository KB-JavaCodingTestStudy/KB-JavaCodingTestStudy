package week06.BOJ_S1_2529_부등호;

import java.io.*;

/* ================================================================
 *
 * Author : 남민주
 * Link : https://www.acmicpc.net/problem/2529
 * ================================================================
 * 📌 문제 분석 요약
 *
 * # 입력
 * -  부등호 개수
 * - 부등호 기호
 *
 * # 출력
 * - 이를 만족하는 가장 큰 수
 * - 이를 만족하는 가장 작은 수 (0이 맨 앞 가능)
 *
 * 💻 알고리즘 설계
 * -  최소를 구하기 위해 비교 위치 중 큰 위치에 +1을 수행
 *  -  0 부터 n개를 앞에서 부터 0인 위치에 넣기
 *      - 해당 위치- 1 (이후 다시 업데이트하는 것을 막기 위해)
 *      - 넣을 때 해당 위치의 앞, 뒤가 1이상이라면 -1
 *      - 이를 다음 수에 대해 반복
 *  -  최대를 구하기 위해 비교 위치 중 작은 위치에 +1을 수행
 *  -  9 부터 n개의 수를 앞에서 부터 0인 위치에 넣기(9에서 작은 수로 n개)
 *      - 해당 위치- 1 (이후 다시 업데이트하는 것을 막기 위해)
 *      - 넣을 때 해당 위치의 앞, 뒤가 1이상이라면 -1
 *      - 이를 다음 수에 대해 반복
 *  - 해당 두 문자 배열을 앞에서부터 출력(결과 출력)
 *
 *  - 시간복잡도
 *      - O(n^2)
 * ================================================================
 */
public class MJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num =Integer.parseInt(br.readLine());
        String[] array = br.readLine().split(" ");
        int[] degree = new int[num+1];
        int[] degree2 = new int[num+1];

        int[] min = new int[num+1];
        int[] max = new int[num+1];

        for(int i=0; i<array.length; i++){
            if(array[i].equals("<")){
                degree[i+1]++;
                degree2[i]++;
            }else if(array[i].equals(">")){
                degree[i]++;
                degree2[i+1]++;
            }
        }

        for(int i=9; i>=9-num; i--){
            for(int j=0; j<=num; j++){
               if( degree2[j]==0){
                   max[j] = i;
                   if(j>0 && degree2[j-1]>0){
                       degree2[j-1]--;
                   }
                   degree2[j]--;
                   if(j<num&&degree2[j+1]>0) {
                       degree2[j + 1]--;
                   }
                   break;
               }
            }
        }

        for(int i=0; i<=num; i++){
            for(int j=0; j<=num; j++){
                if( degree[j]==0){
                    min[j] = i;
                    if(j>0 && degree[j-1]>0){
                        degree[j-1]--;
                    }
                    degree[j]--;
                    if(j<num&&degree[j+1]>0) {
                        degree[j + 1]--;
                    }
                    break;
                }
            }
        }

        for(int i=0;i<=num;i++){
            bw.write(String.valueOf(max[i]) );
        }bw.write("\n");
        for(int i=0;i<=num;i++){
            bw.write(String.valueOf(min[i]));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
