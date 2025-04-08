class Solution {
    int[][] dp;
    int solve(int index, int prevIndex, int[] arr){
        if(index == arr.length) return 0;
        int max = Integer.MIN_VALUE;
        if(dp[index][prevIndex+1] > -1) return dp[index][prevIndex+1];
        if(prevIndex == -1 || arr[prevIndex] < arr[index]){
            max = Math.max(max, (arr[index]+solve(index+1,index,arr) ) );
        }
        max = Math.max(max, solve(index+1,prevIndex,arr));
        return dp[index][prevIndex+1] = max;
    }
    
    public int maxSumIS(int arr[]) {
        dp = new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,-1,arr);
    }
}
