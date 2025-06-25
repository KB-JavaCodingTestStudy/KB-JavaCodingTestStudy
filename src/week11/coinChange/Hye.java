package week11.coinChange;

/* ================================================================
 *
 * Problem  : CoinChange_
 * Date     : 2025년 06월 25일
 * 
 * ================================================================
 */

import java.util.Arrays;

public class Hye {
    class Solution {
        public int coinChange(int[] coins, int amount) {

            int[] memo = new int[amount+1];
            int max = amount + 1;

            Arrays.fill(memo, max);
            memo[0] = 0;

            for(int i = 1; i <= amount; i++){
                for(int coin : coins){
                    if(i-coin >= 0){
                        memo[i] = Math.min(memo[i], memo[i-coin] + 1);
                    }

                }
            }

            return memo[amount] == max ? -1 : memo[amount];

        }
    }
}
