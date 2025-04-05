class Solution {

    int solve(int start, int end, int[] nums){
        System.out.println(start+" -- "+end);
        if(start>end) return -1;
        int mid = start+((end-start)/2);
        if((mid&1) == 1){
            if(mid>0 && nums[mid] == nums[mid-1]) return solve(mid+1,end,nums);
            else if(mid+1 < nums.length && nums[mid] == nums[mid+1]) return solve(start,mid-1,nums); 
            else return nums[mid]; 
        } else{
            if(mid+1 < nums.length && nums[mid] == nums[mid+1]) return solve(mid+1,end,nums);
            else if(mid>0 && nums[mid] == nums[mid-1]) return solve(start,mid-1,nums); 
            else return nums[mid]; 
        }
    }

    public int singleNonDuplicate(int[] nums) {
        return solve(0,nums.length-1,nums);
    }
}
