class Solution {

    // List<<List<Integer>> ans;
    HashSet<List<Integer>> set;
    void solve(int index, int[] nums, int target, int sum, List<Integer> l1){
        if(index >= nums.length || target<=sum) {
            // System.out.println(l1);
            if(sum == target){
                set.add(new ArrayList<>(l1));
            }
            return;
        }

        l1.add(nums[index]);
        solve(index,nums,target,(sum+nums[index]),l1);
        // solve(index+1,nums,target,(sum+nums[index]),l1);
        l1.remove(l1.size()-1);
        solve(index+1,nums,target,sum,l1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        set = new HashSet<>();
        // set = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        solve(0, candidates, target, 0, l1);
        return new ArrayList<>(set);
    }
}

TC: 2^target * k
SC: k*x  
