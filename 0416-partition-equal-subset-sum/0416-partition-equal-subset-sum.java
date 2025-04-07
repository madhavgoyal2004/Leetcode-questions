class Solution {
    Boolean [][] dp;
    public boolean partition(int [] nums, int i, int sum, int total){
        if(i >= nums.length){
            return false;
        } 

        if(dp[i][sum] != null) return dp[i][sum];

        if(total - sum == sum){
            return dp[i][sum] = true;
        }

        return dp[i][sum] = partition(nums, i+1, sum + nums[i], total) || partition(nums, i+1, sum, total);

    }
    public boolean canPartition(int[] nums) {
        int n = nums.length; 
        int total = 0;
        for(int i=0; i<n; i++){
            total += nums[i];
        }
        dp = new Boolean [n+1][total+1];
        return partition(nums, 0, 0, total);
    }
}