class Solution {
    int [] r = {-1,0,1};
    int [] c = {1,1,1};

    public void helper(int [][] grid, int i, int j, int [] count, int curr, int [][] dp){
        
        count[0] = Math.max(count[0], curr);
        
        if(dp[i][j] != 0) return;
        for(int k = 0; k < 3; k++){
            int row = i + r[k];
            int col = j + c[k];
            if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] > grid[i][j]){
                helper(grid, row, col, count, curr + 1, dp);
                dp[i][j] = count[0];
            }
        }
    }
    public int maxMoves(int[][] grid) {
        int [] count = new int[1];
        int [][] dp = new int[grid.length+1][grid[0].length + 1];
        for(int j = 0; j<grid.length;j++){
            // System.out.println(j);
            helper(grid, j , 0, count, 0, dp);
            // System.out.println(count[0]);
        }
        return count[0];
    }
}