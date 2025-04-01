class Solution {
    
    int pow(int power, int base, int target){
        int ans = 1; 
        for(int i=0;i<power;i++){
            ans *= base;
            if(target<ans) return 2;
        }
        if(target == ans) return 0;
        return 1;
    }
    
    int binary(int start, int end, int target, int power){
        if(start>end) return -1;
        int mid = start+((end-start)/2);
        int val = pow(power,mid,target);
        // System.out.print(mid+" -- "+val+" ");
        if(val == 0) return mid;
        if(val == 2) return binary(start,mid-1,target,power);
        else return binary(mid+1,end,target,power);
    }
    public int nthRoot(int n, int m) {
        return binary(0,m,m,n);
        // code here
    }
}

TC: O(N*log(N))
