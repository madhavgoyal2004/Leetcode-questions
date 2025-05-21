class Solution {
    int [] r = {1,0,-1,0};
    int [] c = {0,1,0,-1};
    public void dfs(int [][] grid, int m, int n, int row, int col){
        grid[row][col] = 2;
        for(int i=0; i<4; i++){
            int nr = row + r[i];
            int nc = col + c[i];
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1){
                dfs(grid, m, n, nr, nc);
            }
        }
    }
    public boolean isValid(int [][] grid, int m, int n, int row, int col){
        return (row == 0 || col == 0 || row == m-1 || col == n-1) && grid[row][col] == 1;
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(isValid(grid, m, n, i, j)){
                    dfs(grid, m, n, i, j);
                }
            }
        }

        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }

        return count;

    }
}