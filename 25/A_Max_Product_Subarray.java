class Solution {
    public int maxProduct(int[] nums) {
        int max = 1, min = 1, maxFinal = Integer.MIN_VALUE;
        for(int n: nums){
            if(n<=0){
                int temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(min*n,n);
            max = Math.max(max*n,n);
            maxFinal = Math.max(maxFinal,max);
        }
        return maxFinal;
    }
}
