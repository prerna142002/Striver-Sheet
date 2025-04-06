class Solution {

    int[][] dp;
    int solve(int i1, int i2, String text1, String text2){
        if(i1 == text1.length() || i2 == text2.length()) return 0;
        if(dp[i1][i2] > -1) return dp[i1][i2];
        int max = 0;
        if(text1.charAt(i1) == text2.charAt(i2)){
            max = (1+solve(i1+1,i2+1,text1,text2));
        } else{
            max = Math.max( max, solve(i1,i2+1,text1,text2)  );
            max = Math.max( max, solve(i1+1,i2,text1,text2)  );
        }
        
        return dp[i1][i2] = max;
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }
        return solve(0,0,text1,text2);
    }
}
