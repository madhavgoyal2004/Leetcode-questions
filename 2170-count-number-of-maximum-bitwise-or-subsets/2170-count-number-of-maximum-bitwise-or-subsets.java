class Solution {
    public int helper(int [] nums, int idx, int calOr, int maxOr){
        if(idx >= nums.length) return calOr == maxOr ? 1 : 0;

        return helper(nums, idx+1, calOr, maxOr) + helper(nums, idx+1, calOr|nums[idx], maxOr);
    }
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int i : nums){
            maxOr |= i;
        }

        return helper(nums, 0, 0, maxOr);
    }
}