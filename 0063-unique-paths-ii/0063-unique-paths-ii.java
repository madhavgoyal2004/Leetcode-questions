class Solution {
    public int helper(int [][] arr, int m, int n, int i, int j, int [][] dp){
        if(i >= m || j >= n || arr[i][j] == 1){
            return 0;
        }
        if(i == m-1 && j == n-1){
            return 1;
        }

        if(dp[i][j] != -1) return dp[i][j];
        int r = helper(arr, m, n, i, j+1, dp);
        int d = helper(arr, m, n, i+1, j, dp);

        return dp[i][j] = r+d;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int [][] dp = new int[m+1][n+1];

        for(int [] row : dp) Arrays.fill(row, -1);
    
        return helper(obstacleGrid, m , n , 0 , 0, dp);
    }
}