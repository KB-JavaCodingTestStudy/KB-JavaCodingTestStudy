import java.util.*;
import java.io.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount + 1];

        for(int n = 1; n <= amount; n++) {

            int tmp = amount;

            for(int coin : coins) {
                if (n - coin >= 0) {
                    tmp = Math.min(tmp, dp[n - coin]);
                }
            }

            dp[n] = tmp + 1;
        }


        if (dp[amount] == amount + 1)
            return -1;

        return dp[amount];
    }
}
