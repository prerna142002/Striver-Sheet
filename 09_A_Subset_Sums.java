class Solution {
    
    ArrayList<Integer> list;
    // int[][] dp;
    void solve(int index, int sum,  int[] arr){
        if(index >= arr.length){
            list.add(sum);
            return;
        }
        
        solve(index+1,sum, arr);
        solve(index+1, arr[index]+sum ,arr);
    }
    
    public ArrayList<Integer> subsetSums(int[] arr) {
        list = new ArrayList<>();
        // dp = new int[arr.length][1000000009];
        solve(0, 0, arr);
        return list;
        // code here
    }
}

TC: O(2^N)
