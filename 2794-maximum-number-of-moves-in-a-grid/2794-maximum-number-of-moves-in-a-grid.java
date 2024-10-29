class Solution {
    int [] r = {-1,0,1};

    public int helper(int [][] grid, int i, int j,int [][] dp){
        
        if(dp[i][j] != 0) return dp[i][j];
        for(int k = 0; k < 3; k++){
            int row = i + r[k];
            int col = j + 1;
            if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] > grid[i][j]){
                dp[i][j] = Math.max(dp[i][j],1 + helper(grid, row, col, dp));
            }
        }
        return dp[i][j];
    }
    public int maxMoves(int[][] grid) {
        int [][] dp = new int[grid.length][grid[0].length];
        int ans = 0;
        for(int j = 0; j<grid.length;j++){
            if(dp[j][0] == 0)
            ans = Math.max(ans, helper(grid, j , 0, dp));
        }
        return ans;
    }
}