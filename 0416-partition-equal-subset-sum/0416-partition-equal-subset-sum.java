class Solution {
    Boolean [][] dp;
    public boolean partition(int [] nums, int i, int sum, int total, boolean [] ans){
        if(i >= nums.length) return false;

        if(dp[i][sum] != null) return dp[i][sum];
        if(total - sum == sum){
            ans[0] = true;
            return dp[i][sum] = true; 
        }
        return dp[i][sum] = partition(nums, i+1, sum + nums[i], total, ans) || partition(nums, i+1, sum, total, ans);

    }
    public boolean canPartition(int[] nums) {
        int n = nums.length; 
        int total = 0;
        for(int i=0; i<n; i++){
            total += nums[i];
        }
        dp = new Boolean [n+1][total+1];
        boolean [] ans = new boolean[1];
        partition(nums, 0, 0, total, ans);
        return ans[0];
    }
}