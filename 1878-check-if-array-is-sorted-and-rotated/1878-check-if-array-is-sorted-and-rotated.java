class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int c = 0;
        int i;
        for(i=1; i<n; i++){
            if(nums[i-1] > nums[i]){
                c++;
            }
        }
        if(nums[(i-1) % n] > nums[i % n])c++;
        return c < 2;
    }
}