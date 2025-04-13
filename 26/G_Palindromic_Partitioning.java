class Solution {
    
    static int[] dp;
    static boolean palindrome(int start, int end, String s){
        
        int s1 = start, e = end;
        while(s1<e){
            if(s.charAt(s1)!=s.charAt(e)) return false;
            s1++;
            e--;
        }
        return true;
    }
    
    
    static int solve(int start, String s){
        // System.out.println(start);
        if(start >= s.length() || palindrome(start,s.length()-1,s)) return 0;
        if(dp[start] > 0) return dp[start];
        int max = Integer.MAX_VALUE;
        for(int i=s.length()-1;i>=start;i--){
            String ans = s.substring(start,i+1);
            // System.out.println(start+" "+ans);
            if(palindrome(0,ans.length()-1,ans)) max = Math.min(max,1+solve(i+1,s));
        }
        return dp[start] = max;
        
    }
    
    static int palPartition(String s) {
        // code here
        dp = new int[s.length()];
        return solve(0,s);
        
    }
}
