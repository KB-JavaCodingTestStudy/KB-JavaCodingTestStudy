package week06.BOJ_G3_2623_음악프로그램;

import java.io.*;
import java.util.*;

/* ================================================================
 *
 * Author : 남민주
 * Link : https://www.acmicpc.net/problem/2623
 * ================================================================
 * 📌 문제 분석 요약
 *
 * # 입력
 * -  가수의 수, 보조 PD의 수
 *  - 보조 PD 담당 가수의 수, 가수 순서
 *
 * # 출력
 * - 출연 순서(보조 PD의 순서를 만족하는)
 *      - 여러 순서가 가능하다면 아무거나 하나 출력
 *      - 만약 불가능한 경우라면 0을 출력
 *
 * 💻 알고리즘 설계
 * - 가수의 수와 보조 PD의 수를 입력받음
 * -  보조 PD의 수만큼 입력받음
 *      - 맨 처음 가수가 아닌 다음 가수부터는 +1
 *      - 이전 가수에 다음 가수를 목록에 추가
 * - 가수의 수만큼 가수 목록을 확인하여 0인 경우
 *  - 해당 가수를  결과에 추가
 *  - 해당 가수의 값을 -1(이후 검색되지 않도록 하기 위해서)
 *  - 해당 가수 다음 가수 목록에 지정되어 있는 모든 가수 값을 -1
 *  - 다시 검사를 반복
 * - 가수의 수보다 결과의 길이가 짧으면 순서를 지정하지 못하므로 0
 *  - 길이가 짧지 않다면 순서를 지정할 수 있는 경우이므로 출력
 *
 *  - 시간복잡도
 *      - O(n^2)
 * ================================================================
 */

public class MJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> answer = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] singers = new int[num[0] + 1];

        for (int i = 0; i < num[1]; i++) {
            int[] order = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 2; j < order.length; j++) {
                singers[order[j]]++;
                List<Integer> list = map.getOrDefault(order[j-1], new ArrayList<>());
                list.add(order[j]);
                map.put(order[j-1], list);
            }
        }

        for(int i = 1; i <= singers.length; i++) {
            for(int j = 1; j < singers.length; j++) {
                if(singers[j] == 0){
                    answer.add(j);
                    singers[j]--;
                    for(int n : map.getOrDefault(j, new ArrayList<>())) {
                            singers[n]--;
                    }
                    break;
                }
            }
        }

        if(answer.size() < num[0]){
            bw.write("0");
        }
        else {
            for(int i = 0; i < answer.size(); i++) {
                bw.write(answer.get(i)+"\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
