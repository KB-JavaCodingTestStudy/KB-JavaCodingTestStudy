import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int total = 0;
        int[] visited = new int[amount+1];
        Queue<Integer> q = new ArrayDeque<>();
  
        q.add(0);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int now = q.remove();
                if(now == amount) {
                    return total;
                }

                for(int ii=0; ii<coins.length; ii++) {
                    int newone = now + coins[ii];
                    if(newone>=1 && newone<=amount) {
                        if(visited[newone]==0) {
                        q.add(newone);
                        visited[newone] = 1;
                        }
                    }
                }
            }
            total++;
        }
        
        return -1;
    }
}
