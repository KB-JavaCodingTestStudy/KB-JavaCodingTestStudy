
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
