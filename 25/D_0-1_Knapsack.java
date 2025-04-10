class Solution {
    
    static int[][] dp;
    static int solve(int index, int W, int[] val, int[] w){
        if(index>=val.length) return 0;
        if(dp[index][W] > -1) return dp[index][W];
        int max = Integer.MIN_VALUE;
        if( (W-w[index]) >= 0) max = val[index]+solve(index+1,W-w[index],val,w);
        max = Math.max(max, solve(index+1,W,val,w));
        return dp[index][W] = max;
    }
    
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        dp = new int[val.length][W+1];
        for(int i=0;i<val.length;i++){
            for(int j=0;j<=W;j++){
                dp[i][j] = -1;
            }
        }        
        return solve(0,W,val,wt);
        
    }
}
