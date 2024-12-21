class Solution {
    public int change(int amount, int[] coins) {
        int [] dp = new int[amount + 1];

        int n = coins.length; 
        dp[0] = 1;
        for(int i : coins){
            for(int j=1; j<=amount; j++){
                if(j-i >= 0)
                dp[j] += dp[j-i];
            }
        }

        return dp[amount];
    }
}