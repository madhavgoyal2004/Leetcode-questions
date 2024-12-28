class Solution {
    public void maxArea(int[][] grid, int m, int n, int row, int col, int[] area) {
        int [] r = {0,1,0,-1};
        int [] c = {1,0,-1,0};
        Queue<int []> q = new LinkedList<>();
        q.add(new int [] {row, col});
        grid[row][col] = -1;
        int max =1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int [] curr = q.poll();
                int X = curr[0];
                int Y = curr[1];
                for(int j=0; j<4; j++){
                    int nX = X + r[j];
                    int nY = Y + c[j];
                    if(nX >= 0 && nY >= 0 && nX < m && nY < n && grid[nX][nY] == 1){
                        q.add(new int [] {nX, nY});
                        grid[nX][nY] = -1;
                        max++;
                    }
                }
            }
        }
        area[0] = Math.max(area[0],max);

    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] maxArea = new int[1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    maxArea(grid, m, n, i, j, maxArea);
                }
            }
        }
        return maxArea[0];
    }
}