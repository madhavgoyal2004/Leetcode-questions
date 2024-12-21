class Solution {
    public void bfs (int [][] grid, int m, int n, int [] level){
        int [] r = {0,1,0,-1};
        int [] c = {1,0,-1,0};
        
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2) q.add(new int [] {i,j});
            }
        }

        while(!q.isEmpty()){
            boolean rotten = false;
            int size = q.size();

            while(size-- > 0){
                int [] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                for(int k=0; k<4; k++){
                    int nx = x + r[k];
                    int ny = y + c[k];
                    if(nx >=0 && ny >=0 && nx < m && ny < n && grid[nx][ny] == 1){
                        grid[nx][ny] = 2;
                        rotten = true;
                        q.add(new int [] {nx, ny});
                    }
                }
            }
            if(rotten ) level[0]++;
        }

    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;
        int [] ans = new int[1];
        
        bfs(grid,m , n, ans);

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){ 
                    return -1;
                }
            }
        }

        return ans[0];
    }
}