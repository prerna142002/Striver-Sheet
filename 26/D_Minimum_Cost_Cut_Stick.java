class Solution {

    int[][] dp;
    int[] logs;
    int solve(int start, int end){
        if(start+1==end) return 0;
        
        if(dp[start][end] > -1) return dp[start][end];
        int minAns = Integer.MAX_VALUE;
        for(int i=start+1;i<end;i++){
            int ans = logs[end]-logs[start] + solve(start, i) + solve(i,end);
            
            minAns = Math.min(minAns,ans);
        }
        
        return dp[start][end] = minAns;
    }


    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        logs = new int[cuts.length+2];
        logs[0] = 0;
        logs[logs.length-1] = n;
        for(int i=0;i<cuts.length;i++){
            logs[i+1] = cuts[i];
        }
        dp = new int[cuts.length+2][cuts.length+2];
        for(int i=0;i<cuts.length+2;i++){
            Arrays.fill(dp[i],-1);
        }
        // 
        return solve(0,logs.length-1);
    }
}

