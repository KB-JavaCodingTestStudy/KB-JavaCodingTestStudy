class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount ==0) return 0;
        int [] dp = new int[amount+1];        
        Arrays.fill(dp, amount+1);
        dp[0]=0;
        for(int v: coins){
            if(v <= amount) dp[v]=1;
        }
        
        for(int i=1;i<=amount;i++){
            for(int v: coins){
                if(i-v>=0){
                dp[i] = Math.min(dp[i-v]+1, dp[i]);
                }
            }
        }

        return dp[amount]>amount?-1:dp[amount];
    }
}
