class Solution {
    String w1,w2;
    int[][] dp;
    int solve(int i1, int i2) {
        int max = 510;
        String s = w1;
        if (i1 == -1 && i2 == -1) return 0;
        if (i1 == -1) return i2+1;
        if (i2 == -1) return i1+1;
        if(dp[i1][i2]>-1) return dp[i1][i2];
        if (w1.charAt(i1) == w2.charAt(i2)) {
            return solve(i1-1,i2-1);
        }
        
        // insert
        max = 1+solve(i1,i2-1);

        // replace
        max = Math.min(max, (1+solve(i1-1,i2-1)));

        // delete
        max = Math.min(max, (1+solve(i1-1,i2)));
        
        return dp[i1][i2]=max;
    }

    public int minDistance(String word1, String word2) {
        w1 = word1;
        w2 = word2;
        dp = new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(w1.length()-1, w2.length()-1);
    }
}
