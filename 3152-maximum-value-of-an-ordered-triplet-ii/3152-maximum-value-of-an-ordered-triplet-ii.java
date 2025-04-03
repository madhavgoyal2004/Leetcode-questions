class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int [] right = new int[n];
        right[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            right[i] = Math.max(right[i+1], nums[i+1]);
        }
        long sum = 0;
        long maxdiff = 0;
        for(int i=1; i<n-1; i++){
            sum += (nums[i-1] - nums[i]);
            if(maxdiff < sum*right[i]){
                maxdiff = sum*right[i];
            }
            if(sum < 0) sum = 0;
        }
        return maxdiff;
    }
}