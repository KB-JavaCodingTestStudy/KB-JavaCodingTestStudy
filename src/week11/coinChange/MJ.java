package week11.coinChange;

import java.util.Arrays;

public class MJ {
    class Solution {
        int[] DP;
        public int coinChange(int[] coins, int amount) {
            DP = new int[amount+1];
            Arrays.sort(coins);

            Arrays.fill(DP, Integer.MAX_VALUE);
            DP[0]=0;

            for(int c:coins){
                if(c>amount){continue;}
                DP[c]=1;
            }

            for(int i=1;i<=amount;i++){
                for(int j=coins.length-1;j>=0;j--){
                    int c=coins[j];
                    if(c>i){continue;}
                    if(DP[i-c]<Integer.MAX_VALUE){
                        DP[i] = Math.min(DP[i], DP[i - c] + 1);
                    }
                }
            }

            if(DP[amount]>=Integer.MAX_VALUE){
                return -1;
            }
            return DP[amount];
        }
    }
}
