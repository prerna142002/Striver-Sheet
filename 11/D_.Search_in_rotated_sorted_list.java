class Solution {


    int solve(int start, int end, int target, int[] nums){
       
        if(start>end) return -1;
        int mid = start+((end-start)/2);
        // System.out.println(start+" - "+end+" "+mid+" -- "+end);
        if(nums[mid] == target) return mid;

        if(nums[start] <= nums[mid]){
            if(nums[start]<=target && target<nums[mid]) return solve(start,mid-1,target,nums);
            else return solve(mid+1,end,target,nums);
        } else{
            if(nums[end] >= target && nums[mid] < target ) return solve(mid+1,end,target,nums);
            else return solve(start,mid-1,target,nums);
        }

    }

    public int search(int[] nums, int target) {
        return solve(0,nums.length-1,target,nums);
        
    }
}
