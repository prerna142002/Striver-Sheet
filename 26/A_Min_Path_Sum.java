class Solution {

    int[][] dp;
    int solve(int i, int j, int[][] grid){
        if(i == grid.length-1 && j == grid[0].length-1) return grid[i][j];
        if(i>=grid.length || j>=grid[0].length) return (int) Math.pow(10,9);
        if(dp[i][j] > -1) return dp[i][j];
        return dp[i][j] = ( grid[i][j] + Math.min( solve(i+1,j,grid), solve(i,j+1,grid))  );
    }

    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,grid);
        
    }
}
