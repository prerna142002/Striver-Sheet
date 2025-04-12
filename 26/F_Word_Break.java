class Solution {
    static HashSet<String> set;
    static int visited[];
    static boolean solve(int index, String str){
        if(index == str.length()) return true;
        if(visited[index] > 0) return visited[index] == 2 ? false:true;
        boolean ans = false;
        for(int i=index+1;i<str.length()+1;i++){
            String s = str.substring(index,i);
            if(set.contains(s)) ans = (ans || solve(i,str));
        }
        visited[index] = ans ? 1:2;
        return ans;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        for(String st: wordDict){
            set.add(st);
        }
        visited = new int[s.length()+1];
        return solve(0,s);
    }
}
