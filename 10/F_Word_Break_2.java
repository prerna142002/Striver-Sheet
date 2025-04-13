class Solution {

    HashSet<String> set;
    List<String> list;
    String[] dp;
    void solve(int index, String str,  String s){
        
        if(index >= s.length()){
            list.add(str);
            return;
        } 
        
        for(int i = index;i<s.length();i++){
            String ans = s.substring(index,i+1);
            // System.out.println(ans);
            String z = str+ans;
            if(i < s.length()-1) z += " ";
            if(set.contains(ans)) solve(i+1,z, s);
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        list = new ArrayList<>();
        dp = new String[s.length()];
        for(String str: wordDict){
            set.add(str);
        }
        // System.out.println(dp[0]);
        solve(0,"",s);
        return list;
    }
}
