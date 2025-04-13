class Solution {

    List<List<Integer>> list;
    void solve(int index, int[] nums, HashSet<Integer> set, ArrayList<Integer> l1){
        if(l1.size() == nums.length){
            list.add(new ArrayList<>(l1));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(l1.size() > nums.length) break;
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            l1.add(nums[i]);
            solve(0,nums,set,l1);
            set.remove(nums[i]);
            l1.remove(l1.size()-1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        // HashSet<Integer> set = new HashSet<>();
        solve(0,nums,new HashSet<>(), new ArrayList<>() );
        return list;
    }
}


TC: O(N^N) 
SC: O(N)

class Solution {

    List<List<Integer>> list;

    void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    void solve(int index, int[] nums) {
        if (index == nums.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            solve(index + 1, nums);
            swap(i, index, nums);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        solve(0,nums );
        return list;
    }
}

TC: O(N! X N)
