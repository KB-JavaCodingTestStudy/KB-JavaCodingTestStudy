
/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 입국 필요 잔고와 여행 경비를 고려하여 최대한 많은 나라를 여행할 수 있도록 합니다.
 *  - 
 *  
 * # 입력
 *  - balance: 처음 주어지는 잔액
 *  - countries: 각 나라의 입국 필요 잔고, 여행 경비가 담긴 2차원 배열
 *
 * # 반환
 *  - 여행 가능한 최대 국가 수
 *
 * 💻 알고리즘 설계
 *  - permutation 같은 느낌으로 트리를 만들 듯이 진행합니다. 현재 돈으로 갈 수 있는 나라만 추가하고, 해당 경우에서 그 나라를 visited로 처리하여 중복 방문을 방지합니다. 
 *  - 위 과정을 백트레킹으로 진행합니다.
 *
 *
 * ================================================================
 */

import java.util.*;
import java.io.*;

class Solution {

    public int n;
    
    public int solution(int balance, int[][] countries) {

        n = countries.length;
        boolean[] visited = new boolean[n];

        int maxCount = travel(balance, countries, visited);

        return maxCount - 1;
    }

    public int travel(int balance, int[][] countries, boolean[] visited) {

        int maxCount = 0;
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;  // 이미 갔던 나라는 패스

            if(balance < countries[i][1]) continue;  // 입국 필요잔고가 모자라면 패스

            visited[i] = true;
            maxCount = Math.max(maxCount, travel(balance - countries[i][0], countries, visited));
            visited[i] = false;
        }

        return maxCount + 1;
    }
}
