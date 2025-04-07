class Solution {
    Boolean [][] dp;
    public boolean partition(int [] nums, int i, int sum, int total){
        if(i >= nums.length){
            if(total - sum == sum){
                return true;
            }
            return false;
        } 

        if(dp[i][sum] != null) return dp[i][sum];

        return dp[i][sum] = partition(nums, i+1, sum + nums[i], total) || partition(nums, i+1, sum, total);

    }
    public boolean canPartition(int[] nums) {
        int n = nums.length; 
        int total = 0;
        for(int i : nums){
            total += i;
        }
        dp = new Boolean [n+1][total+1];
        return partition(nums, 0, 0, total);
    }
}