#1 -

class Solution {

    HashSet<String> list;
    ArrayList<List<Integer>> ans;

    void solve(int index, int[] nums, List<Integer> l1) {
        if (index >= nums.length) {

            String z = l1.toString();
            if (list.contains(z))
                return;
            list.add(z);
            ans.add(new ArrayList<>(l1));
            return;
        }

        l1.add(nums[index]);
        solve(index + 1, nums, l1);
        l1.remove(l1.size() - 1);
        solve(index + 1, nums, l1);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        list = new HashSet<>();
        ans = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        solve(0, nums, l1);
        return ans;
    }
}

TC: O(2^N) * O(N) + O(NLog(N)) => Recussion Call + .toString() method

  
