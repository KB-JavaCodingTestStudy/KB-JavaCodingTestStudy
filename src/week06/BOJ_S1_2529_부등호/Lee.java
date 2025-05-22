package study.week06.BOJ_S1_2529_부등호;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 05월 22일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - n개의 부등호가 주어진다. 부등호 사이에 0~9 사이의 숫자를 중복없이 사용하여 부등호를 만족하도록 끼워넣는다.
 *  - 이 때, 왼쪽부터 숫자를 차례로 나열하여 수를 만든다고 할 때, 부등호를 만족하는 수의 최댓값과 최솟값을 구해야 한다.
 *
 * # 입력
 *  - line 1: n (부등호 개수)
 *  - line 2: < 또는 > 가 공백 단위로 n개 주어짐
 *
 * # 출력
 *  - line 1: 만들 수 있는 최댓값
 *  - line 2: 만들 수 있는 최솟값
 *
 * 💻 알고리즘 설계
 *  1. min, max를 동시에 구하기 위해 각각을 한꺼번에 설명한다.
 *  2. 0~n 까지의 인덱스 번호를 매긴 노드 n+1개를 준비한다. (min, max 각각 하나씩)
 *  3. 부등호 방향에 따라 해당 노드의 진입 차수를 설정한다. (a < b 의 경우 min 에서는 a의 진입 차수를 1 증가, max 에서는 b의 진입 차수를 1 증가시킨다.)
 *  4. 우선순위 큐 (min, max 각각 준비)에 진입 차수가 0인 노드의 인덱스 값을 넣는다.
 *  5. 우선순위 큐에서 인덱스를 하나 꺼낸다. (현재 진입 차수가 0인 노드 중, 가장 작은 인덱스를 가져오게 된다.) 
 *  6. 해당 인덱스 자리에 0~9의 숫자를 채워넣는다. min은 0부터 점점 커지도록, max는 9부터 점점 작아지도록 채운다.
 *  7. 해당 인덱스 양옆의 진입 차수를 1씩 감소시키고, 0이 될 경우 우선순위 큐에 넣는다.
 *  8. 우선순위 큐가 빌 때 까지 5~7을 반복한다.
 *  
 * ================================================================
 */

public class Main {

    static int n;

    static boolean isValid(int x) {
        return x >= 0 && x < n+1;
    }

    public static void main(String[] args) throws IOException {

        ///  input  ///

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        int[] inDegreeMin = new int[n+1];
        int[] inDegreeMax = new int[n+1];

        String[] tokens = br.readLine().split(" ");

        for(int i = 0; i < n; i++) {
            char token = tokens[i].charAt(0);

            if (token == '<') {
                inDegreeMin[i+1]++;
                inDegreeMax[i]++;
            }
            if (token == '>') {
                inDegreeMin[i]++;
                inDegreeMax[i+1]++;
            }
        }

        ///  imple  ///

        int[] resultMin = new int[n+1];
        int[] resultMax = new int[n+1];

        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>();

        // 진입 차수가 0인 인덱스를 우선순위 큐에 넣는다.
        for(int i = 0; i < n+1; i++) {
            if (inDegreeMin[i] == 0)
                pqMin.add(i);
            if (inDegreeMax[i] == 0)
                pqMax.add(i);
        }

        int numMin = 0;
        int numMax = 9;

        for(int i = 0; i < n+1; i++) {
            // 진입 차수가 0인 인덱스 중 가장 작은 (가장 왼쪽의) 값을 가져온다.
            int idxMin = pqMin.poll();
            int idxMax = pqMax.poll();

            // min, max에 따라 적절한 수를 채워 넣는다. (min은 0부터, max는 9부터)
            resultMin[idxMin] = numMin++;
            resultMax[idxMax] = numMax--;

            // 그 양옆의 진입 차수를 1씩 감소시키고, 0이 되면 우선순위 큐에 넣는다.   
            for(int next : new int[]{-1, 1}) {
                if (isValid(idxMin + next) && --inDegreeMin[idxMin + next] == 0) {
                    pqMin.add(idxMin + next);
                }
                if (isValid(idxMax + next) && --inDegreeMax[idxMax + next] == 0) {
                    pqMax.add(idxMax + next);
                }
            }
        }

        ///  print  ///

        // int형 배열을 전부 문자열로 바꿔서 하나의 문자열로 뭉침. { 2, 7, 6, 3 } -> 2763
        String min = Arrays.stream(resultMin)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        String max = Arrays.stream(resultMax)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(max + "\n" + min);
    }


}
