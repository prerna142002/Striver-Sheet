class Solution {

    HashSet<List<Integer>> set;
    void solve(int index, int[] nums, int target, int sum, List<Integer> l1){

        if( index>=nums.length || sum >=target){
            // System.out.println(l1);
            if(target == sum){
                set.add(new ArrayList<>(l1));
            }
            return;
        }

        l1.add(nums[index]);
        solve(index+1,nums,target,sum+nums[index],l1);
        l1.remove(l1.size()-1);
        solve(index+1,nums,target,sum,l1);

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        set = new HashSet<>();

        solve(0,candidates,target,0,new ArrayList<>());

        return new ArrayList<>(set);
    }
}

// This will throw TLE as we are running 1 branch many times and space-wise also + HashSet will take its own processing time

class Solution {

    List<List<Integer>> set;

 void solve(int ind, int[] arr, int target, List < Integer > ds) {
        if (target == 0) {
            set.add(new ArrayList < > (ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            solve(i + 1, arr, target - arr[i], ds);
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        set = new ArrayList<>();
        solve(0, candidates, target, new ArrayList<>());

        return set;
    }
}

TC: 2^n * k
SC: k*x  

