class Solution {
    private boolean helper(int [] nums, int k, int mid){
        int steal = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] <= mid){
                steal++;
                i++;
            }
        }

        return steal >= k;
    }
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int st = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            st = Math.min(st, nums[i]);
            end = Math.max(end, nums[i]);
        }

        while(st < end){
            int mid = st + (end - st)/2;

            if(helper(nums, k, mid)){
                end = mid;
            }
            else{
                st = mid+1;
            }
        }

        return st;
    }
}