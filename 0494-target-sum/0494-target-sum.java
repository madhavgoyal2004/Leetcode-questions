class Solution {
    public void solve(int [] nums, int target, int sum,  int[] count, int idx){
        if(target == sum && idx >= nums.length){
            count[0] ++ ;
            return ;
        }
        if(idx >= nums.length){
            return;
        }

        solve(nums, target, sum + nums[idx], count, idx + 1);
        solve(nums, target, sum - nums[idx], count, idx + 1 );

    }
    public int findTargetSumWays(int[] nums, int target) {
        int [] count = new int[1];
        solve(nums, target, 0, count, 0);
        return count[0];
    }
}