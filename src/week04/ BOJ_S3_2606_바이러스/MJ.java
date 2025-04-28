package week04.BOJ_S3_2606_바이러스;

/* ================================================================
 *
 * Author   : 남민주
 *
 * ================================================================
 * 📌 문제 분석 요약 
 *
 * # 입력
 * - 컴퓨터 수(n)
 * - 연결된 링크 수(m)
 * - 연결된 링크 정보(*m)
 *
 * # 출력
 * - 1번 컴퓨터를 통해 바이러스에 걸리는 컴퓨터 수
 *
 * 💻 알고리즘 설계
 * - 입력값 받기
 * - 연결된 컴퓨너 정보 이중 리스트에 저장
 *  (양방향이므로 양쪽으로 다 저장)
 * - deque에 1번 컴퓨터 넣기
 * - deque에서 값 하나 가져오기
 * - 해당 컴퓨터에 연결된 모든 링크 확인(아래)
 *  1. 방문한 적이 없으면 deque에 추가
 *  2. 방문 여부 업데이트(방문함으로)
 *  3. 바이러스에 감염되었으므로 answer+1
 * - answer 출력
 *
 * ================================================================
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MJ {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<List<Integer>> list = new ArrayList<>();

        int num = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[num+1];

        int answer = 0;

        for(int i=0;i<=num;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<line;i++){
            String str = br.readLine();
            String[] strs = str.split(" ");

            int x = Integer.parseInt(strs[0]);
            int y = Integer.parseInt(strs[1]);

            list.get(x).add(y);
            list.get(y).add(x);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        visited[1]=true;
        
        while(!deque.isEmpty()){
            int now = deque.poll();
            for(int i: list.get(now)){
                if(!visited[i]){
                    deque.add(i);
                    visited[i]=true;
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
