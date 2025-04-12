class Solution {

    int[][] dp;
    boolean solve(int index, int[] nums, int sum, int total){
        if(total-sum == sum) return true;
        if(index >= nums.length || (total-sum < sum) ) return false;
        if(dp[index][sum] > 0) return dp[index][sum] == 1 ? false: true;
        boolean ans = solve(index+1,nums,sum+nums[index],total) || solve(index+1,nums,sum,total);;
        dp[index][sum] = ans ? 2:1;
        return ans;
    }

    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int n: nums) total+=n;
        
        dp = new int[nums.length][(total/2)+1];
        return solve(0,nums,0,total);
    }
}
