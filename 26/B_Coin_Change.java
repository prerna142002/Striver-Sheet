class Solution {

    int[][] dp;
    int solve(int index, int amount, int[] coins){
        if(amount == 0) return 0;
        if(index >= coins.length || amount < 0) return (int) Math.pow(10,9);
        if(dp[index][amount] < Integer.MAX_VALUE) return dp[index][amount];
        int min = Integer.MAX_VALUE;
        if(amount >= coins[index]) min = Math.min(min, 1+solve(index+1,amount-coins[index],coins));
        if(amount >= coins[index]) min = Math.min(min, 1+solve(index,amount-coins[index],coins));
        min = Math.min(min, solve(index+1,amount,coins) );
        return dp[index][amount] = min;
    }
    
    public int coinChange(int[] coins, int amount) {
        
        dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        int ans = solve(0,amount,coins);
        return ans >= 100000000 ? -1:ans;
    }
}
