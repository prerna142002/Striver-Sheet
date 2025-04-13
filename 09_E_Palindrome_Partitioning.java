class Solution {

    List<List<String>> list;

    boolean checkPalindrome(String str){
        int i=0, j=str.length()-1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    void solve(int index, String s, List<String> l1){
        if(index >= s.length()){
            list.add(new ArrayList<>(l1));
            return;
        }
        for(int i = index;i<s.length();i++){
            String str1 = s.substring(index,i+1);
            if(!checkPalindrome(str1)) continue;
            l1.add(str1);
            solve(i+1,s,l1);
            l1.remove(l1.size()-1);
        }
    }

    public List<List<String>> partition(String s) {
        list = new ArrayList<>();
        solve(0,s,new ArrayList<>());
        return list;
    }
}

TC: O(N*2^N)
SC: O(N)
