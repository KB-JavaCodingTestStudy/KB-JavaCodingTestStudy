package week05.BOJ_S1_1697_숨바꼭질;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/* ================================================================
 *
 * Author   : 남민주
 * 
 * ================================================================
 * 📌 문제 분석 요약
 *
 * # 입력
 * - 수빈이 위치
 * - 동생 위치
 *
 * # 출력
 * - 동생을 찾는 최소 시간
 *
 * # 참고사항
 *  - 좌우 이동 & *2 이동 가능
 *
 * 💻 알고리즘 설계
 * -  수빈이의 위치 및 0(이동한 시간)을 queue 에 넣기
 *  - queue 에 값이 있으면 계속 아래 반복(찾을 때까지)
 *      1. 동생의 위치와 같으면
 *              - 이동 시간 출력
 *              - break;
 *      2. 이동 가능한 모든 경우의 수에 대해 다음 적용
 *          - 이동가능한 위치인지, 방문한 적이 없는지 확인
 *          - 확인 결과 모두 true 이면
 *              - 방문 결과 true 로 업데이트
 *              - queue 에 현재 위치 및 이동시간(이전값+1) 넣기
 *
 * ================================================================
 */

public class MJ {
    public static final int MAX = 200000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX];
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        queue.add(new int[]{input[0], 0});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int[] next = new int[]{current[0]+1, current[0]-1, current[0]*2 };
            if(current[0]==input[1]){
                bw.write(current[1]+" ");
                break;
            }

            for(int n : next){
                if(
                        n >= 0
                      && n < MAX
                     &&  !visited[n]
                ){
                    visited[n] = true;
                    queue.add(new int[]{n, current[1]+1});
                }
            }

        }

        bw.flush();
        bw.close();
    }
}
