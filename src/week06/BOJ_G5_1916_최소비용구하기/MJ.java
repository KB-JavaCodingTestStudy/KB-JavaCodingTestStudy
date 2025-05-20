package week06.BOJ_G5_1916_최소비용구하기;

import java.io.*;
import java.util.*;
/* ================================================================
 *
 * Author : 남민주
 * Link : https://www.acmicpc.net/problem/1916
 * ================================================================
 * 📌 문제 분석 요약
 *
 * # 입력
 * -  도시 개수
 *  - 버스 개수
 *  - 버스 정보
 *      - 출발 도시, 도착 도시, 비용(0~100,000)
 *
 * # 출력
 * - 출발 도시 -> 도착 도시까지의 최소 비용
 *
 * 💻 알고리즘 설계
 *  - 도시의 개수만큼 최소 배용 배열 생성 후 최대값으로 초기화
 *  - 출발지, 도착지, 가중치를 입력받아
 *       - 출발점을 key 로 하여 {도착점, 가중치}를 정수 배열로 가지는 map 생성
 *  - 출발지와 도착지를 입력
 *  - 출발지의 최소 비용을 0으로 변경
 *  - priority queue 에 {도시, 비용}의 형태로 추가 (이때 비용에 따라 정렬되도록 설정)
 *  -  이후 qp에 값이 없을 때까지 반복
 *       - 만약 현재 값보다 작은 값이 있었다면 pass
 *      -  아니라면 해당 map 의 도착지 목록에서 
 *      -  현재 비용 + 도착지 가는 비용의 값이 현재보다 작은 경우 pq에 넣기
 *  - 모두 완료한 후 도착지의 최소 비용 배열 확인
 *  - 해당 결과 출력
 * ================================================================
 */
public class MJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, List<int[]>> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] min = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            min[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<int[]> tmp = map.getOrDefault(arr[0], new ArrayList<>());
            tmp.add(new int[]{arr[1], arr[2]});
            map.put(arr[0],  tmp);
        }
        int[] startEnd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        pq.add(new int[]{startEnd[0], 0});
        min[startEnd[0]]=0;
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            if (min[cur[0]] < cur[1]) continue;//현재 비용이 이전에 왔던 경로보다 크다면 생략
            List<int[]> tmp =map.getOrDefault(cur[0], new ArrayList<>());
            for (int[] arr : tmp) {
                if (arr[1]+min[cur[0]] < min[arr[0]]) {
                    min[arr[0]]=arr[1]+min[cur[0]] ;
                    pq.add(new int[]{arr[0], min[arr[0]]});
                }
            }
        }

        bw.write(String.valueOf(min[startEnd[1]]));
        br.close();
        bw.flush();
        bw.close();
    }
}
